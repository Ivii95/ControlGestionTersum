/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Formularios;

import Modelo.Repository.CentroRepository;
import Modelo.Repository.TrabajadorRepository;
import Modelo.Entidades.Trabajador;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Archivos.Trabajadores.VistaTrabajadores;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author DisenoWeb
 */
public class FormularioTrabajador extends javax.swing.JDialog {

    Utilidades utilidades = new Utilidades();
    public Trabajador trabajadorModificar = null;
    TrabajadorRepository repoTrabajador;
    CentroRepository repoCentro;

    /**
     * Creates new form FormularioTrabajador
     *
     * @param parent
     * @param modal
     */
    public FormularioTrabajador(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        iniciarComboBox();
        this.repoTrabajador = new TrabajadorRepository();
        repoTrabajador.rellenarListaDefault();
        this.trabajadorModificar = new Trabajador();
        pulsarX();
    }

    /**
     * Creates new form FormularioTrabajador
     *
     * @param parent
     * @param modal
     * @param trabajador
     * @param repo
     */
    public FormularioTrabajador(VistaTrabajadores parent, boolean modal, Trabajador trabajador, TrabajadorRepository repo) {
        super(parent, modal);
        this.repoTrabajador = repo;
        initComponents();
        this.trabajadorModificar = trabajador;
        rellenarDatos();
        pulsarX();
        iniciarComboBox();
    }

    private void pulsarX() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                trabajadorModificar = null;
                this.windowClosed(evt);
            }
        });
    }

    private void iniciarComboBox() {
        this.repoCentro = new CentroRepository();
        this.setLocationRelativeTo(null);
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 46; j = j + 15) {

                if (i < 10 && j == 0) {
                    comboHorasSemanaAlta.addItem("0" + i + ":" + "0" + j);
                    comboHorasSemanaReales.addItem("0" + i + ":" + "0" + j);
                } else if (i < 10) {
                    comboHorasSemanaAlta.addItem("0" + i + ":" + j);
                    comboHorasSemanaReales.addItem("0" + i + ":" + j);
                } else if (j == 0) {
                    comboHorasSemanaAlta.addItem(i + ":" + "0" + j);
                    comboHorasSemanaReales.addItem(i + ":" + "0" + j);
                } else {
                    comboHorasSemanaAlta.addItem(i + ":" + j);
                    comboHorasSemanaReales.addItem(i + ":" + j);
                }
            }
        }
        comboHorasSemanaAlta.addItem("40:00");
        comboHorasSemanaReales.addItem("40:00");
        /*for (int i = 40; i > 0; i = i--) {
            comboHorasSemanaReales.addItem(i + "");
        }*/
        repoCentro.rellenarCombo(comboCentros);
        UtilidadesPantalla.rellenarComboTiposContrato(comboCodigoContrato);
    }

    private void rellenarDatos() {
        lbl_principal.setText(lbl_principal.getText() + ": " + trabajadorModificar.getNombre() + " " + trabajadorModificar.getApellido1() + " " + trabajadorModificar.getApellido2());
        txt_codigo_trabajador.setText(trabajadorModificar.getCodigo() + "");
        comboCodigoContrato.setSelectedItem(trabajadorModificar.getCodigo_tipo_contrato());
        //Rellenar los centros
        txt_apellido1.setText(trabajadorModificar.getApellido1() + "");
        txt_apellido2.setText(trabajadorModificar.getApellido2() + "");
        txt_nombre.setText(trabajadorModificar.getNombre() + "");
        txt_direccion.setText(trabajadorModificar.getDireccion() + "");
        txt_poblacion.setText(trabajadorModificar.getPoblacion() + "");
        if (trabajadorModificar.getFechanacimiento() != null) {
            fecha_nacimiento.setDate(java.sql.Date.valueOf(trabajadorModificar.getFechanacimiento()));
        }
        txt_categoria.setText(trabajadorModificar.getCategoria() + "");
        if (trabajadorModificar.getAntiguedad() != null) {
            txt_antiguedad.setDate(java.sql.Date.valueOf(trabajadorModificar.getAntiguedad()));
        }
        txt_tlf.setText(trabajadorModificar.getTelefono() + "");
        txt_email.setText(trabajadorModificar.getEmail());
        if (trabajadorModificar.getFecha_alta() != null) {
            txt_fecha_alta.setDate(java.sql.Date.valueOf(trabajadorModificar.getFecha_alta()));
        }
        if (trabajadorModificar.getFecha_baja() != null) {
            txt_fecha_baja.setDate(java.sql.Date.valueOf(trabajadorModificar.getFecha_baja()));
        }
        comboHorasSemanaAlta.setSelectedItem(trabajadorModificar.getHoras_semana_alta());
        comboHorasSemanaReales.setSelectedItem(trabajadorModificar.getHoras_semana_reales());
        txt_costemes.setText(trabajadorModificar.getCoste_mes() + "");
        txt_DNI.setText(trabajadorModificar.getDNI());
        txt_codigo_sede.setText(trabajadorModificar.getCodigo_sede());
        txt_seguridad_social.setText(trabajadorModificar.getSeguridad_social() + "");
        txt_iban.setText(trabajadorModificar.getIban() + "");
        //txt_codigo_trabajador.setEditable(false);
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
        lbl_fecha_alta = new javax.swing.JLabel();
        txt_apellido1 = new javax.swing.JTextField();
        lbl_apellido1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_categoria = new javax.swing.JTextField();
        lbl_categoria = new javax.swing.JLabel();
        txt_tlf = new javax.swing.JTextField();
        lbl_tlf = new javax.swing.JLabel();
        lbl_DNI = new javax.swing.JLabel();
        txt_DNI = new javax.swing.JTextField();
        lbl_principal = new javax.swing.JLabel();
        lbl_nombre_ = new javax.swing.JLabel();
        lbl_antiguedad = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_poblacion = new javax.swing.JTextField();
        lbl_poblacion = new javax.swing.JLabel();
        fecha_nacimiento = new org.jdesktop.swingx.JXDatePicker();
        lbl_nacimiento = new javax.swing.JLabel();
        lbl_apellido2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Aceptar = new org.edisoncor.gui.button.ButtonRect();
        Cancelar = new org.edisoncor.gui.button.ButtonRect();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboCodigoContrato = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        comboCentros = new javax.swing.JComboBox<>();
        lbl_centro = new javax.swing.JLabel();
        lbl_denominacion_contrato = new javax.swing.JLabel();
        txt_apellido2 = new javax.swing.JTextField();
        lbl_fecha_baja = new javax.swing.JLabel();
        lbl_horasreales = new javax.swing.JLabel();
        lbl_direccion = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JTextField();
        lbl_costemes = new javax.swing.JLabel();
        txt_costemes = new javax.swing.JTextField();
        lbl_horassemanales = new javax.swing.JLabel();
        txt_fecha_alta = new org.jdesktop.swingx.JXDatePicker();
        txt_fecha_baja = new org.jdesktop.swingx.JXDatePicker();
        comboHorasSemanaAlta = new javax.swing.JComboBox<>();
        comboHorasSemanaReales = new javax.swing.JComboBox<>();
        txt_antiguedad = new org.jdesktop.swingx.JXDatePicker();
        lbl_codigoSede = new javax.swing.JLabel();
        lbl_codigo = new javax.swing.JLabel();
        txt_codigo_sede = new javax.swing.JTextField();
        txt_codigo_trabajador = new javax.swing.JTextField();
        txt_seguridad_social = new javax.swing.JTextField();
        lbl_seguridad_social = new javax.swing.JLabel();
        lbl_iban = new javax.swing.JLabel();
        txt_iban = new javax.swing.JTextField();

        setTitle("INSERTAR O MODIFICAR TRABAJADOR");
        setMinimumSize(new java.awt.Dimension(1100, 697));
        setResizable(false);
        setSize(new java.awt.Dimension(1100, 697));
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

        lbl_fecha_alta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fecha_alta.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fecha_alta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha_alta.setText("Fecha de alta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fecha_alta, gridBagConstraints);

        txt_apellido1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_apellido1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellido1KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_apellido1, gridBagConstraints);

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

        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_nombre, gridBagConstraints);

        txt_categoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_categoria.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_categoria, gridBagConstraints);

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

        txt_tlf.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_tlf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_tlf.setText("0");
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

        lbl_DNI.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_DNI.setForeground(new java.awt.Color(204, 204, 204));
        lbl_DNI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_DNI.setText("DNI/NIE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_DNI, gridBagConstraints);

        txt_DNI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_DNI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_DNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DNIActionPerformed(evt);
            }
        });
        txt_DNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_DNIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_DNIKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_DNI, gridBagConstraints);

        lbl_principal.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        lbl_principal.setForeground(new java.awt.Color(204, 204, 204));
        lbl_principal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_principal.setText("Datos del trabajador");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        jPanel2.add(lbl_principal, gridBagConstraints);

        lbl_nombre_.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_nombre_.setForeground(new java.awt.Color(204, 204, 204));
        lbl_nombre_.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_nombre_.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_nombre_, gridBagConstraints);

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

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_email, gridBagConstraints);

        txt_poblacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_poblacion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_poblacion, gridBagConstraints);

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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(fecha_nacimiento, gridBagConstraints);

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
        gridBagConstraints.gridy = 20;
        gridBagConstraints.gridwidth = 6;
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
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Aceptar, gridBagConstraints);

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 21;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        jPanel2.add(Cancelar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
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
        gridBagConstraints.gridy = 18;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipady = 20;
        jPanel2.add(jLabel5, gridBagConstraints);

        comboCodigoContrato.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboCodigoContrato.setToolTipText("");
        comboCodigoContrato.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCodigoContratoItemStateChanged(evt);
            }
        });
        comboCodigoContrato.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboCodigoContratoFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(comboCodigoContrato, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Codigo contrato");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        jPanel2.add(jLabel17, gridBagConstraints);

        comboCentros.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboCentros.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comboCentrosFocusGained(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(comboCentros, gridBagConstraints);

        lbl_centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_centro.setForeground(new java.awt.Color(204, 204, 204));
        lbl_centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_centro.setText("Centro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        jPanel2.add(lbl_centro, gridBagConstraints);

        lbl_denominacion_contrato.setBackground(new java.awt.Color(102, 102, 102));
        lbl_denominacion_contrato.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_denominacion_contrato.setForeground(new java.awt.Color(204, 204, 204));
        lbl_denominacion_contrato.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_denominacion_contrato.setText("TIPO DE CONTRATO");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 19;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(lbl_denominacion_contrato, gridBagConstraints);

        txt_apellido2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_apellido2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_apellido2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_apellido2KeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_apellido2, gridBagConstraints);

        lbl_fecha_baja.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fecha_baja.setForeground(new java.awt.Color(204, 204, 204));
        lbl_fecha_baja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fecha_baja.setText("Fecha de baja");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_fecha_baja, gridBagConstraints);

        lbl_horasreales.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_horasreales.setForeground(new java.awt.Color(204, 204, 204));
        lbl_horasreales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_horasreales.setText("Horas reales");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
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

        txt_direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_direccion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_direccion, gridBagConstraints);

        lbl_costemes.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_costemes.setForeground(new java.awt.Color(204, 204, 204));
        lbl_costemes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_costemes.setText("Coste al mes (€)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_costemes, gridBagConstraints);

        txt_costemes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_costemes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_costemes.setText("0.0");
        txt_costemes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costemesActionPerformed(evt);
            }
        });
        txt_costemes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_costemesKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_costemes, gridBagConstraints);

        lbl_horassemanales.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_horassemanales.setForeground(new java.awt.Color(204, 204, 204));
        lbl_horassemanales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_horassemanales.setText("Horas semana alta");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_horassemanales, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_fecha_alta, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_fecha_baja, gridBagConstraints);

        comboHorasSemanaAlta.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboHorasSemanaAlta.setMaximumRowCount(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(comboHorasSemanaAlta, gridBagConstraints);

        comboHorasSemanaReales.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        comboHorasSemanaReales.setMaximumRowCount(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(comboHorasSemanaReales, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_antiguedad, gridBagConstraints);

        lbl_codigoSede.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigoSede.setForeground(new java.awt.Color(204, 204, 204));
        lbl_codigoSede.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigoSede.setText("Codigo Sede");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_codigoSede, gridBagConstraints);

        lbl_codigo.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
        lbl_codigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_codigo.setText("Codigo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 100;
        jPanel2.add(lbl_codigo, gridBagConstraints);

        txt_codigo_sede.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codigo_sede.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo_sede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_sedeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigo_sedeKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_codigo_sede, gridBagConstraints);

        txt_codigo_trabajador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_codigo_trabajador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_codigo_trabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_codigo_trabajadorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_codigo_trabajadorKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_codigo_trabajador, gridBagConstraints);

        txt_seguridad_social.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_seguridad_social.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_seguridad_social.setText("0");
        txt_seguridad_social.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_seguridad_social.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_seguridad_socialKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_seguridad_social, gridBagConstraints);

        lbl_seguridad_social.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_seguridad_social.setForeground(new java.awt.Color(204, 204, 204));
        lbl_seguridad_social.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_seguridad_social.setText("Nº Seguridad Social");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        jPanel2.add(lbl_seguridad_social, gridBagConstraints);

        lbl_iban.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_iban.setForeground(new java.awt.Color(204, 204, 204));
        lbl_iban.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_iban.setText("IBAN");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.ipadx = 50;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel2.add(lbl_iban, gridBagConstraints);

        txt_iban.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_iban.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_iban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ibanActionPerformed(evt);
            }
        });
        txt_iban.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_ibanKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ibanKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel2.add(txt_iban, gridBagConstraints);

        panelCurves1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1050, 640));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1110, 700));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1120, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCodigoContratoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCodigoContratoItemStateChanged
        try {
            if (!comboCodigoContrato.getSelectedItem().equals("Selecciona uno")) {
                String denominacion_contrato = utilidades.rellenarTipoContrato((int) comboCodigoContrato.getSelectedItem());
                lbl_denominacion_contrato.setText(denominacion_contrato);
            } else {
                lbl_denominacion_contrato.setText("");
            }

        } catch (ClassCastException e) {

        }
    }//GEN-LAST:event_comboCodigoContratoItemStateChanged

    private void txt_tlfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tlfKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_tlfKeyTyped

    private void txt_DNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DNIKeyTyped
        //comprobarNumero(evt);
        //comprobarCodigo(evt);
    }//GEN-LAST:event_txt_DNIKeyTyped

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        // TODO add your handling code here:
        trabajadorModificar = null;
        this.setVisible(false);
    }//GEN-LAST:event_CancelarActionPerformed

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_costemesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_costemesKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_costemesKeyTyped

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        boolean correcto = true;
        try {
            trabajadorModificar.setCodigo(txt_codigo_trabajador.getText());
            if (!comboCodigoContrato.getSelectedItem().equals("Selecciona uno")) {
                trabajadorModificar.setCodigo_tipo_contrato((int) comboCodigoContrato.getSelectedItem());
            }
            trabajadorModificar.setCodigo_sede(txt_codigo_sede.getText());
            trabajadorModificar.setNombre(txt_nombre.getText());
            trabajadorModificar.setApellido1(txt_apellido1.getText());
            trabajadorModificar.setApellido2(txt_apellido2.getText());
            trabajadorModificar.setDireccion(txt_direccion.getText());
            trabajadorModificar.setPoblacion(txt_poblacion.getText());
            if (txt_categoria.getText() != null || !txt_categoria.getText().equals("")) {
                System.out.println(txt_categoria.getText());
                trabajadorModificar.setCategoria(txt_categoria.getText());
            }
            if (fecha_nacimiento.getDate() != null) {
                trabajadorModificar.setFechanacimiento(UtilidadesPantalla.convertToLocalDateViaInstant(fecha_nacimiento.getDate()));
            }
            if (txt_antiguedad.getDate() != null) {
                trabajadorModificar.setAntiguedad(UtilidadesPantalla.convertToLocalDateViaInstant(txt_antiguedad.getDate()));
            }
            if (txt_tlf.getText() != null) {
                trabajadorModificar.setTelefono(Integer.parseInt(txt_tlf.getText()));
            }
            trabajadorModificar.setEmail(txt_email.getText());
            if (comboHorasSemanaAlta.getSelectedItem() != null) {
                String semana_alta = (String) comboHorasSemanaAlta.getSelectedItem();
                trabajadorModificar.setHoras_semana_alta(semana_alta);
            }
            if (comboHorasSemanaReales.getSelectedItem() != null) {
                String semana_reales = (String) comboHorasSemanaReales.getSelectedItem();
                trabajadorModificar.setHoras_semana_reales(semana_reales);
            }
            trabajadorModificar.setCoste_mes(Float.parseFloat(txt_costemes.getText()));
            trabajadorModificar.setDNI(txt_DNI.getText());
            trabajadorModificar.setCodigo_sede(txt_codigo_sede.getText());
            if (txt_fecha_alta.getDate() != null) {
                trabajadorModificar.setFecha_alta(UtilidadesPantalla.convertToLocalDateViaInstant(txt_fecha_alta.getDate()));
            }
            if (txt_fecha_baja.getDate() != null) {
                trabajadorModificar.setFecha_baja(UtilidadesPantalla.convertToLocalDateViaInstant(txt_fecha_baja.getDate()));
            }
            if (txt_seguridad_social.getText() != null) {
                trabajadorModificar.setSeguridad_social(txt_seguridad_social.getText());
            }
            if (txt_iban.getText() != null) {
                trabajadorModificar.setIban(txt_iban.getText());
            }
            /*
            if (!txt_DNI.getText().equals("") && txt_DNI.getText() != null) {//Codigo
                //if (!utilidades.comprobarCodigoRepetido(txt_codigo_trabajador.getText(), "trabajadores")) {//Codigo repetido

                if (!comboCodigoContrato.getSelectedItem().equals("Selecciona uno")) {//Codigo tipo contrato

                    if (!comboCentros.getSelectedItem().equals("Selecciona uno")) {//Centros
                        String centroSeleccionado = (String) comboCentros.getSelectedItem();
                        //Centro centro = utilidades.getCentroByNombre(centroSeleccionado);
                        //trabajadorModificar.setCentro(centro);
                        if (!txt_nombre.getText().equals("") && txt_nombre.getText() != null) {//Nombre

                            if (!txt_apellido1.getText().equals("") && txt_apellido1.getText() != null) {//Apellido1

                                if (!txt_apellido2.getText().equals("") && txt_apellido2.getText() != null) {//Apellido2

                                    if (null != txt_direccion.getText() && !txt_direccion.equals("")) {//Direccion

                                        if (txt_poblacion.getText() != null && !txt_poblacion.equals("")) {//Poblacion
                                            trabajadorModificar.setPoblacion(txt_poblacion.getText());
                                            if (fecha_nacimiento.getDate() != null) {//Fecha de nacimiento no este vacia
                                                trabajadorModificar.setFechanacimiento(UtilidadesPantalla.convertToLocalDateViaInstant(fecha_nacimiento.getDate()));
                                                if (txt_categoria.getText() != null && !txt_categoria.getText().equals("")) {//Categoria
                                                    trabajadorModificar.setCategoria(txt_categoria.getText());
                                                    if (txt_antiguedad.getDate() != null && !txt_antiguedad.getDate().equals("")) {//Antiguedad
                                                        trabajadorModificar.setAntiguedad(UtilidadesPantalla.convertToLocalDateViaInstant(txt_antiguedad.getDate()));
                                                        if (txt_tlf.getText() != null && !txt_tlf.getText().equals("")) {//Telefono
                                                            trabajadorModificar.setTelefono(Integer.parseInt(txt_tlf.getText()));
                                                            if (UtilidadesPantalla.comprobarEmail(txt_email.getText())) {//Email
                                                                trabajadorModificar.setEmail(txt_email.getText());
                                                                int semana_alta = Integer.parseInt((String) comboHorasSemanaAlta.getSelectedItem());
                                                                int semana_reales = Integer.parseInt((String) comboHorasSemanaReales.getSelectedItem());
                                                                trabajadorModificar.setHoras_semana_alta(semana_alta);
                                                                trabajadorModificar.setHoras_semana_reales(semana_reales);
                                                                if (txt_costemes.getText() != null && !txt_costemes.getText().equals("")) {//Coste mes
                                                                    trabajadorModificar.setCoste_mes(Float.parseFloat(txt_costemes.getText()));
                                                                    if (txt_DNI.getText() != null && !txt_DNI.getText().equals("")) {
                                                                        trabajadorModificar.setDNI(txt_DNI.getText());
                                                                        if (txt_codigo_sede.getText() != null && !txt_codigo_sede.getText().equals("")) {
                                                                            trabajadorModificar.setCodigo_sede(txt_codigo_sede.getText());
                                                                            if (txt_fecha_alta.getDate() != null) {//Fecha alta vacia

                                                                                if (fecha_nacimiento.getDate().before(txt_fecha_alta.getDate())) {//Fecha de nacimientos antes de la fecha de alta
                                                                                    trabajadorModificar.setFecha_alta(UtilidadesPantalla.convertToLocalDateViaInstant(txt_fecha_alta.getDate()));

                                                                                    if (txt_fecha_baja.getDate() != null) {//Fecha de baja vacia
                                                                                        if (txt_fecha_alta.getDate().before(txt_fecha_baja.getDate())) {//Fecha de alta antes de la fecha de baja
                                                                                            trabajadorModificar.setFecha_baja(UtilidadesPantalla.convertToLocalDateViaInstant(txt_fecha_baja.getDate()));
                                                                                            correcto = true;
                                                                                        } else {
                                                                                            JOptionPane.showMessageDialog(this, "La fecha de baja no puede ser superior a la fecha de alta", "Fechas", JOptionPane.WARNING_MESSAGE);
                                                                                        }
                                                                                    } else {
                                                                                        trabajadorModificar.setFecha_baja(null);
                                                                                        correcto = true;
                                                                                    }

                                                                                } else {
                                                                                    JOptionPane.showMessageDialog(this, "La fecha de nacimiento no puede ser superior a la fecha de alta", "Fechas", JOptionPane.WARNING_MESSAGE);
                                                                                }
                                                                            } else {
                                                                                JOptionPane.showMessageDialog(this, "Necesita ingresar una fecha de alta", "Fechas", JOptionPane.WARNING_MESSAGE);
                                                                            }
                                                                        } else {
                                                                            JOptionPane.showMessageDialog(this, "Necesita ingresar una sede", "Coste al mes", JOptionPane.WARNING_MESSAGE);
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(this, "Necesita ingresar un DNI", "Coste al mes", JOptionPane.WARNING_MESSAGE);
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(this, "Necesita ingresar un coste al mes", "Coste al mes", JOptionPane.WARNING_MESSAGE);
                                                                }
                                                            } else {
                                                                JOptionPane.showMessageDialog(this, "Necesita ingresar un e-mail", "E-mail", JOptionPane.WARNING_MESSAGE);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(this, "Necesita ingresar un telefono", "Telefono", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(this, "Necesita ingresar una antiguedad", "Antiguedad", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(this, "Necesita ingresar una categoria", "Categoria", JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(this, "Necesita ingresar una fecha de nacimiento", "Fechas", JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this, "Necesita ingresar una población", "Población", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Necesita ingresar una dirección", "Dirección", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this, "Necesita ingresar un segundo apellido", "Apellidos", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Necesita ingresar un primer apellido", "Apellidos", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Necesita ingresar un nombre", "Nombre", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Necesita ingresar un centro", "Centros", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Necesita ingresar un codigo de algun tipo de contrato", "Tipos de contrato", JOptionPane.WARNING_MESSAGE);
                }
                //} else {
                //  JOptionPane.showMessageDialog(this, "El codigo ya existe en la base de datos", "Codigo", JOptionPane.WARNING_MESSAGE);
                //}
            } else {
                JOptionPane.showMessageDialog(this, "Necesita ingresar un DNI", "DNI", JOptionPane.WARNING_MESSAGE);
            }*/
            //if (correcto) {
            this.setVisible(false);
            //}
        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "No se pueden meter números en algunos campos", "Errores con los números", JOptionPane.WARNING_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al meter los datos del formulario", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_AceptarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        comprobarLetra(evt);
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_apellido1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido1KeyTyped
        comprobarLetra(evt);
    }//GEN-LAST:event_txt_apellido1KeyTyped

    private void txt_apellido2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_apellido2KeyTyped
        comprobarLetra(evt);
    }//GEN-LAST:event_txt_apellido2KeyTyped

    private void comboCodigoContratoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCodigoContratoFocusGained
        comboCodigoContrato.removeItem("Selecciona uno");
    }//GEN-LAST:event_comboCodigoContratoFocusGained

    private void comboCentrosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comboCentrosFocusGained
        comboCentros.removeItem("Selecciona uno");
    }//GEN-LAST:event_comboCentrosFocusGained

    private void txt_DNIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_DNIKeyReleased

    }//GEN-LAST:event_txt_DNIKeyReleased

    private void txt_codigo_sedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_sedeKeyReleased

    }//GEN-LAST:event_txt_codigo_sedeKeyReleased

    private void txt_codigo_sedeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_sedeKeyTyped
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigo_sedeKeyTyped

    private void txt_codigo_trabajadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_trabajadorKeyReleased
        comprobarCodigo(evt);
    }//GEN-LAST:event_txt_codigo_trabajadorKeyReleased

    private void txt_codigo_trabajadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_codigo_trabajadorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codigo_trabajadorKeyTyped

    private void txt_DNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DNIActionPerformed

    private void txt_seguridad_socialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_seguridad_socialKeyTyped
        comprobarNumero(evt);
    }//GEN-LAST:event_txt_seguridad_socialKeyTyped

    private void txt_costemesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costemesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costemesActionPerformed

    private void txt_ibanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ibanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ibanActionPerformed

    private void txt_ibanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ibanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ibanKeyReleased

    private void txt_ibanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ibanKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ibanKeyTyped

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
            java.util.logging.Logger.getLogger(FormularioTrabajador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTrabajador.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormularioTrabajador dialog = new FormularioTrabajador(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        this.windowClosed(e);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.edisoncor.gui.button.ButtonRect Aceptar;
    private org.edisoncor.gui.button.ButtonRect Cancelar;
    private javax.swing.JComboBox<String> comboCentros;
    private javax.swing.JComboBox<String> comboCodigoContrato;
    private javax.swing.JComboBox<String> comboHorasSemanaAlta;
    private javax.swing.JComboBox<String> comboHorasSemanaReales;
    private org.jdesktop.swingx.JXDatePicker fecha_nacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_DNI;
    private javax.swing.JLabel lbl_antiguedad;
    private javax.swing.JLabel lbl_apellido1;
    private javax.swing.JLabel lbl_apellido2;
    private javax.swing.JLabel lbl_categoria;
    private javax.swing.JLabel lbl_centro;
    private javax.swing.JLabel lbl_codigo;
    private javax.swing.JLabel lbl_codigoSede;
    private javax.swing.JLabel lbl_costemes;
    private javax.swing.JLabel lbl_denominacion_contrato;
    private javax.swing.JLabel lbl_direccion;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_fecha_alta;
    private javax.swing.JLabel lbl_fecha_baja;
    private javax.swing.JLabel lbl_horasreales;
    private javax.swing.JLabel lbl_horassemanales;
    private javax.swing.JLabel lbl_iban;
    private javax.swing.JLabel lbl_nacimiento;
    private javax.swing.JLabel lbl_nombre_;
    private javax.swing.JLabel lbl_poblacion;
    private javax.swing.JLabel lbl_principal;
    private javax.swing.JLabel lbl_seguridad_social;
    private javax.swing.JLabel lbl_tlf;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTextField txt_DNI;
    private org.jdesktop.swingx.JXDatePicker txt_antiguedad;
    private javax.swing.JTextField txt_apellido1;
    private javax.swing.JTextField txt_apellido2;
    private javax.swing.JTextField txt_categoria;
    private javax.swing.JTextField txt_codigo_sede;
    private javax.swing.JTextField txt_codigo_trabajador;
    private javax.swing.JTextField txt_costemes;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_email;
    private org.jdesktop.swingx.JXDatePicker txt_fecha_alta;
    private org.jdesktop.swingx.JXDatePicker txt_fecha_baja;
    private javax.swing.JTextField txt_iban;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_poblacion;
    private javax.swing.JTextField txt_seguridad_social;
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
            if (repoTrabajador.ifCodigoExist(txt_codigo_trabajador.getText()) && lbl_codigo.getForeground().equals(new java.awt.Color(204, 204, 204))) {
                JOptionPane.showMessageDialog(this, "Codigo repetito", "Codigo", JOptionPane.WARNING_MESSAGE);
                lbl_codigo.setForeground(Color.red);
            } else if (!repoTrabajador.ifCodigoExist(txt_codigo_trabajador.getText()) && lbl_codigo.getForeground().equals(Color.red)) {
                lbl_codigo.setForeground(new java.awt.Color(204, 204, 204));
            }
        } catch (NumberFormatException e) {

        }
    }

    private void comprobarDNI(KeyEvent evt) {
        try {
            if (repoTrabajador.ifCodigoExist(txt_DNI.getText()) && lbl_DNI.getForeground().equals(new java.awt.Color(204, 204, 204))) {
                JOptionPane.showMessageDialog(this, "Codigo repetito", "Codigo", JOptionPane.WARNING_MESSAGE);
                lbl_DNI.setForeground(Color.red);
            } else if (!repoTrabajador.ifCodigoExist(txt_DNI.getText()) && lbl_DNI.getForeground().equals(Color.red)) {
                lbl_DNI.setForeground(new java.awt.Color(204, 204, 204));
            }
        } catch (NumberFormatException e) {

        }
    }
}
