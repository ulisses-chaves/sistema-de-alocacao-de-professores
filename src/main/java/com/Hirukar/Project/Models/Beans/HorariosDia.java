/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

/**
 *
 * @author RODEMARCK
 */
public class HorariosDia {

    private Disciplina__[] espacos = new Disciplina__[15];
    private String s = "sou gay";

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public HorariosDia() {
        //for(int x=0;x<15;x++)
        //    espacos[x] = new Disciplina__();
    }

    public HorariosDia(boolean naoNulo, Disciplina__... espacos) {
        this.espacos = espacos;
    }

    public void setEspacoDisciplina(int t, Disciplina__ d) {
        this.espacos[t - 7] = d;
    }

    public Disciplina__[] getEspacos() {
        return espacos;
    }

    public void setEspacos(Disciplina__[] espacos) {
        this.espacos = espacos;
    }

}
