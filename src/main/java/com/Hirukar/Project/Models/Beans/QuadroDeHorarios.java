/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODEMARCK
 */
public class QuadroDeHorarios {
    private String horario;
    private List<Disciplina> disciplinas;
    public static int tempo = 8;
    public QuadroDeHorarios(String horario,List<Disciplina> disciplinas) {
        this.horario = horario;
        this.disciplinas = disciplinas;
    }

    public QuadroDeHorarios() {
        horario = String.format("%d:00 - %d:00", tempo,tempo+2);
        disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina("001"+tempo,"bc4","black"));
        disciplinas.add(new Disciplina("002"+tempo,"bc4","blue"));
        disciplinas.add(new Disciplina("003"+tempo,"bc4","purple"));
        disciplinas.add(new Disciplina("004"+tempo,"bc4","green"));
        disciplinas.add(new Disciplina("005"+tempo,"bc4","yellow"));
        tempo += 2;
        
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
}
