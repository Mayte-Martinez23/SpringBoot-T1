/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebamysql;
import java.sql.*;

/**
 *
 * @author DELL
 */
    
public class dbConnection {
    static String url = "jdbc:mysql://localhost:3306/donibax_db";
    static String user = "root";
    static String pass = "root";
    
    public static Connection conectar()
    {
        Connection con=null;
        try
        {
        con=DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }
    
}
