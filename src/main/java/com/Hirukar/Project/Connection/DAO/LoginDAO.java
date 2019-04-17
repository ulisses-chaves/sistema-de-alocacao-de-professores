/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
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
public final class LoginDAO {
    private Connection con;
    
    public LoginDAO(){}
    
    public boolean logar(String login,String senha) throws SQLException {
        boolean check = false;
        ResultSet rs=null;
        PreparedStatement stmt=null;
        try {
            stmt = DatabaseConnection.getConnection().prepareStatement("SELECT * FROM Login WHERE Login.login=? AND Login.senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            check = rs.next();
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DatabaseConnection.closeConnection(rs, stmt);
        }
        
        return check;
    }

    public void cadastrarProfessor(String name, String login, String senha, String email, String codigo, String area)  throws SQLException {
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
    }

    public void cadastrarDisciplina(String disciplina, String codigo, String curso, String area, String obr, String opt)throws SQLException {
        PreparedStatement stmt = null;
        try{
            stmt = DatabaseConnection.getConnection().prepareStatement("INSERT INTO Disciplina (disciplina,codigo,curso,area,obr,opt) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, disciplina);
            stmt.setString(2, codigo);
            stmt.setString(3, curso);
            stmt.setString(4, area);
            stmt.setString(5, obr);
            stmt.setString(6, opt);
            stmt.executeUpdate();
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DatabaseConnection.closeConnection(stmt);
        }
    }
    
    
}
