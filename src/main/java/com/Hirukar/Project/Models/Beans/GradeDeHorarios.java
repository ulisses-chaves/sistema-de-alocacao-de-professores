package com.Hirukar.Project.Models.Beans;

import java.util.ArrayList;
import java.util.List;

public class GradeDeHorarios {
    private List<Horario> quadros;

    public GradeDeHorarios() {
        quadros = new ArrayList<>();
        Horario.reset();
        for(int x=0; x<14 ; x++)
            quadros.add(new Horario());
    }
    public List<Horario> getQuadros(){
        return quadros;
    }
    public void setQuadros(List<Horario> quadros){
        this.quadros = quadros;
    }
}
