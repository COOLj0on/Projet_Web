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
import java.util.List;
import java.util.Map;

/**
 * Created by rgars2016 on 20/06/2017.
 */
@WebServlet("/Question")
public class QuestionController extends HttpServlet {
    private String nextAction = "Vues/Question/index.jsp";

    public void editQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        boolean continu = true;
        try{
            if(params.containsKey("action")){
                switch (params.get("action")[0]){
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
}
