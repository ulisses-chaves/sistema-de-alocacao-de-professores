/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;


/**
 *
 * @author RODEMARCK
 */
public class Horarios__ {
    private Slots slot;
    private Disciplina__[] disciplinas = new Disciplina__[6];
    
    public Horarios__(int id) throws IllegalAccessException{
        slot = new Slots();
        disciplinas[0] = new Disciplina__();
        disciplinas[1] = new Disciplina__("prog", "0001", "red", Cursos.BCC, Area.ENCISO, TipoDisciplina.OBRIGATORIA);
        disciplinas[2] = new Disciplina__("alg", "0002", "blue", Cursos.BCC, Area.ARC, TipoDisciplina.OBRIGATORIA);
        disciplinas[3] = new Disciplina__("calc", "0003", "green", Cursos.BCC, Area.ARC, TipoDisciplina.OBRIGATORIA);
        disciplinas[4] = new Disciplina__("icc", "0003", "pink", Cursos.BCC, Area.ARC, TipoDisciplina.OBRIGATORIA);
        disciplinas[5] = new Disciplina__("disc", "000", "yellow", Cursos.BCC, Area.FC, TipoDisciplina.OBRIGATORIA);
    }
    
    public Disciplina__ get(Object index){
        //return disciplinas[Integer.parseInt(index)];
        System.out.println(index);
        return disciplinas[Integer.parseInt(""+index)];
    }
    
    public Slots getSlot() {
        return slot;
    }

    public void setSlot(Slots slot) {
        this.slot = slot;
    }

    public Disciplina__[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina__[] disciplinas) {
        this.disciplinas = disciplinas;
    }
    
}
