/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;

/**
 *
 * @author DisenoWeb
 */
public class SedeUsuario implements Serializable {

    int id;
    int codigo_sede;
    int id_usuario;

    public SedeUsuario(int id, int codigo_sede, int id_usuario) {
        this.id = id;
        this.codigo_sede = codigo_sede;
        this.id_usuario = id_usuario;
    }

    public SedeUsuario(int codigo_sede, int id_usuario) {
        this.codigo_sede = codigo_sede;
        this.id_usuario = id_usuario;
    }

    public SedeUsuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(int codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
