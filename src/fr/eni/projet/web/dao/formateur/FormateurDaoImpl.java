package fr.eni.projet.web.dao.formateur;

import fr.eni.projet.web.bean.Formateur;
import fr.eni.projet.web.dao.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FormateurDaoImpl implements FormateurDao {
		private static FormateurDao instance;

		
		private FormateurDaoImpl() {

		}
		
		public static FormateurDao getInstance() {
			if (instance == null) {
				instance = new FormateurDaoImpl();
			}
			return instance;
		}

		@Override
		public Formateur checkCredentials(String identifiant, String mdp) throws Exception {
			Formateur result = null;
			Connection con = null;
			try {
				con = ConnectionPool.getConPool();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "SELECT * FROM Formateur WHERE identifiant=? AND mdp=?";
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, identifiant);
				stmt.setString(2, mdp);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					Formateur formateur = new Formateur();
					formateur.setIdFormateur( rs.getInt("idFormateur"));
					formateur.setIdentifiant(rs.getString("identifiant"));
					formateur.setMdp(rs.getString("mdp"));
					formateur.setNom(rs.getString("nom"));
					formateur.setPrenom(rs.getString("prenom"));
					result = formateur;
				}
			} catch (SQLException e) {
				System.err.println(e);
			}finally{if(con != null){con.close();}}
			
			return result;
		}
	}

