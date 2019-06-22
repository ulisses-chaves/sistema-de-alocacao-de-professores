/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class Coordenador extends User{

    public Coordenador(ResultSet rs) throws SQLException {
        super(rs.getString("User.login"), rs.getString("User.email"), rs.getString("User.matricula"), rs.getString("User.senha"), rs.getInt("User.tipo"), rs.getInt("User.id"));
    }

    
}
