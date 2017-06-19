package fr.eni.projet.web.dao.Formateur;

import fr.eni.web.site.bean.AnimateurBean;
import fr.eni.web.site.dao.ConnectionPool;
import fr.eni.web.site.dao.ConnectorDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AnimateurDaoImpl implements AnimateurDao {
		private static AnimateurDao instance;

		
		private AnimateurDaoImpl() {

		}
		
		public static AnimateurDao getInstance() {
			if (instance == null) {
				instance = new AnimateurDaoImpl();
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

		/*@Override
		public List<AnimateurBean> selectAll() throws SQLException{
			List<AnimateurBean> result = new ArrayList<AnimateurBean>();
			Connection con = null;
			try{
				con = ConnectionPool.getConPool();	
			}catch(Exception e){
				e.printStackTrace();
			}
			String sql = "SELECT * FROM formations";
			PreparedStatement stmt;
			try {
				stmt = con.prepareStatement(sql);

				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					AnimateurBean animateurBean = new AnimateurBean();
					animateurBean.setId( rs.getInt( "id" ));
					animateurBean.setLibelle(rs.getString("libelle"));
					animateurBean.setDescription(rs.getString("description"));
					animateurBean.setDebut(rs.getDate("debut"));
					animateurBean.setFin(rs.getDate("fin"));
					result.add(animateurBean);
				}
			} catch (SQLException e) {
				System.err.println(e);
			}finally{if(con != null){con.close();}}
			
			return result;
		}*/
	}

