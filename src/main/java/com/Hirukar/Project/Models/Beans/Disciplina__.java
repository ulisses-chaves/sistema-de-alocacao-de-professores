/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import static com.Hirukar.Project.Models.Beans.Enums.Area.EXTERNA;
import com.Hirukar.Project.Models.Beans.Enums.Cursos;
import com.Hirukar.Project.Models.Beans.Enums.TipoDisciplina;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author RODEMARCK
 */
public class Disciplina__ {
    public final static  List<Disciplina__> todasDisciplinas = inicializar();
    private int ID;
    private String nome;
    private String cor;
    private String codigo;
    private TipoDisciplina tipo;
    private Area area;
    List<Disciplina__> preRequisito;
    
    
    public boolean remover(int n){
        return this.area == Area.getArea(n);
    }
   

    Disciplina__(ResultSet rs) {
        
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public TipoDisciplina getTipo() {
        return tipo;
    }

    public void setTipo(TipoDisciplina tipo) {
        this.tipo = tipo;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    public List<Disciplina__> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(List<Disciplina__> preRequisito) {
        this.preRequisito = preRequisito;
    }

    public int getID() {
        return ID;
    }
    
    public void serID(int ID){
        this.ID = ID;
    }
}
