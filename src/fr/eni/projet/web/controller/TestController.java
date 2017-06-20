package fr.eni.projet.web.controller;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.question.QuestionDaoImpl;
import fr.eni.projet.web.dao.theme.ThemeDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jdiaz2016 on 19/06/2017.
 */
@WebServlet("/Test")
public class TestController extends HttpServlet {
    private String nextAction="/Vues/Test/index.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nextAction="/Vues/Test/index.jsp";
    }

    public void testAction() throws Exception {
        try{
            String enonce = "Enonce test";
            String image = "Image test";
            Theme theme = new Theme();
            theme.setLibelle("test");
            Integer idTheme = 1;
            Question newQuestion = new Question();
            newQuestion.setEnonce(enonce);
            newQuestion.setImage(image);
            newQuestion.setTheme(theme);

            QuestionDaoImpl.getInstance().insert(newQuestion, idTheme);
        }catch (Exception e){
            System.err.print(e);
        }
    }

    public void selectAll() throws Exception {
        List<Question> question = new ArrayList<Question>();
        question = QuestionDaoImpl.getInstance().selectAll();
        for (Question q: question) {
            System.out.println(q);

        }
    }

    public Theme selectThemeAction(){

        Theme ceTheme = new Theme();
        ThemeDAOImpl.getInstance().selectThemeByID(1);

        System.out.println(ceTheme);
        return ceTheme;
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        boolean continu = true;
        try{
            if(params.containsKey("action")){
                switch (params.get("action")[0]){
                    case "":
                        continu = false;
                        break;
                    default:
                        break;
                }
            }else{
               // selectThemeAction();
                //testAction();
                selectAll();
                index(request,response);
            }
            if(continu){
                this.getServletContext().getRequestDispatcher(nextAction).forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
