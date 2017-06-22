package fr.eni.projet.web.controller;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Test;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.question.QuestionDaoImpl;
import fr.eni.projet.web.dao.theme.ThemeDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.sql.Timestamp;
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

    public void createTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        nextAction = "/Vues/Question/authentified/create.jsp";
    }

    public void addTest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        Test test = new Test();
//        int result = Test.getInstance().insert(test,Integer.parseInt(request.getParameter("theme")));
//        if(result != 1){
//            request.setAttribute("error","L'insertion ne c'est pas déroulée correctement");
//        }
        index(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        boolean continu = true;
        try{
            if(params.containsKey("action")){
                switch (params.get("action")[0]){
                    case "new":
                        if("GET".equals(request.getMethod())){
                            createTest(request,response);
                        }else{
                            addTest(request,response);
                        }
                        break;
                    default:
                        break;
                }
            }else{
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
