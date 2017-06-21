package fr.eni.projet.web.controller;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.dao.question.QuestionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by rgars2016 on 20/06/2017.
 */
@WebServlet("/Question")
@MultipartConfig
public class QuestionController extends HttpServlet {
    private String nextAction = "Vues/Question/index.jsp";

    public void editQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public int getIdFromParam(Map<String, String[]> params){
        Integer id = null;
        if(params.containsKey("id") && params.get("id")[0] != null){
            id = Integer.parseInt(params.get("id")[0]);
        }else{
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return id;
    }

    public void index(HttpServletRequest request, HttpServletResponse response){
        List<Question> questions = null;
        try {
            questions = QuestionDaoImpl.getInstance().selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.getServletContext().setAttribute("questions", questions);
        nextAction = "/Vues/Question/index.jsp";
    }

    public void addQuestion(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Question question = new Question();
        String fileName = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        question.setEnonce(request.getParameter("enonce"));
        Part filePart = request.getPart("image"); // Retrieves <input type="file" name="file">
        InputStream fileContent = filePart.getInputStream();
        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);

        File targetFile = new File(request.getServletContext().getRealPath("/")+"data/img/"+ fileName +".jpg");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(buffer);
        question.setImage(fileName);

        int result = QuestionDaoImpl.getInstance().insert(question,Integer.parseInt(request.getParameter("theme")));
        if(result != 1){
            request.setAttribute("error","L'insertion ne c'est pas déroulée correctement");
        }
        index(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        boolean continu = true;
        try{
            if(params.containsKey("action")){
                switch (params.get("action")[0]){
                    case "new":
                        if("GET".equals(request.getMethod())){
                            nextAction = "/Vues/Question/authentified/create.jsp";
                        }else{
                            addQuestion(request,response);
                        }
                        break;
                    case "delete":
                        int id = getIdFromParam(params);
                        deleteQuestion(request,response,id);
                        break;
                    default:

                        break;
                }
            }else{
                index(request, response);
            }
            if(continu){
                this.getServletContext().getRequestDispatcher(nextAction).forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteQuestion(HttpServletRequest request, HttpServletResponse response,int idQues) throws Exception{
        int result = QuestionDaoImpl.getInstance().delete(idQues);
        if(result != 1){
            request.setAttribute("error", "Erreur suppression question");
        }
        index(request,response);
    }

}
