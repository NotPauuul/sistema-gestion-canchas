/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
/**
 *
 * @author Paul
 */
public class Colores extends DefaultTableCellRenderer {
    @Override
    public void setValue(Object value) {
        super.setValue(value);

        if (value != null && value.equals("Disponible")) {
            setBackground(Color.GREEN); 
            setForeground(Color.WHITE); 
        } else if (value != null && value.equals("Ocupado")) {
            setBackground(Color.RED); 
            setForeground(Color.WHITE); 
        } else {
            setBackground(Color.WHITE); 
            setForeground(Color.BLACK); 
        }
    }
}
