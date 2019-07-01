package com.Hirukar.Project.Models.Beans.Users;

import com.Hirukar.Project.Models.Beans.Enums.Area;
import com.Hirukar.Project.Models.Beans.Enums.TipoUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Professor extends User{
    public final static List<Professor> todosProfessores = inicializar();
    private String nome;
    private String matricula;
    private Area area;

    public static List<Professor> getTodosProfessores() {
        return todosProfessores;
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
    
    private static List<Professor> inicializar(){
        List<Professor> l = new ArrayList<>();
        l.addAll(Arrays.asList(new Professor("professor1","1001",Area.ARC),
                               new Professor("professor2","1002",Area.ENSISO),
                               new Professor("professor3","1003",Area.FC)));
        return l;
    }
    
    public Professor(ResultSet rs) throws SQLException {
        super(rs.getString("User.login"), rs.getString("User.email"), rs.getString("User.matricula"), rs.getString("User.senha"), rs.getInt("User.tipo"), rs.getInt("User.id"));
    }
    public Professor(String nome,String matricula, Area area){
        super("","","","",0,0);
        this.nome = nome;
        this.matricula = matricula;
        this.area = area;
        
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
