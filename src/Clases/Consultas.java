package Clases;
import Formularios.*;
import java.sql.*;
import javax.swing.*;

public class Consultas {
    
    public void GuardarUsuario(String name, String user, String pass) {
        ConexionDB con = new ConexionDB();
        String query = "INSERT INTO Usuarios (Nombre,Usuario,Contraseña) VALUES (?,?,?)";
        try (Connection conexion = con.conectar(); 
             PreparedStatement pst = conexion.prepareStatement(query)) {
             
            pst.setString(1, name);
            pst.setString(2, user);
            pst.setString(3, pass);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registrado Correctamente!");
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error al guardar el usuario: " + e.getMessage());
        }
    }
    
    public boolean Acceso(String user, String pass) {
        ConexionDB db = new ConexionDB();
        boolean conf = false;
        
        String query = "SELECT Nombre FROM Usuarios WHERE Usuario = ? AND Contraseña = ?";
        
        try (Connection con = db.conectar(); 
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, user);
            pst.setString(2, pass);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    String Nombre = rs.getString("Nombre");
                    JOptionPane.showMessageDialog(null, "Acceso correcto, Bienvenid@ " + Nombre);
                    conf = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder: " + e.getMessage());
        }
        
        return conf;
    }
}
