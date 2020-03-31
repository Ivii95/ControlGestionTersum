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
 * @author DisenoWeb
 */
public class Trabajador implements Serializable{

    int id;
    String codigo;
    int codigo_tipo_contrato;
    String codigo_sede;
    String apellido1;
    String apellido2;
    String nombre;
    String DNI;
    String direccion;
    String poblacion;
    Date fechanacimiento;
    String categoria;
    Date antiguedad;
    int telefono;
    String email;
    Date fecha_alta;
    Date fecha_baja;
    int horas_semana_alta;
    int horas_semana_reales;
    float coste_mes;

    public Trabajador(int id, String codigo, int codigo_tipo_contrato, String codigo_sede, String apellido1, String apellido2, String nombre, String DNI, String direccion, String poblacion, Date fechanacimiento, String categoria, Date antiguedad, int telefono, String email, Date fecha_alta, Date fecha_baja, int horas_semana_alta, int horas_semana_reales, float coste_mes) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_tipo_contrato = codigo_tipo_contrato;
        this.codigo_sede = codigo_sede;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.fechanacimiento = fechanacimiento;
        this.categoria = categoria;
        this.antiguedad = antiguedad;
        this.telefono = telefono;
        this.email = email;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.horas_semana_alta = horas_semana_alta;
        this.horas_semana_reales = horas_semana_reales;
        this.coste_mes = coste_mes;
    }

    public Trabajador(String codigo, int codigo_tipo_contrato, String codigo_sede, String apellido1, String apellido2, String nombre, String DNI, String direccion, String poblacion, Date fechanacimiento, String categoria, Date antiguedad, int telefono, String email, Date fecha_alta, Date fecha_baja, int horas_semana_alta, int horas_semana_reales, float coste_mes) {
        this.codigo = codigo;
        this.codigo_tipo_contrato = codigo_tipo_contrato;
        this.codigo_sede = codigo_sede;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.DNI = DNI;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.fechanacimiento = fechanacimiento;
        this.categoria = categoria;
        this.antiguedad = antiguedad;
        this.telefono = telefono;
        this.email = email;
        this.fecha_alta = fecha_alta;
        this.fecha_baja = fecha_baja;
        this.horas_semana_alta = horas_semana_alta;
        this.horas_semana_reales = horas_semana_reales;
        this.coste_mes = coste_mes;
    }

    public Trabajador() {

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

    public int getCodigo_tipo_contrato() {
        return codigo_tipo_contrato;
    }

    public void setCodigo_tipo_contrato(int codigo_tipo_contrato) {
        this.codigo_tipo_contrato = codigo_tipo_contrato;
    }

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Date antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public int getHoras_semana_alta() {
        return horas_semana_alta;
    }

    public void setHoras_semana_alta(int horas_semana_alta) {
        this.horas_semana_alta = horas_semana_alta;
    }

    public int getHoras_semana_reales() {
        return horas_semana_reales;
    }

    public void setHoras_semana_reales(int horas_semana_reales) {
        this.horas_semana_reales = horas_semana_reales;
    }

    public float getCoste_mes() {
        return coste_mes;
    }

    public void setCoste_mes(float coste_mes) {
        this.coste_mes = coste_mes;
    }

}
