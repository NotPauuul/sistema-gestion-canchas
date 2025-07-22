package Clases;
import java.sql.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
/**
 *
 * @author Paul
 */
public class ConexionDB {
    private static final String DB_PATH = System.getProperty("user.home") + "/AppData/Local/GestionEscenarios/ProyectoDB.db";
    private static final String url = "jdbc:sqlite:" + DB_PATH;

    public ConexionDB() {
        verificarYCopiarDB(); 
    }

    private void verificarYCopiarDB() {
        try {
            File dbFile = new File(DB_PATH);
            File dbFolder = new File(dbFile.getParent());

            if (!dbFolder.exists()) {
                dbFolder.mkdirs();
                System.out.println("✔ Carpeta creada en: " + dbFolder.getAbsolutePath());
            }

            if (!dbFile.exists()) {
                InputStream is = getClass().getResourceAsStream("/DB/ProyectoDB.db");
                if (is == null) {
                    System.out.println("❌ No se encontró la base de datos en los recursos.");
                    return;
                }
                Files.copy(is, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("✔ Base de datos copiada a: " + DB_PATH);
            } else {
                System.out.println("✔ Base de datos ya existe en: " + DB_PATH);
            }
        } catch (Exception e) {
            System.out.println("❌ Error al copiar la base de datos: " + e.getMessage());
        }
    }
    
    public Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName("org.sqlite.JDBC"); 
            conexion = DriverManager.getConnection(url);
            System.out.println("Conexion exitosa a SQLite.");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
