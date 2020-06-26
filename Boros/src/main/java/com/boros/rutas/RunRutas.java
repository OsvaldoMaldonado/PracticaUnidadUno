package com.boros.rutas;

import com.boros.main.Main;
import java.io.*;
import java.util.Scanner;

public class RunRutas {

    public static String cambioRuta(){

        String rutaR = "";
        try {
            File ruta = null;
            FileReader fr = null;
            BufferedReader br = null;

            ruta = new File("src/main/resources/ruta.txt");
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            String usuario = "";
            String contrasenia = "";
            String rutaTXT = "";
            String rutaXLSX = "";

            String linea;

            while ((linea = br.readLine()) != null) {
                int tipo = linea.indexOf(",", 0);
                for (int j = 0; j < tipo; j++) {
                    usuario += linea.charAt(j);
                }
                int cont = linea.indexOf(",", tipo + 1);
                for (int j = tipo + 1; j < cont; j++) {
                    contrasenia+=linea.charAt(j);
                }
                int cont1 = linea.indexOf(",", cont + 1);
                for (int j = cont + 1; j < cont1; j++) {
                    rutaTXT += linea.charAt(j);
                }
                int cont2 = linea.indexOf(",", cont1 + 1);
                for (int j = cont1 + 1; j < cont2; j++) {
                    rutaXLSX += linea.charAt(j);
                }
            }
            Main.usuario = usuario;
            Main.contrasenia = contrasenia;
            System.out.println(usuario);
            System.out.println(contrasenia);
            Main.rutaTXT = rutaTXT;
            Main.rutaXLSX = rutaXLSX;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutaR;
    }
}
