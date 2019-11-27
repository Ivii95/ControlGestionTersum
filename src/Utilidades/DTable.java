/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author DisenoWeb
 */
public class DTable extends DefaultTableCellRenderer {

    public static String colorceldas = "Claro";

    @Override
    public Component getTableCellRendererComponent(JTable tabla, Object value, boolean selected, boolean hasFocus, int row, int column) {
        Color c = null;

        switch (colorceldas) {
            case "Claro":
                c = Color.LIGHT_GRAY;
                break;
            case "Oscuro":
                c = Color.DARK_GRAY;
                break;
            default:
                break;
        }
        try {
            if (column == 0) { //si es la columna 0 (que es la de las horas) entra aqui
                if (c.equals(Color.DARK_GRAY)) {
                    this.setBackground(Color.LIGHT_GRAY);
                    this.setForeground(Color.BLACK);
                } else {
                    this.setBackground(Color.DARK_GRAY);
                    this.setForeground(Color.WHITE);
                }

                this.setText(value.toString());
            } else { // Si no es la columna 0, es decir, todas las demas entra aqui.
                if (!selected) {
                    if (value == null || value.equals("")) { //si la celda o celdas que no estan seleccionadas estan vacias
                        this.setText("");
                        this.setBackground(Color.white);
                    } else { //si las celdas que no estan seleccionadas no estan vacias
                        if (c.equals(Color.DARK_GRAY)) {
                            this.setForeground(Color.white);
                        } else {
                            this.setForeground(Color.black);
                        }
                        this.setText(value.toString());
                        this.setBackground(c);

                    }
                }
            }
        } catch (Exception e) {

        }
        return this;
    }

}
