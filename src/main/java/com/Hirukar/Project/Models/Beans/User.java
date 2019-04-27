/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class User {
    private String login;
    private String email;
    private String matricula;
    private String senha;
    private TipoUsuario tipo;
    
    public static User logar(ResultSet rs) throws SQLException{
        if(!rs.next())
            throw new SQLException("critical error @logar:constructor");
        switch(rs.getInt("User.tipo")){
            default: return new Professor(rs);
        }
    }

   public User(String login,String senha,String email,String matricula){
       this.login = login;
       this.matricula = matricula;
       this.senha = senha;
       this.email = email;
   }

    public boolean isB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
