/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Vistas.Formularios.FormularioTrabajador;
import Modelo.Entidades.Centro;
import Modelo.Entidades.Sede;
import Modelo.Repository.TrabajadorRepository;
import Modelo.Entidades.Trabajador;
import Utilidades.Utilidades;
import Utilidades.UtilidadesPantalla;
import Vistas.Principal.Principal_vista;
import Vistas.Fichas.FichaTrabajador;
import java.util.ArrayList;
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
public class VistaTrabajadores extends javax.swing.JFrame {

    ArrayList<Sede> sedesByUsuario;
    TrabajadorRepository repoTrabajador;
    Utilidades utilidades = new Utilidades();
    int id_trabajador_seleccionado;
    String nombre_apellidos_trabajador;
    Centro centroListadoTrabajadores = null;
    boolean isAlreadyOneClick;
    Trabajador trabajador;

    /**
     * Creates new form VistaTrabajadores
     *
     * @param centro
     */
    public VistaTrabajadores(Centro centro) {
        this.centroListadoTrabajadores = centro;
        initComponents();
        iniciarOtrosComponentes();
        repoTrabajador.rellenarTablaPorCodigoCentro(tabla_trabajadores, centroListadoTrabajadores);
        //utilidades.rellenarTabla(tabla_trabajadores, "trabajadores", "WHERE codigo_centro='" + centroListadoTrabajadores.getCodigo() + "'");
    }

    public VistaTrabajadores(ArrayList sedes) {
        this.sedesByUsuario = sedes;
        initComponents();
        iniciarOtrosComponentes();
        repoTrabajador.rellenarTablaPorSedes(tabla_trabajadores,sedesByUsuario);
        //utilidades.rellenarTabla(tabla_trabajadores, "trabajadores", "");
    }

    public VistaTrabajadores() {
        initComponents();
        iniciarOtrosComponentes();
        repoTrabajador.rellenarTablaDefault(tabla_trabajadores);
        //utilidades.rellenarTabla(tabla_trabajadores, "trabajadores", "");
    }

    private void iniciarOtrosComponentes() {
        repoTrabajador = new TrabajadorRepository();
        UtilidadesPantalla.centrarTablas(tabla_trabajadores);
        UtilidadesPantalla.resolucionPantalla(this);
        ponAyuda();
        tabla_trabajadores.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_trabajadores.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_trabajadores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_trabajadores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        tabla_trabajadores.getColumnModel().getColumn(1).setMaxWidth(100);
        tabla_trabajadores.getColumnModel().getColumn(1).setPreferredWidth(75);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_botones = new org.edisoncor.gui.panel.Panel();
        btn_nominas_trabajador = new javax.swing.JButton();
        btn_horario_trabajador = new javax.swing.JButton();
        btn_vacaciones_trabajador = new javax.swing.JButton();
        btn_incidencias_trabajador = new javax.swing.JButton();
        btn_borrar_trabjador = new javax.swing.JButton();
        btn_modificar_trabajador = new javax.swing.JButton();
        btn_añadir_trabajador = new javax.swing.JButton();
        Buscador = new javax.swing.JPanel();
        txt_buscador_trabajador = new javax.swing.JTextField();
        btn_buscar = new org.edisoncor.gui.button.ButtonIcon();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_trabajadores = new javax.swing.JTable();
        panelRect1 = new org.edisoncor.gui.panel.PanelRect();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TRABAJADORES");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new ImageIcon(getClass().getResource("/img/trabajador.png")).getImage());
        setMaximumSize(new java.awt.Dimension(1360, 762));
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setName("TRABAJADORES"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1360, 762));
        setResizable(false);
        setSize(new java.awt.Dimension(1360, 762));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_botones.setColorPrimario(new java.awt.Color(102, 102, 102));
        Panel_botones.setColorSecundario(new java.awt.Color(51, 51, 51));

        btn_nominas_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_nominas_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nominas.png"))); // NOI18N
        btn_nominas_trabajador.setText("Nóminas");
        btn_nominas_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nominas_trabajadorActionPerformed(evt);
            }
        });

        btn_horario_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_horario_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/planificador.png"))); // NOI18N
        btn_horario_trabajador.setText("Horario");
        btn_horario_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_horario_trabajadorActionPerformed(evt);
            }
        });

        btn_vacaciones_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_vacaciones_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/falta.png"))); // NOI18N
        btn_vacaciones_trabajador.setText("Faltas");
        btn_vacaciones_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_vacaciones_trabajadorActionPerformed(evt);
            }
        });

        btn_incidencias_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_incidencias_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incidencias .png"))); // NOI18N
        btn_incidencias_trabajador.setText("Incidencias");
        btn_incidencias_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_incidencias_trabajadorActionPerformed(evt);
            }
        });

        btn_borrar_trabjador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrar_trabjador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrar_trabjador.setText("Borrar ");
        btn_borrar_trabjador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrar_trabjadorActionPerformed(evt);
            }
        });

        btn_modificar_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_modificar_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modificar.png"))); // NOI18N
        btn_modificar_trabajador.setText("Modificar");
        btn_modificar_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificar_trabajadorActionPerformed(evt);
            }
        });

        btn_añadir_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_añadir_trabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/añadir.png"))); // NOI18N
        btn_añadir_trabajador.setText("Añadir");
        btn_añadir_trabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_añadir_trabajadorActionPerformed(evt);
            }
        });

        Buscador.setBackground(new java.awt.Color(102, 102, 102));
        Buscador.setForeground(new java.awt.Color(102, 102, 102));

        txt_buscador_trabajador.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txt_buscador_trabajador.setText("Buscar...");
        txt_buscador_trabajador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_buscador_trabajadorFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_buscador_trabajadorFocusLost(evt);
            }
        });
        txt_buscador_trabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscador_trabajadorKeyReleased(evt);
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
                .addComponent(txt_buscador_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BuscadorLayout.setVerticalGroup(
            BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BuscadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txt_buscador_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout Panel_botonesLayout = new javax.swing.GroupLayout(Panel_botones);
        Panel_botones.setLayout(Panel_botonesLayout);
        Panel_botonesLayout.setHorizontalGroup(
            Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_botonesLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_añadir_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_modificar_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_borrar_trabjador, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addComponent(btn_incidencias_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_vacaciones_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_horario_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nominas_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        Panel_botonesLayout.setVerticalGroup(
            Panel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_botonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Buscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btn_añadir_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_modificar_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btn_borrar_trabjador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btn_incidencias_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btn_vacaciones_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btn_horario_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btn_nominas_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        getContentPane().add(Panel_botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(992, 63, 250, 610));

        tabla_trabajadores.setAutoCreateRowSorter(true);
        tabla_trabajadores.setBackground(new java.awt.Color(204, 204, 204));
        tabla_trabajadores.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tabla_trabajadores.setForeground(new java.awt.Color(0, 0, 0));
        tabla_trabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CÓDIGO", "NOMBRE", "APELLIDOS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_trabajadores.setRowHeight(25);
        tabla_trabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_trabajadoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_trabajadores);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 860, 600));

        panelRect1.setColorPrimario(new java.awt.Color(102, 102, 102));
        panelRect1.setColorSecundario(new java.awt.Color(204, 204, 204));

        panelCurves1.setBackground(new java.awt.Color(102, 102, 102));
        panelCurves1.setForeground(new java.awt.Color(0, 0, 0));
        panelCurves1.setOpaque(true);

        javax.swing.GroupLayout panelRect1Layout = new javax.swing.GroupLayout(panelRect1);
        panelRect1.setLayout(panelRect1Layout);
        panelRect1Layout.setHorizontalGroup(
            panelRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelRect1Layout.setVerticalGroup(
            panelRect1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRect1Layout.createSequentialGroup()
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 780));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_trabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_trabajadoresMouseClicked
        if (isAlreadyOneClick) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            if (trabajador != null) {
                FichaTrabajador ficha = new FichaTrabajador(this, rootPaneCheckingEnabled, trabajador);
                ficha.setVisible(true);
            }
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

    }//GEN-LAST:event_tabla_trabajadoresMouseClicked

    private void btn_nominas_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nominas_trabajadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            if (trabajador != null) {
                Nominas_vista vista_nominas = new Nominas_vista(trabajador);
                vista_nominas.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_nominas_trabajadorActionPerformed

    private void btn_horario_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_horario_trabajadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            if (trabajador != null) {
                VistaHorario vista_planificadorHorario = new VistaHorario(trabajador);
                vista_planificadorHorario.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_horario_trabajadorActionPerformed

    private void btn_vacaciones_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_vacaciones_trabajadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            if (trabajador != null) {
                Faltas_vista vista_faltas = new Faltas_vista(trabajador);
                vista_faltas.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_vacaciones_trabajadorActionPerformed

    private void btn_incidencias_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_incidencias_trabajadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            if (trabajador != null) {
                Incidencias_vista vista_incidencias = new Incidencias_vista(trabajador);
                vista_incidencias.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_incidencias_trabajadorActionPerformed

    private void btn_borrar_trabjadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrar_trabjadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            int filaSeleccionada = tabla_trabajadores.getSelectedRow();
            int opcionborrar = JOptionPane.showConfirmDialog(rootPane, "¿Estas seguro de borrar el registro?\n"
                    + "Trabajador: " + (String) tabla_trabajadores.getValueAt(filaSeleccionada, 2) + " " + (String) tabla_trabajadores.getValueAt(filaSeleccionada, 3));
            switch (opcionborrar) {
                case 0://OPCION SI BORRAR TRABAJADOR
                    int id = UtilidadesPantalla.getIdSelected(tabla_trabajadores);
                    repoTrabajador.delete(id);
                    restablecerTabla();
                    break;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_borrar_trabjadorActionPerformed

    private void btn_modificar_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificar_trabajadorActionPerformed
        if (tabla_trabajadores.getSelectedRow() != -1) {
            trabajador = repoTrabajador.getById(UtilidadesPantalla.getIdSelected(tabla_trabajadores));//Cogemos el trabajador seleccionado.
            FormularioTrabajador FT = new FormularioTrabajador(this, true, trabajador, repoTrabajador);
            if (trabajador != null) {
                FT.setVisible(true);
            }
            Trabajador get = FT.trabajadorModificar;
            if (get != null) {
                repoTrabajador.update(get);
                restablecerTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un trabajador");
        }
    }//GEN-LAST:event_btn_modificar_trabajadorActionPerformed

    private void btn_añadir_trabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_añadir_trabajadorActionPerformed
        FormularioTrabajador FT = new FormularioTrabajador(this, true);
        FT.setVisible(true);
        Trabajador get = FT.trabajadorModificar;
        if (get != null) {
            if (!repoTrabajador.ifCodigoExist(get.getCodigo())) {
                repoTrabajador.insert(get);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo insertar el trabajador por que ya existe en la base de datos", "Error al insertar", JOptionPane.WARNING_MESSAGE);
            }
            restablecerTabla();
        }

    }//GEN-LAST:event_btn_añadir_trabajadorActionPerformed

    private void txt_buscador_trabajadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscador_trabajadorFocusGained
        if (txt_buscador_trabajador.getText().contains("Buscar...")) {
            txt_buscador_trabajador.setText("");
        }
    }//GEN-LAST:event_txt_buscador_trabajadorFocusGained

    private void txt_buscador_trabajadorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_buscador_trabajadorFocusLost
        if (txt_buscador_trabajador.getText().length() == 0) {
            txt_buscador_trabajador.setText("Buscar...");
        }
    }//GEN-LAST:event_txt_buscador_trabajadorFocusLost

    private void txt_buscador_trabajadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscador_trabajadorKeyReleased

        if (!txt_buscador_trabajador.getText().isEmpty()) {//SI EL BUSCADOR NO ESTA VACIO, VACIA LA TABLA Y EMPIEZA A BUSCAR CON LOS CARACTERES QUE LE VAMOS INTRODUCIENDO
            DefaultTableModel dm = (DefaultTableModel) tabla_trabajadores.getModel();
            dm.getDataVector().removeAllElements();
            dm.fireTableDataChanged();
            repoTrabajador.buscar(tabla_trabajadores, txt_buscador_trabajador.getText());
            //utilidades.buscaryRellenarTabla(evt, txt_buscador_trabajador.getText(), tabla_trabajadores,"trabajadores");
        } else {//SI POR EL CONTRARIO ESTA VACIO EL BUSCADOR, ENTONCES RELLENA LA TABLA CON TODO
            restablecerTabla();
        }
    }//GEN-LAST:event_txt_buscador_trabajadorKeyReleased

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_buscarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaTrabajadores().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Buscador;
    private org.edisoncor.gui.panel.Panel Panel_botones;
    private javax.swing.JButton btn_añadir_trabajador;
    private javax.swing.JButton btn_borrar_trabjador;
    private org.edisoncor.gui.button.ButtonIcon btn_buscar;
    private javax.swing.JButton btn_horario_trabajador;
    private javax.swing.JButton btn_incidencias_trabajador;
    private javax.swing.JButton btn_modificar_trabajador;
    private javax.swing.JButton btn_nominas_trabajador;
    private javax.swing.JButton btn_vacaciones_trabajador;
    private javax.swing.JScrollPane jScrollPane1;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelRect panelRect1;
    private javax.swing.JTable tabla_trabajadores;
    private javax.swing.JTextField txt_buscador_trabajador;
    // End of variables declaration//GEN-END:variables

    private void restablecerTabla() {
        if (centroListadoTrabajadores != null) {
            //utilidades.rellenarTabla(tabla_trabajadores, "trabajadores", "WHERE codigo_centro='" + centroListadoTrabajadores.getCodigo() + "'");
            repoTrabajador.rellenarTablaPorCodigoCentro(tabla_trabajadores, centroListadoTrabajadores);
        } else if (centroListadoTrabajadores == null) {
            repoTrabajador.rellenarTablaDefault(tabla_trabajadores);
        }
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "trabajadores", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
