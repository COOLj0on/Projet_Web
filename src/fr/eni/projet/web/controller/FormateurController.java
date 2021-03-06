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

@WebServlet("/Formateur")
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

	public void deconnect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if((boolean)session.getAttribute("isAuthent") == true){
			session.removeAttribute("formateur");
			session.setAttribute("isAuthent",false);
		}else{
			request.setAttribute("error", "Vous n'êtes pas connecté.");
		}
		nextAction = "/Vues/index.jsp";
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
			if (params.containsKey("identifiant") && !params.get("identifiant").toString().isEmpty()) {//En cours d'authent
				if (params.containsKey("password") && !params.get("password").toString().isEmpty()) {
					connect(request, response);
				} else {
					request.setAttribute("error", "Pas de mot de passe renseigné");
					nextAction = "/Vues/Formateur/authent.jsp";
				}
			} else if(params.containsKey("action")){
				switch (params.get("action")[0]){
					case "deconnecter":
						deconnect(request,response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
