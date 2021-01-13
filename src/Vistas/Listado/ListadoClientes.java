/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Listado;

import Modelo.Entidades.Centro;
import Modelo.Entidades.Cliente;
import Modelo.Repository.ClienteRepository;
import Utilidades.UtilidadesPantalla;

/**
 *
 * @author usuario
 */
public class ListadoClientes extends javax.swing.JFrame {

    ClienteRepository repoCliente;
    Centro centroListadoTrabajadores;
    private Centro centroListadoClientes;

//   public ListadoClientes(Centro centro) {
//        initComponents();
//       this.centroListadoClientes = centro;
//        UtilidadesPantalla.centrarTablas(listado_clientes);
//        UtilidadesPantalla.resolucionPantalla(this);
//        listado_clientes.getColumnModel().getColumn(0).setMaxWidth(0);
//        listado_clientes.getColumnModel().getColumn(0).setMinWidth(0);
//        listado_clientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
//        listado_clientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
//        utilidades.rellenarTabla(listado_clientes, "clientes", "WHERE codigo_centro=''");
// 
//    }
    public ListadoClientes() {
        initComponents();
        repoCliente = new ClienteRepository();
        UtilidadesPantalla.centrarTablas(listado_clientes);
        UtilidadesPantalla.resolucionPantalla(this);
        listado_clientes.getColumnModel().getColumn(0).setMaxWidth(0);
        listado_clientes.getColumnModel().getColumn(0).setMinWidth(0);
        listado_clientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        listado_clientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        repoCliente.rellenarTablaDefault(listado_clientes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listado_clientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1360, 762));
        setSize(new java.awt.Dimension(1360, 762));

        listado_clientes.setAutoCreateRowSorter(true);
        listado_clientes.setBackground(new java.awt.Color(204, 204, 204));
        listado_clientes.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        listado_clientes.setForeground(new java.awt.Color(51, 51, 51));
        listado_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "NOMBRE", "APELLIDOS"
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
        listado_clientes.setRowHeight(30);
        listado_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listado_clientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listado_clientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listado_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listado_clientesMouseClicked
        int id_cliente = 0;
        Cliente cliente = null;
        id_cliente = (Integer) (listado_clientes.getValueAt(listado_clientes.getSelectedRow(), 0));
        cliente = repoCliente.getById(id_cliente);
        Listado listar = new Listado();
        listar.ListarCliente(cliente.getCodigo());
        /*for (int i = 0; i < utilidades.lista_de_clientes.size(); i++) {
            if (utilidades.lista_de_clientes.get(i).getId() == id_cliente) {
                cliente = utilidades.lista_de_clientes.get(i);
            }
        }*/
        //FichaCliente ficha = new FichaCliente(this, rootPaneCheckingEnabled, cliente);
        //ficha.setVisible(true);
    }//GEN-LAST:event_listado_clientesMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ListadoClientes().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listado_clientes;
    // End of variables declaration//GEN-END:variables
}
