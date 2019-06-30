/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Users.Professor;
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
    
    
    public UserDAO(){}
    
    public User logar(String login,String senha) throws SQLException {
        boolean check = false;
        ResultSet rs=null;
        PreparedStatement stmt=null;
        Connection con = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement("SELECT * FROM Login WHERE Login.login=? AND Login.senha=?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            return User.logar(rs);
        }catch(ClassNotFoundException | SQLException e){
            throw new SQLException(e.getMessage());
        }finally{
            DatabaseConnection.getInstance().close(con,rs, stmt);
        }
        
    }

    

    public void cadastrarProfessor(Professor professor) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
