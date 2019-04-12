package com.Hirukar.Project.Connection.DAO;

import com.Hirukar.Project.Models.Beans.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    public List<Professor> listarProfessores(){
        List<Professor> l = new ArrayList<Professor>();
        l.add(new Professor("rodemarck","algoritmos"));
        l.add(new Professor("renato","programação"));
        return l;
    }
}
