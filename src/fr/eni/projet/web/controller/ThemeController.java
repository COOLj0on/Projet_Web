package fr.eni.projet.web.controller;

import fr.eni.projet.web.bean.Theme;
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
 * Created by jdiaz2016 on 20/06/2017.
 */
@WebServlet("/Theme")
public class ThemeController extends HttpServlet {
    private String nextAction = "/Vues/Theme/index.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
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

    public void editTheme(HttpServletRequest request, HttpServletResponse response, int id){
        Theme theme = ThemeDAOImpl.getInstance().selectThemeByID(id);
        request.setAttribute("theme",theme);
        nextAction = "/Vues/authentified/create.jsp";
    }

    public void index(HttpServletRequest request, HttpServletResponse response){
        List<Theme> formations = new ArrayList<>();//ThemeDAOImpl.getInstance().selectAll();
        this.getServletContext().setAttribute("formations", formations);
        nextAction = "/Vues/Theme/index.jsp";
    }

    public void updateTheme(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Theme theme = new Theme();
        theme.setIdTheme(Integer.parseInt(request.getParameter("id")));
        theme.setLibelle(request.getParameter("libelle"));
        //TODO: Ajouter des questions au thème
        int result = 1;//ThemeDAOImpl.getInstance().update(theme);
        if(result != 1){
            request.setAttribute("error","La mise à jour ne c'est pas déroulée correctement");
        }
        index(request,response);
    }

    public void deleteTheme(HttpServletRequest request, HttpServletResponse response,int id) throws Exception{
        Theme theme = new Theme();
        theme.setIdTheme(id);
        int result = 1;//ThemeDAOImpl.getInstance().delete(theme);
        if(result != 1){
            request.setAttribute("error","La suppression ne c'est pas déroulée correctement");
        }
        index(request,response);
    }

    public void addTheme(HttpServletRequest request, HttpServletResponse response) throws Exception{
        Theme formation = new Theme();
        formation.setLibelle(request.getParameter("libelle"));
        //TODO:Ajouter des questions

        int result = 1;//ThemeDAOImpl.getInstance().insert(formation);
        if(result != 1){
            request.setAttribute("error","L'insertion ne c'est pas déroulée correctement");
        }
        index(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> params = request.getParameterMap();
        boolean continu = true;
        try{
            if(params.containsKey("action")){
                switch (params.get("action")[0]){
                    case "edit":
                        if("GET".equals(request.getMethod())){
                            int id = getIdFromParam(params);
                            editTheme(request,response,id);
                        }else{
                            updateTheme(request,response);
                        }
                        break;
                    case "delete":
                        int id = getIdFromParam(params);
                        deleteTheme(request,response,id);
                        break;
                    case "new" :
                        if("GET".equals(request.getMethod())){
                            nextAction = "/Vues/Theme/create.jsp";
                        }else{
                            addTheme(request,response);
                        }
                        break;
                    default:

                        break;
                }
            }
            if(continu){
                this.getServletContext().getRequestDispatcher(nextAction).forward(request, response);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
