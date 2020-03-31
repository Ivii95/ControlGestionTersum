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
public class Cliente implements Serializable{

    int id;
    String codigo;
    String cif;
    String nombre_fiscal;
    String nombre_comercial;
    String contacto;
    int telefono;
    int fax;
    int movil;
    String email;
    Date fecha_alta;
    Date fecha_baja;

    public Cliente(int id, String codigo, String cif, String nombre_fiscal, String nombre_comercial, String contacto, int telefono, int fax, int movil, String email, Date fecha_alta, Date fecha_baja) {
        this.id = id;
        this.codigo = codigo;
        this.cif = cif;
        this.nombre_fiscal = nombre_fiscal;
        this.nombre_comercial = nombre_comercial;
        this.contacto = contacto;
        this.telefono = telefono;
        this.fax = fax;
        this.movil = movil;
        this.email = email;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
    }

    public Cliente(String codigo, String cif, String nombre_fiscal, String nombre_comercial, String contacto, int telefono, int fax, int movil, String email, Date fecha_alta, Date fecha_baja) {
        this.codigo = codigo;
        this.cif = cif;
        this.nombre_fiscal = nombre_fiscal;
        this.nombre_comercial = nombre_comercial;
        this.contacto = contacto;
        this.telefono = telefono;
        this.fax = fax;
        this.movil = movil;
        this.email = email;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
    }

    public Cliente() {

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

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre_fiscal() {
        return nombre_fiscal;
    }

    public void setNombre_fiscal(String nombre_fiscal) {
        this.nombre_fiscal = nombre_fiscal;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    public int getMovil() {
        return movil;
    }

    public void setMovil(int movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

}
