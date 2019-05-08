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
    private String nome;
    private String codigo;
    private String turma;
    private String cor;
    private TipoDisciplina tipo;
    private Area area;
    private Cursos curso;
    private int periodo ;
    List<Disciplina__> preRequisito;
    
    
    public boolean remover(int n){
        return this.area == Area.getArea(n);
    }
    public static List<Disciplina__> inicializar(){
        List<Disciplina__> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(new Disciplina__(),
                                   new Disciplina__("prog", "0001", "#373a07", Cursos.BCC, Area.ENCISO, TipoDisciplina.OBRIGATORIA),
                                   new Disciplina__("alg", "0002", "#700202", Cursos.BCC, Area.ENCISO, TipoDisciplina.OBRIGATORIA),
                                   new Disciplina__("calc", "0004", "#144b03", Cursos.BCC, Area.EXTERNA, TipoDisciplina.OBRIGATORIA),
                                   new Disciplina__("icc", "0005", "#9e6105", Cursos.BCC, Area.ARC, TipoDisciplina.OBRIGATORIA),
                                   new Disciplina__("disc", "0006", "#140458", Cursos.BCC, Area.FC, TipoDisciplina.OBRIGATORIA)));
        return lista;
    }
   

    public Disciplina__ (String disciplina, String codigo,String cor, Cursos curso, Area area, TipoDisciplina tipoDisciplina,Disciplina__ ... preRequisito){
        this.nome = disciplina;
        this.codigo = codigo;
        this.turma = "BC3";
        this.curso = curso;
        this.area = area;
        this.tipo = tipoDisciplina;
        this.periodo = -1;
        this.preRequisito = Arrays.asList(preRequisito);
        this.cor = cor;
    }

    public Disciplina__(){
        this.nome = "--";
        this.codigo = "";
        this.turma = "";
        this.curso = Cursos.getCurso(0);
        this.area = Area.EXTERNA;
        this.tipo = TipoDisciplina.getTipoDisciplina(0);
        this.periodo = -1;
        this.preRequisito = Arrays.asList();
        this.cor = "white";
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
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

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public List<Disciplina__> getPreRequisito() {
        return preRequisito;
    }

    public void setPreRequisito(List<Disciplina__> preRequisito) {
        this.preRequisito = preRequisito;
    }
}
