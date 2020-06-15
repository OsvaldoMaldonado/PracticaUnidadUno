package com.proyecto;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args ) throws SQLException{

        Scanner c = new Scanner(System.in);
        int opcion;

        do {


            String direccion;
            String rutaArchivo;
            System.out.println("----- Proyecto Unidad Uno -----");
            System.out.println("¿Que desea hacer?");
            System.out.println("Seleccionar Ruta de Archivos: ");
            do {
                System.out.println("Ingrese direccion del txt");
                direccion = c.next();
                rutaArchivo = CambioRutas.cambioRuta(direccion);
            } while (rutaArchivo == "");
            System.out.println("1.- Cargar Archivos de un XLSX");
            System.out.println("2.- Cargar Archivos de un TXT");
            System.out.println("3.- Base de datos local");
            System.out.println("4.- Base de datos temporal");
            System.out.println("");
            System.out.println("Seleccione: ");
            opcion = c.nextInt();

            switch (opcion) {
                case 1:
                    RunXLSX.lecturaXLSX(rutaArchivo);
                    break;
                case 2:
                    RunTXT.lecturaTXT(rutaArchivo);
                    break;
                case 3:
                    try {
                        RunDB.baseDeDatos();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 4:
                    RunSQLite.sql();
            }

        }while(opcion==0);
    }
}
