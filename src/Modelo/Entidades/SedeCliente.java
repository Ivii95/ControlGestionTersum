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
public class SedeCliente implements Serializable {

    int id;
    int id_cliente;
    int id_sede;

    public SedeCliente(int id, int id_cliente, int id_sede) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_sede = id_sede;
    }

    public SedeCliente(int id_cliente, int id_sede) {
        this.id_cliente = id_cliente;
        this.id_sede = id_sede;
    }

    public SedeCliente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_sede() {
        return id_sede;
    }

    public void setId_sede(int id_sede) {
        this.id_sede = id_sede;
    }

}
