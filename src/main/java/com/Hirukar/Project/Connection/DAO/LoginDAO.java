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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            DatabaseConnection.closeConnection(rs, stmt);
        }
        
        return check;
    }
    
    
}
