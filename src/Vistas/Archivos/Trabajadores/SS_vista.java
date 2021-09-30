/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.AsuntosPropios;
import Modelo.Entidades.Centro;
import Modelo.Entidades.Vacaciones;
import Modelo.Entidades.Pluses;
import Modelo.Repository.PlusesRepository;
import Modelo.Entidades.Trabajador;
import Utilidades.UtilidadesPantalla;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SS_vista extends javax.swing.JFrame {

    PlusesRepository repoSS;
    PlusesRepository repoSSTotal;
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    Trabajador trabajadorSS;
    Centro centroIncidencias;

    public SS_vista(Trabajador trabajador) {
        this.trabajadorSS = trabajador;
        iniciarOtrosComponentes();
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
    }

    private SS_vista() {
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());

    }

    public SS_vista(Centro centro) {
        this.centroIncidencias = centro;
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByIncidenciasDeUnCentro(tabla_incidencias, centro.getCodigo());
        String centroinfo = centro.getNombre();
        lbl_info_trabajador1.setText(centroinfo.toUpperCase());
    }

    public SS_vista(Trabajador trabajadorVacaciones, Vacaciones falta) {
        this.trabajadorSS = trabajadorVacaciones;
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        //txt_fecha_inicio.setDate(java.sql.Date.valueOf(falta.getFecha_inicio()));
        //txt_fecha_fin.setDate(java.sql.Date.valueOf(falta.getFecha_fin()));
        txt_descripcion.setText(falta.getMotivo());
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorSS.getNombre() + " - " + trabajadorSS.getApellido1() + " " + trabajadorSS.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
    }

    public SS_vista(Trabajador trabajadorAP, AsuntosPropios falta) {
        this.trabajadorSS = trabajadorAP;
        iniciarOtrosComponentes();
        repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        txt_codigo.setText(falta.getCodigo());
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
        btn_modificar_incidencia.setVisible(false);
        btn_borrar_incidencia.setVisible(false);
        btn_limpiar_incidencia.setVisible(false);
        //INICIAMOS REPO
        repoSS = new PlusesRepository();
        repoSSTotal = new PlusesRepository();

        //TABLA INCIDENCIAS
        tabla_incidencias.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_incidencias.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_incidencias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_incidencias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        txt_codigo.requestFocus();
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
        btn_limpiar_incidencia = new javax.swing.JButton();
        btn_borrar_incidencia = new javax.swing.JButton();
        btn_modificar_incidencia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        btn_añadir_incidencia = new javax.swing.JButton();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PLUSES");
        setIconImage(new ImageIcon(getClass().getResource("/img/incidencias .png")).getImage());
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setPreferredSize(new java.awt.Dimension(1360, 762));
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
        label_descripcion.setText("Descripción del contrato");
        label_fechainicio.add(label_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, 320, 35));

        btn_limpiar_incidencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar_incidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar_incidencia.setText("Limpiar");
        btn_limpiar_incidencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_incidenciaActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_limpiar_incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 110, 200, 35));

        btn_borrar_incidencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar_incidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar_incidencia.setText("Borrar");
        btn_borrar_incidencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_borrar_incidenciaMouseClicked(evt);
            }
        });
        label_fechainicio.add(btn_borrar_incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 200, 35));

        btn_modificar_incidencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar_incidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar_incidencia.setText("Modificar");
        btn_modificar_incidencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificar_incidenciaMouseClicked(evt);
            }
        });
        label_fechainicio.add(btn_modificar_incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 200, 35));

        txt_descripcion.setColumns(20);
        txt_descripcion.setLineWrap(true);
        txt_descripcion.setRows(5);
        txt_descripcion.setMaximumSize(new java.awt.Dimension(270, 80));
        txt_descripcion.setMinimumSize(new java.awt.Dimension(270, 80));
        txt_descripcion.setPreferredSize(new java.awt.Dimension(270, 80));
        jScrollPane1.setViewportView(txt_descripcion);

        label_fechainicio.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 320, 80));

        btn_añadir_incidencia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir_incidencia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir_incidencia.setText("Añadir");
        btn_añadir_incidencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_añadir_incidenciaMouseClicked(evt);
            }
        });
        label_fechainicio.add(btn_añadir_incidencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 70, 200, 35));

        lbl_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Codigo del contrato");
        label_fechainicio.add(lbl_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 160, 30));

        txt_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
        });
        label_fechainicio.add(txt_codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 160, 40));

        panelCurves1.add(label_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 1230, 170));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, -1));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        repoSS.buscarFecha(tabla_incidencias, txt_buscar.getText(), trabajadorSS.getCodigo());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void btn_limpiar_incidenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_incidenciaActionPerformed
        restablecerTodo();
    }//GEN-LAST:event_btn_limpiar_incidenciaActionPerformed

    private void btn_borrar_incidenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_borrar_incidenciaMouseClicked
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
    }//GEN-LAST:event_btn_borrar_incidenciaMouseClicked

    private void btn_modificar_incidenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificar_incidenciaMouseClicked
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
    }//GEN-LAST:event_btn_modificar_incidenciaMouseClicked

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
    //Comprobamos que el codigo no se repita.
    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        comprobarNumero(evt);
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigoKeyReleased

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

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SS_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new SS_vista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_incidencia;
    private javax.swing.JButton btn_borrar_incidencia;
    private javax.swing.JButton btn_limpiar_incidencia;
    private javax.swing.JButton btn_modificar_incidencia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_descripcion;
    private org.edisoncor.gui.panel.PanelRect label_fechainicio;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_info_trabajador1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTable tabla_incidencias;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextArea txt_descripcion;
    // End of variables declaration//GEN-END:variables

    private void rellenardatos(int filaSeleccionada) {
        /*btn_añadir_incidencia.setVisible(false);
        btn_borrar_incidencia.setVisible(true);
        btn_limpiar_incidencia.setVisible(true);
        btn_modificar_incidencia.setVisible(true);
        Pluses plus;
        int id = (int) tabla_incidencias.getValueAt(filaSeleccionada, 0);
        plus = repoSS.getById(id);
        txt_codigo.setText(plus.getCodigo());
        txt_horas.setText(plus.getHoras() + "");
        txt_precio.setText(plus.getPrecio() + "");
        txt_fecha_inicio.setDate(java.sql.Date.valueOf(plus.getFecha_inicio()));
        txt_fecha_fin.setDate(java.sql.Date.valueOf(plus.getFecha_fin()));
        txt_descripcion.setText(plus.getDescripcion());*/
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
        /*repoSS.rellenarTablaByTrabajador(tabla_incidencias, trabajadorSS.getCodigo());
        txt_descripcion.setText("");
        txt_codigo.setText("");
        txt_fecha_inicio.setDate(null);
        txt_fecha_fin.setDate(null);
        txt_horas.setText("");
        txt_precio.setText("");
        btn_modificar_incidencia.setVisible(false);
        btn_borrar_incidencia.setVisible(false);
        btn_limpiar_incidencia.setVisible(false);
        btn_añadir_incidencia.setVisible(true);*/
    }

    /**
     * Comprobamos que el codigo no se repita, avisandole en rojo.
     *
     * @param evt
     */
    private void comprobarCodigo(KeyEvent evt) {
        if (repoSSTotal.ifCodigoExist(txt_codigo.getText()) && lbl_codigo.getForeground().equals(new java.awt.Color(0, 0, 0))) {
            JOptionPane.showMessageDialog(this, "Codigo repetito", "Codigo", JOptionPane.WARNING_MESSAGE);
            lbl_codigo.setForeground(Color.red);
        } else if (!repoSSTotal.ifCodigoExist(txt_codigo.getText()) && lbl_codigo.getForeground().equals(Color.red)) {
            lbl_codigo.setForeground(new java.awt.Color(0, 0, 0));
        }
    }
}
