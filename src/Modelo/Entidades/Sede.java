/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DisenoWeb
 */
public class Sede implements Serializable {

    int id;
    int codigo;
    String ciudad;
    ArrayList usuarios;
    ArrayList clientes;

    public Sede(int id, int codigo, String ciudad, ArrayList usuarios, ArrayList clientes) {
        this.id = id;
        this.codigo = codigo;
        this.ciudad = ciudad;
        this.usuarios = usuarios;
        this.clientes = clientes;
    }

    public Sede(int id, int codigo, String ciudad) {
        this.id = id;
        this.codigo = codigo;
        this.ciudad = ciudad;
    }

    public Sede(int codigo, String ciudad) {
        this.codigo = codigo;
        this.ciudad = ciudad;
    }

    public ArrayList getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }

    public Sede() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
