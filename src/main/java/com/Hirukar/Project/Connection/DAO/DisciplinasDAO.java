/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Connection.ConnectionFactory.DatabaseConnection;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Beans.HoraAula;
import com.Hirukar.Project.Models.Beans.HorarioDisciplinas;
import com.Hirukar.Project.Models.Beans.Periodo;
import com.Hirukar.Project.Models.Beans.Slots;
import com.Hirukar.Project.Models.Beans.Slotss;
import com.Hirukar.Project.Models.Enums.Cursos;
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

    public static Periodo getPeriodo(int idCurso, int nPeriodo) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Periodo horarios = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM slots\n"
                    + "	INNER JOIN periodo\n"
                    + "	ON periodo.FK_ID_slot=slots.ID\n"
                    + "    	INNER JOIN curso\n"
                    + "           ON periodo.FK_ID_curso=curso.ID\n"
                    + "WHERE curso.ID=? AND periodo.n_periodo=?"
            );
            stmt.setInt(1, idCurso);
            stmt.setInt(2, nPeriodo);
            rs = stmt.executeQuery();
            if (rs.next()) {
                horarios = new Periodo(rs);
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return horarios;
    }

    public static Disciplina getDisciplina(int idDisciplina) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Disciplina d = null;
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM `disciplina` \n" +
                    "WHERE disciplina.ID=?"
            );
            stmt.setInt(1, idDisciplina);
            rs = stmt.executeQuery();
            if(rs.next())
                d = new Disciplina(rs);
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return d;
    }

    public static void cadastrar(Disciplina d) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "insert into disciplina \n"
                    + "	(Nome,Tipo,Area,Codigo) \n"
                    + "values \n"
                    + "	(?,?,?,?)"
            );
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getTipo().name());
            stmt.setString(3, d.getArea().name());
            stmt.setString(4, d.getCodigo());
            stmt.execute();

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.getInstance().close(con, stmt);
        }

    }

    public static ArrayList<Disciplina> listar() throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "select * from disciplina where 1"
            );
            rs = stmt.executeQuery();
            while (rs.next()) {
                disciplinas.add(new Disciplina(rs));
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return disciplinas;
    }

    public static HoraAula[] getHorariosAula(int idSlots) throws ClassNotFoundException, SQLException {
        HoraAula[] ha = null;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<HoraAula> array = new ArrayList<>();
        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM hora_aula\n"
                    + "\tINNER JOIN slots\n"
                    + "   \tON hora_aula.FK_ID_slot=slots.ID\n"
                    + "WHERE slots.ID=?"
            );
            stmt.setInt(1, idSlots);
            rs = stmt.executeQuery();
            while (rs.next()) {
                array.add(new HoraAula(rs));
            }
            ha = new HoraAula[array.size()];
            ha = array.toArray(ha);

        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }

        return ha;
    }
    public static HorarioDisciplinas[] getHorarioDisciplinas(int idCurso,int nPeriodo) throws ClassNotFoundException, SQLException {
        HorarioDisciplinas[] hd = null;
        ArrayList<HorarioDisciplinas> array = new ArrayList<>();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        try{
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM `horario_disciplinas` \n" +
                    "	INNER JOIN periodo\n" +
                    "    ON horario_disciplinas.FK_ID_periodo=periodo.ID\n" +
                    "    	INNER JOIN curso\n" +
                    "           ON periodo.FK_ID_curso=curso.ID\n" +
                    "WHERE curso.ID=? AND periodo.n_periodo=?"
            );
            stmt.setInt(1, idCurso);
            stmt.setInt(2, nPeriodo);
            rs = stmt.executeQuery();
            while(rs.next())
                array.add(new HorarioDisciplinas(rs));
            hd = new HorarioDisciplinas[array.size()];
            hd = array.toArray(hd);
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }finally{
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return hd;
    }

    public static Slotss getSlots(int id) throws ClassNotFoundException, SQLException {
        Connection con = null;
        Slotss s = null;
        PreparedStatement stmt = null;
        ResultSet rs  = null;
        try {
            con = DatabaseConnection.getInstance().getConnection();
            stmt = con.prepareStatement(
                    "SELECT * FROM slots\n" +
                    "WHERE slots.ID=?"
            );
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next())
                s = new Slotss(rs);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }finally        {
            DatabaseConnection.getInstance().close(con, rs, stmt);
        }
        return s;
    }

    public static void atualiza(String nome, Disciplina disciplina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static Cursos getCurso(int idCurso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
