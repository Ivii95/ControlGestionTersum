/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Archivos.Trabajadores;

import Modelo.Entidades.Centro;
import Modelo.Entidades.CentroTrabajador;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Horario;
import Modelo.Entidades.Trabajador;
import Modelo.Repository.CentroRepository;
import Modelo.Repository.CentroTrabajadoresRepository;
import Modelo.Repository.ClienteRepository;
import Modelo.Repository.HorarioRepository;
import Utilidades.DTable;
import Vistas.Principal.Principal_vista;
import java.awt.HeadlessException;
import java.time.LocalTime;
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
public class VistaHorario extends javax.swing.JFrame {

    //Como podemos comprobar este es el metodo que mas tira de la memoria ram ya que tiene que cargar todos los repositorios.
    CentroTrabajadoresRepository repoCentroTrabajadores;
    HorarioRepository repoHorario;
    ClienteRepository repoCliente;
    CentroRepository repoCentro;

    //Aqui cogeremos el trabajador y el centro si fuera necesario.
    Trabajador trabajadorHorario;
    Centro centroHorario;
    //tenemos una variable statica y booleana para ver si todo fue correctamente
    public boolean aceptado = false;

    /**
     *
     * @param trabajador
     */
    public VistaHorario(Trabajador trabajador) {
        //se le asigna el trabajador que le llega por parametros a el trabajador de la clase.
        trabajadorHorario = trabajador;
        //iniciamos los componentes graficos
        initComponents();
        //Iniciamos estos dos repositorios por que los tendremos que usar solo en el caso de que no tengamos el centro por parametro.
        repoCentro = new CentroRepository();
        repoCliente = new ClienteRepository();
        repoCliente.rellenarCombo(comboCliente);
        //iniciamos los componentes como nosotros queramos
        iniciarOtrosComponentes();
    }

    /**
     *
     * @param trabajador
     * @param centro
     */
    public VistaHorario(Trabajador trabajador, Centro centro) {
        centroHorario = centro;
        trabajadorHorario = trabajador;
        initComponents();
        //si el constructor tiene un centro tenemos que deshabilitar todo a lo que elegir centro se refiere. 
        comboCentro.setSelectedItem(centroHorario.getNombre());
        comboCentro.setEnabled(false);
        comboCliente.setSelectedItem(centroHorario.getCodigo_cliente());
        comboCliente.setEnabled(false);
        txt_direccion.setText("Dirección: " + centroHorario.getDireccion());
        iniciarOtrosComponentes();
    }

    /**
     *
     */
    public VistaHorario() {
        initComponents();
        iniciarOtrosComponentes();
    }

    private void iniciarOtrosComponentes() {
        lbl_titulo.setText(lbl_titulo.getText() + " " + trabajadorHorario.getNombre() + " " + trabajadorHorario.getApellido1() + " " + trabajadorHorario.getApellido2());
        //Al iniciar el repositorio le pasamos un trabajador para que saque todas las tuplas de un solo trabajador.
        //Seria optimo crear primero el objeto y luego que tuviera un objeto rellenarLista para hacer varios segun conveniencia.
        repoCentroTrabajadores = new CentroTrabajadoresRepository();
        repoCentroTrabajadores.rellenarListaByTrabajador(trabajadorHorario);
        repoHorario = new HorarioRepository();
        //Al ser llamado pocas veces lo importamos tan solo el metodo/objeto que vayamos a usar.
        Utilidades.UtilidadesPantalla.resolucionPantalla(this);
        //Inicia la tabla por horas.
        iniciarTabla();
        //Rellenamos el resto de los combos
        rellenarCombobox();
        //pone la ayuda para cuando pulse F1 AHI QUE REVISAR LOS HTML.
        ponAyuda();
        //Pinta la tabla
        TablaPlanificador.setDefaultRenderer(Object.class, new DTable());
        //Rellena los datos con los parametros pasados.
        repoHorario.rellenarTablaDefault(TablaPlanificador, repoCentroTrabajadores);
    }

    public void ponAyuda() {
        try {
            HelpSet helpset = new HelpSet(getClass().getClassLoader(), Utilidades.UtilidadesPantalla.obtenerUrlAyuda());
            HelpBroker hb = helpset.createHelpBroker();
            hb.enableHelpKey(this.getContentPane(), "horarios", helpset);
        } catch (HelpSetException ex) {
            Logger.getLogger(Principal_vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void iniciarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) TablaPlanificador.getModel();
        for (int i = 0; i < 24; i++) {
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
     * Creates new form VistaHorario
     */
    //  public static ArrayList<Centro> lista_de_centros = new ArrayList<Centro>();
    private void pintarTabla() {
        int IndiceHoraInicio = comboHoraInicio.getSelectedIndex();
        int IndiceHoraFinal = comboHoraFin.getSelectedIndex();
        int diaIndex = comboDia.getSelectedIndex() + 1;
        for (int i = IndiceHoraInicio; i <= IndiceHoraFinal; i++) {
            TablaPlanificador.setValueAt(comboCentro.getSelectedItem(), i, diaIndex);
        }
    }

    public void rellenarCombobox() {
        comboDia.addItem("Lunes");
        comboDia.addItem("Martes");
        comboDia.addItem("Miercoles");
        comboDia.addItem("Jueves");
        comboDia.addItem("Viernes");
        comboDia.addItem("Sabado");
        comboDia.addItem("Domingo");
        for (int i = 0; i < 24; i++) {
            if (i <= 9) {
                comboHoraInicio.addItem("0" + i);
                comboHoraFin.addItem("0" + i);
            } else {
                comboHoraInicio.addItem(i + "");
                comboHoraFin.addItem(i + "");
            }

        }
        for (int i = 0; i < 60; i++) {
            if (i <= 9) {
                comboMinutoInicio.addItem("0" + i);
                comboMinutoFin.addItem("0" + i);
            } else {
                comboMinutoInicio.addItem(i + "");
                comboMinutoFin.addItem(i + "");
            }
        }
    }

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
        comboMinutoInicio = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones2 = new javax.swing.JLabel();
        lbl_Centro = new javax.swing.JLabel();
        comboCentro = new javax.swing.JComboBox<>();
        comboMinutoFin = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones1 = new javax.swing.JLabel();
        txt_direccion = new javax.swing.JLabel();
        btn_aceptar = new javax.swing.JButton();
        BTN_AÑADIR = new javax.swing.JToggleButton();
        lbl_fechafin_vacaciones3 = new javax.swing.JLabel();
        lbl_fechafin_vacaciones4 = new javax.swing.JLabel();
        comboHoraInicio = new javax.swing.JComboBox<>();
        comboHoraFin = new javax.swing.JComboBox<>();
        lbl_fechafin_vacaciones5 = new javax.swing.JLabel();
        lbl_fechafin_vacaciones6 = new javax.swing.JLabel();
        btn_borrarr1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 762));
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
        TablaPlanificador.setCellSelectionEnabled(true);
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
        label_fechainicio.add(lbl_Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 200, 35));

        comboDia.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        comboDia.setToolTipText("");
        label_fechainicio.add(comboDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 200, 35));

        lbl_Cliente.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Cliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Cliente.setText("Cliente");
        label_fechainicio.add(lbl_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 34));

        comboCliente.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        comboCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboClienteItemStateChanged(evt);
            }
        });
        label_fechainicio.add(comboCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 280, 35));

        comboMinutoInicio.setMaximumRowCount(11);
        comboMinutoInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboMinutoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 100, 35));

        lbl_fechafin_vacaciones2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones2.setText("Minutos");
        label_fechainicio.add(lbl_fechafin_vacaciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, 100, 35));

        lbl_Centro.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_Centro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Centro.setText("Centro");
        label_fechainicio.add(lbl_Centro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 200, 35));

        comboCentro.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        comboCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        comboCentro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCentroItemStateChanged(evt);
            }
        });
        label_fechainicio.add(comboCentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 200, 35));

        comboMinutoFin.setMaximumRowCount(11);
        comboMinutoFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboMinutoFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 110, 100, 35));

        lbl_fechafin_vacaciones1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones1.setText("Hora de fin");
        label_fechainicio.add(lbl_fechafin_vacaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 200, 35));

        txt_direccion.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txt_direccion.setText("Direccion");
        label_fechainicio.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 400, 35));

        btn_aceptar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_aceptar.setText("Aceptar");
        btn_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aceptarActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 130, 200, 35));

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

        comboHoraInicio.setMaximumRowCount(9);
        comboHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 100, 35));

        comboHoraFin.setMaximumRowCount(9);
        comboHoraFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        label_fechainicio.add(comboHoraFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 110, 100, 35));

        lbl_fechafin_vacaciones5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones5.setText("Minutos");
        label_fechainicio.add(lbl_fechafin_vacaciones5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 100, 35));

        lbl_fechafin_vacaciones6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lbl_fechafin_vacaciones6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_fechafin_vacaciones6.setText("Hora");
        label_fechainicio.add(lbl_fechafin_vacaciones6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 100, 35));

        btn_borrarr1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btn_borrarr1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/borrar.png"))); // NOI18N
        btn_borrarr1.setText("Borrar Dia");
        btn_borrarr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_borrarr1ActionPerformed(evt);
            }
        });
        label_fechainicio.add(btn_borrarr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, 200, 35));

        panelCurves1.add(label_fechainicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 1310, 210));

        panelRect1.add(panelCurves1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 1370, 760));

        getContentPane().add(panelRect1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-8, -10, 1380, 780));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_AÑADIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AÑADIRActionPerformed
        try {
            LocalTime inicio = LocalTime.of(Integer.parseInt((String) comboHoraInicio.getSelectedItem()), Integer.parseInt((String) comboMinutoInicio.getSelectedItem()));
            LocalTime fin = LocalTime.of(Integer.parseInt((String) comboHoraFin.getSelectedItem()), Integer.parseInt((String) comboMinutoFin.getSelectedItem()));

            int indiceCentro = comboCentro.getSelectedIndex();
            if (indiceCentro != 0) {
                if (inicio.isBefore(fin)) {
                    Horario horario = new Horario();
                    Centro centro = repoCentro.getByNombre((String) comboCentro.getSelectedItem());
                    horario.setDiaSemana((String) comboDia.getSelectedItem());
                    CentroTrabajador ct = repoCentroTrabajadores.getByCodigos(trabajadorHorario, centro);
                    horario.setId_CentroTrabajadores(ct.getId());
                    horario.setHora_inicio(inicio);
                    horario.setHora_fin(fin);
                    int horasT = fin.getHour() - inicio.getHour();
                    int minT = (60 - fin.getMinute()) + inicio.getMinute();
                    if (minT >= 60) {
                        minT = minT - 60;
                        horasT++;
                    }
                    if (inicio.getMinute() > fin.getMinute()) {
                        horasT--;
                    }
                    horario.setHoras_totales(Float.parseFloat(horasT + "." + minT));
                    if (repoHorario.insert(horario)) {
                        pintarTabla();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "La hora de inicio debe ser inferior a la fecha fin.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Debes seleccionar un centro.");
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado\n" + e.getMessage());
        }
    }//GEN-LAST:event_BTN_AÑADIRActionPerformed

    private void btn_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aceptarActionPerformed
        aceptado = true;
        this.setVisible(false);

    }//GEN-LAST:event_btn_aceptarActionPerformed

    private void comboCentroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCentroItemStateChanged
        // TODO add your handling code here:
        String nombre = (String) comboCentro.getSelectedItem();
        Centro centro = repoCentro.getByNombre(nombre);
        if (centro != null) {
            txt_direccion.setText("Dirección: " + centro.getDireccion());
        }
    }//GEN-LAST:event_comboCentroItemStateChanged

    private void comboClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboClienteItemStateChanged
        String nombre = (String) comboCliente.getSelectedItem();
        Cliente cliente = repoCliente.getByNombre(nombre);
        if (cliente != null) {
            comboCentro.removeAllItems();
            repoCentro.rellenarComboByCodigoCliente(comboCentro, cliente.getCodigo());
        }
    }//GEN-LAST:event_comboClienteItemStateChanged

    private void btn_borrarr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_borrarr1ActionPerformed
        try {
            repoHorario.borrarColumnaHorario(TablaPlanificador, trabajadorHorario.getId(), (String) comboDia.getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrio un error inesperado\n" + e.getMessage());
        }
    }//GEN-LAST:event_btn_borrarr1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaHorario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new VistaHorario().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BTN_AÑADIR;
    private javax.swing.JTable TablaPlanificador;
    private javax.swing.JButton btn_aceptar;
    private javax.swing.JButton btn_borrarr1;
    private javax.swing.JComboBox<String> comboCentro;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboDia;
    private javax.swing.JComboBox<String> comboHoraFin;
    private javax.swing.JComboBox<String> comboHoraInicio;
    private javax.swing.JComboBox<String> comboMinutoFin;
    private javax.swing.JComboBox<String> comboMinutoInicio;
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
