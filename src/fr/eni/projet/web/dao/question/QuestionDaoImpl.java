package fr.eni.projet.web.dao.question;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.ConnectionPool;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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


//    public Question selectQuestionByID(Integer idQuestion) {
//        Connection con = null;
//        con = ConnectionPool.getConPool();
//        boolean flag = true;
//
//        String sql = "SELECT idQuestion, enonce, image, fk_theme FROM Question q JOIN Theme t ON q.fk_theme = t.idTheme WHERE t.idTheme=?";
//
//        PreparedStatement stmt;
//        Question cesQuestion = null;
//
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setInt(1, idQuestion);
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                if(flag)
//                {
//                    cesQuestion = new Question();
//                    cesQuestion.setId(rs.getInt("idTheme"));
//                    cesQuestion.setLibelle(rs.getString("libelle"));
//                    //ceTheme.se((rs.getFloat("distance")));
//
//                }
//                Question laQuestion = new Question();
//                laQuestion.setIdQuestion(rs.getInt("idQuestion"));
//                laQuestion.setEnonce(rs.getString("enonce"));
//                laQuestion.setImage(rs.getNString("image"));
//                laQuestion.setTheme(ceTheme);
//                ceTheme.getQuestion().add(laQuestion);
//                flag = false;
//
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


    public List<Question> selectAll() throws Exception{
        List<Question> result = new ArrayList<Question>();

        Connection con = null;
        con = ConnectionPool.getConPool();
        String sql = "SELECT * FROM Question q LEFT JOIN Theme t ON t.idTheme = q.fk_theme";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Question ques = new Question();
                ques.setEnonce(rs.getString("enonce"));
                ques.setImage(rs.getString("image"));

                result.add(ques);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
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
            stmt.executeUpdate();
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

    @Override
    public void update(Question modifQuestion) throws Exception{
        Connection con = null;
        con = ConnectionPool.getConPool();
        String sql = "UPDATE Question SET enonce=? AND image=? AND fk_theme=? WHERE idQuestion =?";

        PreparedStatement stmt;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,modifQuestion.getEnonce());
            stmt.setString(2,modifQuestion.getImage());
            stmt.setInt(3, modifQuestion.getTheme().getIdTheme());
            stmt.executeUpdate();
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

    @Override
    public void delete(Question supprQuestion) throws Exception{
        Connection con = null;
        con = ConnectionPool.getConPool();
        String sql = "DELETE FROM Question WHERE idQuestion =?";

        PreparedStatement stmt;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, supprQuestion.getIdQuestion());
            stmt.executeUpdate();

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
}
