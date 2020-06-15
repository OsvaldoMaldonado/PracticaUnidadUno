package com.proyecto;


import com.mysql.jdbc.Connection;

import java.sql.DriverManager;


public class Conexion {

    Connection conect = null;

    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/horarios","root","");
            if(conect!=null){

                /*Statement s = conect.createStatement();
                ResultSet rs = s.executeQuery ("sentencia SQL");
                while (rs.next())
                {
                    System.out.println (rs.getInt (1) + " " + rs.getString (2));
                }*/
            }
        } catch (Exception e) {
            System.out.println("No se pudo establecer la conexion a la base de datos");;
        }
        return conect;
    }
}
