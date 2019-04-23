/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
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
            slots [x] = new Slot(x+7);
        
    }
    

    Slots() {
        for(int x=0 ; x<15 ; x++)
            slots [x] = new Slot();
        slots[7]= new Slot(2,3,4,5,1);
        
        slots[8]= new Slot(2,3,4,5,1);
        
        slots[9]= new Slot(4,5,1,2,3);
        
        slots[10]= new Slot(4,5,1,2,3);
        
        slots[7].setHora(14);
        slots[7].setUsado(true);
        slots[8].setHora(15);
        slots[8].setUsado(true);
        slots[9].setHora(16);
        slots[9].setUsado(true);
        slots[10].setHora(17);
        slots[10].setUsado(true);
    }
    
    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public boolean troca(int n1, int n2) {
        for(int x=0;x<15;x++)
            slots[x].troca(n1,n2);
        return true;
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
        }
        public Slot(int ... v){
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

        private void troca(int n1, int n2) {
            System.out.println("vector:"+dias.length);
            for(int x=0 ;x<5 ;x++){
                if(dias[x] == n1){
                    dias[x] = n2;
                }
                else if(dias[x] == n2){
                    dias[x] = n1;
                }
            }
        }
    }
    
}
