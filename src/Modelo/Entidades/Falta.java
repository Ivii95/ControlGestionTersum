/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author diseño
 */
public class Falta implements Serializable{

    int id;
    String codigo;
    String codigo_trabajador;
    Date fecha_inicio, fecha_fin;
    String motivo;

    public Falta() {

    }

    public Falta(int id, String codigo, String codigo_trabajador, Date fecha_inicio, Date fecha_fin, String motivo) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.motivo = motivo;
    }

    public Falta(String codigo, String codigo_trabajador, Date fecha_inicio, Date fecha_fin, String motivo) {
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.motivo = motivo;
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

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha) {
        this.fecha_inicio = fecha;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
