/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.Centro;
import Modelo.Entidades.Trabajador;
import Utilidades.DTable;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
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
    Centro centroHorario;

    public PlanificadorHorario2_vista(Trabajador trabajador) {
        trabajadorHorario = trabajador;
        initComponents();
        iniciarOtrosComponentes();
        lbl_titulo.setText(lbl_titulo.getText() + " " + trabajadorHorario.getNombre() + " " + trabajadorHorario.getApellido1() + " " + trabajadorHorario.getApellido2());
    }

    public PlanificadorHorario2_vista(Trabajador trabajador, Centro centro) {
        centroHorario = centro;
        trabajadorHorario = trabajador;
        initComponents();
        iniciarOtrosComponentes();
        lbl_titulo.setText(lbl_titulo.getText() + " " + trabajadorHorario.getNombre() + " " + trabajadorHorario.getApellido1() + " " + trabajadorHorario.getApellido2());
    }

    public PlanificadorHorario2_vista() {
        initComponents();
        iniciarOtrosComponentes();
    }

    private void iniciarOtrosComponentes() {
        UtilidadesPantalla.resolucionPantalla(this);
        iniciarTabla();

        try {
            //utilidades.rellenarLista("horastrabajadas", "");
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
    private void iniciarCombo(){
        
    }
    private void iniciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TablaPlanificador.getModel();
        for (int i = 0; i < 25; i++) {
            if (i <= 9) {
                modelo.addRow(new Object[]{"0" + i + ":00", "", "", "", "", "", "", ""});
            } else {
                modelo.addRow(new Object[]{i + ":00", "", "", "", "", "", "", ""});
            }

        }
        for (int i = 0; i < 25; i++) {
            if (i <= 6) {
                TablaPlanificador.setRowHeight(i, 18);
            } else {
                TablaPlanificador.setRowHeight(i, 28);
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
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        lbl_titulo = new javax.swing.JLabel();
        label_fechainicio = new org.edisoncor.gui.panel.PanelRect();
        lbl_Dia = new javax.swing.JLabel();
        comboDia = new javax.swing.JComboBox<>();
        lbl_Cliente = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboHoraInicio = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones2 = new javax.swing.JLabel();
        lbl_Centro = new javax.swing.JLabel();
        comboCentro = new javax.swing.JComboBox<>();
        comboHoraFin = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones1 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JLabel();
        btn_borrarr = new javax.swing.JButton();
        BTN_AÑADIR = new javax.swing.JToggleButton();
        lbl_fechafin_vacaciones3 = new javax.swing.JLabel();
        lbl_fechafin_vacaciones4 = new javax.swing.JLabel();
        comboHoraInicio1 = new javax.swing.JComboBox<>();
        comboHoraFin1 = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones5 = new javax.swing.JLabel();
        lbl_fechafin_vacaciones6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Horarios"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1360, 762));
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1330, 470));

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

        lbl_titulo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lbl_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setText("TRABAJADOR :");
        panelCurves1.add(lbl_titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1320, 24));

        label_fechainicio.setColorDeSegundoBorde(new java.awt.Color(102, 102, 102));
        label_fechainicio.setColorPrimario(new java.awt.Color(153, 153, 153));
        label_fechainicio.setColorSecundario(new java.awt.Color(102, 102, 102));
        label_fechainicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Dia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Dia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Dia.setText("Dia");
        label_fechainicio.add(lbl_Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 200, 35));

        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        label_fechainicio.add(comboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 200, 35));

        lbl_Cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Cliente.setText("Cliente");
        label_fechainicio.add(lbl_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, 34));

        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 200, 35));

        comboHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 100, 35));

        lbl_fechafin_vacaciones2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones2.setText("Minutos");
        label_fechainicio.add(lbl_fechafin_vacaciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, 100, 35));

        lbl_Centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Centro.setText("Centro");
        label_fechainicio.add(lbl_Centro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 35));

        comboCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboCentro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCentroItemStateChanged(evt);
            }
        });
        label_fechainicio.add(comboCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 35));

        comboHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 100, 35));

        lbl_fechafin_vacaciones1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones1.setText("Hora de fin");
        label_fechainicio.add(lbl_fechafin_vacaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 200, 35));

        txt_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_direccion.setText("Direccion");
        label_fechainicio.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 400, 35));

        btn_borrarr.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrarr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrarr.setText("Borrar Dia");
        btn_borrarr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarrActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_borrarr, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 110, 200, 35));

        BTN_AÑADIR.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        BTN_AÑADIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        BTN_AÑADIR.setText("Añadir");
        BTN_AÑADIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AÑADIRActionPerformed(evt);
            }
        });
        label_fechainicio.add(BTN_AÑADIR, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 50, 200, 35));

        lbl_fechafin_vacaciones3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones3.setText("Hora de inicio");
        label_fechainicio.add(lbl_fechafin_vacaciones3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 40, 200, 35));

        lbl_fechafin_vacaciones4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones4.setText("Hora");
        label_fechainicio.add(lbl_fechafin_vacaciones4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 100, 35));

        comboHoraInicio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraInicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 100, 35));

        comboHoraFin1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraFin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 100, 35));

        lbl_fechafin_vacaciones5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones5.setText("Minutos");
        label_fechainicio.add(lbl_fechafin_vacaciones5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 100, 35));

        lbl_fechafin_vacaciones6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones6.setText("Hora");
        label_fechainicio.add(lbl_fechafin_vacaciones6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 100, 35));

        panelCurves1.add(label_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1310, 200));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1370, 760));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 780));

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
    private javax.swing.JComboBox<String> comboHoraFin1;
    private javax.swing.JComboBox<String> comboHoraInicio;
    private javax.swing.JComboBox<String> comboHoraInicio1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelRect label_fechainicio;
    private javax.swing.JLabel lbl_Centro;
    private javax.swing.JLabel lbl_Cliente;
    private javax.swing.JLabel lbl_Dia;
    private javax.swing.JLabel lbl_fechafin_vacaciones1;
    private javax.swing.JLabel lbl_fechafin_vacaciones2;
    private javax.swing.JLabel lbl_fechafin_vacaciones3;
    private javax.swing.JLabel lbl_fechafin_vacaciones4;
    private javax.swing.JLabel lbl_fechafin_vacaciones5;
    private javax.swing.JLabel lbl_fechafin_vacaciones6;
    private javax.swing.JLabel lbl_titulo;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JLabel txt_direccion;
    // End of variables declaration//GEN-END:variables

}
