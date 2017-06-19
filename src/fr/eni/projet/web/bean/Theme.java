package fr.eni.projet.web.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Theme {
    private Integer idTheme;
    private String libelle;
    private List<Question> question = new ArrayList<Question>();

    public Theme() {
    }

    public Theme(Integer idTheme, String libelle, List<Question> question) {
        this.setIdTheme(idTheme);
        this.setLibelle(libelle);
        this.setQuestion(question);
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "theme{" +
                "idTheme=" + idTheme +
                ", libelle='" + libelle + '\'' +
                ", question=" + question +
                '}';
    }
}
