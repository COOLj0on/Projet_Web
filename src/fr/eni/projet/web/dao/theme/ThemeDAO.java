package fr.eni.projet.web.dao.theme;

import fr.eni.projet.web.bean.Theme;

import java.util.List;

/**
 * Created by Administrateur on 19/06/2017.
 */
public interface ThemeDAO {

    public Theme selectThemeByID( Integer idTheme);
    public List<Theme> selectAllTheme();
    public int insert(Theme leTheme);
    public int  delete(Integer id);
}
