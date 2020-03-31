/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalTime;

/**
 *
 * @author DisenoWeb
 */
public class Horario implements Serializable{

    int id;
    int id_CentroTrabajadores;
    String diaSemana;
    LocalTime hora_inicio, hora_fin;
    float horas_totales;

    public Horario() {
    }

    public Horario(int id_CentroTrabajadores, String diaSemana, LocalTime hora_inicio, LocalTime hora_fin, float horas_totales) {
        this.id_CentroTrabajadores = id_CentroTrabajadores;
        this.diaSemana = diaSemana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.horas_totales = horas_totales;
    }

    public Horario(int id, int id_CentroTrabajadores, String diaSemana, LocalTime hora_inicio, LocalTime hora_fin, float horas_totales) {
        this.id = id;
        this.id_CentroTrabajadores = id_CentroTrabajadores;
        this.diaSemana = diaSemana;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.horas_totales = horas_totales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_CentroTrabajadores() {
        return id_CentroTrabajadores;
    }

    public void setId_CentroTrabajadores(int id_CentroTrabajadores) {
        this.id_CentroTrabajadores = id_CentroTrabajadores;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public float getHoras_totales() {
        return horas_totales;
    }

    public void setHoras_totales(float horas_totales) {
        this.horas_totales = horas_totales;
    }

}
