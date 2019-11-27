package Modelo;

import Modelo.Centro;
import Modelo.Trabajador;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DisenoWeb
 */
public class CentroTrabajadores {

    ArrayList<Trabajador> trabajadores;
    Centro centro;

    public CentroTrabajadores() {
    }

    public CentroTrabajadores(ArrayList<Trabajador> trabajadores, Centro centro) {
        this.trabajadores = trabajadores;
        this.centro = centro;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Centro getCentro() {
        return centro;
    }

    public void setCentro(Centro centro) {
        this.centro = centro;
    }

}
