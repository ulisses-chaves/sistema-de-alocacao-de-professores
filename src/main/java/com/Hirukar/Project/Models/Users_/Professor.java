package com.Hirukar.Project.Models.Users_;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Beans.Disciplina;
import com.Hirukar.Project.Models.Enums.Area;
import com.Hirukar.Project.Models.Enums.TipoUsuario;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor implements Serializable{
    private String CPF;
    private String nome;
    private Area area;
    private String login;
    private String senha;
    private TipoUsuario cargo;
    private Disciplina preferencia1;
    private Disciplina preferencia2;
    
    public Professor(ResultSet rs) throws SQLException, ClassNotFoundException{
        String prof = "professor";
        try{this.CPF = rs.getString("professor.CPF");
        }catch(SQLException e){
            prof = "P";
            this.CPF = rs.getString("P.CPF");
        }
        this.nome = rs.getString(prof+".Nome");
        this.area = Area.valueOf(rs.getString(prof+".Area").toUpperCase());
        this.login = rs.getString(prof+".Login");
        this.senha = rs.getString(prof+".senha");
        this.cargo = TipoUsuario.valueOf(rs.getString(prof+".cargo").toUpperCase());
        this.preferencia1 = rs.getInt(prof+".FK_Disciplina_Preferencia_1") == 0 ? 
                null : DisciplinasDAO.getDisciplina(rs.getInt(prof+".FK_Disciplina_Preferencia_1"));
        this.preferencia2 = rs.getInt(prof+".FK_Disciplina_Preferencia_2") == 0 ? 
                null : DisciplinasDAO.getDisciplina(rs.getInt(prof+".FK_Disciplina_Preferencia_2"));
    }
    public Professor(){
        this.login = " ";
        this.senha = " ";
        this.CPF = " ";
        this.cargo = TipoUsuario.PROFESSOR;
    }
    public Professor(String CPF, String nome, Area area, String login, String senha, TipoUsuario cargo) {
        this.CPF = CPF;
        this.nome = nome;
        this.area = area;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
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

    public Disciplina getPreferencia1() {
        return preferencia1;
    }

    public void setPreferencia1(Disciplina preferencia1) {
        this.preferencia1 = preferencia1;
    }

    public Disciplina getPreferencia2() {
        return preferencia2;
    }

    public void setPreferencia2(Disciplina preferencia2) {
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
