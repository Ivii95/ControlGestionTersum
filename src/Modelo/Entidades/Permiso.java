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
public class Permiso implements Serializable{

    public int id;
    public int id_permiso;
    public int id_empresa;
    public int id_usuario;
    public boolean activo;

    public Permiso(int id, int id_permiso, int id_empresa, int id_usuario, boolean activo) {
        this.id = id;
        this.id_permiso = id_permiso;
        this.id_empresa = id_empresa;
        this.id_usuario = id_usuario;
        this.activo = activo;
    }

    public Permiso(int id_permiso, int id_empresa, int id_usuario, boolean activo) {
        this.id_permiso = id_permiso;
        this.id_empresa = id_empresa;
        this.id_usuario = id_usuario;
        this.activo = activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public Permiso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
