/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Connection.DAO.ProfessorDAO;
import com.Hirukar.Project.Models.Users_.Professor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public class Ministra {
    private int ID;
    private Professor professor;
    private Disciplina discplina;
    private int FK_ID_periodo;

    public Ministra(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.ID = rs.getInt("ministra.ID");
        this.professor = ProfessorDAO.getPeloID(rs.getInt("ministra.FK_CPF_professor"));
        this.discplina = DisciplinasDAO.getDisciplina(rs.getInt("ministra.FK_ID_disciplina"));
        this.FK_ID_periodo = rs.getInt("ministra.FK_ID_periodo");
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDiscplina() {
        return discplina;
    }

    public void setDiscplina(Disciplina discplina) {
        this.discplina = discplina;
    }

    public int getFK_ID_periodo() {
        return FK_ID_periodo;
    }

    public void setFK_ID_periodo(int FK_ID_periodo) {
        this.FK_ID_periodo = FK_ID_periodo;
    }
    
    
}
