/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

/**
 *
 * @author Paul
 */
public class Links extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (value != null && value instanceof String) {
            String url = (String) value;
            label.setText("<html><a href=''>" + url + "</a></html>");
            label.setForeground(Color.BLUE); 
            label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); 
        }
        return label;
    }
    
    
}