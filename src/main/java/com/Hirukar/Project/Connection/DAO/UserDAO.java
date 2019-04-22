/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Professor;
import com.Hirukar.Project.Models.Beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RODEMARCK
 */
public final class UserDAO {
    private Connection con;
    
    public UserDAO(){}
    
    public User logar(String login,String senha) throws SQLException {
        boolean check = false;
        ResultSet rs=null;
        PreparedStatement stmt=null;
        try {
            stmt = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM Login WHERE Login.login=? AND Login.senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            return new User(rs);
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DatabaseConnection.closeConnection(rs, stmt);
        }
        
    }

    /*public void cadastrarProfessor(String name, String login, String senha, String email, String codigo, String area)  throws SQLException {
        PreparedStatement stmt = null;
        try{
            stmt = DatabaseConnection.getConnection().prepareStatement("INSERT INTO Professor (name,login,senha,email,codigo,area) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, name);
            stmt.setString(2, login);
            stmt.setString(3, senha);
            stmt.setString(4, email);
            stmt.setString(5, codigo);
            stmt.setString(6, area);
            stmt.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DatabaseConnection.closeConnection(stmt);
        }
    }*/

    public void cadastrarProfessor(Professor professor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
