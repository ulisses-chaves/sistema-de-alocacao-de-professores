package com.Hirukar.Project.Models.Beans;

import java.util.ArrayList;
import java.util.List;

public class GradeDeHorarios {
    private List<QuadroDeHorarios> quadros;

    public GradeDeHorarios() {
        quadros = new ArrayList<>();
        QuadroDeHorarios.reset();
        for(int x=0; x<14 ; x++)
            quadros.add(new QuadroDeHorarios());
    }
    public List<QuadroDeHorarios> getQuadros(){
        return quadros;
    }
    public void setQuadros(List<QuadroDeHorarios> quadros){
        this.quadros = quadros;
    }
}
