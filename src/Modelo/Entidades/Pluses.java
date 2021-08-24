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
public class Pluses implements Serializable{

    int id;
    String codigo;
    String codigo_trabajador;
    String descripcion;
    LocalDate fecha_inicio, fecha_fin;
    int horas;
    int precio;

    public Pluses() {

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
    public Pluses(String codigo, String codigo_trabajador,  String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
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
    public Pluses(int id, String codigo, String codigo_trabajador, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Pluses(int id, String codigo, String codigo_trabajador, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, int horas, int precio) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horas = horas;
        this.precio = precio;
    }public Pluses( String codigo, String codigo_trabajador, String descripcion, LocalDate fecha_inicio, LocalDate fecha_fin, int horas, int precio) {
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.horas = horas;
        this.precio = precio;
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

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Object getTotal() {
        return precio*horas;
    }
    
}
