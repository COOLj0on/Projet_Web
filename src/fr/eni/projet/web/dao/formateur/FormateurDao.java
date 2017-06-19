package fr.eni.projet.web.dao.formateur;


import fr.eni.projet.web.bean.Formateur;

public interface FormateurDao {
	
	public Formateur checkCredentials(String identifiant, String mdp) throws Exception;
}
