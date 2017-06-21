package fr.eni.projet.web.bean;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Reponse {
    @JsonProperty("id")
    private Integer idReponse;

    @JsonProperty("libelle")
    private String libelle;

    @JsonProperty("type")
    private Boolean type;

    public Reponse() {
    }

    public Reponse(Integer idReponse, String libelle, Boolean type) {
        this.setIdReponse(idReponse);
        this.setLibelle(libelle);
        this.setType(type);
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "idReponse=" + idReponse +
                ", libelle='" + libelle + '\'' +
                ", type=" + type +
                '}';
    }
}
