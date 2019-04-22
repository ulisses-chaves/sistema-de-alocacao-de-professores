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
    private boolean b;
    public User(ResultSet rs) throws SQLException {
        b = rs.next();
    }

    public boolean isB() {
        return b;
    }
    
    
}
