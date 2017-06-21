package fr.eni.projet.web.bean;

import com.google.gson.annotations.SerializedName;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Reponse {
    @JsonProperty("id")
    private Integer idReponse;

    @JsonProperty("libelle")
    private String libelle;

    @JsonProperty("estBonne")
    private Boolean estBonne;

    public Reponse() {
    }

    public Reponse(Integer idReponse, String libelle, Boolean estBonne) {
        this.setIdReponse(idReponse);
        this.setLibelle(libelle);
        this.setEstBonne(estBonne);
    }

    public Integer getIdReponse() {
        return idReponse;
    }

    public void setIdReponse(Integer idReponse) {
        this.idReponse = idReponse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEstBonne() {
        return estBonne;
    }

    public void setEstBonne(Boolean estBonne) {
        this.estBonne = estBonne;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "idReponse=" + idReponse +
                ", libelle='" + libelle + '\'' +
                ", estBonne=" + estBonne +
                '}';
    }
}
