package com.proyecto;

import java.io.FileNotFoundException;

public class Ex_ArchivoNoEncontrado extends FileNotFoundException {

    public Ex_ArchivoNoEncontrado(){};

    public String excErrorPersonalizado(){
        return "Archivo No Encontrado";
    }

}
