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
public class Slotss {
    
    private final int id;
    private String tipo;
    private Slot[] slots = new Slot[15];
    private HoraAula[] horaAulas;
    
    public Slotss(ResultSet rs) throws SQLException, ClassNotFoundException {
        this.id = rs.getInt("slots.ID");
        this.tipo = rs.getString("slots.tipo_slot");
        for(Slot s : this.slots) {
            s = new Slot();
            s.setUsado(false);
        }

        this.horaAulas = DisciplinasDAO.getHorariosAula(id);
        for(HoraAula h : this.horaAulas)
            if(h.getNumero() != 0)
                slots[h.getHora_inicio()].getDias()[h.getHora_inicio()] = h.getNumero();
        for(int x=0; x<15; x++){
            boolean check = false;
            for(int i : this.slots[x].getDias())
                if(i != 0)
                    check = true;
            if(check){
                this.slots[x].setHora((x<10?"0":"") + x +":00 - " +((x+1)<10?"0":"") + (x+1));
            }
        }

    }



    public Slotss() {
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
        System.out.println("de:");
        for(int x=0;x<15;x++)
            if(slots[x].isUsado())
                slots[x].print();
        for(int x=0;x<15;x++)
            if(slots[x].isUsado())
                slots[x].troca(n1,n2);
        System.out.println("vai para:");
        for(int x=0;x<15;x++)
            if(slots[x].isUsado())
                slots[x].print();
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        
    public class Slot{
        
        private boolean usado = false;
        String hora;
        private int [] dias = {0,0,0,0,0};
        
        public Slot(){
        }
        public void print(){
            for(int x=0;x<5;x++)
                System.out.print(dias[x]);
            System.out.println("");
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
