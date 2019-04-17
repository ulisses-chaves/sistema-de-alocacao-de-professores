/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODEMARCK
 */
public class Horarios__ {
    private String horario;
    private Disciplina[] disciplinas;
    private int[][] slots;
    
    public Horarios__(Cursos curso,TipoDisciplina tipoDisciplina,Disciplina... disciplinas){
        
    }
    
    private int[][] setSlots(Cursos curso,TipoDisciplina tipoDisciplina){
        
        return null;
    }
}
