/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.Nominas;
import Modelo.Entidades.Trabajador;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
import java.awt.event.KeyEvent;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;

/**
 *
 * @author DisenoWeb
 */
public class Nominas_vista extends javax.swing.JFrame {

    Utilidades utilidades = new Utilidades();
    SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
    public static int id_trabajador;

    /**
     * Creates new form Nominas_vista
     */
    public Nominas_vista() {
        initComponents();
    }

    Nominas_vista(Trabajador trabajador) {
        initComponents();
        UtilidadesPantalla.resolucionPantalla(this);
        UtilidadesPantalla.centrarTablas(tabla_nominas);
        ponAyuda();
        id_trabajador = trabajador.getId();
        tabla_nominas.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_nominas.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_nominas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_nominas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        btn_añadir.setVisible(true);
        btn_borrar.setVisible(false);
        btn_limpiar.setVisible(false);
        btn_modificar.setVisible(false);
        String trabajadorinfo = lbl_info_trabajador2.getText() + " " + id_trabajador + " - " + trabajador.getApellido1() + trabajador.getApellido2();
        lbl_info_trabajador2.setText(trabajadorinfo.toUpperCase());
        utilidades.rellenarTablaDatosIndividuales(tabla_nominas, "nominas", id_trabajador);
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "nominas", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        lbl_info_trabajador2 = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_nominas = new javax.swing.JTable();
        panelRect2 = new org.edisoncor.gui.panel.PanelRect();
        btn_limpiar = new javax.swing.JButton();
        btn_borrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        lbl_fechainicio = new javax.swing.JLabel();
        txt_fechainicio = new org.jdesktop.swingx.JXDatePicker();
        lbl_fechafin = new javax.swing.JLabel();
        txt_fechafin = new org.jdesktop.swingx.JXDatePicker();
        txt_importe = new javax.swing.JTextField();
        lbl_importe = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        panelCurves1.setOpaque(true);
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_info_trabajador2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_info_trabajador2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_info_trabajador2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_info_trabajador2.setText("TRABAJADOR:");
        panelCurves1.add(lbl_info_trabajador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 830, 40));

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

        tabla_nominas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_nominas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO TRABAJADOR", "FECHA INICIO", "FECHA FIN", "IMPORTE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_nominas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_nominasMouseClicked(evt);
            }
        });
        tabla_nominas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabla_nominasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_nominas);
        if (tabla_nominas.getColumnModel().getColumnCount() > 0) {
            tabla_nominas.getColumnModel().getColumn(0).setResizable(false);
            tabla_nominas.getColumnModel().getColumn(1).setResizable(false);
            tabla_nominas.getColumnModel().getColumn(2).setResizable(false);
            tabla_nominas.getColumnModel().getColumn(4).setResizable(false);
        }

        panelCurves1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 94, 1330, 430));

        panelRect2.setColorDeSegundoBorde(new java.awt.Color(102, 102, 102));
        panelRect2.setColorPrimario(new java.awt.Color(153, 153, 153));
        panelRect2.setColorSecundario(new java.awt.Color(102, 102, 102));
        panelRect2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_limpiar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        panelRect2.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 100, 200, 35));

        btn_borrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar.setText("Borrar");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });
        panelRect2.add(btn_borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 200, 35));

        btn_modificar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        panelRect2.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 20, 200, 35));

        btn_añadir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir.setText("Añadir");
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });
        panelRect2.add(btn_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 60, 200, 35));

        lbl_fechainicio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechainicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechainicio.setText("Fecha de inicio");
        panelRect2.add(lbl_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 200, 34));

        txt_fechainicio.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_fechainicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_fechainicioActionPerformed(evt);
            }
        });
        panelRect2.add(txt_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 200, 35));

        lbl_fechafin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin.setText("Fecha de fin");
        panelRect2.add(lbl_fechafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, 200, 34));

        txt_fechafin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        panelRect2.add(txt_fechafin, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 200, 35));

        txt_importe.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_importe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_importeActionPerformed(evt);
            }
        });
        panelRect2.add(txt_importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, 200, 35));

        lbl_importe.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_importe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_importe.setText("Importe");
        panelRect2.add(lbl_importe, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 200, 35));

        panelCurves1.add(panelRect2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 1320, 150));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1370, 740));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_nominasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_nominasKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            int filaSeleccionada = tabla_nominas.getSelectedRow();
            if (filaSeleccionada > 0) {
                filaSeleccionada = filaSeleccionada - 1;
            }
            rellenardatos(filaSeleccionada);
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            int filaSeleccionada = tabla_nominas.getSelectedRow();
            if (filaSeleccionada < tabla_nominas.getRowCount() - 1) {
                filaSeleccionada = filaSeleccionada + 1;
            }
            rellenardatos(filaSeleccionada);
        }
    }//GEN-LAST:event_tabla_nominasKeyReleased

    private void tabla_nominasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_nominasMouseClicked
        int filaSeleccionada = tabla_nominas.getSelectedRow();
        rellenardatos(filaSeleccionada);
    }//GEN-LAST:event_tabla_nominasMouseClicked

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

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased

    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        restablecerTodo();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed

    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed

    }//GEN-LAST:event_btn_añadirActionPerformed

    private void txt_fechainicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_fechainicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_fechainicioActionPerformed

    private void txt_importeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_importeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_importeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Nominas_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nominas_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nominas_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nominas_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nominas_vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_borrar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_fechafin;
    private javax.swing.JLabel lbl_fechainicio;
    private javax.swing.JLabel lbl_importe;
    private javax.swing.JLabel lbl_info_trabajador2;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private org.edisoncor.gui.panel.PanelRect panelRect2;
    private javax.swing.JTable tabla_nominas;
    private javax.swing.JTextField txt_buscar;
    private org.jdesktop.swingx.JXDatePicker txt_fechafin;
    private org.jdesktop.swingx.JXDatePicker txt_fechainicio;
    private javax.swing.JTextField txt_importe;
    // End of variables declaration//GEN-END:variables

    private void restablecerTodo() {
        //txt_buscador_trabajador.setText("");
        txt_fechafin.setDate(null);
        txt_fechainicio.setDate(null);
        txt_importe.setText("");
        btn_añadir.setVisible(true);
        btn_modificar.setVisible(false);
        btn_borrar.setVisible(false);
        btn_limpiar.setVisible(false);
    }

    private void rellenardatos(int filaSeleccionada) {
        btn_añadir.setVisible(false);
        btn_modificar.setVisible(true);
        btn_borrar.setVisible(true);
        btn_limpiar.setVisible(true);

        try {
            Date fechainicio = formato.parse((String) tabla_nominas.getValueAt(filaSeleccionada, 2));
            if (tabla_nominas.getValueAt(filaSeleccionada, 3).equals("Sin fecha")) {
                txt_fechafin.setDate(null);
            } else {
                Date fechafin = formato.parse((String) tabla_nominas.getValueAt(filaSeleccionada, 3));
                txt_fechafin.setDate(fechafin);
            }
            txt_fechainicio.setDate(fechainicio);
            txt_importe.setText(String.valueOf(tabla_nominas.getValueAt(filaSeleccionada, 4)));
        } catch (ParseException ex) {
            Logger.getLogger(Faltas_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
