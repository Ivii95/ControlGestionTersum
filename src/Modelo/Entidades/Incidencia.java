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
 * @author diseño
 */
public class Incidencia implements Serializable{

    int id;
    String codigo;
    String codigo_trabajador;
    String descripcion;
    LocalDate fecha_inicio, fecha_fin;
    int extras;

    public Incidencia() {

    }
    /**
     *
     * @param codigo
     * @param codigo_trabajador
     * @param extras
     * @param descripcion
     * @param fecha_inicio
     * @param fecha_fin
     */
    public Incidencia(String codigo, String codigo_trabajador, int extras, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.extras = extras;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    /**
     *
     * @param id
     * @param codigo
     * @param codigo_trabajador
     * @param extras
     * @param descripcion
     * @param fecha_inicio
     * @param fecha_fin
     */
    public Incidencia(int id, String codigo, String codigo_trabajador, int extras, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.extras = extras;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo_trabajador() {
        return codigo_trabajador;
    }

    public void setCodigo_trabajador(String codigo_trabajador) {
        this.codigo_trabajador = codigo_trabajador;
    }

    public int getExtras() {
        return extras;
    }

    public void setExtras(int extras) {
        this.extras = extras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

}
