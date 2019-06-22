/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Models.Beans.Users.User;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class Coordenador extends User_{

    public Coordenador(String login, String password, String[] ROLES) throws IOException {
        super(login, password, ROLES);
    }



    
}
