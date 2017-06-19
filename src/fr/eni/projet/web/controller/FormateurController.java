package fr.eni.projet.web.controller;


import fr.eni.projet.web.bean.Formateur;
import fr.eni.projet.web.dao.formateur.FormateurDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/formateur")
public class FormateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextAction = "/Vues/Formateur/authent.jsp";

    public FormateurController() {
        super();
    }
    
    //Default view
    public void index(HttpServletRequest request, HttpServletResponse response)throws Exception{
		nextAction = "/Vues/Formateur/authent.jsp";
    }

	public void connect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		nextAction 					= "/Vues/Formateur/authent.jsp";
    	String password 			= request.getParameter("password");
		String identifiant 			= request.getParameter("identifiant");
		Formateur formateur 		= null;
		try {
			formateur = FormateurDaoImpl.getInstance().checkCredentials(identifiant, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(formateur != null){
			HttpSession session = request.getSession();
			session.setAttribute("formateur", formateur);
			session.setAttribute("isAuthent", true);
			session.setMaxInactiveInterval(600);
			nextAction = "/Vues/index.jsp";
		}else{
			request.setAttribute("error", "Pas de compte correspondant");
		}
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
				index(request,response);
			}
			if(continu){
				this.getServletContext().getRequestDispatcher(nextAction).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
