/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import com.Hirukar.Project.Models.Servidor.Repositorio;
import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author RODEMARCK
 */
public class Horarios__ implements Serializable{
    private final int id;
    private int periodo;
    private Slots slot;
    private Cursos curso;
    private Disciplina[] disciplinas = new Disciplina[6];
    
    public Horarios__(){    
        this.id = 0;
        slot = new Slots();
        periodo = 3;
        curso = Cursos.BCC;
        try{
            for(int i=0; i<6;i++)
                disciplinas[i] = Repositorio.get().getDisciplinas().get(i);
        }catch(Exception e){
        }
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
    
    public Horarios__(int id) throws SQLException, ClassNotFoundException{
        DisciplinasDAO dao = new DisciplinasDAO();
        ResultSet rs = null;
        try {
            dao.criaConexao();
            rs = dao.getHorario(id);
            if(!rs.next())
                throw new SQLException("Critical error");
            this.id = rs.getInt("Horario.id");
            this.slot = new Slots(dao.getSlots(rs.getInt("Horario.slots")));
            rs = dao.getDisciplina(rs.getInt("Horario.aulas"));
            /*for(Disciplina d : this.disciplinas)
                d = new Disciplina(rs);*/
        }catch(SQLException | ClassNotFoundException e){
            throw e;
        }finally{
            dao.fechaConexao();
        }
        
    }
    
    public Disciplina get(Object index){
        return disciplinas[Integer.parseInt(""+index)];
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

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public boolean troca(int n1, int n2){
        return this.slot.troca(n1,n2);
    }
    
}
