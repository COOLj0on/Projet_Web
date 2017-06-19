package fr.eni.projet.web.dao.theme;

import fr.eni.projet.web.bean.Theme;

/**
 * Created by Administrateur on 19/06/2017.
 */
public interface ThemeDAO {

    public Theme selectThemeByID( Integer idTheme);
}
