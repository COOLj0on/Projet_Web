package fr.eni.projet.web.bean;

/**
 * Created by jdiaz2016 on 19/06/2017.
 */
public class Formateur {
    private Integer idFormateur;
    private String identifiant;
    private String mdp;
    private String nom;
    private String prenom;

    public Formateur() {
    }

    public Formateur(Integer idFormateur, String identifiant, String mdp, String nom, String prenom) {
        this.setIdFormateur(idFormateur);
        this.setIdentifiant(identifiant);
        this.setMdp(mdp);
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    public Integer getIdFormateur() {
        return idFormateur;
    }

    public void setIdFormateur(Integer idFormateur) {
        this.idFormateur = idFormateur;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Formateur{" +
                "idFormateur=" + idFormateur +
                ", identifiant='" + identifiant + '\'' +
                ", mdp='" + mdp + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
