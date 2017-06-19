package fr.eni.projet.web.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.sql.Connection;

public class ConnectionPool extends HttpServlet {

    public static Connection getConPool()
    {
        Connection conn = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/tp_web");
            conn = ds.getConnection();
            System.out.println("Database connection success");
        } catch (Exception e) {
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
        return conn;
    }
}
