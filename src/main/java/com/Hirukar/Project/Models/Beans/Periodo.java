/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Enums.Cursos;
import java.sql.ResultSet;

import java.sql.SQLException;


/**
 *
 * @author RODEMARCK
 */
public class Periodo {
    private final int id;
    private int nPeriodo;
    private Slotss slot;
    private Cursos curso;
    private int anoLetivo;
    private HorarioDisciplinas[] horarioDisciplinas;
    
    public Periodo() throws SQLException, ClassNotFoundException {
        this.id = 0;
        slot = new Slotss();
        nPeriodo = 3;
        curso = Cursos.BCC;
    }

    public Periodo(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.id = rs.getInt("periodo.ID");
        this.nPeriodo = rs.getInt("periodo.n_periodo");
        this.curso = Cursos.getCurso(rs.getInt("periodo.FK_ID_curso"));
        this.slot = DisciplinasDAO.getSlots(rs.getInt("periodo.FK_ID_slot"));
        this.horarioDisciplinas = DisciplinasDAO.getHorarioDisciplinas(this.curso.getValue(), nPeriodo);
        this.anoLetivo = rs.getInt("periodo.ano_letivo");
    }
    
    public HorarioDisciplinas getHorarioDisciplina(int numero){
        for(HorarioDisciplinas hd : this.horarioDisciplinas)
            if(hd.getNumero() == numero)
                return hd;
        HorarioDisciplinas h = this.horarioDisciplinas[numero-1];
        return h;

    }

    public int getId() {
        return id;
    }

    public int getPeriodo() {
        return nPeriodo;
    }

    public void setPeriodo(int periodo) {
        this.nPeriodo = periodo;
    }
    
    
    
    public Disciplina get(int index){
        return horarioDisciplinas[index-1].getDisciplina();
    }
    
    public Slotss getSlot() {
        return slot;
    }

    public void setSlot(Slotss slot) {
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
        HorarioDisciplinas h1 = getHorarioDisciplina(n1);
        HorarioDisciplinas h2 = getHorarioDisciplina(n2);
        h1.setNumero(n2);
        h2.setNumero(n1);
        
        //this.slot.troca(n1,n2);
    }

    public int getnPeriodo() {
        return nPeriodo;
    }

    public HorarioDisciplinas[] getHorarioDisciplinas() {
        return horarioDisciplinas;
    }

    public void setnPeriodo(int nPeriodo) {
        this.nPeriodo = nPeriodo;
    }

    public void setHorarioDisciplinas(HorarioDisciplinas[] horarioDisciplinas) {
        this.horarioDisciplinas = horarioDisciplinas;
    }

    public int getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(int anoLetivo) {
        this.anoLetivo = anoLetivo;
    }
    
    
}
