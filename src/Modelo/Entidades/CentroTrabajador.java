/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Entidades;

/**
 *
 * @author Programacion
 */
public class CentroTrabajador {
    int id;
    String codigo_centro;
    String codigo_trabajador;

public CentroTrabajador (int id, String codigo_centro, String cogido_trabajadores) {
    this.id = id;
    this.codigo_centro = codigo_centro;
    this.codigo_trabajador = codigo_trabajador;
}

public CentroTrabajador (){
 
}

public int getId(){
    return id;
}

public void setId(int id){
    this.id = id;
}

public String getCodigo_centro(){
    return codigo_centro;
}

public void setCodigo_centro (String codigo_centro){
    this.codigo_centro = codigo_centro;
}

public String getCodigo_trabajador(){
    return codigo_trabajador;
}

public void setCodigo_trabajador (String codigo_trabajador){
    this.codigo_trabajador = codigo_trabajador;
}

}

