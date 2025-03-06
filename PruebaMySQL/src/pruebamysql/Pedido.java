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

public class Pedido {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/donibax_db"; 
        String usuario = "root";
        String contraseña = "root";

        try (Connection conexion = DriverManager.getConnection(url,user,pass);
             Statement sentencia = conexion.createStatement()) {

            String sql = "CREATE TABLE pedido (" +
                         "ID INT PRIMARY KEY AUTO_INCREMENT," +
                         "recibo_id INT," +
                         "inventario_id INT," +
                         "cantidad INT, " +
                         "precio_unitario DECIMAL(10,2)," +
                         "FOREIGN KEY(recibo_id) REFERENCES recibo(id), " +
                         "FOREIGN KEY(inventario_id) REFERENCES inventario(id) " +
                         ")";
       

            sentencia.executeUpdate(sql);
            System.out.println("Tabla creada exitosamente.");

        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }
}