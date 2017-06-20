package fr.eni.projet.web.dao.theme;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrateur on 19/06/2017.
 */
public class ThemeDAOImpl implements ThemeDAO {

    private static ThemeDAO instance;


    //Constructeur vide.
    public ThemeDAOImpl() {
    }

    public static ThemeDAO getInstance() {
        if (instance == null) {
            instance = new ThemeDAOImpl();
        }
        return instance;
    }

    @Override
    public Theme selectThemeByID(Integer idTheme) {

        Connection con = null;
        con = ConnectionPool.getConPool();
        boolean flag = true;

        String sql = "select * from theme t " +
                "left outer join Question q " +
                "on t.idTheme = q.fk_theme" +
                "where idTheme = ?";

        PreparedStatement stmt;
        Theme ceTheme = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idTheme);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                if(flag)
                {
                    ceTheme = new Theme();

                    ceTheme.setIdTheme(rs.getInt("idTheme"));
                    ceTheme.setLibelle(rs.getString("libelle"));
                    //ceTheme.se((rs.getFloat("distance")));

                }
                Question laQuestion = new Question();
                laQuestion.setIdQuestion(rs.getInt("idQuestion"));
                laQuestion.setEnonce(rs.getString("enonce"));
                laQuestion.setImage(rs.getNString("image"));
                laQuestion.setTheme(ceTheme);
                ceTheme.getQuestion().add(laQuestion);
                flag = false;

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return ceTheme;
    }
}
