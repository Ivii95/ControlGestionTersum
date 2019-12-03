/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.CentroTrabajador;
import Modelo.Entidades.Horario;
import Modelo.Entidades.Trabajador;
import static Modelo.Repository.UtilidadesRepository.*;
import Utilidades.Conexion;
import Utilidades.Utilidades;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DisenoWeb
 */
public class HorarioRepository {

    private final ArrayList<Horario> horarios;
    private final String TABLA = "horarios";
    private final String consultaHorarios = consultaPrincipal + TABLA;
    private final String id = "id";
    private final String idCentrotrabajadores = "id_centrotrabajadores";
    private final String diaSemana = "dia_semana";
    private final String horaInicio = "hora_inicio";
    private final String horaFin = "hora_fin";
    private final String horasTotales = "horas_totales";

    public HorarioRepository() {
        horarios = new ArrayList<>();
    }

    /**
     *
     * @param consulta
     */
    public void ejecutarConsulta(String consulta) {
        horarios.clear();
        conn = new Conexion();
        conexion = conn.conectar_empresa_concreta(empresa);
        try {
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            while (rs.next()) {
                Horario horario = new Horario();
                horario.setId(rs.getInt(id));
                horario.setId_CentroTrabajadores(rs.getInt(idCentrotrabajadores));
                horario.setDiaSemana(rs.getString(diaSemana));
                horario.setHora_inicio(rs.getTime(horaInicio).toLocalTime());
                horario.setHora_fin(rs.getTime(horaFin).toLocalTime());
                horario.setHoras_totales(retornarDec(rs.getFloat(horasTotales) + ""));
                horarios.add(horario);
            }
            conn.desconectar(conexion);
        } catch (SQLException ex) {
            Logger.getLogger(CentroRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Rellena la tabla de horarios con las tuplas de horarios que hay en la base de datos.
     *
     * @param tabla
     * @param repoCentroTrabajador
     * @param trabajador
     */
    public void rellenarTablaDefault(JTable tabla, CentroTrabajadoresRepository repoCentroTrabajador) {
        ejecutarConsulta(consultaHorarios);
        ArrayList<CentroTrabajador> centroTrabajadores = repoCentroTrabajador.getCentrosTrabajadores();
        dtm = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < horarios.size(); i++) {
            for (int l = 0; l < centroTrabajadores.size(); l++) {
                if (centroTrabajadores.get(l).getId() == horarios.get(i).getId_CentroTrabajadores()) {
                    CentroTrabajador centroTrabajador = centroTrabajadores.get(l);
                    Horario horario = horarios.get(i);
                    for (int column = 0; column < dtm.getColumnCount(); column++) {
                        String dia = dtm.getColumnName(column);//Cogemos el header de la tabla y lo guardamos en dia
                        if (dia.equals(horarios.get(i).getDiaSemana())) {//Entrara si el dia es el mismo
                            for (int row = 0; row < dtm.getRowCount(); row++) {
                                if (LocalTime.parse((CharSequence) dtm.getValueAt(row, 0)).equals(horario.getHora_inicio())) {//Entrara si si la hora de inicio es igual que la de horario
                                    while (!LocalTime.parse((CharSequence) dtm.getValueAt(row, 0)).equals(horario.getHora_fin())) {//Escribira hasta llegar a la hora final
                                        dtm.setValueAt(centroTrabajador.getCentro().getNombre(), row, column);//Escribimos el nombre del centro con el indice de la columna y la fila
                                        row++;//Aumentamos el indice de la fila mientras estamos en el bucle para que continue el bucle de arriba una vez dentro
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        tabla.setModel(dtm);
    }

    /**
     *
     * @param horario
     * @return
     */
    public boolean insert(Horario horario) {
        correcto = false;
        try {
            Utilidades.conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(Utilidades.empresa);
            insert = "INSERT INTO " + TABLA + " (id, "
                    + idCentrotrabajadores + ", "
                    + diaSemana + ", "
                    + horaInicio + ", "
                    + horaFin + ", "
                    + horasTotales + " "
                    + ") VALUES (NULL, ?, ?, ?, ?, ?)";
            ps = conexion.prepareStatement(insert);
            ps.setInt(1, horario.getId_CentroTrabajadores());
            ps.setString(2, horario.getDiaSemana());
            ps.setTime(3, Time.valueOf(horario.getHora_inicio()));
            ps.setTime(4, Time.valueOf(horario.getHora_fin()));
            ps.setFloat(5, retornarHex(horario.getHoras_totales() + ""));
            ps.executeUpdate();
            conn.desconectar(conexion);
            horarios.add(horario);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

    public float retornarHex(String horasTotales) {
        String str = String.valueOf(horasTotales);
        int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
        float decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));
        //int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));
        decNumbert = (decNumbert * 100) / 60;
        return decNumbert + intNumber;
    }

    public float retornarDec(String horasTotales) {
        String str = String.valueOf(horasTotales);
        int intNumber = Integer.parseInt(str.substring(0, str.indexOf('.')));
        float decNumbert = Float.parseFloat(str.substring(str.indexOf('.')));
        //int decNumberInt = Integer.parseInt(str.substring(str.indexOf('.') + 1));
        decNumbert = (decNumbert * 60) / 100;
        return decNumbert + intNumber;
    }

    public boolean borrarColumnaHorario(JTable tabla, int codigo_trabajador, String dia) {
        correcto = false;
        try {
            delete = "DELETE FROM " + TABLA + " WHERE " + idCentrotrabajadores + "="
                    + "(SELECT " + idCentrotrabajadores + " FROM centrostrabajadores WHERE codigo_trabajadores='" + codigo_trabajador + "')"
                    + " && dia='" + dia + "'";
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            ps = conexion.prepareStatement(delete);
            DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < dtm.getColumnCount(); i++) {
                if (tabla.getColumnName(i).equals(dia)) {
                    for (int j = 0; j < dtm.getRowCount(); j++) {
                        tabla.setValueAt(null, j, i);//Aqui borramos las horas correspondientes
                    }
                }
            }
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

}
