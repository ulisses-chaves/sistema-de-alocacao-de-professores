/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Enums;

/**
 *
 * @author RODEMARCK
 */
public enum TipoDisciplina {
    OBRIGATORIA(0),OPTATIVA(1),ELETIVA(2);
    private final int value;
    public int getValue(){
        return value;
    }
    public static TipoDisciplina getTipoDisciplina(int n){
        switch(n){
            case 0: return TipoDisciplina.OBRIGATORIA;
            case 1: return TipoDisciplina.OPTATIVA;
            case 2: return TipoDisciplina.ELETIVA;
        }
       return TipoDisciplina.OBRIGATORIA;
    }
    private TipoDisciplina(int n){
        value = n;
    }
}
