/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Fichas;

import Modelo.Trabajador;
import Utilidades.Utilidades;
import javax.swing.JFrame;

/**
 *
 * @author DisenoWeb
 */
public class FichaTrabajador extends javax.swing.JDialog {

    private Utilidades utilidades = new Utilidades();
    private Trabajador trabajador;
    private java.awt.Frame princi;

    /**
     * Creates new form FichaTrabajador
     */
    public FichaTrabajador(java.awt.Frame parent, boolean modal, Trabajador trabajador) {
        super(parent, modal);
        this.princi = parent;
        initComponents();
        this.setLocationRelativeTo(null);
        this.trabajador = trabajador;
        String principal = lbl_principal.getText() + ": " + trabajador.getNombre() + " " + trabajador.getApellido1() + " " + trabajador.getApellido2() + " ";
        lbl_principal.setText(principal);
        txt_codigo_trabajador.setText(trabajador.getCodigo() + "");
        txt_codigo_contrato.setText(trabajador.getCodigo_tipo_contrato() + "");
        String denominacion_contrato = utilidades.rellenarTipoContrato(trabajador.getCodigo_tipo_contrato());
        lbl_denominacion_contrato.setText(denominacion_contrato);
        //txt_centro.setText(trabajador.getCentro().getNombre());
        txt_apellido1.setText(trabajador.getApellido1());
        txt_apellido2.setText(trabajador.getApellido2());
        txt_nombre.setText(trabajador.getNombre());
        txt_direccion.setText(trabajador.getDireccion());
        txt_poblacion.setText(trabajador.getPoblacion());
        txt_nacimiento.setText(trabajador.getFechanacimiento() + "");
        txt_categoria.setText(trabajador.getCategoria());
        txt_antiguedad.setText(trabajador.getAntiguedad() + "");
        txt_telefono.setText(trabajador.getTelefono() + "");
        txt_email.setText(trabajador.getEmail());
        txt_fecha_alta.setText(trabajador.getFecha_alta() + "");
        txt_fecha_baja.setText(trabajador.getFecha_baja() + "");
        txt_horas_semana_alta.setText(trabajador.getHoras_semana_alta() + "");
        txt_horas_semana_reales.setText(trabajador.getHoras_semana_reales() + "");
        txt_coste_mes.setText(trabajador.getCoste_mes() + "");

    }

    private FichaTrabajador(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        lbl_fecha_alta = new javax.swing.JLabel();
        lbl_apellido1 = new javax.swing.JLabel();
        lbl_categoria = new javax.swing.JLabel();
        lbl_tlf = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        lbl_principal = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_antiguedad = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_poblacion = new javax.swing.JLabel();
        lbl_nacimiento = new javax.swing.JLabel();
        lbl_apellido2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Aceptar = new org.edisoncor.gui.button.ButtonRect();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_codigo_contrato = new javax.swing.JLabel();
        lbl_centro = new javax.swing.JLabel();
        lbl_denominacion_contrato = new javax.swing.JLabel();
        lbl_fecha_baja = new javax.swing.JLabel();
        lbl_horasreales = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        lbl_costemes = new javax.swing.JLabel();
        lbl_horassemanales = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JLabel();
        txt_apellido1 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JLabel();
        txt_email = new javax.swing.JLabel();
        txt_fecha_alta = new javax.swing.JLabel();
        txt_fecha_baja = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JLabel();
        txt_horas_semana_alta = new javax.swing.JLabel();
        txt_horas_semana_reales = new javax.swing.JLabel();
        txt_apellido2 = new javax.swing.JLabel();
        txt_categoria = new javax.swing.JLabel();
        txt_nacimiento = new javax.swing.JLabel();
        txt_codigo_contrato = new javax.swing.JLabel();
        txt_centro = new javax.swing.JLabel();
        txt_coste_mes = new javax.swing.JLabel();
        txt_codigo_trabajador = new javax.swing.JLabel();
        buttonIcon1 = new org.edisoncor.gui.button.ButtonIcon();
        txt_antiguedad = new javax.swing.JLabel();
        txt_poblacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ficha de un trabajador");
        setMinimumSize(new java.awt.Dimension(900, 550));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(900, 550));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(204, 204, 204));
        jPanel2.setMaximumSize(new java.awt.Dimension(900, 550));
        jPanel2.setMinimumSize(new java.awt.Dimension(900, 550));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 550));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        lbl_fecha_alta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fecha_alta.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fecha_alta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha_alta.setText("Fecha de alta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fecha_alta, gridBagConstraints);

        lbl_apellido1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_apellido1.setForeground(new java.awt.Color(204, 204, 204));
        lbl_apellido1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_apellido1.setText("Primer apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_apellido1, gridBagConstraints);

        lbl_categoria.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_categoria.setForeground(new java.awt.Color(204, 204, 204));
        lbl_categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_categoria.setText("Categoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_categoria, gridBagConstraints);

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

        lbl_principal.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_principal.setForeground(new java.awt.Color(255, 255, 255));
        lbl_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_principal.setText("Datos del trabajador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        jPanel2.add(lbl_principal, gridBagConstraints);

        lbl_nombre.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombre.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombre, gridBagConstraints);

        lbl_antiguedad.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_antiguedad.setForeground(new java.awt.Color(204, 204, 204));
        lbl_antiguedad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_antiguedad.setText("Antigüedad (Años)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_antiguedad, gridBagConstraints);

        lbl_email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(204, 204, 204));
        lbl_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_email.setText("E-mail");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_email, gridBagConstraints);

        lbl_poblacion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_poblacion.setForeground(new java.awt.Color(204, 204, 204));
        lbl_poblacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_poblacion.setText("Poblacion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_poblacion, gridBagConstraints);

        lbl_nacimiento.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nacimiento.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nacimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nacimiento.setText("Fecha de nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nacimiento, gridBagConstraints);

        lbl_apellido2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_apellido2.setForeground(new java.awt.Color(204, 204, 204));
        lbl_apellido2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_apellido2.setText("Segundo Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_apellido2, gridBagConstraints);

        jSeparator1.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 8;
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
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Aceptar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 25;
        jPanel2.add(jSeparator2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 15;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 15;
        jPanel2.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel5, gridBagConstraints);

        lbl_codigo_contrato.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo_contrato.setForeground(new java.awt.Color(204, 204, 204));
        lbl_codigo_contrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo_contrato.setText("Codigo contrato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        jPanel2.add(lbl_codigo_contrato, gridBagConstraints);

        lbl_centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_centro.setForeground(new java.awt.Color(204, 204, 204));
        lbl_centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_centro.setText("Centro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 100;
        jPanel2.add(lbl_centro, gridBagConstraints);

        lbl_denominacion_contrato.setBackground(new java.awt.Color(102, 102, 102));
        lbl_denominacion_contrato.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_denominacion_contrato.setForeground(new java.awt.Color(204, 204, 204));
        lbl_denominacion_contrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_denominacion_contrato.setText("TIPO DE CONTRATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(lbl_denominacion_contrato, gridBagConstraints);

        lbl_fecha_baja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fecha_baja.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fecha_baja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha_baja.setText("Fecha de baja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fecha_baja, gridBagConstraints);

        lbl_horasreales.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_horasreales.setForeground(new java.awt.Color(204, 204, 204));
        lbl_horasreales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_horasreales.setText("Horas reales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_horasreales, gridBagConstraints);

        lbl_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_direccion.setForeground(new java.awt.Color(204, 204, 204));
        lbl_direccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_direccion.setText("Direccion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_direccion, gridBagConstraints);

        lbl_costemes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_costemes.setForeground(new java.awt.Color(204, 204, 204));
        lbl_costemes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_costemes.setText("Coste al mes (€)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_costemes, gridBagConstraints);

        lbl_horassemanales.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_horassemanales.setForeground(new java.awt.Color(204, 204, 204));
        lbl_horassemanales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_horassemanales.setText("Horas semana alta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_horassemanales, gridBagConstraints);

        txt_nombre.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_nombre.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_nombre, gridBagConstraints);

        txt_apellido1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_apellido1.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido1.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_apellido1, gridBagConstraints);

        txt_telefono.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_telefono.setForeground(new java.awt.Color(255, 255, 255));
        txt_telefono.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_telefono, gridBagConstraints);

        txt_email.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        txt_email.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_email, gridBagConstraints);

        txt_fecha_alta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_fecha_alta.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha_alta.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_fecha_alta, gridBagConstraints);

        txt_fecha_baja.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_fecha_baja.setForeground(new java.awt.Color(255, 255, 255));
        txt_fecha_baja.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_fecha_baja, gridBagConstraints);

        txt_direccion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_direccion.setForeground(new java.awt.Color(255, 255, 255));
        txt_direccion.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_direccion, gridBagConstraints);

        txt_horas_semana_alta.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_horas_semana_alta.setForeground(new java.awt.Color(255, 255, 255));
        txt_horas_semana_alta.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_horas_semana_alta, gridBagConstraints);

        txt_horas_semana_reales.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_horas_semana_reales.setForeground(new java.awt.Color(255, 255, 255));
        txt_horas_semana_reales.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_horas_semana_reales, gridBagConstraints);

        txt_apellido2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_apellido2.setForeground(new java.awt.Color(255, 255, 255));
        txt_apellido2.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_apellido2, gridBagConstraints);

        txt_categoria.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_categoria.setForeground(new java.awt.Color(255, 255, 255));
        txt_categoria.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_categoria, gridBagConstraints);

        txt_nacimiento.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_nacimiento.setForeground(new java.awt.Color(255, 255, 255));
        txt_nacimiento.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_nacimiento, gridBagConstraints);

        txt_codigo_contrato.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_codigo_contrato.setForeground(new java.awt.Color(255, 255, 255));
        txt_codigo_contrato.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_codigo_contrato, gridBagConstraints);

        txt_centro.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_centro.setForeground(new java.awt.Color(255, 255, 255));
        txt_centro.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_centro, gridBagConstraints);

        txt_coste_mes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_coste_mes.setForeground(new java.awt.Color(255, 255, 255));
        txt_coste_mes.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_coste_mes, gridBagConstraints);

        txt_codigo_trabajador.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_codigo_trabajador.setForeground(new java.awt.Color(255, 255, 255));
        txt_codigo_trabajador.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_codigo_trabajador, gridBagConstraints);

        buttonIcon1.setBackground(new java.awt.Color(204, 204, 204));
        buttonIcon1.setForeground(new java.awt.Color(102, 102, 102));
        buttonIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/centros .png"))); // NOI18N
        buttonIcon1.setText("buttonIcon1");
        buttonIcon1.setToolTipText("");
        buttonIcon1.setColorDeSombra(new java.awt.Color(51, 51, 51));
        buttonIcon1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        buttonIcon1.setPreferredSize(new java.awt.Dimension(35, 30));
        buttonIcon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIcon1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(buttonIcon1, gridBagConstraints);

        txt_antiguedad.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_antiguedad.setForeground(new java.awt.Color(255, 255, 255));
        txt_antiguedad.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_antiguedad, gridBagConstraints);

        txt_poblacion.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txt_poblacion.setForeground(new java.awt.Color(255, 255, 255));
        txt_poblacion.setText("aaaa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(txt_poblacion, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        this.dispose();
    }//GEN-LAST:event_AceptarActionPerformed

    private void buttonIcon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIcon1ActionPerformed
        //FichaCentros centro = new FichaCentros(princi, true, trabajador.getCentro());
        //centro.setVisible(true);
    }//GEN-LAST:event_buttonIcon1ActionPerformed

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
            java.util.logging.Logger.getLogger(FichaTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FichaTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FichaTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FichaTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FichaTrabajador dialog = new FichaTrabajador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect Aceptar;
    private org.edisoncor.gui.button.ButtonIcon buttonIcon1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_antiguedad;
    private javax.swing.JLabel lbl_apellido1;
    private javax.swing.JLabel lbl_apellido2;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_centro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigo_contrato;
    private javax.swing.JLabel lbl_costemes;
    private javax.swing.JLabel lbl_denominacion_contrato;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_fecha_alta;
    private javax.swing.JLabel lbl_fecha_baja;
    private javax.swing.JLabel lbl_horasreales;
    private javax.swing.JLabel lbl_horassemanales;
    private javax.swing.JLabel lbl_nacimiento;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_poblacion;
    private javax.swing.JLabel lbl_principal;
    private javax.swing.JLabel lbl_tlf;
    private javax.swing.JLabel txt_antiguedad;
    private javax.swing.JLabel txt_apellido1;
    private javax.swing.JLabel txt_apellido2;
    private javax.swing.JLabel txt_categoria;
    private javax.swing.JLabel txt_centro;
    private javax.swing.JLabel txt_codigo_contrato;
    private javax.swing.JLabel txt_codigo_trabajador;
    private javax.swing.JLabel txt_coste_mes;
    private javax.swing.JLabel txt_direccion;
    private javax.swing.JLabel txt_email;
    private javax.swing.JLabel txt_fecha_alta;
    private javax.swing.JLabel txt_fecha_baja;
    private javax.swing.JLabel txt_horas_semana_alta;
    private javax.swing.JLabel txt_horas_semana_reales;
    private javax.swing.JLabel txt_nacimiento;
    private javax.swing.JLabel txt_nombre;
    private javax.swing.JLabel txt_poblacion;
    private javax.swing.JLabel txt_telefono;
    // End of variables declaration//GEN-END:variables
}
