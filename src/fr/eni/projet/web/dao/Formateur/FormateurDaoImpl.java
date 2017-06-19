package fr.eni.projet.web.dao.Formateur;

import fr.eni.web.site.bean.AnimateurBean;
import fr.eni.web.site.dao.ConnectionPool;
import fr.eni.web.site.dao.ConnectorDao;

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
		public AnimateurBean checkCredentials(String email, String password) throws Exception {
			AnimateurBean result = null;
			Connection con = null;
			try {
				con = ConnectionPool.getConPool();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String sql = "SELECT * FROM animateurs WHERE email=? AND motdepasse=?";
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setString(1, email);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					AnimateurBean animateurBean = new AnimateurBean();
					animateurBean.setId( rs.getInt( "id" ));
					animateurBean.setNom(rs.getString("nom"));
					animateurBean.setPrenom(rs.getString("prenom"));
					animateurBean.setMail(rs.getString("email"));
					animateurBean.setPassword(rs.getString("motdepasse"));
					result = animateurBean;
				}
			} catch (SQLException e) {
				System.err.println(e);
			}finally{if(con != null){con.close();}}
			
			return result;
		}
	}

