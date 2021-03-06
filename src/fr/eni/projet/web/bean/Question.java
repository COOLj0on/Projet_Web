package fr.eni.projet.web.bean;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonSubTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Question {
    @JsonProperty("id")
    private Integer idQuestion;

    @JsonProperty("enonce")
    private String enonce;

    @JsonProperty("image")
    private String image;

    @JsonProperty("theme")
    private Theme theme;

    @JsonProperty("reponses")
    private List<Reponse> reponse = new ArrayList<Reponse>();

    public Question() {
    }

    public Question(Integer idQuestion, String enonce, String image, Theme theme, List<Reponse> reponse) {
        this.setIdQuestion(idQuestion);
        this.setEnonce(enonce);
        this.setImage(image);
        this.setTheme(theme);
        this.setReponse(reponse);
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public List<Reponse> getReponse() {
        return reponse;
    }

    public void setReponse(List<Reponse> reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", enonce='" + enonce + '\'' +
                ", image='" + image + '\'' +
                ", theme=" + theme +
                ", reponse=" + reponse +
                '}';
    }
}
