package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import java.sql.SQLException;


public class Professor extends User{
    private String nome;
    private String disciplina;

    public Professor(String name, String login, String senha, String email, String codigo, Area area) throws SQLException {
        super(null);
    }

    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Professor(String nome, String disciplina) throws SQLException {
        super(null);
        this.nome = nome;
        this.disciplina = disciplina;
    }

    
}
