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
public enum TipoUsuario {
    PROFESSOR(0),COORDENADOR(1),SUPERVISOR(2);
    
    private final int value;
    
    public static TipoUsuario getTipoUsuario(int n){
        switch(n){
            case 0: return PROFESSOR;
            case 1: return COORDENADOR;
            case 2: return SUPERVISOR;
            default: return PROFESSOR;
        }
    }
    
    public int getValue(){
        return value;
    }
    
    private TipoUsuario(int n){
        this.value = n;
    }
}
