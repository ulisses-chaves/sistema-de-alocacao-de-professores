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
    ARC(0),ENCISO(1),FC(2);
    
    private final int value;
    public int getValue(){
        return value;
    }
    public static Area getArea(int n){
       switch(n){
            case 0: return Area.ARC;
            case 1: return Area.ENCISO;
            case 2: return Area.FC;
       }
            return null;
    }
    private Area(int n){
        value = n;
    }
}
