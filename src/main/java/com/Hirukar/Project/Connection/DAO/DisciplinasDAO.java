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
import java.util.ArrayList;
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
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina__ d = null;
        con = DatabaseConnection.getInstance().getConnection();
        
        
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return d;
    }
    
    
    public static void cadastrar(Disciplina__ d) throws ClassNotFoundException,SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                        "insert into disciplina \n"+
			"	(Nome,Tipo,Area,Codigo) \n"+
			"values \n"+
			"	(?,?,?,?)"
            );
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getTipo().name());
            stmt.setString(3, d.getArea().name());
            stmt.setString(4, d.getCodigo());
            stmt.execute();
            
            
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, stmt);
        }
        
        
    }
    
    
    public static ArrayList<Disciplina__> listar()  throws ClassNotFoundException,SQLException {
    	Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Disciplina__> disciplinas = new ArrayList<>();
        
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "select * from disciplina where 1"
            );
            rs = stmt.executeQuery();
            while(rs.next())
            	disciplinas.add(new Disciplina__(rs));
            
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs , stmt);
        }

        
        return disciplinas; 
        
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
