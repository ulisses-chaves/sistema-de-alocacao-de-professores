/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Beans.Enums.DiasDaSemana;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

/**
 *
 * @author RODEMARCK
 */
public class HorarioDisciplinas {
    private int ID;
    private int numero;
    private Disciplina__ disciplina;
    private DiasDaSemana dia1;   
    private DiasDaSemana dia2;   
    private int horario1;
    private int horario2;

    public HorarioDisciplinas(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.ID = rs.getInt("horario_disciplinas.ID");
        this.numero = rs.getInt("horario_disciplinas.numero");
        this.disciplina = DisciplinasDAO.getDisciplina(rs.getInt("horario_disciplinas.FK_ID_disciplinas"));
        this.dia1 = DiasDaSemana.getDia(rs.getString("horario_disciplinas.dia1"));
        this.dia2 = DiasDaSemana.getDia(rs.getString("horario_disciplinas.dia2"));
        this.horario1 = rs.getInt("horario_disciplinas.horario1");
        this.horario2 = rs.getInt("horario_disciplinas.horario2");
    }

    public HorarioDisciplinas(int ID, int numero, Disciplina__ disciplina, DiasDaSemana dia1, DiasDaSemana dia2, int horario1, int horario2) {
        this.ID = ID;
        this.numero = numero;
        this.disciplina = disciplina;
        this.dia1 = dia1;
        this.dia2 = dia2;
        this.horario1 = horario1;
        this.horario2 = horario2;
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Disciplina__ getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina__ disciplina) {
        this.disciplina = disciplina;
    }

    public DiasDaSemana getDia1() {
        return dia1;
    }

    public void setDia1(DiasDaSemana dia1) {
        this.dia1 = dia1;
    }

    public DiasDaSemana getDia2() {
        return dia2;
    }

    public void setDia2(DiasDaSemana dia2) {
        this.dia2 = dia2;
    }

    public int getHorario1() {
        return horario1;
    }

    public void setHorario1(int horario1) {
        this.horario1 = horario1;
    }

    public int getHorario2() {
        return horario2;
    }

    public void setHorario2(int horario2) {
        this.horario2 = horario2;
    }
    
}
