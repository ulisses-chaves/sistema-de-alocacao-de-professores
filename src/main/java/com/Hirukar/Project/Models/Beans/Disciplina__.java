/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author RODEMARCK
 */
public class Disciplina__ {
    private String codigo;
    private String turma;
    private String cor;
    private String tipo;
    private int periodo;
    List<Disciplina__> preRequisito;

    public Disciplina__(String codigo, String turma, String cor,String tipo,int periodo,Disciplina__ ...  preRequisito) {
        this.codigo = codigo;
        this.turma = turma;
        this.cor = cor;
        this.tipo = tipo;
        this.periodo = periodo;
        this.preRequisito = Arrays.asList(preRequisito);
    }
    
    public Disciplina__(){
        this.codigo = "";
        this.turma = "";
        this.codigo = "white";
        this.tipo = "none";
        this.periodo = 0;
        this.preRequisito = Arrays.asList();
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
