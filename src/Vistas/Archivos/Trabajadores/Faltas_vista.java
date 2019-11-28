/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.Falta;
import Modelo.Repository.FaltaRepository;
import Modelo.Repository.TrabajadorRepository;
import Modelo.Entidades.Trabajador;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dwigh
 */
public final class Faltas_vista extends javax.swing.JFrame {

    FaltaRepository repoFalta;
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    Trabajador trabajadorFaltas;

    /**
     * Creates new form Vacaciones_vista
     */
    public Faltas_vista() {
    }

    public Faltas_vista(Trabajador trabajador) {
        this.trabajadorFaltas = trabajador;
        repoFalta=new FaltaRepository();
        initComponents();
        ponAyuda();
        pulsarX();
        UtilidadesPantalla.resolucionPantalla(this);
        UtilidadesPantalla.centrarTablas(tabla_faltas);
        tabla_faltas.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_faltas.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_faltas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_faltas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla_faltas.getColumnModel().getColumn(1).setMaxWidth(100);
        btn_añadir_faltas.setVisible(true);
        btn_borrar_faltas.setVisible(false);
        btn_limpiar_faltas.setVisible(false);
        btn_modificar_faltas.setVisible(false);
        String trabajadorinfo = lbl_info_trabajador1.getText() + " " + trabajadorFaltas.getNombre() + " - " + trabajadorFaltas.getApellido1() + " " + trabajadorFaltas.getApellido2();
        lbl_info_trabajador1.setText(trabajadorinfo.toUpperCase());
        repoFalta.rellenarTablaByTrabajador(tabla_faltas, trabajadorFaltas.getCodigo());
        txt_codigo_falta.requestFocus();
    }

    private void pulsarX() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                trabajadorFaltas = null;
                this.windowClosed(evt);
            }
        });
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "faltas", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        lbl_info_trabajador1 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_faltas = new javax.swing.JTable();
        panelRect2 = new org.edisoncor.gui.panel.PanelRect();
        btn_limpiar_faltas = new javax.swing.JButton();
        btn_borrar_faltas = new javax.swing.JButton();
        btn_modificar_faltas = new javax.swing.JButton();
        btn_añadir_faltas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_motivo = new javax.swing.JTextArea();
        label_descripcion = new javax.swing.JLabel();
        lbl_fechainicio_faltas = new javax.swing.JLabel();
        txt_fechainicio_faltas = new org.jdesktop.swingx.JXDatePicker();
        lbl_fechafin_faltas = new javax.swing.JLabel();
        txt_fechafin_faltas = new org.jdesktop.swingx.JXDatePicker();
        lbl_codigo_faltas = new javax.swing.JLabel();
        txt_codigo_falta = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("FALTAS");
        setIconImage(new ImageIcon(getClass().getResource("/img/falta.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1360, 762));
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setPreferredSize(new java.awt.Dimension(1360, 762));
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelRect1.setMaximumSize(new java.awt.Dimension(1370, 768));
        panelRect1.setMinimumSize(new java.awt.Dimension(1370, 768));
        panelRect1.setPreferredSize(new java.awt.Dimension(1370, 768));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setForeground(new java.awt.Color(0, 0, 0));
        panelCurves1.setOpaque(true);
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_info_trabajador1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_info_trabajador1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_info_trabajador1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_info_trabajador1.setText("TRABAJADOR:");
        panelCurves1.add(lbl_info_trabajador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 830, 40));

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
        panelCurves1.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 230, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        panelCurves1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, 40));

        tabla_faltas.setAutoCreateRowSorter(true);
        tabla_faltas.setBackground(new java.awt.Color(204, 204, 204));
        tabla_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_faltas.setForeground(new java.awt.Color(0, 0, 0));
        tabla_faltas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "FECHA INICIO", "FECHA FIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
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
        tabla_faltas.setRowHeight(35);
        tabla_faltas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_faltasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_faltas);
        if (tabla_faltas.getColumnModel().getColumnCount() > 0) {
            tabla_faltas.getColumnModel().getColumn(0).setResizable(false);
            tabla_faltas.getColumnModel().getColumn(1).setResizable(false);
            tabla_faltas.getColumnModel().getColumn(2).setResizable(false);
            tabla_faltas.getColumnModel().getColumn(3).setResizable(false);
        }

        panelCurves1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 1230, 450));

        panelRect2.setColorDeSegundoBorde(new java.awt.Color(102, 102, 102));
        panelRect2.setColorPrimario(new java.awt.Color(153, 153, 153));
        panelRect2.setColorSecundario(new java.awt.Color(102, 102, 102));
        panelRect2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_limpiar_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar_faltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar_faltas.setText("Limpiar");
        btn_limpiar_faltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiar_faltasActionPerformed(evt);
            }
        });
        panelRect2.add(btn_limpiar_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, 200, 35));

        btn_borrar_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar_faltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar_faltas.setText("Borrar");
        btn_borrar_faltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrar_faltasActionPerformed(evt);
            }
        });
        panelRect2.add(btn_borrar_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 200, 35));

        btn_modificar_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar_faltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar_faltas.setText("Modificar");
        btn_modificar_faltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_faltasActionPerformed(evt);
            }
        });
        panelRect2.add(btn_modificar_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 200, 35));

        btn_añadir_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir_faltas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir_faltas.setText("Añadir");
        btn_añadir_faltas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_faltasActionPerformed(evt);
            }
        });
        panelRect2.add(btn_añadir_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 200, 35));

        txt_motivo.setColumns(20);
        txt_motivo.setLineWrap(true);
        txt_motivo.setRows(5);
        txt_motivo.setMaximumSize(new java.awt.Dimension(270, 80));
        txt_motivo.setMinimumSize(new java.awt.Dimension(270, 80));
        txt_motivo.setPreferredSize(new java.awt.Dimension(270, 80));
        jScrollPane1.setViewportView(txt_motivo);

        panelRect2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 350, 80));

        label_descripcion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_descripcion.setForeground(new java.awt.Color(0, 0, 0));
        label_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_descripcion.setText("Descripcion de la falta");
        panelRect2.add(label_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 340, 35));

        lbl_fechainicio_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechainicio_faltas.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fechainicio_faltas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechainicio_faltas.setText("Fecha de inicio");
        panelRect2.add(lbl_fechainicio_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 200, 34));

        txt_fechainicio_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        panelRect2.add(txt_fechainicio_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 200, 35));

        lbl_fechafin_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_faltas.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fechafin_faltas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_faltas.setText("Fecha de fin");
        panelRect2.add(lbl_fechafin_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 200, 34));

        txt_fechafin_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        panelRect2.add(txt_fechafin_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 200, 35));

        lbl_codigo_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo_faltas.setForeground(new java.awt.Color(0, 0, 0));
        lbl_codigo_faltas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo_faltas.setText("Codigo de Falta");
        panelRect2.add(lbl_codigo_faltas, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 42, 150, 30));

        txt_codigo_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_codigo_falta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codigo_faltaActionPerformed(evt);
            }
        });
        txt_codigo_falta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_faltaKeyReleased(evt);
            }
        });
        panelRect2.add(txt_codigo_falta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 160, 30));

        panelCurves1.add(panelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 530, 1250, 150));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1370, 740));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void tabla_vacacionesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_vacacionesKeyReleased
        int filaSeleccionada = tabla_faltas.getSelectedRow();
        rellenardatos(filaSeleccionada);

    }//GEN-LAST:event_tabla_vacacionesKeyReleased

    private void txt_buscador_trabajadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscador_trabajadorKeyReleased

    }//GEN-LAST:event_txt_buscador_trabajadorKeyReleased

    private void tabla_faltasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_faltasMouseClicked
        int filaSeleccionada = tabla_faltas.getSelectedRow();
        rellenardatos(filaSeleccionada);
    }//GEN-LAST:event_tabla_faltasMouseClicked

    private void btn_modificar_faltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_faltasActionPerformed
        Falta falta = new Falta();
        falta.setCodigo(txt_codigo_falta.getText());
        falta.setCodigo_trabajador(trabajadorFaltas.getCodigo());
        falta.setFecha_inicio(txt_fechainicio_faltas.getDate());
        if (txt_fechafin_faltas.getDate() != null) {
            falta.setFecha_fin(txt_fechafin_faltas.getDate());
        } else {
            falta.setFecha_fin(null);
        }
        falta.setMotivo(txt_motivo.getText());
        falta.setId((int) tabla_faltas.getValueAt(tabla_faltas.getSelectedRow(), 0));
        repoFalta.update(falta);
        restablecerTodo();
    }//GEN-LAST:event_btn_modificar_faltasActionPerformed

    private void btn_borrar_faltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrar_faltasActionPerformed
        int filaSeleccionada = tabla_faltas.getSelectedRow();
        int opcionborrar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de borrar el registro?");
        switch (opcionborrar) {
            case 0://OPCION SI BORRAR TRABAJADOR
                int id = (int) tabla_faltas.getValueAt(filaSeleccionada, 0);
                repoFalta.delete(id);
                break;
            case 1://OPCION NO BORRAR CONTRATO, se tiene que poner para que los datos que ya estan escritos en los jtextfield no se borren al darle a "NO"
                break;
            default://OPCION CANCELAR
                restablecerTodo();
                break;
        }
    }//GEN-LAST:event_btn_borrar_faltasActionPerformed

    private void btn_limpiar_faltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiar_faltasActionPerformed
        restablecerTodo();
    }//GEN-LAST:event_btn_limpiar_faltasActionPerformed

    private void btn_añadir_faltasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_faltasActionPerformed
        Falta falta = new Falta();
        falta.setCodigo(txt_codigo_falta.getText());
        falta.setCodigo_trabajador(trabajadorFaltas.getCodigo());
        falta.setFecha_inicio(txt_fechainicio_faltas.getDate());
        if (txt_fechafin_faltas.getDate() != null) {
            falta.setFecha_fin(txt_fechafin_faltas.getDate());
        } else {
            falta.setFecha_fin(null);
        }
        falta.setMotivo(txt_motivo.getText());
        //AHORA NOS CONECTAMOS A LA BBDD Y LO AÑADIMOS
        repoFalta.insert(falta);
        int input = JOptionPane.showConfirmDialog(this,
                "¿Quieres crear una incidencia con esta falta?", "Crear una INCIDENCIA", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            TrabajadorRepository tr = new TrabajadorRepository();
            Object[] trabajadores = tr.buscarTrabajadoresPorCentrosDeUnCodigoTrabajador(trabajadorFaltas.getCodigo());
            String opcion = (String) JOptionPane.showInputDialog(this, "Selecciona un trabajador", "Elegir", JOptionPane.QUESTION_MESSAGE,
                    null, trabajadores, "Selecciona uno");
            Incidencias_vista inci = new Incidencias_vista(tr.getByNombre(opcion), falta);
            inci.setVisible(true);
            this.dispose();
        }
        restablecerTodo();
    }//GEN-LAST:event_btn_añadir_faltasActionPerformed

    private void txt_codigo_faltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codigo_faltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_faltaActionPerformed

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        if (!txt_buscar.getText().isEmpty()) {//SI EL BUSCADOR NO ESTA VACIO, VACIA LA TABLA Y EMPIEZA A BUSCAR CON LOS CARACTERES QUE LE VAMOS INTRODUCIENDO
            DefaultTableModel dm = (DefaultTableModel) tabla_faltas.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged();
            repoFalta.buscarFecha(tabla_faltas, txt_buscar.getText(), trabajadorFaltas.getCodigo());
        } else {//SI POR EL CONTRARIO ESTA VACIO EL BUSCADOR, ENTONCES RELLENA LA TABLA CON TODO
            restablecerTodo();
        }

    }//GEN-LAST:event_txt_buscarKeyReleased

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

    private void txt_codigo_faltaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_faltaKeyReleased
        comprobarNumero(evt);
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigo_faltaKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Faltas_vista().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir_faltas;
    private javax.swing.JButton btn_borrar_faltas;
    private javax.swing.JButton btn_limpiar_faltas;
    private javax.swing.JButton btn_modificar_faltas;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel lbl_codigo_faltas;
    private javax.swing.JLabel lbl_fechafin_faltas;
    private javax.swing.JLabel lbl_fechainicio_faltas;
    private javax.swing.JLabel lbl_info_trabajador1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private org.edisoncor.gui.panel.PanelRect panelRect2;
    private javax.swing.JTable tabla_faltas;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo_falta;
    private org.jdesktop.swingx.JXDatePicker txt_fechafin_faltas;
    private org.jdesktop.swingx.JXDatePicker txt_fechainicio_faltas;
    private javax.swing.JTextArea txt_motivo;
    // End of variables declaration//GEN-END:variables

    private void rellenardatos(int filaSeleccionada) {
        btn_añadir_faltas.setVisible(false);
        btn_modificar_faltas.setVisible(true);
        btn_borrar_faltas.setVisible(true);
        btn_limpiar_faltas.setVisible(true);
        int id = (int) tabla_faltas.getValueAt(filaSeleccionada, 0);
        Falta falta = repoFalta.getById(id);
        txt_codigo_falta.setText(falta.getCodigo() + "");
        txt_fechainicio_faltas.setDate(falta.getFecha_inicio());
        txt_fechafin_faltas.setDate(falta.getFecha_fin());
        txt_motivo.setText(falta.getMotivo());

    }

    private void restablecerTodo() {
        repoFalta.rellenarTablaByTrabajador(tabla_faltas, trabajadorFaltas.getCodigo());
        txt_fechafin_faltas.setDate(null);
        txt_fechainicio_faltas.setDate(null);
        btn_añadir_faltas.setVisible(true);
        btn_modificar_faltas.setVisible(false);
        btn_limpiar_faltas.setVisible(false);
        btn_borrar_faltas.setVisible(false);
        txt_codigo_falta.setText("");
        txt_fechafin_faltas.setDate(null);
        txt_fechainicio_faltas.setDate(null);
        txt_motivo.setText("");
    }

    private void comprobarCodigo(KeyEvent evt) {
        try {
            if (repoFalta.ifCodigoExist(txt_codigo_falta.getText()) && lbl_codigo_faltas.getForeground().equals(new java.awt.Color(0, 0, 0))) {
                JOptionPane.showMessageDialog(this, "Codigo repetito", "Codigo", JOptionPane.WARNING_MESSAGE);
                lbl_codigo_faltas.setForeground(Color.red);
            } else if (!repoFalta.ifCodigoExist(txt_codigo_falta.getText()) && lbl_codigo_faltas.getForeground().equals(Color.red)) {
                lbl_codigo_faltas.setForeground(new java.awt.Color(0, 0, 0));
            }
        } catch (NumberFormatException e) {

        }
    }

    private void comprobarNumero(KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar()) == false) {
            //JOptionPane.showMessageDialog(rootPane, "No puedes introducir letras");
            evt.consume();
        }
    }
}
