/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class User {
    private String login;
    private String senha;
    private User usuario;
    public User(ResultSet rs) throws SQLException {
        
        if(!rs.next())
            throw new SQLException("critical error @User:Constructor");
        switch(rs.getInt("User.tipo")){
            case 0:usuario = new Professor(login, login);
            case 1:
            case 2:
        }
        throw new UnsupportedOperationException();
    }

   public User(String login,String senha){
       this.login = login;
       this.senha = senha;
   }
    
    
}
