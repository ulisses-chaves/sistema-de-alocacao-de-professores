/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Disciplina__;
import com.Hirukar.Project.Models.Beans.Horarios__;
import com.Hirukar.Project.Models.Beans.Slots;
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
public abstract class DisciplinasDAO {

    
    public static Horarios__ getHorario(int id)  throws ClassNotFoundException,SQLException{
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Horarios__ horarios = null;
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return horarios;
    }
    
    public static Disciplina__ getDisciplina(int id) throws ClassNotFoundException,SQLException{
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina__ d = null;
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return d;
    }
    
    
    public static Slots getSlots(int id) throws ClassNotFoundException,SQLException{
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Slots s = null;
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return s;
    }
}
