/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Repository;

import Modelo.Entidades.Horario;
import static Modelo.Repository.UtilidadesRepository.*;
import Utilidades.Conexion;
import static Utilidades.Utilidades.conn;
import static Utilidades.Utilidades.empresa;
import java.sql.SQLException;
import java.sql.Time;
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

    public boolean insert(Horario horario) {
        correcto = false;
        try {
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
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
            delete = "DELETE FROM horarios WHERE id_centrotrabajadores="
                    + "(SELECT id_centrotrabajadores FROM centrostrabajadores WHERE codigo_trabajadores='" + codigo_trabajador + "')"
                    + " && dia='" + dia + "'";
            DefaultTableModel dtm = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < dtm.getColumnCount(); i++) {
                if (tabla.getColumnName(i).equals(dia)) {
                    for (int j = 0; j < dtm.getRowCount(); j++) {
                        tabla.setValueAt(null, j, i);//Aqui borramos las horas correspondientes
                    }
                }
            }
            conn = new Conexion();
            conexion = conn.conectar_empresa_concreta(empresa);
            ps = conexion.prepareStatement(delete);
            correcto = true;
        } catch (SQLException ex) {
            correcto = false;
            Logger.getLogger(TrabajadorRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return correcto;
    }

}
