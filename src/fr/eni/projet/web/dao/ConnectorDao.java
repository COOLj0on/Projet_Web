package fr.eni.projet.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorDao  {

	public static Connection dbConnect()
   {
		Connection conn = null;
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=TPJavaEE_GestionFormations","sa", "Pa$$w0rd");
         System.out.println("Connected to the database");
      } catch (Exception e) {
    	 System.err.println("Database connection failed");
         e.printStackTrace();
      }
      return conn;
   }

   public static void main(String[] args)
   {
      ConnectorDao.dbConnect();
   }
}
