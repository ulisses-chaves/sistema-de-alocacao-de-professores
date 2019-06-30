package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Models.Beans.Disciplina__;
import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import java.io.*;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Professor {
    private String CPF;
    private String nome;
    private Area area;
    private String login;
    private String senha;
    private TipoUsuario cargo;
    private Disciplina__ preferencia1;
    private Disciplina__ preferencia2;
    
    public Professor(ResultSet rs){
        
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public TipoUsuario getCargo() {
        return cargo;
    }

    public void setCargo(TipoUsuario cargo) {
        this.cargo = cargo;
    }

    public Disciplina__ getPreferencia1() {
        return preferencia1;
    }

    public void setPreferencia1(Disciplina__ preferencia1) {
        this.preferencia1 = preferencia1;
    }

    public Disciplina__ getPreferencia2() {
        return preferencia2;
    }

    public void setPreferencia2(Disciplina__ preferencia2) {
        this.preferencia2 = preferencia2;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
