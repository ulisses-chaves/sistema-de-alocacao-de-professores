/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Disciplina;
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
public class DisciplinasDAO {
    Connection con;
    
    public void criaConexao() throws ClassNotFoundException,SQLException{
        if(con != null)
            try {
                con = new DatabaseConnection().getConnection();
            } catch (SQLException ex) {
                new DatabaseConnection().close(con);
                throw ex;
            }
    }
    
    public ResultSet getHorario(int id) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Horarios WHERE Horario.id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            new DatabaseConnection().close(con,rs, stmt);
            throw ex;
        }
    }
    
    public ResultSet getDisciplina(int id) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Disciplina "
                                       +"INNER JOIN Aulas "
                                       +"ON Disciplinas.Aulas_id=Aulas.id"
                                       +"WHERE Aulas.id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            new DatabaseConnection().close(con,rs, stmt);
            throw ex;
        }
    }
    
    
    public ResultSet getSlots(int id) throws SQLException{
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement("SELECT * FROM Slots "
                                       +"INNER JOIN Sub_slot "
                                       +"ON Sub_slot.Slot_id=Slots.id "
                                       +"WHERE Slots.id=?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            new DatabaseConnection().close(con,rs, stmt);
            throw ex;
        }
    }
    
    public void fechaConexao() throws SQLException{
        if(con != null)
            new DatabaseConnection().close(con);
    }
}
