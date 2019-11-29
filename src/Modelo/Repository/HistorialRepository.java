/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Historial;
import static Modelo.Repository.UtilidadesRepository.consultaPrincipal;
import java.util.ArrayList;

/**
 *
 * @author DisenoWeb
 */
public class HistorialRepository {
    private final ArrayList<Historial> historial;
    private final String TABLA = "centros";
    private final String consultaCentros = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String cod = "codigo";
    private final String codCliente = "codigo_cliente";
    private final String nombre = "nombre";
    private final String direccion = "direccion";
    private final String poblacion = "poblacion";
    private final String telefono = "telefono";
    private final String contacto = "contacto";
    private final String email = "email";
    private final String horasNecesariosSemana = "horas_semana";
    private final String facturacionMes = "facturacion_mes";
    
    public HistorialRepository(){
        historial=new ArrayList<Historial>();
    }
}
