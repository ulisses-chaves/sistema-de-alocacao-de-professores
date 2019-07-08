/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Enums.DiasDaSemana;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class HorarioDisciplinas {
    private int ID;
    private int numero;
    private Disciplina disciplina;
    private int FK_ID_periodo;
    private String cor;
    
    public HorarioDisciplinas(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.ID = rs.getInt("horario_disciplinas.ID");
        this.numero = rs.getInt("horario_disciplinas.numero");
        this.cor = rs.getString("horario_disciplinas.cor");
        this.FK_ID_periodo = rs.getInt("horario_disciplinas.FK_ID_periodo");
        this.disciplina = DisciplinasDAO.getDisciplina(rs.getInt("horario_disciplinas.FK_ID_disciplinas"));
    }

    public HorarioDisciplinas(int ID, int numero, Disciplina disciplina) {
        this.ID = ID;
        this.numero = numero;
        this.disciplina = disciplina;

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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public int getFK_ID_slot() {
        return FK_ID_periodo;
    }

    public void setFK_ID_slot(int FK_ID_slot) {
        this.FK_ID_periodo = FK_ID_slot;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
