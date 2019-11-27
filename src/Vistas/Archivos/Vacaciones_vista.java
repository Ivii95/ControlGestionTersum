/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos;


import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
import Utilidades.Conexion;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Vacaciones_vista extends javax.swing.JFrame {

    Conexion conn;
    Utilidades utilidades = new Utilidades();

    public Vacaciones_vista() {
        initComponents();
        UtilidadesPantalla.resolucionPantalla(this);
        ponAyuda();
        UtilidadesPantalla.centrarTablas(tabla_faltas);
        jPanel2.requestFocusInWindow();
//        btn_modificar_falta.setVisible(false);
//        btn_borrar_falta.setVisible(false);
//        btn_limpiar_falta.setVisible(false);
//        utilidades.rellenarTabla(tabla_faltas, "faltas","");
//        tabla_faltas.getColumnModel().getColumn(0).setMaxWidth(0);
//        tabla_faltas.getColumnModel().getColumn(0).setMinWidth(0);
//        tabla_faltas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
//        tabla_faltas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
//        tabla_faltas.getColumnModel().getColumn(1).setMaxWidth(60);

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

        Grupo1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        label_codigo = new javax.swing.JLabel();
        label_descripcion = new javax.swing.JLabel();
        label_sindical = new javax.swing.JLabel();
        txt_codigo_falta = new javax.swing.JTextField();
        btn_añadir_falta = new javax.swing.JButton();
        btn_modificar_falta = new javax.swing.JButton();
        btn_borrar_falta = new javax.swing.JButton();
        btn_limpiar_falta = new javax.swing.JButton();
        rb_sindical_si = new javax.swing.JRadioButton();
        rb_sindical_no = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion_falta = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_faltas = new javax.swing.JTable();
        txt_buscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1366, 768));

        label_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo.setText("Código");

        label_descripcion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_descripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_descripcion.setText("Descripcion");

        label_sindical.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_sindical.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_sindical.setText("Sindical");

        txt_codigo_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_codigo_falta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo_falta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_codigo_faltaMouseClicked(evt);
            }
        });
        txt_codigo_falta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigo_faltaKeyTyped(evt);
            }
        });

        btn_añadir_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir_falta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir_falta.setText("Añadir");
        btn_añadir_falta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_añadir_faltaMouseClicked(evt);
            }
        });

        btn_modificar_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar_falta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar_falta.setText("Modificar");
        btn_modificar_falta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_modificar_faltaMouseClicked(evt);
            }
        });

        btn_borrar_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar_falta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar_falta.setText("Borrar");
        btn_borrar_falta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_borrar_faltaMouseClicked(evt);
            }
        });

        btn_limpiar_falta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_limpiar_falta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpiar.png"))); // NOI18N
        btn_limpiar_falta.setText("Limpiar");
        btn_limpiar_falta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_limpiar_faltaMouseClicked(evt);
            }
        });

        Grupo1.add(rb_sindical_si);
        rb_sindical_si.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_sindical_si.setText("Si");

        Grupo1.add(rb_sindical_no);
        rb_sindical_no.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        rb_sindical_no.setText("No");

        txt_descripcion_falta.setColumns(20);
        txt_descripcion_falta.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion_falta);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(label_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(label_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(label_sindical, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txt_codigo_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(rb_sindical_si)
                        .addGap(34, 34, 34)
                        .addComponent(rb_sindical_no)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_añadir_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_borrar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_limpiar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_añadir_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_modificar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_borrar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btn_limpiar_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_sindical, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rb_sindical_si)
                                            .addComponent(rb_sindical_no)))
                                    .addComponent(txt_codigo_falta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_faltas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_faltas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Código", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        tabla_faltas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabla_faltasKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_faltas);
        if (tabla_faltas.getColumnModel().getColumnCount() > 0) {
            tabla_faltas.getColumnModel().getColumn(0).setResizable(false);
            tabla_faltas.getColumnModel().getColumn(1).setResizable(false);
            tabla_faltas.getColumnModel().getColumn(2).setResizable(false);
        }

        txt_buscar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_buscar.setText("Buscar...");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(382, 382, 382)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_faltasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_faltasMouseClicked
        btn_añadir_falta.setVisible(false);
        btn_modificar_falta.setVisible(true);
        btn_borrar_falta.setVisible(true);
        btn_limpiar_falta.setVisible(true);
        txt_codigo_falta.setEditable(false);
        int filaSeleccionada = tabla_faltas.getSelectedRow();
        rellenardatos(filaSeleccionada);
    }//GEN-LAST:event_tabla_faltasMouseClicked

    private void tabla_faltasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabla_faltasKeyPressed

        if (evt.getKeyCode() == 38) {
            int filaSeleccionada = tabla_faltas.getSelectedRow();
            if (filaSeleccionada > 0) {
                filaSeleccionada = filaSeleccionada - 1;
            }
            rellenardatos(filaSeleccionada);
        }

        if (evt.getKeyCode() == 40) {
            int filaSeleccionada = tabla_faltas.getSelectedRow();
            if (filaSeleccionada < tabla_faltas.getRowCount() - 1) {
                filaSeleccionada = filaSeleccionada + 1;
            }
            rellenardatos(filaSeleccionada);
        }
    }//GEN-LAST:event_tabla_faltasKeyPressed

    private void txt_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_buscarMouseClicked
        txt_buscar.setText("");
    }//GEN-LAST:event_txt_buscarMouseClicked

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        boolean esTexto = utilidades.validarCampoTexto(evt);

        if (!esTexto && !txt_buscar.getText().isEmpty()) {//SI EL BUSCADOR NO ESTA VACIO, VACIA LA TABLA Y EMPIEZA A BUSCAR CON LOS CARACTERES QUE LE VAMOS INTRODUCIENDO
            DefaultTableModel dm = (DefaultTableModel) tabla_faltas.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged();
            utilidades.buscaryRellenarTabla(evt, txt_buscar.getText(), tabla_faltas, "faltas");
        } else {//SI POR EL CONTRARIO ESTA VACIO EL BUSCADOR, ENTONCES RELLENA LA TABLA CON TODO
            txt_buscar.setText("");
            utilidades.rellenarTabla(tabla_faltas, "faltas","");
        }

    }//GEN-LAST:event_txt_buscarKeyReleased

    private void btn_limpiar_faltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_limpiar_faltaMouseClicked
        limpiardatos();
    }//GEN-LAST:event_btn_limpiar_faltaMouseClicked

    private void btn_borrar_faltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_borrar_faltaMouseClicked
        int filaSeleccionada = tabla_faltas.getSelectedRow();
        int opcionborrar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de borrar el registro?\nfalta: " + (String) tabla_faltas.getValueAt(filaSeleccionada, 2));
        switch (opcionborrar) {
            case 0://OPCION SI BORRAR TRABAJADOR
                String id = String.valueOf(tabla_faltas.getValueAt(filaSeleccionada, 0));
                 {
                    try {
                        utilidades.deleteBbdd("faltas", id);

                    } catch (SQLException ex) {
                        Logger.getLogger(Vacaciones_vista.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    utilidades.rellenarTabla(tabla_faltas, "faltas","");
                    limpiardatos();
                }

                break;

            case 1://OPCION NO BORRAR TRABAJADOR, se tiene que poner para que los datos que ya estan escritos en los jtextfield no se borren al darle a "NO"
                break;

            default://OPCION CANCELAR
                limpiardatos();
                break;
        }
    }//GEN-LAST:event_btn_borrar_faltaMouseClicked

    private void btn_modificar_faltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_modificar_faltaMouseClicked
//        boolean sindical = false;
//
//        if (txt_codigo_falta.getText().equals("") || txt_descripcion_falta.getText().equals("")) {
//            JOptionPane.showMessageDialog(rootPane, "Ningún campo menos el sindical puede estar vacio");
//        } else {
//            int codigo = Integer.parseInt(txt_codigo_falta.getText());
//            int filaSeleccionada = tabla_faltas.getSelectedRow();
//            int id = (int) tabla_faltas.getValueAt(filaSeleccionada, 0);
//            String descripcion = txt_descripcion_falta.getText();
//            sindical = rb_sindical_si.isSelected();
//            Falta falta = new Falta(codigo, descripcion, sindical);
//            try {
//                utilidades.updatebbdd("faltas", falta, id);
//                utilidades.rellenarTabla(tabla_faltas, "faltas","");
//            } catch (SQLException ex) {
//                Logger.getLogger(Trabajadores_vista.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            limpiardatos();
//
//        }
    }//GEN-LAST:event_btn_modificar_faltaMouseClicked

    private void btn_añadir_faltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_añadir_faltaMouseClicked
//        boolean sindical = false;
//        if (txt_codigo_falta.getText().equals("") || txt_descripcion_falta.getText().equals("")) {
//            JOptionPane.showMessageDialog(rootPane, "Ningún campo menos el sindical puede estar vacio");
//        } else {
//            String codigo = txt_codigo_falta.getText();
//            if (utilidades.comprobarCodigoRepetido(codigo, "faltas")) {
//                JOptionPane.showMessageDialog(rootPane, "El codigo de falta ya está asignado a otra falta");
//                utilidades.rellenarTabla(tabla_faltas, "faltas","");
//            } else {
//                try {
//                    String descripcion = txt_descripcion_falta.getText();
//                    sindical = rb_sindical_si.isSelected();
//                    //CREAR EL OBJETO
//            //        Falta falta = new Falta(Integer.parseInt(codigo), descripcion, sindical);
//                    //LLAMAR A LOS METODOS
//                    utilidades.addBbdd("faltas", falta);
//                    utilidades.rellenarTabla(tabla_faltas, "faltas","");
//                    limpiardatos();
//                } catch (SQLException ex) {
//                    Logger.getLogger(Clientes_vista.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
    }//GEN-LAST:event_btn_añadir_faltaMouseClicked

    private void txt_codigo_faltaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_faltaKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_codigo_faltaKeyTyped

    private void txt_codigo_faltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_codigo_faltaMouseClicked
        btn_añadir_falta.setVisible(true);
        //btn_modificar_falta.setVisible(true);
        //btn_borrar_falta.setVisible(true);
        btn_limpiar_falta.setVisible(true);
        txt_buscar.setText("Buscar...");
    }//GEN-LAST:event_txt_codigo_faltaMouseClicked

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vacaciones_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vacaciones_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vacaciones_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vacaciones_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vacaciones_vista().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton btn_añadir_falta;
    private javax.swing.JButton btn_borrar_falta;
    private javax.swing.JButton btn_limpiar_falta;
    private javax.swing.JButton btn_modificar_falta;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_codigo;
    private javax.swing.JLabel label_descripcion;
    private javax.swing.JLabel label_sindical;
    private javax.swing.JRadioButton rb_sindical_no;
    private javax.swing.JRadioButton rb_sindical_si;
    private javax.swing.JTable tabla_faltas;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_codigo_falta;
    private javax.swing.JTextArea txt_descripcion_falta;
    // End of variables declaration//GEN-END:variables

    private void rellenardatos(int filaSeleccionada) {
//
//        Falta falta = new Falta();
//        int id = (int) tabla_faltas.getValueAt(filaSeleccionada, 0);
//        for (int i = 0; i < utilidades.lista_de_faltas.size(); i++) {
//            falta = utilidades.lista_de_faltas.get(i);
//            if (falta.getId() == id) {
//                txt_codigo_falta.setText(String.valueOf(tabla_faltas.getValueAt(filaSeleccionada, 1)));
//                txt_descripcion_falta.setText(String.valueOf(tabla_faltas.getValueAt(filaSeleccionada, 2)));
//                if (falta.isSindical()) {
//                    rb_sindical_si.setSelected(true);
//                } else {
//                    rb_sindical_no.setSelected(true);
//                }
//            }
//        }
    }

    private void limpiardatos() {
        Grupo1.clearSelection();
        txt_codigo_falta.setText("");
        txt_descripcion_falta.setText("");
        btn_modificar_falta.setVisible(false);
        btn_borrar_falta.setVisible(false);
        btn_limpiar_falta.setVisible(false);
        btn_añadir_falta.setVisible(true);
        txt_codigo_falta.setEditable(true);

    }

    private void comprobarNumero(KeyEvent evt) {

        if (Character.isDigit(evt.getKeyChar()) == false) {
            JOptionPane.showMessageDialog(rootPane, "No puedes introducir letras");
            evt.consume();
        }
    }

    private void comprobarLetra(KeyEvent evt) {

        if (Character.isDigit(evt.getKeyChar()) == true) {
            JOptionPane.showMessageDialog(rootPane, "No puedes introducir números");
            evt.consume();
        }
    }
}
