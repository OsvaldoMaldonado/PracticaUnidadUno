package com.boros.mysql;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class Conexion {

    Connection conect = null;

    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios","root","");

        } catch (Exception e) {
            System.out.println("No se pudo establecer la conexion a la base de datos");;
        }
        return conect;
    }
}
