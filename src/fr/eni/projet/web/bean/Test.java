package fr.eni.projet.web.bean;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rgars2016 on 19/06/2017.
 */
public class Test {
    private Integer id;
    private String nom;
    private Time temps;
    private Integer seuil1;
    private Integer seuil2;
    private List<Section> section = new ArrayList<Section>();

    public Test() {
    }

    public Test(Integer id, String nom, Time temps, Integer seuil1, Integer seuil2, List<Section> section) {
        this.setId(id);
        this.setNom(nom);
        this.setTemps(temps);
        this.setSeuil1(seuil1);
        this.setSeuil2(seuil2);
        this.setSection(section);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Time getTemps() {
        return temps;
    }

    public void setTemps(Time temps) {
        this.temps = temps;
    }

    public Integer getSeuil1() {
        return seuil1;
    }

    public void setSeuil1(Integer seuil1) {
        this.seuil1 = seuil1;
    }

    public Integer getSeuil2() {
        return seuil2;
    }

    public void setSeuil2(Integer seuil2) {
        this.seuil2 = seuil2;
    }

    public List<Section> getSection() {
        return section;
    }

    public void setSection(List<Section> section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", temps=" + temps +
                ", seuil1=" + seuil1 +
                ", seuil2=" + seuil2 +
                ", section=" + section +
                '}';
    }
}
