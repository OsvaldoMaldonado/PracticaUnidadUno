package com.proyecto;

import java.io.*;
import java.util.Scanner;

public class CambioRutas {

    public static String cambioRuta(String ruta_archivo){

        String rutaR = "";
        try {
            File ruta = null;
            FileReader fr = null;
            BufferedReader br = null;
            Scanner c = new Scanner(System.in);


            ruta = new File(ruta_archivo);
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                rutaR += linea;
            }
            System.out.println(rutaR);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rutaR;
    }
}
