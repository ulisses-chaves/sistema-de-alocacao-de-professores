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
public class Disciplina {
    private String codigo;
    private String turma;
    private String cor;
    private String tipo;
    private int periodo;

    public Disciplina(String codigo, String turma, String cor) {
        this.codigo = codigo;
        this.turma = turma;
        this.cor = cor;
    }

    public Disciplina(String disciplina, String codigo, Cursos curso, Area area, TipoDisciplina tipoDisciplina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
}
