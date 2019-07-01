package com.Hirukar.Project.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DatabaseConnection {
    private final static String HOST = "localhost";
    private final static int PORT=3306;
    private final static String DATABASE = "sap";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?useTimezone=true&serverTimezone=UTC";
    private final static String USER = "root";
    private final static String PASS = "godluzes";
    
    private static DatabaseConnection instance;
     
    public static DatabaseConnection getInstance(){
        if(instance == null)
            instance = new DatabaseConnection();
        return instance;
    }

    private DatabaseConnection() {}
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void close(Connection CON) throws SQLException {
        if (CON != null) 
            CON.close();
    }

    public void close(Connection CON,PreparedStatement stmt) throws SQLException {
        if (stmt != null)
            stmt.close();
        close(CON);
    }

    public void close(Connection CON,ResultSet rs, PreparedStatement stmt) throws SQLException {
        if (rs != null)
            rs.close();
        close(CON,stmt);
    }

}
