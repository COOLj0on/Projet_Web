package fr.eni.projet.web.bean;


import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Theme {

    @JsonProperty("id")
    private Integer idTheme;

    @JsonProperty("libelle")
    private String libelle;

    public Theme() {
    }

    public Theme(Integer idTheme, String libelle) {
        this.setIdTheme(idTheme);
        this.setLibelle(libelle);
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

    @Override
    public String toString() {
        return "theme{" +
                "idTheme=" + idTheme +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
