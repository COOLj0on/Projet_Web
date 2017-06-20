package fr.eni.projet.web.controller;

import fr.eni.projet.web.dao.question.QuestionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rgars2016 on 20/06/2017.
 */
@WebServlet("/Question")
public class QuestionController extends HttpServlet {
    private String nextAction = "Vues/Question";

    public void editQuestion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void index(){

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
