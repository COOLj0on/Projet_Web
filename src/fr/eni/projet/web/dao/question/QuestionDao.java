package fr.eni.projet.web.dao.question;

import fr.eni.projet.web.bean.Question;
import fr.eni.projet.web.bean.Theme;

import java.util.List;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public interface QuestionDao {

//    public Question selectQuestionByID(Integer idQuestion);
    public List<Question> selectAll() throws Exception;
    public void insert(Question uneQuestion, Integer idTheme) throws Exception;
    public void update(Question modifQuestion) throws Exception;
    public void delete(Question supprQuestion) throws Exception;



    }
