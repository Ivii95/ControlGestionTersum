/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Centro;
import Modelo.Cliente;
import Modelo.Historial;
import Modelo.Trabajador;
import Utilidades.DTable;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dwigh
 */
public class PlanificadorHorario2_vista extends javax.swing.JFrame {

    Utilidades utilidades = new Utilidades();
    Trabajador trabajadorHorario;

    public PlanificadorHorario2_vista(Trabajador trabajador) {
        trabajadorHorario = trabajador;
        initComponents();
        iniciarOtrosComponentes();
        lbl_titulo.setText(lbl_titulo.getText() + " " + trabajadorHorario.getNombre() + " " + trabajadorHorario.getApellido1() + " " + trabajadorHorario.getApellido2());
    }

    public PlanificadorHorario2_vista() {
    }

    private void iniciarOtrosComponentes() {
        UtilidadesPantalla.resolucionPantalla(this);
        iniciarTabla();

        try {
            utilidades.rellenarLista("horastrabajadas", "");
            //utilidades.rellenarTablaHorarios(TablaPlanificador, trabajadorHorario.getId());
        } catch (Exception e) {

        }
        rellenarCombobox();
        ponAyuda();
        TablaPlanificador.setDefaultRenderer(Object.class, new DTable());
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "horarios", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iniciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TablaPlanificador.getModel();
        modelo.addRow(new Object[]{"", "", "", "", "", "", "", ""});
        for (int i = 0; i < 25; i++) {
            if (i <= 9) {
                modelo.addRow(new Object[]{"0" + i + ":00", "", "", "", "", "", "", ""});
            } else {
                modelo.addRow(new Object[]{i + ":00", "", "", "", "", "", "", ""});
            }

        }
        for (int i = 0; i < 25; i++) {
            if (i <= 6) {
                TablaPlanificador.setRowHeight(i, 15);
            } else {
                TablaPlanificador.setRowHeight(i, 30);
            }
        }
        TablaPlanificador.setModel(modelo);

    }

    /**
     * Creates new form PlanificadorHorario2_vista
     */
    //  public static ArrayList<Centro> lista_de_centros = new ArrayList<Centro>();
    private void anadirTabla() {
        int IndiceHoraInicio = comboHoraInicio.getSelectedIndex();
        int IndiceHoraFinal = comboHoraFin.getSelectedIndex();
        int diaIndex = comboDia.getSelectedIndex() + 1;
        for (int i = IndiceHoraInicio; i <= IndiceHoraFinal; i++) {
            TablaPlanificador.setValueAt(comboCentro.getSelectedItem(), i, diaIndex);
        }
    }

    private void anadirTablaBBDD() {
        /*String CadenaHoraInicio = (String) comboHoraInicio.getSelectedItem();
        String CadenaHoraFin = (String) comboHoraFin.getSelectedItem();

        int horaInicio = comboHoraInicio.getSelectedIndex(), horaFinal = comboHoraFin.getSelectedIndex(), diaindex = comboDia.getSelectedIndex();
        String Cliente = (String) comboCliente.getSelectedItem();
        String Centro = (String) comboCentro.getSelectedItem();
        Cliente cliente = utilidades.getClienteByNombre(Cliente);
        Centro centro = utilidades.getCentroByNombre(Cliente);
        Historial horas = new Historial(
                trabajadorHorario.getId(),
                (String) comboDia.getSelectedItem(),
                CadenaHoraInicio,
                CadenaHoraFin,
                cliente.getCif(),
                centro.getCodigo(),
                horaInicio + 1,
                diaindex + 1,
                horaFinal - horaInicio
        );
        try {
            utilidades.addBbdd("horastrabajadas", horas);
        } catch (SQLException ex) {
            Logger.getLogger(PlanificadorHorario2_vista.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public void rellenarCombobox() {
        comboDia.addItem("Lunes");
        comboDia.addItem("Martes");
        comboDia.addItem("Miercoles");
        comboDia.addItem("Jueves");
        comboDia.addItem("Viernes");
        comboDia.addItem("Sabado");
        comboDia.addItem("Domingo");
        //Acceso a las listas.
//        utilidades.lista_de_centros.clear();
//        utilidades.lista_de_clientes.clear();
//        utilidades.rellenarLista("centros", "");
//        utilidades.rellenarLista("clientes", "");
//        for (Centro i : utilidades.lista_de_centros) {
//            comboCentro.addItem(i.getNombre());
//        }
//        for (Cliente i : utilidades.lista_de_clientes) {
//            comboCliente.addItem(i.getNombre_comercial());
//        }
    }

    /*private void restablecerTodo() {
        comboCentro.setSelectedIndex(0);
        comboCliente.setSelectedIndex(0);
        comboColor.setSelectedIndex(0);
        comboDia.setSelectedIndex(0);
        comboHoraFin.setSelectedIndex(0);
        comboHoraInicio.setSelectedIndex(0);
    }*/

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPlanificador = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        comboHoraInicio = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones1 = new javax.swing.JLabel();
        lbl_fechafin_vacaciones2 = new javax.swing.JLabel();
        comboHoraFin = new javax.swing.JComboBox<>();
        lbl_Dia = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        comboCliente = new javax.swing.JComboBox<>();
        lbl_Cliente = new javax.swing.JLabel();
        comboCentro = new javax.swing.JComboBox<>();
        lbl_Centro = new javax.swing.JLabel();
        BTN_AÑADIR = new javax.swing.JToggleButton();
        btn_borrarr = new javax.swing.JButton();
        txt_direccion = new javax.swing.JLabel();
        lbl_titulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Horarios"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));

        TablaPlanificador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Horas", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaPlanificador.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaPlanificador.setEnabled(false);
        TablaPlanificador.setFocusable(false);
        TablaPlanificador.setName("tablaHorarios"); // NOI18N
        TablaPlanificador.setOpaque(false);
        jScrollPane1.setViewportView(TablaPlanificador);
        if (TablaPlanificador.getColumnModel().getColumnCount() > 0) {
            TablaPlanificador.getColumnModel().getColumn(0).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(1).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(2).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(3).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(4).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(5).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(6).setResizable(false);
            TablaPlanificador.getColumnModel().getColumn(7).setResizable(false);
        }

        comboHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        lbl_fechafin_vacaciones1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones1.setText("Hora de fin");

        lbl_fechafin_vacaciones2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones2.setText("Hora de inicio");

        comboHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        lbl_Dia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Dia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Dia.setText("Dia");

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));

        lbl_Cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Cliente.setText("Cliente");

        comboCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboCentro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCentroItemStateChanged(evt);
            }
        });

        lbl_Centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Centro.setText("Centro");

        BTN_AÑADIR.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BTN_AÑADIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        BTN_AÑADIR.setText("Añadir");
        BTN_AÑADIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AÑADIRActionPerformed(evt);
            }
        });

        btn_borrarr.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrarr.setText("Borrar Dia");
        btn_borrarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarrActionPerformed(evt);
            }
        });

        txt_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_direccion.setText("Direccion");

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("TRABAJADOR :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(lbl_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_fechafin_vacaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboCliente, 0, 200, Short.MAX_VALUE)
                                            .addComponent(lbl_Cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_Centro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_fechafin_vacaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(118, 118, 118)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(BTN_AÑADIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btn_borrarr, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(lbl_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbl_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbl_fechafin_vacaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(BTN_AÑADIR, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_borrarr, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_fechafin_vacaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbl_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbl_Centro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))))
                        .addGap(49, 49, 49))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_AÑADIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AÑADIRActionPerformed
        // JOptionPane.showMessageDialog(null, "Operación realizada correctamente");
        if (comboHoraInicio.getSelectedIndex() >= comboHoraFin.getSelectedIndex()) {
            JOptionPane.showMessageDialog(null, "La hora de inicio debe ser inferior a la fecha fin.");
        } else {
            //if (TablaPlanificador.getValueAt(comboHoraInicio.getSelectedIndex(), comboDia.getSelectedIndex()) != (null)) {
            //    JOptionPane.showMessageDialog(this, "No puedes añadir una hora que ya esta añadida", "ERROR", HEIGHT);
            //} else {
            anadirTablaBBDD();
            anadirTabla();
            //}
        }

    }//GEN-LAST:event_BTN_AÑADIRActionPerformed

    private void btn_borrarrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarrActionPerformed
        utilidades.borrarColumnaHorario(TablaPlanificador, trabajadorHorario.getId(), (String) comboDia.getSelectedItem());
    }//GEN-LAST:event_btn_borrarrActionPerformed

    private void comboCentroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCentroItemStateChanged
        // TODO add your handling code here:
        String Centro = (String) comboCentro.getSelectedItem();
        Centro ObjCentro = new Centro();
        String ct = (String) Centro.subSequence(0, Centro.indexOf(" "));
        //ObjCentro = utilidades.getCentroByNombre(Centro);
        txt_direccion.setText("Dirección:" + ObjCentro.getDireccion());
    }//GEN-LAST:event_comboCentroItemStateChanged

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
            java.util.logging.Logger.getLogger(PlanificadorHorario2_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlanificadorHorario2_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlanificadorHorario2_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlanificadorHorario2_vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlanificadorHorario2_vista().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BTN_AÑADIR;
    private javax.swing.JTable TablaPlanificador;
    private javax.swing.JButton btn_borrarr;
    private javax.swing.JComboBox<String> comboCentro;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboHoraFin;
    private javax.swing.JComboBox<String> comboHoraInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Centro;
    private javax.swing.JLabel lbl_Cliente;
    private javax.swing.JLabel lbl_Dia;
    private javax.swing.JLabel lbl_fechafin_vacaciones1;
    private javax.swing.JLabel lbl_fechafin_vacaciones2;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JLabel txt_direccion;
    // End of variables declaration//GEN-END:variables

}
