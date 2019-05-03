package com.Hirukar.Project.Models.Beans.Users;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Professor extends User{
    private String nome;
    private String disciplina;
    private Area area;

    public Professor(ResultSet rs) throws SQLException {
        super(rs.getString("User.login"), rs.getString("User.email"), rs.getString("User.matricula"), rs.getString("User.senha"), rs.getInt("User.tipo"), rs.getInt("User.id"));
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
