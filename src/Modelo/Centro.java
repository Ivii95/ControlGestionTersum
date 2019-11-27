/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author diseño
 */
public class Centro {

    int id;
    String codigo;
    String codigo_cliente;
    String nombre;
    String direccion;
    String poblacion;
    int telefono;
    String contacto;
    String email;
    int horas_semana;
    float facturacion_mes;            
    public Centro() {

    }

    public Centro(String codigo, String codigo_cliente, String nombre, String direccion, String poblacion, int telefono, String contacto, String email, int horas_semana, float facturacion_mes) {
        this.codigo = codigo;
        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.email = email;
        this.horas_semana = horas_semana;
        this.facturacion_mes = facturacion_mes;
    }
    
    public Centro(int id, String codigo, String codigo_cliente, String nombre, String direccion, String poblacion, int telefono, String contacto, String email, int horas_semana, float facturacion_mes) {
        this.id = id;
        this.codigo = codigo;
        this.codigo_cliente = codigo_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.email = email;
        this.horas_semana = horas_semana;
        this.facturacion_mes = facturacion_mes;
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

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHoras_semana() {
        return horas_semana;
    }

    public void setHoras_semana(int horas_semana) {
        this.horas_semana = horas_semana;
    }

    public float getFacturacion_mes() {
        return facturacion_mes;
    }

    public void setFacturacion_mes(float facturacion_mes) {
        this.facturacion_mes = facturacion_mes;
    }
    
}
