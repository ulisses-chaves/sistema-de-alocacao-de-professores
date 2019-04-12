package com.Hirukar.Project.Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class DatabaseConnection {
    private final static String HOST = "remotemysql.com";
    private final static int PORT=3306;
    private final static String DATABASE = "CNV7omG8PV";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE+"?useSSL=false";
    private final static String USER = "CNV7omG8PV";
    private final static String PASS = "ema3gCwtYr";
    private static Connection CON;
    

    public DatabaseConnection() {}
    
    public Connection conect() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }
    private Connection get() throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER);
        return DriverManager.getConnection(URL, USER, PASS);
    }
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if(CON == null){
            DatabaseConnection gambiarra = new DatabaseConnection();
            CON = gambiarra.get();
        }
        return CON;
    }
    private void close() throws SQLException {
        if (CON != null) {
            CON.close();
        }
        CON = null;
    }

    private void close(PreparedStatement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
    }

    private void close(ResultSet rs, PreparedStatement stmt) throws SQLException {
        if (rs != null) {
            rs.close();
        }
        close(stmt);
    }
    
    public static void closeConnection() throws SQLException {
        DatabaseConnection gambiarra = new DatabaseConnection();
        gambiarra.close();
    }

    public static void closeConnection(PreparedStatement stmt) throws SQLException {
        DatabaseConnection gambiarra = new DatabaseConnection();
        gambiarra.close(stmt);
    }

    public static void closeConnection(ResultSet rs, PreparedStatement stmt) throws SQLException {
        DatabaseConnection gambiarra = new DatabaseConnection();
        gambiarra.close(rs,stmt);
    }
}
