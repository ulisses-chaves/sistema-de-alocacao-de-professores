/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans.Users;

import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RODEMARCK
 */
public abstract class User {

    private String login;
    private String email;
    private String matricula;
    private String senha;
    private TipoUsuario tipo;
    private int id;

    public static User logar(ResultSet rs) throws SQLException {
        switch (TipoUsuario.getTipoUsuario(rs.getInt("User.tipo"))) {
            case PROFESSOR: return new Professor(rs);
            case COORDENADOR: return new Coordenador(rs);
            case SUPERVISOR: return new Supervisor(rs);
            default: return null;
        }
    }

    public User(String login, String email, String matricula, String senha, int tipo, int id) {
        this.login = login;
        this.email = email;
        this.matricula = matricula;
        this.senha = senha;
        this.tipo = TipoUsuario.getTipoUsuario(tipo);
        this.id = id;
    }

    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

}
