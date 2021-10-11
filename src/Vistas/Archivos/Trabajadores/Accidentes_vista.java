/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.AccidentesLaborales;
import Modelo.Entidades.AsuntosPropios;
import Modelo.Entidades.Centro;
import Modelo.Entidades.Vacaciones;
import Modelo.Entidades.Trabajador;
import Modelo.Repository.AccidentesLaboralesRepository;
import Utilidades.UtilidadesPantalla;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Accidentes_vista extends javax.swing.JFrame {

    AccidentesLaboralesRepository repoSS;
    AccidentesLaboralesRepository repoSSTotal;
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    Trabajador trabajadorSS;
    Centro centroIncidencias;

    public Accidentes_vista(Trabajador trabajador) {
        this.trabajadorSS = trabajador;
        iniciarOtrosComponentes();
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
    }

    private Accidentes_vista() {
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());

    }

    public Accidentes_vista(Trabajador trabajadorVacaciones, Vacaciones falta) {
        this.trabajadorSS = trabajadorVacaciones;
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        //txt_fecha_inicio.setDate(java.sql.Date.valueOf(falta.getFecha_inicio()));
        //txt_fecha_fin.setDate(java.sql.Date.valueOf(falta.getFecha_fin()));
        txt_descripcion.setText(falta.getMotivo());
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
    }

    public Accidentes_vista(Trabajador trabajadorAP, AsuntosPropios falta) {
        this.trabajadorSS = trabajadorAP;
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        hora_accidente.setText(falta.getCodigo());
        txt_descripcion.setText(falta.getMotivo());
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
    }

    private void iniciarOtrosComponentes() {
        initComponents();
        UtilidadesPantalla.resolucionPantalla(this);
        UtilidadesPantalla.centrarTablas(tabla_incidencias);
        ponAyuda();
        pulsarX();
        btn_modificar.setVisible(false);
        btn_borrar.setVisible(false);
        btn_limpiar.setVisible(false);
        //INICIAMOS REPO
        repoSS = new AccidentesLaboralesRepository();
        repoSSTotal = new AccidentesLaboralesRepository();

        //TABLA INCIDENCIAS
        tabla_incidencias.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_incidencias.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_incidencias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_incidencias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        hora_accidente.requestFocus();
    }

    private void pulsarX() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                trabajadorSS = null;
                this.windowClosed(evt);
            }
        });
    }

    private void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "incidencias_trabajador", helpset);
        } catch (HelpSetException ex) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_incidencias = new javax.swing.JTable();
        lbl_info_trabajador1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        label_fechainicio = new org.edisoncor.gui.panel.PanelRect();
        label_descripcion = new javax.swing.JLabel();
        btn_limpiar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btn_añadir_incidencia = new javax.swing.JButton();
        lbl_accidente = new javax.swing.JLabel();
        hora_accidente = new javax.swing.JTextField();
        fecha_accidente = new org.jdesktop.swingx.JXDatePicker();
        lbl_baja = new javax.swing.JLabel();
        fecha_baja = new org.jdesktop.swingx.JXDatePicker();
        hora_accidente1 = new javax.swing.JTextField();
        lbl_zona_lesionada = new javax.swing.JLabel();
        txt_zona_lesionada = new javax.swing.JTextField();
        lbl_lugar = new javax.swing.JLabel();
        txt_lugar = new javax.swing.JTextField();
        txt_codigo_centro = new javax.swing.JTextField();
        lbl_codigo_centro = new javax.swing.JLabel();
        txt_codigo_trabajador_sustituto = new javax.swing.JTextField();
        lbl_codigo_trabajador_sustituto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PLUSES");
        setIconImage(new ImageIcon(getClass().getResource("/img/incidencias .png")).getImage());
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRect1.setAnchoDeBorde(0.0F);
        panelRect1.setAnchoDeSegundoBorde(0.0F);
        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelRect1.setMinimumSize(new java.awt.Dimension(1360, 762));
        panelRect1.setPreferredSize(new java.awt.Dimension(1360, 762));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setMaximumSize(null);
        panelCurves1.setMinimumSize(new java.awt.Dimension(1360, 762));
        panelCurves1.setOpaque(true);
        panelCurves1.setPreferredSize(new java.awt.Dimension(1360, 762));
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_incidencias.setAutoCreateRowSorter(true);
        tabla_incidencias.setBackground(new java.awt.Color(204, 204, 204));
        tabla_incidencias.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_incidencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "FECHA", "TOTAL (€)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_incidencias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabla_incidencias.setRowHeight(35);
        tabla_incidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_incidenciasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_incidencias);
        if (tabla_incidencias.getColumnModel().getColumnCount() > 0) {
            tabla_incidencias.getColumnModel().getColumn(0).setResizable(false);
            tabla_incidencias.getColumnModel().getColumn(1).setResizable(false);
            tabla_incidencias.getColumnModel().getColumn(2).setResizable(false);
            tabla_incidencias.getColumnModel().getColumn(3).setResizable(false);
        }

        panelCurves1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 1210, 440));

        lbl_info_trabajador1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_info_trabajador1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_info_trabajador1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_info_trabajador1.setText("TRABAJADOR:");
        panelCurves1.add(lbl_info_trabajador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 810, 40));

        txt_buscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_buscar.setText("Buscar...");
        txt_buscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_buscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_buscarFocusLost(evt);
            }
        });
        txt_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_buscarMouseClicked(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        panelCurves1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 230, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        panelCurves1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 40));

        label_fechainicio.setColorDeSegundoBorde(new java.awt.Color(102, 102, 102));
        label_fechainicio.setColorPrimario(new java.awt.Color(153, 153, 153));
        label_fechainicio.setColorSecundario(new java.awt.Color(102, 102, 102));
        label_fechainicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_descripcion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_descripcion.setText("Descripción");
        label_fechainicio.add(label_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 150, 35));

        btn_limpiar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 200, 35));

        btn_borrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar.setText("Borrar");
        btn_borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_borrarMouseClicked(evt);
            }
        });
        label_fechainicio.add(btn_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 200, 35));

        btn_modificar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificarMouseClicked(evt);
            }
        });
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 200, 35));

        txt_descripcion.setColumns(20);
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(5);
        txt_descripcion.setMaximumSize(new java.awt.Dimension(270, 80));
        txt_descripcion.setMinimumSize(new java.awt.Dimension(270, 80));
        txt_descripcion.setPreferredSize(new java.awt.Dimension(270, 80));
        jScrollPane1.setViewportView(txt_descripcion);

        label_fechainicio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 150, 90));

        btn_añadir_incidencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir_incidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir_incidencia.setText("Añadir");
        btn_añadir_incidencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_añadir_incidenciaMouseClicked(evt);
            }
        });
        label_fechainicio.add(btn_añadir_incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 200, 35));

        lbl_accidente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_accidente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_accidente.setText("Fecha y Hora del Accidente");
        label_fechainicio.add(lbl_accidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, 30));

        hora_accidente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hora_accidente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hora_accidenteKeyReleased(evt);
            }
        });
        label_fechainicio.add(hora_accidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 190, 40));

        fecha_accidente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fechainicio.add(fecha_accidente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 35));

        lbl_baja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_baja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_baja.setText("Fecha y Hora de la Baja");
        label_fechainicio.add(lbl_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 210, 30));

        fecha_baja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_fechainicio.add(fecha_baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 190, 35));

        hora_accidente1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        hora_accidente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hora_accidente1KeyReleased(evt);
            }
        });
        label_fechainicio.add(hora_accidente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 190, 40));

        lbl_zona_lesionada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_zona_lesionada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_zona_lesionada.setText("Zona lesionada");
        label_fechainicio.add(lbl_zona_lesionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 190, 30));

        txt_zona_lesionada.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_zona_lesionada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_zona_lesionadaKeyReleased(evt);
            }
        });
        label_fechainicio.add(txt_zona_lesionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 190, 40));

        lbl_lugar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_lugar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_lugar.setText("Lugar del Accidente");
        label_fechainicio.add(lbl_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 190, 30));

        txt_lugar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_lugar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_lugarKeyReleased(evt);
            }
        });
        label_fechainicio.add(txt_lugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 190, 40));

        txt_codigo_centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_codigo_centro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_centroKeyReleased(evt);
            }
        });
        label_fechainicio.add(txt_codigo_centro, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 190, 40));

        lbl_codigo_centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo_centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo_centro.setText("Codigo Centro");
        label_fechainicio.add(lbl_codigo_centro, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, 190, 30));

        txt_codigo_trabajador_sustituto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_codigo_trabajador_sustituto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_trabajador_sustitutoKeyReleased(evt);
            }
        });
        label_fechainicio.add(txt_codigo_trabajador_sustituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 110, 190, 40));

        lbl_codigo_trabajador_sustituto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo_trabajador_sustituto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo_trabajador_sustituto.setText("Codigo Trabajador Sustituto");
        label_fechainicio.add(lbl_codigo_trabajador_sustituto, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 210, 30));

        panelCurves1.add(label_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 1230, 170));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        repoSS.buscarFechaAccidente(tabla_incidencias, txt_buscar.getText(), trabajadorSS.getCodigo());
        repoSS.buscarFechaBaja(tabla_incidencias, txt_buscar.getText(), trabajadorSS.getCodigo());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        restablecerTodo();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_borrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_borrarMouseClicked
        int filaSeleccionada = tabla_incidencias.getSelectedRow();
        int opcionborrar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de borrar el registro?\nContrato: " + (String) tabla_incidencias.getValueAt(filaSeleccionada, 1));
        switch (opcionborrar) {
            case 0://OPCION SI BORRAR TRABAJADOR
                int id = UtilidadesPantalla.getIdSelected(tabla_incidencias);
                repoSS.delete(id);
                restablecerTodo();
                break;

            case 1://OPCION NO BORRAR CONTRATO, se tiene que poner para que los datos que ya estan escritos en los jtextfield no se borren al darle a "NO"
                break;

            default://OPCION CANCELAR
                restablecerTodo();
                break;
        }
    }//GEN-LAST:event_btn_borrarMouseClicked

    private void btn_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificarMouseClicked
        /*if (txt_descripcion.getText().equals("") || txt_fecha_fin.getDate().equals("") || txt_horas.getText().equals(0) || txt_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacio");
        } else {
            int id = UtilidadesPantalla.getIdSelected(tabla_incidencias);
            String codigo = txt_codigo.getText();
            String descripcion = txt_descripcion.getText();
            Date fecha_inicio = (Date) txt_fecha_inicio.getDate();
            Date fecha_fin = (Date) txt_fecha_fin.getDate();
            formato.format(fecha);
            int horas = Integer.parseInt((String) txt_horas.getText());
            int precio = Integer.parseInt((String) txt_precio.getText());
            Pluses incidencia = new Pluses(id,
                    codigo,
                    trabajadorSS.getCodigo(),
                    descripcion,
                    UtilidadesPantalla.convertToLocalDateViaInstant(fecha_inicio),
                    UtilidadesPantalla.convertToLocalDateViaInstant(fecha_fin),
                    horas,
                    precio
            );
            repoSS.update(incidencia);
            restablecerTodo();
        }*/
    }//GEN-LAST:event_btn_modificarMouseClicked

    private void btn_añadir_incidenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_añadir_incidenciaMouseClicked
        /*if (txt_descripcion.getText().equals("") || txt_fecha_fin.getDate() == null || txt_codigo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Ningún campo puede estar vacio y la fecha de inicio y fin deben ser correctas");
        } else {
            String codigo = txt_codigo.getText();
            String descripcion = txt_descripcion.getText();
            Date fecha_inicio = (Date) txt_fecha_inicio.getDate();
            Date fecha_fin = (Date) txt_fecha_fin.getDate();
            int horas = Integer.parseInt((String) txt_horas.getText());
            int precio = Integer.parseInt((String) txt_precio.getText());
            Pluses incidencia = new Pluses(codigo,
                    trabajadorSS.getCodigo(),
                    descripcion, UtilidadesPantalla.convertToLocalDateViaInstant(fecha_inicio),
                    UtilidadesPantalla.convertToLocalDateViaInstant(fecha_fin),
                    horas,
                    precio
            );
            repoSS.insert(incidencia);
            restablecerTodo();
        }*/
    }//GEN-LAST:event_btn_añadir_incidenciaMouseClicked

    private void tabla_incidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_incidenciasMouseClicked
        rellenardatos(tabla_incidencias.getSelectedRow());
    }//GEN-LAST:event_tabla_incidenciasMouseClicked

    private void txt_buscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscarFocusGained
        if (txt_buscar.getText().contains("Buscar...")) {
            txt_buscar.setText("");
        }
    }//GEN-LAST:event_txt_buscarFocusGained

    private void txt_buscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscarFocusLost
        if (txt_buscar.getText().length() == 0) {
            txt_buscar.setText("Buscar...");
        }
    }//GEN-LAST:event_txt_buscarFocusLost

    //Comprobamos que el codigo no se repita.
    private void hora_accidenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora_accidenteKeyReleased
        comprobarNumero(evt);
    }//GEN-LAST:event_hora_accidenteKeyReleased

    private void hora_accidente1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hora_accidente1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_hora_accidente1KeyReleased

    private void txt_zona_lesionadaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_zona_lesionadaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_zona_lesionadaKeyReleased

    private void txt_lugarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_lugarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lugarKeyReleased

    private void txt_codigo_centroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_centroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_centroKeyReleased

    private void txt_codigo_trabajador_sustitutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_trabajador_sustitutoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_trabajador_sustitutoKeyReleased

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Accidentes_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Accidentes_vista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_incidencia;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private org.jdesktop.swingx.JXDatePicker fecha_accidente;
    private org.jdesktop.swingx.JXDatePicker fecha_baja;
    private javax.swing.JTextField hora_accidente;
    private javax.swing.JTextField hora_accidente1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_descripcion;
    private org.edisoncor.gui.panel.PanelRect label_fechainicio;
    private javax.swing.JLabel lbl_accidente;
    private javax.swing.JLabel lbl_baja;
    private javax.swing.JLabel lbl_codigo_centro;
    private javax.swing.JLabel lbl_codigo_trabajador_sustituto;
    private javax.swing.JLabel lbl_info_trabajador1;
    private javax.swing.JLabel lbl_lugar;
    private javax.swing.JLabel lbl_zona_lesionada;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTable tabla_incidencias;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo_centro;
    private javax.swing.JTextField txt_codigo_trabajador_sustituto;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_lugar;
    private javax.swing.JTextField txt_zona_lesionada;
    // End of variables declaration//GEN-END:variables

    private void rellenardatos(int filaSeleccionada) {
        btn_añadir_incidencia.setVisible(false);
        btn_borrar.setVisible(true);
        btn_limpiar.setVisible(true);
        btn_modificar.setVisible(true);
        AccidentesLaborales plus;
        int id = (int) tabla_incidencias.getValueAt(filaSeleccionada, 0);
        plus = repoSS.getById(id);

        fecha_accidente.setDate(java.sql.Date.valueOf(plus.getFecha_accidente()));
        fecha_baja.setDate(java.sql.Date.valueOf(plus.getFecha_baja()));
        txt_descripcion.setText(plus.getDescripcion());
        txt_zona_lesionada.setText(plus.getZona_lesionada());
        txt_lugar.setText(plus.getLugar());
        txt_codigo_centro.setText(plus.getId_centro()+"");
        txt_codigo_trabajador_sustituto.setText(plus.getId_trabajador_sustituto()+"");
        
    }

    /**
     * Comprueba el evento para que no puedan introducirse letras.
     *
     * @param evt
     */
    private void comprobarNumero(KeyEvent evt) {

        if (Character.isDigit(evt.getKeyChar()) == false) {
            //JOptionPane.showMessageDialog(rootPane, "No puedes introducir letras");
            evt.consume();
        }
    }

    /**
     * Comprueba el evento para que no puedan introducirse numeros.
     *
     * @param evt
     */
    private void comprobarLetra(KeyEvent evt) {

        if (Character.isDigit(evt.getKeyChar()) == true) {
            //JOptionPane.showMessageDialog(rootPane, "No puedes introducir números");
            evt.consume();
        }
    }

    /**
     * Restablece todo el panel por defecto.
     */
    private void restablecerTodo() {
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        txt_descripcion.setText("");
        txt_codigo_centro.setText("");
        txt_codigo_trabajador_sustituto.setText(null);
        fecha_accidente.setDate(null);
        fecha_baja.setDate(null);
        hora_accidente.setText("");
        hora_accidente1.setText("");
        txt_zona_lesionada.setText("");
        txt_lugar.setText("");
        btn_modificar.setVisible(false);
        btn_borrar.setVisible(false);
        btn_limpiar.setVisible(false);
        btn_añadir_incidencia.setVisible(true);
    }

    /**
     * Comprobamos que el codigo no se repita, avisandole en rojo.
     *
     * @param evt
     */
    /*private void comprobarCodigo(KeyEvent evt) {
        if (repoSSTotal.ifCodigoExist(hora_accidente.getText()) && lbl_accidente.getForeground().equals(new java.awt.Color(0, 0, 0))) {
            JOptionPane.showMessageDialog(this, "Codigo repetido", "Codigo", JOptionPane.WARNING_MESSAGE);
            lbl_accidente.setForeground(Color.red);
        } else if (!repoSSTotal.ifCodigoExist(hora_accidente.getText()) && lbl_accidente.getForeground().equals(Color.red)) {
            lbl_accidente.setForeground(new java.awt.Color(0, 0, 0));
        }
    }*/
}
