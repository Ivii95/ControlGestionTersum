/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Programacion
 */
public class AccidentesLaborales implements Serializable {

    int id;
    LocalDate fecha_accidente;
    LocalDate fecha_baja;
    String descripcion;
    String zona_lesionada;
    String lugar;
    int id_centro;
    int id_trabajador_sustituto;

    public AccidentesLaborales(int id, LocalDate fecha_accidente, LocalDate fecha_baja, String descripcion, String zona_lesionada, String lugar, int id_centro, int id_trabajador_sustituto) {
        this.id = id;
        this.fecha_accidente = fecha_accidente;
        this.fecha_baja = fecha_baja;
        this.descripcion = descripcion;
        this.zona_lesionada = zona_lesionada;
        this.lugar = lugar;
        this.id_centro = id_centro;
        this.id_trabajador_sustituto = id_trabajador_sustituto;
    }

    public AccidentesLaborales() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha_accidente() {
        return fecha_accidente;
    }

    public void setFecha_accidente(LocalDate fecha_accidente) {
        this.fecha_accidente = fecha_accidente;
    }

    public LocalDate getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(LocalDate fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona_lesionada() {
        return zona_lesionada;
    }

    public void setZona_lesionada(String zona_lesionada) {
        this.zona_lesionada = zona_lesionada;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getId_centro() {
        return id_centro;
    }

    public void setId_centro(int id_centro) {
        this.id_centro = id_centro;
    }

    public int getId_trabajador_sustituto() {
        return id_trabajador_sustituto;
    }

    public void setId_trabajador_sustituto(int id_trabajador_sustituto) {
        this.id_trabajador_sustituto = id_trabajador_sustituto;
    }
    
}
