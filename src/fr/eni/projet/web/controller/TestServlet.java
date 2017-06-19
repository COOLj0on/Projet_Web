package fr.eni.projet.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by jdiaz2016 on 19/06/2017.
 */
@WebServlet(name = "Test")
public class TestServlet extends HttpServlet {
    private String nextAction="/Vues/Test/index.jsp";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
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
