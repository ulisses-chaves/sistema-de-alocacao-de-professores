/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Servidor;

import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Users_.Professor;

/**
 *
 * @author RODEMARCK
 */
public class Ministra {
    private Disciplina disciplina;
    private Professor professor;
    private String periodo;

    public Ministra(Disciplina disciplina, Professor professor, String periodo) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.periodo = periodo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
}
