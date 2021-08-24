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
public class AsuntosPropios implements Serializable {

    int id;
    String codigo;
    String codigo_trabajador;
    String codigo_trabajador_sustituto;
    LocalDate dia;
    String motivo;

    public AsuntosPropios() {

    }

    public AsuntosPropios(String codigo, String codigo_trabajador, String codigo_trabajador_sustituto, LocalDate dia, String motivo) {
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.codigo_trabajador_sustituto = codigo_trabajador_sustituto;
        this.dia = dia;
        this.motivo = motivo;
    }

    public AsuntosPropios(int id, String codigo, String codigo_trabajador, String codigo_trabajador_sustituto, LocalDate dia, String motivo) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_trabajador = codigo_trabajador;
        this.codigo_trabajador_sustituto = codigo_trabajador_sustituto;
        this.dia = dia;
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

    public String getCodigo_trabajador_sustituto() {
        return codigo_trabajador_sustituto;
    }

    public void setCodigo_trabajador_sustituto(String codigo_trabajador_sustituto) {
        this.codigo_trabajador_sustituto = codigo_trabajador_sustituto;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
