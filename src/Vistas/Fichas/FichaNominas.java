/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Fichas;

import Modelo.Entidades.Nominas;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class FichaNominas extends javax.swing.JDialog {

    Nominas nomina;

    /**
     * Creates new form FichaNominas
     *
     * @param parent
     * @param modal
     * @param nomina
     */
    public FichaNominas(java.awt.Frame parent, boolean modal, Nominas nomina) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        rellenarDatos();
    }

    private FichaNominas(JFrame parent, boolean b) {
        super(parent, b);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void rellenarDatos() {
        txt_codigo_trabajador.setText(nomina.getCodigo_trabajador() + "");
        txt_fecha_inicio.setText(nomina.getFecha_inicio() + "");
        txt_fecha_fin.setText(nomina.getFecha_fin() + "");
        txt_importe.setText(nomina.getImporte() + "");
        if (nomina.isActivo()) {
            txt_activo.setText("Activo");
        } else {
            txt_activo.setText("No Activo");
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        lbl_fecha_fin = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_principal = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_activo = new javax.swing.JLabel();
        lbl_importe = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Aceptar = new org.edisoncor.gui.button.ButtonRect();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbl_denominacion_contrato = new javax.swing.JLabel();
        txt_fecha_inicio = new javax.swing.JLabel();
        txt_fecha_fin = new javax.swing.JLabel();
        txt_importe = new javax.swing.JLabel();
        txt_codigo_trabajador = new javax.swing.JLabel();
        txt_activo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(762, 381));
        setMinimumSize(new java.awt.Dimension(762, 381));
        setPreferredSize(new java.awt.Dimension(762, 381));
        setSize(new java.awt.Dimension(762, 381));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(762, 381));
        jPanel2.setMinimumSize(new java.awt.Dimension(762, 381));
        jPanel2.setPreferredSize(new java.awt.Dimension(762, 381));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_fecha_fin.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fecha_fin.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fecha_fin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha_fin.setText("Fecha Fin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fecha_fin, gridBagConstraints);

        lbl_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Codigo Trabajador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        jPanel2.add(lbl_codigo, gridBagConstraints);

        lbl_principal.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_principal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_principal.setText("Datos de la nomina");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel2.add(lbl_principal, gridBagConstraints);

        lbl_nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre.setText("Fecha Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombre, gridBagConstraints);

        lbl_activo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_activo.setForeground(new java.awt.Color(204, 204, 204));
        lbl_activo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_activo.setText("Activo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_activo, gridBagConstraints);

        lbl_importe.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_importe.setForeground(new java.awt.Color(204, 204, 204));
        lbl_importe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_importe.setText("Importe");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_importe, gridBagConstraints);

        jSeparator1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 25;
        jPanel2.add(jSeparator1, gridBagConstraints);

        Aceptar.setBackground(new java.awt.Color(204, 204, 204));
        Aceptar.setForeground(new java.awt.Color(51, 51, 51));
        Aceptar.setText("Aceptar");
        Aceptar.setColorDeSombra(new java.awt.Color(204, 204, 204));
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Aceptar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 25;
        jPanel2.add(jSeparator2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel5, gridBagConstraints);

        lbl_denominacion_contrato.setBackground(new java.awt.Color(102, 102, 102));
        lbl_denominacion_contrato.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_denominacion_contrato.setForeground(new java.awt.Color(204, 204, 204));
        lbl_denominacion_contrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_denominacion_contrato.setText("TIPO DE CONTRATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(lbl_denominacion_contrato, gridBagConstraints);

        txt_fecha_inicio.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_fecha_inicio.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha_inicio.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_fecha_inicio, gridBagConstraints);

        txt_fecha_fin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_fecha_fin.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha_fin.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_fecha_fin, gridBagConstraints);

        txt_importe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_importe.setForeground(new java.awt.Color(255, 255, 255));
        txt_importe.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_importe, gridBagConstraints);

        txt_codigo_trabajador.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_codigo_trabajador.setForeground(new java.awt.Color(255, 255, 255));
        txt_codigo_trabajador.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_codigo_trabajador, gridBagConstraints);

        txt_activo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_activo.setForeground(new java.awt.Color(255, 255, 255));
        txt_activo.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_activo, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

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
            java.util.logging.Logger.getLogger(FichaNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaNominas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            FichaNominas dialog = new FichaNominas(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect Aceptar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_activo;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_denominacion_contrato;
    private javax.swing.JLabel lbl_fecha_fin;
    private javax.swing.JLabel lbl_importe;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_principal;
    private javax.swing.JLabel txt_activo;
    private javax.swing.JLabel txt_codigo_trabajador;
    private javax.swing.JLabel txt_fecha_fin;
    private javax.swing.JLabel txt_fecha_inicio;
    private javax.swing.JLabel txt_importe;
    // End of variables declaration//GEN-END:variables

}
