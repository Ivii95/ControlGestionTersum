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
 * @author DisenoWeb
 */
public class Trabajador implements Serializable {

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
    LocalDate fechanacimiento;
    String categoria;
    LocalDate antiguedad;
    int telefono;
    String email;
    LocalDate fecha_alta;
    LocalDate fecha_baja;
    String horas_semana_alta;
    String horas_semana_reales;
    int seguridad_social;
    float coste_mes;

    public Trabajador(int id, String codigo, int codigo_tipo_contrato, String codigo_sede, String apellido1, String apellido2, String nombre, String DNI, String direccion, String poblacion, LocalDate fechanacimiento, String categoria, LocalDate antiguedad, int telefono, String email, LocalDate fecha_alta, LocalDate fecha_baja, String horas_semana_alta, String horas_semana_reales, int seguridad_social, float coste_mes) {
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
        this.seguridad_social = seguridad_social;
        this.coste_mes = coste_mes;
    }

    public Trabajador(String codigo, int codigo_tipo_contrato, String codigo_sede, String apellido1, String apellido2, String nombre, String DNI, String direccion, String poblacion, LocalDate fechanacimiento, String categoria, LocalDate antiguedad, int telefono, String email, LocalDate fecha_alta, LocalDate fecha_baja, String horas_semana_alta, String horas_semana_reales, int seguridad_social, float coste_mes) {
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
        this.seguridad_social = seguridad_social;
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

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public LocalDate getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(LocalDate antiguedad) {
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

    public LocalDate getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(LocalDate fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public LocalDate getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(LocalDate fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public String getHoras_semana_alta() {
        return horas_semana_alta;
    }

    public void setHoras_semana_alta(String horas_semana_alta) {
        this.horas_semana_alta = horas_semana_alta;
    }

    public String getHoras_semana_reales() {
        return horas_semana_reales;
    }

    public void setHoras_semana_reales(String horas_semana_reales) {
        this.horas_semana_reales = horas_semana_reales;
    }

    public int getSeguridad_social() {
        return seguridad_social;
    }

    public void setSeguridad_social(int seguridad_social) {
        this.seguridad_social = seguridad_social;
    }

    public float getCoste_mes() {
        return coste_mes;
    }

    public void setCoste_mes(float coste_mes) {
        this.coste_mes = coste_mes;
    }

}
