/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Formularios;

import Modelo.Entidades.Cliente;
import Modelo.Repository.ClienteRepository;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author DisenoWeb
 */
public class FormularioCliente extends javax.swing.JDialog {

    Utilidades utilidades = new Utilidades();
    public Cliente clienteModificar;
    ClienteRepository repoCliente;
    /**
     * Creates new form FormularioCliente
     *
     * @param parent
     * @param modal
     */
    public FormularioCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        repoCliente = new ClienteRepository();
        this.setLocationRelativeTo(parent);
        clienteModificar = new Cliente();
    }
    
    /**
     * Creates new form FormularioCliente
     *
     * @param parent
     * @param modal
     * @param cliente
     * @param repoCliente
     */
    public FormularioCliente(java.awt.Frame parent, boolean modal, Cliente cliente, ClienteRepository repoCliente) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.repoCliente = repoCliente;
        this.clienteModificar = cliente;
        iniciarComponenteModificar();
    }

    private void iniciarComponenteModificar() {
        txt_codigo_cliente.setText(clienteModificar.getCodigo() + "");
        txt_cif.setText(clienteModificar.getCif() + "");
        txt_nombre_fiscal.setText(clienteModificar.getNombre_fiscal());
        txt_nombre_comercial.setText(clienteModificar.getNombre_comercial());
        txt_contacto.setText(clienteModificar.getContacto());
        txt_tlf.setText(clienteModificar.getTelefono() + "");
        txt_fax.setText(clienteModificar.getFax() + "");
        txt_movil.setText(clienteModificar.getMovil() + "");
        txt_email.setText(clienteModificar.getEmail() + "");
        if (clienteModificar.getFecha_alta() != null) {
            fecha_alta.setDate(java.sql.Date.valueOf(clienteModificar.getFecha_alta()));
        }
        if (clienteModificar.getFecha_baja()!= null) {
            fecha_baja.setDate(java.sql.Date.valueOf(clienteModificar.getFecha_baja()));
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
        lbl_movil = new javax.swing.JLabel();
        txt_nombre_comercial = new javax.swing.JTextField();
        lbl_nombre_comercial = new javax.swing.JLabel();
        txt_nombre_fiscal = new javax.swing.JTextField();
        txt_contacto = new javax.swing.JTextField();
        lbl_contacto = new javax.swing.JLabel();
        txt_tlf = new javax.swing.JTextField();
        lbl_tlf = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo_cliente = new javax.swing.JTextField();
        txt_movil = new javax.swing.JTextField();
        lbl_responsable2 = new javax.swing.JLabel();
        lbl_nombre_fiscal = new javax.swing.JLabel();
        label_codigo1 = new javax.swing.JLabel();
        txt_cif = new javax.swing.JTextField();
        lbl_fax = new javax.swing.JLabel();
        txt_fax = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        fecha_alta = new org.jdesktop.swingx.JXDatePicker();
        fecha_baja = new org.jdesktop.swingx.JXDatePicker();
        label_codigo2 = new javax.swing.JLabel();
        lbl_cif = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Aceptar = new org.edisoncor.gui.button.ButtonRect();
        Cancelar = new org.edisoncor.gui.button.ButtonRect();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("INSERTAR O MODIFICAR CLIENTE");
        setIconImage(new ImageIcon(getClass().getResource("/img/clientes.png")).getImage());
        setMinimumSize(new java.awt.Dimension(903, 682));
        setSize(new java.awt.Dimension(903, 682));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_movil.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_movil.setForeground(new java.awt.Color(204, 204, 204));
        lbl_movil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_movil.setText("Móvil");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_movil, gridBagConstraints);

        txt_nombre_comercial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre_comercial.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_nombre_comercial, gridBagConstraints);

        lbl_nombre_comercial.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombre_comercial.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre_comercial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre_comercial.setText("Nombre Comercial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombre_comercial, gridBagConstraints);

        txt_nombre_fiscal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre_fiscal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_nombre_fiscal, gridBagConstraints);

        txt_contacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_contacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_contacto, gridBagConstraints);

        lbl_contacto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_contacto.setForeground(new java.awt.Color(204, 204, 204));
        lbl_contacto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_contacto.setText("Persona de contacto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_contacto, gridBagConstraints);

        txt_tlf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_tlf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tlf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_tlfKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_tlf, gridBagConstraints);

        lbl_tlf.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_tlf.setForeground(new java.awt.Color(204, 204, 204));
        lbl_tlf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tlf.setText("Teléfono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        jPanel2.add(lbl_tlf, gridBagConstraints);

        lbl_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        jPanel2.add(lbl_codigo, gridBagConstraints);

        txt_codigo_cliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codigo_cliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_clienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigo_clienteKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_codigo_cliente, gridBagConstraints);

        txt_movil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_movil.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_movil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_movilKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_movil, gridBagConstraints);

        lbl_responsable2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_responsable2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_responsable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_responsable2.setText("Datos del cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel2.add(lbl_responsable2, gridBagConstraints);

        lbl_nombre_fiscal.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombre_fiscal.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre_fiscal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre_fiscal.setText("Nombre Fiscal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombre_fiscal, gridBagConstraints);

        label_codigo1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_codigo1.setForeground(new java.awt.Color(204, 204, 204));
        label_codigo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo1.setText("Fecha de alta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(label_codigo1, gridBagConstraints);

        txt_cif.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_cif.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_cif, gridBagConstraints);

        lbl_fax.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fax.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fax.setText("Fax");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fax, gridBagConstraints);

        txt_fax.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_fax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_fax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_faxKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_fax, gridBagConstraints);

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_email, gridBagConstraints);

        lbl_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(204, 204, 204));
        lbl_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_email.setText("E-mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_email, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(fecha_alta, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(fecha_baja, gridBagConstraints);

        label_codigo2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        label_codigo2.setForeground(new java.awt.Color(204, 204, 204));
        label_codigo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_codigo2.setText("Fecha de baja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(label_codigo2, gridBagConstraints);

        lbl_cif.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_cif.setForeground(new java.awt.Color(204, 204, 204));
        lbl_cif.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_cif.setText("CIF");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_cif, gridBagConstraints);

        jSeparator1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 25;
        jPanel2.add(jSeparator1, gridBagConstraints);

        Aceptar.setText("Aceptar");
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Aceptar, gridBagConstraints);

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Cancelar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 25;
        jPanel2.add(jSeparator2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 15;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        jPanel2.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel2, gridBagConstraints);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 540, 520));

        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setForeground(new java.awt.Color(0, 0, 0));
        panelCurves1.setOpaque(true);
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 952, 654));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 940, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_codigo_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_clienteKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_codigo_clienteKeyTyped

    private void txt_movilKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_movilKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_movilKeyTyped

    private void txt_tlfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tlfKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_tlfKeyTyped

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        clienteModificar = null;
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void txt_contactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactoKeyTyped
        comprobarLetra(evt);
    }//GEN-LAST:event_txt_contactoKeyTyped

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        boolean correcto = true;
        try {
            if (!txt_codigo_cliente.getText().isEmpty()) {
                clienteModificar.setCodigo(txt_codigo_cliente.getText());
            } else {
                JOptionPane.showMessageDialog(this, "Necesitas meter un codigo");
                correcto = false;
            }
            clienteModificar.setCif(txt_cif.getText());
            clienteModificar.setNombre_fiscal(txt_nombre_fiscal.getText());
            clienteModificar.setNombre_comercial(txt_nombre_comercial.getText());
            clienteModificar.setContacto(txt_contacto.getText());
            if (!txt_tlf.getText().isBlank()) {
                clienteModificar.setTelefono(Integer.parseInt(txt_tlf.getText()));
            }
            if (!txt_fax.getText().isBlank()) {
                clienteModificar.setFax(Integer.parseInt(txt_fax.getText()));
            }else{
                clienteModificar.setFax(0);
            }
            if (!txt_movil.getText().isBlank()) {
                clienteModificar.setMovil(Integer.parseInt(txt_movil.getText()));
            }else{
                clienteModificar.setMovil(0);
            }
            clienteModificar.setEmail(txt_email.getText());
            if(fecha_alta.getDate() != null){
                clienteModificar.setFecha_alta((UtilidadesPantalla.convertToLocalDateViaInstant(fecha_alta.getDate())));
            }
            if (fecha_baja.getDate() != null) {//Fecha de baja vacia
                clienteModificar.setFecha_baja(UtilidadesPantalla.convertToLocalDateViaInstant(fecha_baja.getDate()));
            } 
            //} else {
            //  JOptionPane.showMessageDialog(this, "El codigo ya existe en la base de datos", "Codigo", JOptionPane.WARNING_MESSAGE);
            //}
            if (correcto) {
                this.setVisible(false);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "No se pueden meter números en algunos campos", "Errores con los números", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Problemas al meter los datos del formulario", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void txt_faxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_faxKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_faxKeyTyped

    private void txt_codigo_clienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_clienteKeyReleased
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigo_clienteKeyReleased

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
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            FormularioCliente dialog = new FormularioCliente(new javax.swing.JFrame(), true);
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
    private org.edisoncor.gui.button.ButtonRect Cancelar;
    private org.jdesktop.swingx.JXDatePicker fecha_alta;
    private org.jdesktop.swingx.JXDatePicker fecha_baja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel label_codigo1;
    private javax.swing.JLabel label_codigo2;
    private javax.swing.JLabel lbl_cif;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_contacto;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_fax;
    private javax.swing.JLabel lbl_movil;
    private javax.swing.JLabel lbl_nombre_comercial;
    private javax.swing.JLabel lbl_nombre_fiscal;
    private javax.swing.JLabel lbl_responsable2;
    private javax.swing.JLabel lbl_tlf;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTextField txt_cif;
    private javax.swing.JTextField txt_codigo_cliente;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fax;
    private javax.swing.JTextField txt_movil;
    private javax.swing.JTextField txt_nombre_comercial;
    private javax.swing.JTextField txt_nombre_fiscal;
    private javax.swing.JTextField txt_tlf;
    // End of variables declaration//GEN-END:variables
private void comprobarNumero(KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar()) == false) {
            //JOptionPane.showMessageDialog(rootPane, "No puedes introducir letras");
            evt.consume();
        }
    }

    private void comprobarLetra(KeyEvent evt) {
        if (Character.isDigit(evt.getKeyChar()) == true) {
            //JOptionPane.showMessageDialog(rootPane, "No puedes introducir números");
            evt.consume();
        }
    }

    private void comprobarCodigo(KeyEvent evt) {
        try {
            if (repoCliente.ifCodigoExist((String) txt_codigo_cliente.getText()) && lbl_codigo.getForeground().equals(new java.awt.Color(204, 204, 204))) {
                JOptionPane.showMessageDialog(this, "Codigo usado", "Codigo", JOptionPane.WARNING_MESSAGE);
                lbl_codigo.setForeground(Color.red);
            } else if (!repoCliente.ifCodigoExist(txt_codigo_cliente.getText()) && lbl_codigo.getForeground().equals(Color.red)) {
                lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
            }
        } catch (NumberFormatException e) {

        }
    }
}
