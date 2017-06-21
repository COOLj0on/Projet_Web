package fr.eni.projet.service.resource;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.theme.ThemeDAOImpl;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("/Theme")
public class ThemeRest {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Theme getThemeJson(@PathParam("id") int id) {
        Theme theme =  null;
        try {
            return theme = ThemeDAOImpl.getInstance().selectThemeByID(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return theme;
    }
}
