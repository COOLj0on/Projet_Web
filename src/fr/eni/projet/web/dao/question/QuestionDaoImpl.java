package fr.eni.projet.web.dao.question;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class QuestionDaoImpl implements QuestionDao {
    private static QuestionDao instance;

    public QuestionDaoImpl() {
    }

    public static QuestionDao getInstance() {
        if(instance == null){
            instance = new QuestionDaoImpl();
        }
        return instance;
    }

    @Override
    public void insert(Question uneQuestion, Integer idTheme) throws Exception {
        Connection con = null;
        con = ConnectionPool.getConPool();
        String sql = "INSERT INTO Question(enonce,image,fk_theme) VALUES(?,?,?)";

        PreparedStatement stmt;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,uneQuestion.getEnonce());
            stmt.setString(2,uneQuestion.getImage());
            stmt.setInt(3, idTheme);
            stmt.executeQuery();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*select
    Update
    Delete
     */

}
