package fr.eni.projet.web.dao.question;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;
import fr.eni.projet.web.dao.ConnectionPool;

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

    //Selectionner toutes les questions par rapport à un theme
    public Question selectQuestionByID(Integer idTheme) {
        Connection con = null;
        con = ConnectionPool.getConPool();
        boolean flag = true;

        String sql = "SELECT idQuestion, enonce, image, fk_theme FROM Question q JOIN Theme t ON q.fk_theme = t.idTheme WHERE t.idTheme=?";

        PreparedStatement stmt;
        Question cesQuestion = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idTheme);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                    cesQuestion = new Question();
                    cesQuestion.setIdQuestion(rs.getInt("idQuestion"));
                    cesQuestion.setEnonce(rs.getString("enonce"));
                    cesQuestion.setImage(rs.getString("image"));
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

    return cesQuestion;
    }

    //Selection de toutes les questions
    public List<Question> selectAll() throws Exception{
        List<Question> result = new ArrayList<Question>();
        List<Theme> listTheme = new ArrayList<Theme>();

        Connection con = null;
        con = ConnectionPool.getConPool();
        boolean flag = true;
        String sql = "SELECT * FROM Question q LEFT JOIN Theme t ON t.idTheme = q.fk_theme";

        PreparedStatement stmt;
       // boolean existe = false;
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                boolean existe = false;
                Question ques = new Question();
                ques.setIdQuestion(rs.getInt("idQuestion"));
                ques.setEnonce(rs.getString("enonce"));
                ques.setImage(rs.getString("image"));


                Theme ceTheme = new Theme();
                ceTheme.setIdTheme(rs.getInt("idTheme"));
                for( int i = 0; i < listTheme.size(); i++)
                {
                    if (listTheme.get(i).getIdTheme().equals(ceTheme.getIdTheme()))
                    {
                        existe = true;
                        ques.setTheme(listTheme.get(i));
                    }
                }
                if (existe ==false)
                {
                    ceTheme.setLibelle(rs.getString("libelle"));
                    listTheme.add(ceTheme);
                    ques.setTheme(ceTheme);
                }

                result.add(ques);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int insert(Question uneQuestion, Integer idTheme) throws Exception {
        Connection con = null;
        int result = -1;
        con = ConnectionPool.getConPool();
        String sql = "INSERT INTO Question(enonce,image,fk_theme) VALUES(?,?,?)";

        PreparedStatement stmt;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1,uneQuestion.getEnonce());
            stmt.setString(2,uneQuestion.getImage());
            stmt.setInt(3, idTheme);
            result = stmt.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
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
    public int delete(Integer idQues) {
        Integer res = 1;

        Connection con = null;
        con = ConnectionPool.getConPool();
        String sql = "DELETE FROM Question WHERE idQuestion =?";

        PreparedStatement stmt;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, idQues);
            stmt.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
            res = 2;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                res = 3;
            }
        }
        return res;
    }
}
