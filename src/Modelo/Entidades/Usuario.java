/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

/**
 *
 * @author DisenoWeb
 */
public final class Usuario {

    private int id;
    private String nombre;
    private String password;
    private int id_rol;
    private String ultima_sesion;

    public Usuario(int id, String nombre, String password, int id_rol, String ultima_sesion) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.id_rol = id_rol;
        this.ultima_sesion = ultima_sesion;
    }

    public Usuario(String nombre, String password, int id_rol) {
        this.nombre = nombre;
        this.password = password;
        this.id_rol = id_rol;

    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getUltima_sesion() {
        return ultima_sesion;
    }

    public void setUltima_sesion(String ultima_sesion) {
        this.ultima_sesion = ultima_sesion;
    }
}
