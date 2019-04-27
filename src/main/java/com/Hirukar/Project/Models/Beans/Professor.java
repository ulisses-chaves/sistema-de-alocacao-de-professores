package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Professor extends User{
    private String nome;
    private String disciplina;
    private Area area;



    
    Professor(ResultSet rs) throws SQLException {
        super(rs.getString("User.login"),rs.getString("User.senha"),rs.getString("User.email"),rs.getString("User.matricula"));
        this.area = Area.getArea(rs.getInt("User.area"));
    }

    public Professor(String name, String login, String senha, String email, String codigo, Area area) {
        super(login,senha,email,codigo);
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



    
}
