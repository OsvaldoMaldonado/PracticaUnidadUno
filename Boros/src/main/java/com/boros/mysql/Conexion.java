package com.boros.mysql;

import com.boros.main.Main;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {

    public static String usuario= Main.usuario;
    public static String contrasenia= Main.contrasenia;

    public static Connection conexion(){
        Connection conect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios",usuario,contrasenia);

        } catch (Exception e) {
            System.out.println("No se pudo establecer la conexion a la base de datos");;
        }
        return conect;
    }
}
