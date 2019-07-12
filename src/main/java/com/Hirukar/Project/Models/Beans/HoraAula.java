package com.Hirukar.Project.Models.Beans;

import com.Hirukar.Project.Models.Enums.DiasDaSemana;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoraAula {
    private DiasDaSemana diasDaSemana;
    private int numero;
    private int FK_ID_slots;
    private int hora_inicio;

    public static final HoraAula nulo = new HoraAula();

    public HoraAula(ResultSet rs) throws SQLException {
        this.diasDaSemana = DiasDaSemana.valueOf(rs.getString("hora_aula.dia_da_semana").toUpperCase());
        this.numero = rs.getInt("hora_aula.numero");
        this.FK_ID_slots = rs.getInt("hora_aula.FK_ID_slot");
        this.hora_inicio = rs.getInt("hora_aula.hora_inicio");
    }

    public  HoraAula() {
        this.numero = 0;
    }

    public DiasDaSemana getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getFK_ID_slots() {
        return FK_ID_slots;
    }

    public void setFK_ID_slots(int FK_ID_slots) {
        this.FK_ID_slots = FK_ID_slots;
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    @Override
    public String toString() {
        return "HoraAula{" +
                "diasDaSemana=" + diasDaSemana +
                ", numero=" + numero +
                ", FK_ID_slots=" + FK_ID_slots +
                ", hora_inicio=" + hora_inicio +
                '}';
    }
}
