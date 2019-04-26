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
    private final int id;
    private Slot[] slots = new Slot[15];
    
    public Slots(ResultSet rs) throws SQLException{
        if(!rs.next())
            throw new SQLException("critical error @Slots:Constructor");
        
        this.id = rs.getInt("Slots.id");
        for(Slot s : this.slots)
            s = new Slot(rs);
        
    }
    

    Slots() {
        id = 0;
        for(int x=0 ; x<15 ; x++)
            slots [x] = new Slot();
        slots[7]= new Slot(2,3,4,5,1);
        
        slots[8]= new Slot(2,3,4,5,1);
        
        slots[9]= new Slot(4,5,1,2,3);
        
        slots[10]= new Slot(4,5,1,2,3);
        
        slots[7].setHora("14:00 - 15:00");
        slots[7].setUsado(true);
        slots[8].setHora("15:00 - 16:00");
        slots[8].setUsado(true);
        slots[9].setHora("16:00 - 17:00");
        slots[9].setUsado(true);
        slots[10].setHora("17:00 - 18:00");
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
        String hora;
        private int [] dias = {0,0,0,0,0};
        
        public Slot(ResultSet rs) throws SQLException{
            String texto;
            hora = rs.getString("Sub_slot.hora");
            usado = (1 == rs.getShort("Sub_slot.usado"));
            texto = rs.getString("Sub_slot.hora");
            for(int x=0;x<5;x++)
                dias[x] = Integer.parseInt(""+texto.charAt(x));
            if(!rs.next())
                throw new SQLException("critical error @Sub_slot:Constructor");
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

        public String getHora() {
            return hora;
        }

        public void setHora(String hora) {
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
