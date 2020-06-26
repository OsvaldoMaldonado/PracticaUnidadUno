package com.boros.main;

import com.boros.mysql.*;
import com.boros.xlsx.*;
import com.boros.txt.*;
import com.boros.rutas.*;
import com.boros.sqlite.*;
import com.mysql.jdbc.Connection;

import java.sql.SQLException;

public class Main {

    public static String usuario;
    public static String contrasenia;
    public static String rutaTXT;
    public static String rutaXLSX;

    public static void main(String[] args) throws SQLException {


        System.out.println("---- Lectura de Rutas ----");
        System.out.println("");
        RunRutas.cambioRuta();
        System.out.println("---- Lectura de TXT ----");
        RunTXT.lecturaTXT(rutaTXT);
        System.out.println("");
        System.out.println("---- Lectura XLSX ----");
        System.out.println("");
        RunXLSX.lecturaXLSX(rutaXLSX);
        System.out.println("");
        Connection connect = Conexion.conexion();
        if(connect != null){
            System.out.println("---- CRUD de MySQL ----");
            try {
                RunDB.baseDeDatos();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            System.out.println("No se pudo realizar el CRUD de MySQL debido a un fallo en la conexion");
        }

    }


}
