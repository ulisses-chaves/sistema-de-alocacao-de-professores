/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Users_.Professor;
import com.Hirukar.Project.Models.Beans.Users.User;
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
            con = new DatabaseConnection().getConnection();
            stmt = con.prepareStatement("SELECT * FROM Login WHERE Login.login=? AND Login.senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            return null;
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            new DatabaseConnection().close(con,rs, stmt);
        }
        
    }

    

    public void cadastrarProfessor(Professor professor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
