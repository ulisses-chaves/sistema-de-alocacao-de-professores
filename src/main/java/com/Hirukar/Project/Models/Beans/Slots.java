/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author RODEMARCK
 */
public class Slots {
    private Slot[] slots = new Slot[15];
    
    public Slots(ResultSet rs) throws SQLException{
        for(int x=7 ; x<22 ; x++)
            slots [x] = new Slot();
        
    }

    Slots() {
        for(int x=0 ; x<15 ; x++)
            slots [x] = new Slot();
        slots[4]= new Slot(2,3,4,0,1);
        slots[5]= new Slot(4,3,1,0,2);
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }
    public class Slot{
        private boolean usado = false;
        int hora;
        private int [] dias = {0,0,0,0,0};
        public Slot(ResultSet rs, int hora) throws SQLException{
            this.hora = hora;
            for(int x=0;x<5;x++)
                if(dias[x]!=0)
                    this.usado=true;
            
        }
        
        public Slot(){
            this.usado = false;
        }
        public Slot(int ... v){
            usado = true;
            this.dias = v;
        }
        public boolean isUsado() {
            return usado;
        }

        public void setUsado(boolean usado) {
            this.usado = usado;
        }

        public int getHora() {
            return hora;
        }

        public void setHora(int hora) {
            this.hora = hora;
        }

        public int[] getDias() {
            return dias;
        }

        public void setDias(int[] dias) {
            this.dias = dias;
        }
        
    }
    
}
