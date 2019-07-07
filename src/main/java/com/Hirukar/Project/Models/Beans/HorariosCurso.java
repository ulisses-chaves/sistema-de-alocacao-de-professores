/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Enums.Cursos;

import java.sql.SQLException;


/**
 *
 * @author RODEMARCK
 */
public class HorariosCurso {
    private final int id;
    private int periodo;
    private Slots slot;
    private Cursos curso;
    private HorarioDisciplinas[] horarioDisciplinas = new HorarioDisciplinas[6];
    
    public HorariosCurso() throws SQLException, ClassNotFoundException {
        this.id = 0;
        slot = new Slots();
        periodo = 3;
        curso = Cursos.BCC;
    }

    public int getId() {
        return id;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }
    
    
    
    public Disciplina get(String index){
        return horarioDisciplinas[Integer.parseInt(index)].getDisciplina();
    }
    
    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }
    
    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public HorarioDisciplinas[] getDisciplinas() {
        return horarioDisciplinas;
    }

    public void setDisciplinas(HorarioDisciplinas[] disciplinas) {
        this.horarioDisciplinas = disciplinas;
    }
    
    public void troca(int n1, int n2){
        this.slot.troca(n1,n2);
    }
    
}
