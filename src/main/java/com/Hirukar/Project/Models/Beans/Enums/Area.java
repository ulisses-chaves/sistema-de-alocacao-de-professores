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
public enum Area {
    ARC(0),ENSISO(1),FC(2),EXTERNA(3),FLUTUANTE(4);
    
    private final int value;
    public int getValue(){
        return value;
    }
    public static Area getArea(int n){
       switch(n){
            case 0: return Area.ARC;
            case 1: return Area.ENSISO;
            case 2: return Area.FC;
            case 3: return EXTERNA;
            case 4: return FLUTUANTE;
       }
            return Area.ARC;
    }
    private Area(int n){
        value = n;
    }
}
