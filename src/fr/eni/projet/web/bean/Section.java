package fr.eni.projet.web.bean;

import java.util.List;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Section {
    private Integer idSection;
    private Integer numero;
    private String nom;
    private Integer nbQuestions;
    private Theme ceTheme;

    public Section() {
    }

    public Section(Integer idSection, Integer numero, String nom, Integer nbQuestions, Theme ceTheme) {
        this.setIdSection(idSection);
        this.setNumero(numero);
        this.setNom(nom);
        this.setNbQuestions(nbQuestions);
        this.setCeTheme(ceTheme);
    }

    public Integer getIdSection() {
        return idSection;
    }

    public void setIdSection(Integer idSection) {
        this.idSection = idSection;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getNbQuestions() {
        return nbQuestions;
    }

    public void setNbQuestions(Integer nbQuestions) {
        this.nbQuestions = nbQuestions;
    }

    public Theme getCeTheme() {
        return ceTheme;
    }

    public void setCeTheme(Theme ceTheme) {
        this.ceTheme = ceTheme;
    }

    @Override
    public String toString() {
        return "Section{" +
                "idSection=" + idSection +
                ", numero=" + numero +
                ", nom='" + nom + '\'' +
                ", nbQuestions=" + nbQuestions +
                ", ceTheme=" + ceTheme +
                '}';
    }
}
