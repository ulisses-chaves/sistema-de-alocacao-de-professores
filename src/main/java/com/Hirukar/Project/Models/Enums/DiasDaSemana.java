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
public enum DiasDaSemana {
    SEGUNDA(0),TERCA(1),QUARTA(2),QUINTA(3),SEXTA(4);
    
    private final int value;
    
    private DiasDaSemana(int value){
        this.value = value;
    }
    
    public static DiasDaSemana valueOf(int value){

        switch(value){
            case 0: return SEGUNDA;
            case 1: return TERCA;
            case 2: return QUARTA;
            case 3: return QUINTA;
            case 4: return SEXTA;
        }
        return null;
    }
    
    public int getValue() {
        return value;
    }
}
