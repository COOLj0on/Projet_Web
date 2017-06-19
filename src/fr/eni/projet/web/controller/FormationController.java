package fr.eni.projet.web.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class FormationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextAction = "";

    public FormationController() {
        super();
    }
    
    //Default view, the list of all formations
    public void index(HttpServletRequest request, HttpServletResponse response)throws Exception{

		nextAction = "/Vues/formation/formation.jsp";
    }

    public void listAll(HttpServletRequest request, HttpServletResponse response) throws Exception {

		nextAction = "/Vues/formation/gerer.jsp";
	}

	public void listJson(HttpServletRequest request, HttpServletResponse response) throws Exception{
		/*List<FormationBean> liste = FormationDaoImpl.getInstance().selectAll();
		Gson gsonObj = new Gson();
		String json =  gsonObj.toJson(liste);
		request.setAttribute("json",json);
		response.setContentType("application/json");
		response.getWriter().write(json);*/
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nextAction = "/Vues/formation/formation.jsp";
		Map<String, String[]> params = request.getParameterMap();
		boolean continu = true;
		try{
			if(params.containsKey("action")){
				switch (params.get("action")[0]){
					case "gerer":
						listAll(request,response);
						break;
					case "getJson":
						listJson(request,response);
						continu = false;
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
