/*
    * To change this license header, choose License Headers in Project Properties.
    * To change this template file, choose Tools | Templates
        * and open the template in the editor.
 */
package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Connection.DAO.DisciplinasDAO;
import com.Hirukar.Project.Models.Enums.DiasDaSemana;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author RODEMARCK
 */
public class Slots {

    private int ID;
    private ArrayList<HorarioDisciplinas> horariosDisciplinas;
    private final HorariosDia[] horarios = new HorariosDia[5];
    private final boolean[] naoNulos = new boolean[15];
    private final String[] tempo = new String[15];

    public Slots(ResultSet rs) throws SQLException, ClassNotFoundException {

        horariosDisciplinas = new ArrayList<HorarioDisciplinas>();
        this.ID = rs.getInt("slots.ID");
        ArrayList<HorarioDisciplinas> h = new ArrayList<>();
        while (rs.next()) {
            horariosDisciplinas.add(new HorarioDisciplinas(rs));
        }
        horariosDisciplinas.forEach((t) -> {
            horarios[t.getDia1().getValue()].setEspacoDisciplina(t.getHorario1(), t.getDisciplina());
            horarios[t.getDia2().getValue()].setEspacoDisciplina(t.getHorario2(), t.getDisciplina());
        });
    }

    public Slots() throws ClassNotFoundException, SQLException {
        defineHorario();
        this.ID = 0;
        horariosDisciplinas = new ArrayList<HorarioDisciplinas>();
        ArrayList<Disciplina> a = DisciplinasDAO.listar();
        
        horariosDisciplinas.add(new HorarioDisciplinas(1, 1, a.get(0), DiasDaSemana.SEGUNDA, DiasDaSemana.QUINTA, 14, 16));
        horariosDisciplinas.add(new HorarioDisciplinas(2, 2, a.get(1), DiasDaSemana.SEGUNDA, DiasDaSemana.QUARTA, 16, 14));
        horariosDisciplinas.add(new HorarioDisciplinas(3, 3, a.get(2), DiasDaSemana.TERCA, DiasDaSemana.SEXTA, 14, 16));
        horariosDisciplinas.add(new HorarioDisciplinas(4, 4, a.get(3), DiasDaSemana.TERCA, DiasDaSemana.QUINTA, 16, 14));
        horariosDisciplinas.add(new HorarioDisciplinas(5, 5, a.get(4), DiasDaSemana.QUARTA, DiasDaSemana.SEXTA, 16, 14));

        for (int x = 0; x < 5; x++) {
            horarios[x] = new HorariosDia();
        }
        horariosDisciplinas.forEach((t) -> {
            horarios[t.getDia1().getValue()].setEspacoDisciplina(t.getHorario1(), t.getDisciplina());
            horarios[t.getDia2().getValue()].setEspacoDisciplina(t.getHorario2(), t.getDisciplina());
        });
        verificaNulos();
    }

    public void troca(Disciplina d1, Disciplina d2){
        for(HorarioDisciplinas h : this.horariosDisciplinas){
            if(h.getDisciplina().equals(d1))
                h.setDisciplina(d2);
            else if(h.getDisciplina().equals(d2))
                h.setDisciplina(d1);
        }
    }
    
    public int getID() {
        return ID;
    }

    public ArrayList<HorarioDisciplinas> getHorariosDisciplinas() {
        return horariosDisciplinas;
    }

    public HorariosDia[] getHorarios() {
        return horarios;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setHorariosDisciplinas(ArrayList<HorarioDisciplinas> horariosDisciplinas) {
        this.horariosDisciplinas = horariosDisciplinas;
    }

    public void troca(int n1, int n2) {
        HorarioDisciplinas h1 = horariosDisciplinas.get(n1);
        HorarioDisciplinas h2 = horariosDisciplinas.get(n2);

        Disciplina d2 = h2.getDisciplina();
        Disciplina d1 = h1.getDisciplina();

        horarios[h1.getDia1().getValue()].setEspacoDisciplina(h1.getHorario1(), d2);
        horarios[h1.getDia2().getValue()].setEspacoDisciplina(h1.getHorario2(), d2);
        horarios[h2.getDia1().getValue()].setEspacoDisciplina(h2.getHorario1(), d1);
        horarios[h2.getDia2().getValue()].setEspacoDisciplina(h2.getHorario2(), d1);

        h1.setDisciplina(d2);
        h2.setDisciplina(d1);
    }

    private void verificaNulos() {
        boolean check;
        for (int y = 0; y < 15; y++) {
            check = false;
            for (int x = 0; x < 5; x++) {
                if (horarios[x].getEspacos()[y] != null) {
                    check = true;
                }
            }
            naoNulos[y] = check;
        }
    }

    private void defineHorario() {
        for (int x = 0; x < 15; x++) {
            tempo[x] = (x + 7) + ":00 - " + (x + 8) + ":00";
        }
    }

    public boolean[] getNaoNulos() {
        return naoNulos;
    }

    public String[] getTempo() {
        return tempo;
    }

}
