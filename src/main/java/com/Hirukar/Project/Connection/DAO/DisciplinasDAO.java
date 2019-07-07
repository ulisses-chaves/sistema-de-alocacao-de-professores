/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.HoraAula;
import com.Hirukar.Project.Models.Beans.HorariosCurso;
import com.Hirukar.Project.Models.Beans.Slots;
import com.Hirukar.Project.Models.Enums.DiasDaSemana;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RODEMARCK
 */
public abstract class DisciplinasDAO {

    
    public static HorariosCurso getHorario(int id)  throws ClassNotFoundException,SQLException{
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        HorariosCurso horarios = null;
        
        
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return horarios;
    }
    
    public static Disciplina getDisciplina(int id) throws ClassNotFoundException,SQLException{
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina d = null;
        con = DatabaseConnection.getInstance().getConnection();
        
        
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return d;
    }
    
    
    public static void cadastrar(Disciplina d) throws ClassNotFoundException,SQLException{
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
    
    
    public static ArrayList<Disciplina> listar()  throws ClassNotFoundException,SQLException {
    	Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "select * from disciplina where 1"
            );
            rs = stmt.executeQuery();
            while(rs.next())
            	disciplinas.add(new Disciplina(rs));
            
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs , stmt);
        }
        return disciplinas;
    }

    public static HoraAula[] getHorariosAula(int id) throws ClassNotFoundException,SQLException {
        HoraAula[] ha = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<HoraAula> array = new ArrayList<>();
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM hora_aula\n" +
                    "\tINNER JOIN slots\n" +
                    "   \tON hora_aula.FK_ID_slot=slots.ID\n" +
                    "WHERE slots.ID=?"
            );
            rs = stmt.executeQuery();
            array.add(HoraAula.nulo);
            while (rs.next())
                array.add(new HoraAula(rs));
            ha = new HoraAula[array.size()];
            ha = array.toArray(ha);

        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally {
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }

        return ha;
    }
    
    
    public static Slots getSlots(int id) throws ClassNotFoundException,SQLException {
        Connection con = DatabaseConnection.getInstance().getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Slots s = null;
        
        DatabaseConnection.getInstance().close(con, rs, stmt);
        return s;
    }

    public static void atualiza(String nome, Disciplina disciplina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void init() throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            con = DatabaseConnection.getInstance().getConnection();
            String sql = "INSERT INTO hora_aula\n" +
                    "\t(dia_da_semana,hora_inicio,numero,FK_ID_slot)\n" +
                    "VALUES \n";
            for(int x=0;x<20;x++){
                sql+="(?,?,?,?)" + (x==19? "": ",\n");
            }
            stmt = con.prepareStatement(
                    sql
            );
            int[] aulas = new int[]{
                    1, 2,
                    3, 4,
                    2, 5,
                    4, 1,
                    5, 3
            };
            int i = 1;
            for(int x=0; x<20; x++){
                stmt.setString(i++,DiasDaSemana.valueOf(Math.floorDiv(x,4)).name());
                stmt.setInt(i++,14+(x%4));
                stmt.setInt(i++,aulas[Math.floorDiv(x,2)]);
                stmt.setInt(i++,1);

            }
           stmt.execute();


        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs , stmt);
        }
    }
}
