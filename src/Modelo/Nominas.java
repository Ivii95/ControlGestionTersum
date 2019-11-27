/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author DisenoWeb
 */
public class Nominas {

    int id, codigo_trabajador;
    Date fecha_inicio;
    Date fecha_fin;
    double importe;
    boolean activo;

    public Nominas() {
    }

    public Nominas(int id, int codigo_trabajador, Date fecha_inicio, Date fecha_fin, double importe, boolean activo) {
        this.id = id;
        this.codigo_trabajador = codigo_trabajador;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.importe = importe;
        this.activo = activo;
    }

     public Nominas(int codigo_trabajador, Date fecha_inicio, Date fecha_fin, double importe, boolean activo) {
        this.codigo_trabajador = codigo_trabajador;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.importe = importe;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_trabajador() {
        return codigo_trabajador;
    }

    public void setCodigo_trabajador(int codigo_trabajador) {
        this.codigo_trabajador = codigo_trabajador;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Nominas{" + "id=" + id + ", codigo_trabajador=" + codigo_trabajador + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", importe=" + importe + ", activo=" + activo + '}';
    }
     
    
}
