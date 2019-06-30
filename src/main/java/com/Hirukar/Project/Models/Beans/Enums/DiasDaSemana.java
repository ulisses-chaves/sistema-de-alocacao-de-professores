/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans.Enums;

/**
 *
 * @author RODEMARCK
 */
public enum DiasDaSemana {
    SEGUNDA(0),TERCA(1),QUARTA(2),QUINTA(3),SEXTA(4),SABADO(5);
    
    private final int value;
    
    private DiasDaSemana(int value){
        this.value = value;
    }
    
    public static DiasDaSemana getDia(String value){
        switch(value.toUpperCase()){
            case "SEGUNDA": return SEGUNDA;
            case "TERCA": return TERCA;
            case "QUARTA": return QUARTA;
            case "QUINTA": return QUINTA;
            case "SEXTA": return SEXTA;
            case "SABADO": return SABADO;
        }
        return null;
    }
    
    public int getValue() {
        return value;
    }
}
