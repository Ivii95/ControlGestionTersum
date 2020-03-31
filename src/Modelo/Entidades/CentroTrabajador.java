/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

import java.io.Serializable;

/**
 *
 * @author Programacion
 */
public class CentroTrabajador implements Serializable{

    //Añadimos un centro y un trabajador a la vez para asi no tener que andar buscando ya que esto se cargara en memoria principal y no en la base de datos.
    int id;
    Centro centro;
    Trabajador trabajador;

    public CentroTrabajador(int id, Centro centro, Trabajador trabajadores) {
        this.id = id;
        this.centro = centro;
        this.trabajador = trabajadores;
    }

    public CentroTrabajador() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

}
