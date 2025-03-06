/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebamysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import static pruebamysql.dbConnection.pass;
import static pruebamysql.dbConnection.url;
import static pruebamysql.dbConnection.user;

public class Ventas {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/donibax_db"; 
        String usuario = "root";
        String contraseña = "root";

        try (Connection conexion = DriverManager.getConnection(url,user,pass);
             Statement sentencia = conexion.createStatement()) {

            String sql = "CREATE TABLE ventas (" +
                         "ID INT PRIMARY KEY AUTO_INCREMENT," +
                         "pedido_id INT," +
                         "fecha DATE," +
                         "total DECIMAL(10, 2), " +
                         "FOREIGN KEY (pedido_id) REFERENCES pedido(id)" +
                         ")";

            sentencia.executeUpdate(sql);
            System.out.println("Tabla creada exitosamente.");

        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}