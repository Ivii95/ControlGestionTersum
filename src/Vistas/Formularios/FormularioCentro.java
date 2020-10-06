/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Formularios;

import Modelo.Entidades.Centro;
import Modelo.Entidades.Cliente;
import Modelo.Repository.CentroRepository;
import Modelo.Repository.ClienteRepository;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author DisenoWeb
 */
public class FormularioCentro extends javax.swing.JDialog {

    public Centro centroModificar;
    ClienteRepository repoClientes;
    CentroRepository repoCentros;
    /**
     * Creates new form FormularioCentro
     *
     * @param parent
     * @param modal
     * @param centro
     */
    public FormularioCentro(java.awt.Frame parent, boolean modal, Centro centro) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        iniciarOtrosComponentes();
        this.centroModificar = centro;
        iniciarComponenteModificar();
    }
    /**
     *
     * @param parent
     * @param modal
     */
    public FormularioCentro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.setLocationRelativeTo(parent);
        iniciarOtrosComponentes();
        this.centroModificar = new Centro();
    }

    private void iniciarOtrosComponentes() {
        initComponents();

        repoCentros = new CentroRepository();
        repoCentros.rellenarListaDefault();
        repoClientes = new ClienteRepository();
        repoClientes.rellenarCombo(comboCliente);
    }

    private void iniciarComponenteModificar() {
        txt_codigo.setText(centroModificar.getCodigo() + "");
        String nombreCliente = repoClientes.getByCodigo(centroModificar.getCodigo_cliente()).getNombre_comercial();
        comboCliente.setSelectedItem(nombreCliente);
        txt_nombre.setText(centroModificar.getNombre());
        txt_direccion.setText(centroModificar.getDireccion());
        txt_poblacion.setText(centroModificar.getPoblacion() + "");
        txt_tlf.setText(centroModificar.getTelefono() + "");
        txt_contacto.setText(centroModificar.getContacto());
        txt_email.setText(centroModificar.getEmail() + "");
        txt_horas.setText(centroModificar.getHoras_semana() + "");
        txt_faturacion.setText(centroModificar.getFacturacion_mes() + "");
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

        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        jPanel2 = new javax.swing.JPanel();
        lbl_Cliente = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_direccion = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_contacto = new javax.swing.JTextField();
        lbl_contacto = new javax.swing.JLabel();
        txt_tlf = new javax.swing.JTextField();
        lbl_tlf = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo = new javax.swing.JTextField();
        lbl_responsable2 = new javax.swing.JLabel();
        lbl_nombrel = new javax.swing.JLabel();
        txt_poblacion = new javax.swing.JTextField();
        lbl_horas = new javax.swing.JLabel();
        txt_horas = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        lbl_email = new javax.swing.JLabel();
        lbl_poblacion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Aceptar = new org.edisoncor.gui.button.ButtonRect();
        Cancelar = new org.edisoncor.gui.button.ButtonRect();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbl_facturacion = new javax.swing.JLabel();
        txt_faturacion = new javax.swing.JTextField();
        comboCliente = new javax.swing.JComboBox<>();

        setTitle("INSERTAR O MODIFICAR CENTROS");
        setMaximumSize(new java.awt.Dimension(903, 682));
        setMinimumSize(new java.awt.Dimension(903, 682));
        setPreferredSize(new java.awt.Dimension(903, 682));
        setSize(new java.awt.Dimension(903, 682));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));
        panelRect1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setOpaque(true);
        panelCurves1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_Cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Cliente.setForeground(new java.awt.Color(204, 204, 204));
        lbl_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Cliente.setText("Cliente");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_Cliente, gridBagConstraints);

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_direccion, gridBagConstraints);

        lbl_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_direccion.setForeground(new java.awt.Color(204, 204, 204));
        lbl_direccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_direccion.setText("Dirección");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_direccion, gridBagConstraints);

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_nombre, gridBagConstraints);

        txt_contacto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_contacto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_contacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_contacto, gridBagConstraints);

        lbl_contacto.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_contacto.setForeground(new java.awt.Color(204, 204, 204));
        lbl_contacto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_contacto.setText("Persona de contacto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
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

        txt_codigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigoKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_codigo, gridBagConstraints);

        lbl_responsable2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_responsable2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_responsable2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_responsable2.setText("Datos del centro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        jPanel2.add(lbl_responsable2, gridBagConstraints);

        lbl_nombrel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombrel.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombrel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombrel.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombrel, gridBagConstraints);

        txt_poblacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poblacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_poblacion, gridBagConstraints);

        lbl_horas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_horas.setForeground(new java.awt.Color(204, 204, 204));
        lbl_horas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_horas.setText("Horas a la semana");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_horas, gridBagConstraints);

        txt_horas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_horas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_horas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_horasKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_horas, gridBagConstraints);

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_email, gridBagConstraints);

        lbl_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(204, 204, 204));
        lbl_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_email.setText("E-mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_email, gridBagConstraints);

        lbl_poblacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_poblacion.setForeground(new java.awt.Color(204, 204, 204));
        lbl_poblacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_poblacion.setText("Población");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_poblacion, gridBagConstraints);

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

        lbl_facturacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_facturacion.setForeground(new java.awt.Color(204, 204, 204));
        lbl_facturacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_facturacion.setText("Facturación/Mes");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_facturacion, gridBagConstraints);

        txt_faturacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_faturacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_faturacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_faturacionKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_faturacion, gridBagConstraints);

        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(comboCliente, gridBagConstraints);

        panelCurves1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 540, 520));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 952, 654));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 940, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_contactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactoKeyTyped
        comprobarLetra(evt);
    }//GEN-LAST:event_txt_contactoKeyTyped

    private void txt_tlfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tlfKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_tlfKeyTyped

    private void txt_codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyReleased
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigoKeyReleased

    private void txt_codigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigoKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_codigoKeyTyped

    private void txt_horasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_horasKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_horasKeyTyped

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        boolean correcto = true;
        try {
            if (!comboCliente.getSelectedItem().equals("Seleccione uno")) {//Cliente
                String codigo = repoClientes.getByNombre((String) comboCliente.getSelectedItem()).getCodigo();
                System.out.println("Codigo:" + codigo);
                centroModificar.setCodigo_cliente(codigo);
                if (!txt_codigo.getText().equals("") && txt_codigo.getText() != null) {//Codigo
                    //if (!repoCentros.ifCodigoExist(txt_codigo.getText())) {//Codigo repetido
                    centroModificar.setCodigo(txt_codigo.getText());
                    if (txt_poblacion.getText() != null && !txt_poblacion.getText().equals("")) {//Poblacion
                        centroModificar.setPoblacion(txt_poblacion.getText());
                        if (txt_nombre.getText() != null && !txt_nombre.getText().equals("")) {//Nombre
                            centroModificar.setNombre(txt_nombre.getText());
                            if (txt_direccion.getText() != null && !txt_direccion.getText().equals("")) {//Direccion
                                centroModificar.setDireccion(txt_direccion.getText());
                                if (txt_contacto.getText() != null && !txt_contacto.getText().equals("")) {//Contacto
                                    centroModificar.setContacto(txt_contacto.getText());
                                    if (UtilidadesPantalla.comprobarTelefono(txt_tlf.getText()) && txt_tlf.getText() != null && !txt_tlf.getText().equals("")) {//Telefono
                                        centroModificar.setTelefono(Integer.parseInt(txt_tlf.getText()));
                                        if (txt_horas.getText() != null && !txt_horas.getText().equals("")) {//Horas
                                            centroModificar.setHoras_semana(Integer.parseInt(txt_horas.getText()));
                                            if (UtilidadesPantalla.comprobarEmail(txt_email.getText())) {//Email
                                                centroModificar.setEmail(txt_email.getText());

                                            } else {
                                                JOptionPane.showMessageDialog(this, "Necesita ingresar un e-mail valido", "E-mail", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Necesita ingresar un numero de horas", "Horas", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Necesita ingresar un numero de telefono valido", "Telefono", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Necesita ingresar un nombre de contacto", "Contacto", JOptionPane.INFORMATION_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Necesita ingresar una dirección", "Dirección", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Necesita ingresar un nombre", "Nombre", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Necesita ingresar una población", "Población", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //} else {
                    //  JOptionPane.showMessageDialog(this, "El codigo ya existe en la base de datos", "Codigo", JOptionPane.WARNING_MESSAGE);
                    //}
                } else {
                    JOptionPane.showMessageDialog(this, "Necesita ingresar un codigo", "Codigo", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Necesita ingresar un cliente", "Cliente", JOptionPane.INFORMATION_MESSAGE);
            }
            if (correcto) {
                this.setVisible(false);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "No se pueden meter números en algunos campos", "Errores con los números", JOptionPane.WARNING_MESSAGE);
            System.out.println(e.getMessage());
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, "Excepcion al meter los datos del formulario", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        centroModificar = null;
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void txt_faturacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_faturacionKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_faturacionKeyTyped

    private void comboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteActionPerformed

    }//GEN-LAST:event_comboClienteActionPerformed
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
            java.util.logging.Logger.getLogger(FormularioCentro.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FormularioCentro dialog = new FormularioCentro(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_Cliente;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_contacto;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_facturacion;
    private javax.swing.JLabel lbl_horas;
    private javax.swing.JLabel lbl_nombrel;
    private javax.swing.JLabel lbl_poblacion;
    private javax.swing.JLabel lbl_responsable2;
    private javax.swing.JLabel lbl_tlf;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTextField txt_codigo;
    private javax.swing.JTextField txt_contacto;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_faturacion;
    private javax.swing.JTextField txt_horas;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_poblacion;
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
            if (repoCentros.ifCodigoExist((String) txt_codigo.getText()) && lbl_codigo.getForeground().equals(new java.awt.Color(204, 204, 204))) {
                JOptionPane.showMessageDialog(this, "Codigo usado", "Codigo", JOptionPane.WARNING_MESSAGE);
                lbl_codigo.setForeground(Color.red);
            } else if (!repoCentros.ifCodigoExist(txt_codigo.getText()) && lbl_codigo.getForeground().equals(Color.red)) {
                lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
            }
        } catch (NumberFormatException e) {

        }
    }
}
