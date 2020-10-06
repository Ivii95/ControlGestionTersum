/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Clientes;

import Modelo.Entidades.Centro;
import Modelo.Entidades.Cliente;
import Modelo.Repository.CentroRepository;
import Utilidades.UtilidadesPantalla;
import Vistas.Archivos.Trabajadores.VistaTrabajadores;
import Vistas.Fichas.FichaCentros;
import Vistas.Formularios.FormularioCentro;
import Vistas.Principal.Principal_vista;
//import Vistas.Fichas.FichaCentros;
//import Vistas.Formularios.FormularioCentro;
//import Vistas.Principal.Principal_vista;
import java.util.Timer;
import java.util.TimerTask;
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
 * @author DisenoWeb
 */
public class VistaCentros extends javax.swing.JFrame {

    CentroRepository cr;
    Cliente clienteCentros;
    private boolean isAlreadyOneClick;

    /**
     * Creates new form VistaCentros
     */
    public VistaCentros() {
        initComponents();
    }

    public VistaCentros(Cliente cliente) {
        this.clienteCentros = cliente;
        initComponents();
        UtilidadesPantalla.resolucionPantalla(this);
        UtilidadesPantalla.centrarTablas(tabla_centros);
        ponAyuda();
        txt_buscador.requestFocusInWindow();
        tabla_centros.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_centros.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_centros.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_centros.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla_centros.getColumnModel().getColumn(1).setMaxWidth(60);
        String titulo = txtTitulo.getText();
        txtTitulo.setText(titulo + " " + cliente.getNombre_comercial());
        cr = new CentroRepository();
        cr.rellenarTablaByCliente(tabla_centros, clienteCentros);
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "centros", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_botones = new org.edisoncor.gui.panel.Panel();
        btn_borrar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_añadir = new javax.swing.JButton();
        Buscador = new javax.swing.JPanel();
        txt_buscador = new javax.swing.JTextField();
        btn_buscar = new org.edisoncor.gui.button.ButtonIcon();
        btn_trabajadores = new javax.swing.JButton();
        btn_trabajadores1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_centros = new javax.swing.JTable();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        txtTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CENTROS");
        setIconImage(new ImageIcon(getClass().getResource("/img/centros .png")).getImage());
        setMaximumSize(new java.awt.Dimension(1360, 762));
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setPreferredSize(new java.awt.Dimension(1360, 762));
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_botones.setColorPrimario(new java.awt.Color(102, 102, 102));
        Panel_botones.setColorSecundario(new java.awt.Color(51, 51, 51));

        btn_borrar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar.setText("Borrar ");
        btn_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarActionPerformed(evt);
            }
        });

        btn_modificar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_añadir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir.setText("Añadir");
        btn_añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadirActionPerformed(evt);
            }
        });

        Buscador.setBackground(new java.awt.Color(102, 102, 102));
        Buscador.setForeground(new java.awt.Color(102, 102, 102));

        txt_buscador.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_buscador.setText("Buscar...");
        txt_buscador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_buscadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_buscadorFocusLost(evt);
            }
        });
        txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscadorKeyReleased(evt);
            }
        });

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/busqueda.png"))); // NOI18N
        btn_buscar.setText("buttonIcon1");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BuscadorLayout = new javax.swing.GroupLayout(Buscador);
        Buscador.setLayout(BuscadorLayout);
        BuscadorLayout.setHorizontalGroup(
            BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscadorLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BuscadorLayout.setVerticalGroup(
            BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_buscador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btn_trabajadores.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_trabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trabajador.png"))); // NOI18N
        btn_trabajadores.setText("Ver Trabajadores");
        btn_trabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajadoresActionPerformed(evt);
            }
        });

        btn_trabajadores1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btn_trabajadores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trabajador.png"))); // NOI18N
        btn_trabajadores1.setText("Asignar Trabajadores");
        btn_trabajadores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_trabajadores1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_botonesLayout = new javax.swing.GroupLayout(Panel_botones);
        Panel_botones.setLayout(Panel_botonesLayout);
        Panel_botonesLayout.setHorizontalGroup(
            Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_botonesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_borrar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_añadir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Buscador, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_trabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_trabajadores1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26))
        );
        Panel_botonesLayout.setVerticalGroup(
            Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_botonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btn_añadir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(225, 225, 225)
                .addComponent(btn_trabajadores1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_trabajadores, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(Panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(992, 73, -1, 590));

        tabla_centros.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_centros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Código", "Nombre"
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
        tabla_centros.setRowHeight(35);
        tabla_centros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_centrosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_centros);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 860, 600));

        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setOpaque(true);
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtTitulo.setForeground(new java.awt.Color(240, 240, 240));
        txtTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTitulo.setText("Nombre de centro:");
        panelCurves1.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 1170, 40));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1374, 747));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarActionPerformed
        if (tabla_centros.getSelectedRow() != -1) {
            int filaSeleccionada = tabla_centros.getSelectedRow();
            int opcionborrar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de borrar el registro?\n"
                    + "Centro: " + (String) tabla_centros.getValueAt(filaSeleccionada, 2));
            switch (opcionborrar) {
                case 0://OPCION SI BORRAR TRABAJADOR
                    int id = Integer.parseInt(String.valueOf(tabla_centros.getValueAt(filaSeleccionada, 0)));
                     {
                        cr.delete(id);
                        cr.rellenarTablaByCliente(tabla_centros, clienteCentros);
                       //utilidades.deleteBbdd("clientes", id);
                    }
                    break;
                case 1://OPCION NO BORRAR TRABAJADOR, se tiene que poner para que los datos que ya estan escritos en los jtextfield no se borren al darle a "NO"
                    break;

                default://OPCION CANCELAR
                    //utilidades.rellenarTabla(tabla_clientes, "clientes", "");
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente");
        }
    }//GEN-LAST:event_btn_borrarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        if (-1 != tabla_centros.getSelectedRow()) {
            Centro centro;
            int id = (Integer) (tabla_centros.getValueAt(tabla_centros.getSelectedRow(), 0));
            centro = cr.getById(id);
            FormularioCentro FC = new FormularioCentro(this, true, centro);
            FC.setVisible(true);
            Centro get = FC.centroModificar;
            if (get != null) {
                cr.update(centro);
                cr.rellenarTablaByCliente(tabla_centros, clienteCentros);
                //utilidades.updatebbdd("clientes", get, get.getId());
                //restablecerTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadirActionPerformed
        FormularioCentro FC = new FormularioCentro(this, true);
        FC.setVisible(true);
        Centro get = FC.centroModificar;
        if (get != null) {
            cr.insert(get);
            //utilidades.addBbdd("clientes", get);
            cr.rellenarTabla(tabla_centros);
        }
    }//GEN-LAST:event_btn_añadirActionPerformed

    private void txt_buscadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscadorFocusGained
        if (txt_buscador.getText().contains("Buscar...")) {
            txt_buscador.setText("");
        }
    }//GEN-LAST:event_txt_buscadorFocusGained

    private void txt_buscadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscadorFocusLost
        if (txt_buscador.getText().length() == 0) {
            txt_buscador.setText("Buscar...");
        }
    }//GEN-LAST:event_txt_buscadorFocusLost

    private void txt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscadorKeyReleased
        if (!txt_buscador.getText().isEmpty()) {//SI EL BUSCADOR NO ESTA VACIO, VACIA LA TABLA Y EMPIEZA A BUSCAR CON LOS CARACTERES QUE LE VAMOS INTRODUCIENDO
            DefaultTableModel dm = (DefaultTableModel) tabla_centros.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged();
            cr.buscar(tabla_centros, txt_buscador.getText());

        } else {//SI POR EL CONTRARIO ESTA VACIO EL BUSCADOR, ENTONCES RELLENA LA TABLA CON TODO
            cr.rellenarTablaByCliente(tabla_centros, clienteCentros);
        }
    }//GEN-LAST:event_txt_buscadorKeyReleased

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void tabla_centrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_centrosMouseClicked
        if (isAlreadyOneClick) {
            Centro centro;
            int id = (Integer) (tabla_centros.getValueAt(tabla_centros.getSelectedRow(), 0));
            FichaCentros ficha = new FichaCentros(this, rootPaneCheckingEnabled, cr.getById(id));
            ficha.setVisible(true);
            isAlreadyOneClick = false;
        } else {
            isAlreadyOneClick = true;
            Timer t = new Timer("doubleclickTimer", false);
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    isAlreadyOneClick = false;
                }
            }, 250);
        }
    }//GEN-LAST:event_tabla_centrosMouseClicked

    private void btn_trabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajadoresActionPerformed
        int id = (int) tabla_centros.getValueAt(tabla_centros.getSelectedRow(), 0);
        Centro centro;
        centro = cr.getById(id);
        VistaTrabajadores listadoTrabajadores = new VistaTrabajadores(centro);
        listadoTrabajadores.setVisible(true);
    }//GEN-LAST:event_btn_trabajadoresActionPerformed

    private void btn_trabajadores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_trabajadores1ActionPerformed
        int id = (int) tabla_centros.getValueAt(tabla_centros.getSelectedRow(), 0);
        Centro centro;
        centro = cr.getById(id);
        VistaAsignarTrabajadores asignarTrabajadores = new VistaAsignarTrabajadores(centro);
        asignarTrabajadores.setVisible(true);
    }//GEN-LAST:event_btn_trabajadores1ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaCentros().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buscador;
    private org.edisoncor.gui.panel.Panel Panel_botones;
    private javax.swing.JButton btn_añadir;
    private javax.swing.JButton btn_borrar;
    private org.edisoncor.gui.button.ButtonIcon btn_buscar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_trabajadores;
    private javax.swing.JButton btn_trabajadores1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTable tabla_centros;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JTextField txt_buscador;
    // End of variables declaration//GEN-END:variables
}
