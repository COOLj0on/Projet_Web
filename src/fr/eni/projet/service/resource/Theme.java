package fr.eni.projet.service.resource;
import com.google.gson.Gson;
import fr.eni.projet.web.dao.theme.ThemeDAOImpl;

import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;


// The Java class will be hosted at the URI path "/helloworld"
@Path("/theme")
public class Theme {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getClichedMessage(@PathParam("id") int id) {
        fr.eni.projet.web.bean.Theme theme = ThemeDAOImpl.getInstance().selectThemeByID(id);
        Gson gson = new Gson();
        String json = gson.toJson(theme, theme.getClass());
        return json;
    }
}
