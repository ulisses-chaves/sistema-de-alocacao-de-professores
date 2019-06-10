package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import java.io.IOException;


public class Professor extends User_{
    private String nome;
    private String matricula;
    private Area area;

    public Professor(String login, String password, String[] ROLES, String nome, String matricula, Area area) throws IOException {
        super(login, password, ROLES);
        this.nome = nome;
        this.area = area;
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    

}
