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

    private Disciplina[] espacos = new Disciplina[15];


    public HorariosDia() {
        //for(int x=0;x<15;x++)
        //    espacos[x] = new Disciplina();
    }

    public HorariosDia(boolean naoNulo, Disciplina... espacos) {
        this.espacos = espacos;
    }

    public void setEspacoDisciplina(int t, Disciplina d) {
        this.espacos[t - 7] = d;
    }

    public Disciplina[] getEspacos() {
        return espacos;
    }

    public void setEspacos(Disciplina[] espacos) {
        this.espacos = espacos;
    }

}
