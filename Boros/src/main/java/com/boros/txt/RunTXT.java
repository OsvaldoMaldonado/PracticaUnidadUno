package com.boros.txt;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.boros.mysql.*;
import com.boros.sqlite.*;

public class RunTXT {

    public static void lecturaTXT(String archivo) throws SQLException {

        File ruta = null;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner c = new Scanner(System.in);
        String ruta_archivo;
        String terminar = "Si";
        int carga = 3;

        ArrayList<Aula_Equipo> aula_equipo = new ArrayList<>();
        ArrayList<Aulas> aulas = new ArrayList<>();
        ArrayList<Carrera> carrera = new ArrayList<>();
        ArrayList<Categorias_Equipo> categorias_equipo = new ArrayList<>();
        ArrayList<Disponibilidad> disponibilidad = new ArrayList<>();
        ArrayList<Equipo> equipo = new ArrayList<>();
        ArrayList<Grupo_Materia_Profesor> grupo_materia_profesor = new ArrayList<>();
        ArrayList<Grupos> grupos = new ArrayList<>();
        ArrayList<Login> login = new ArrayList<>();
        ArrayList<Materia_Usuario> materia_usuario = new ArrayList<>();
        ArrayList<Materias> materias = new ArrayList<>();
        ArrayList<Plan_Estudios> plan_estudios = new ArrayList<>();
        ArrayList<Prestamos> prestamos = new ArrayList<>();
        ArrayList<Uso_Aula_Grupo> uso_aula_grupo = new ArrayList<>();
        ArrayList<Usuarios> usuarios = new ArrayList<>();

            try {

                ruta_archivo = archivo;
                ruta = new File(ruta_archivo);
                fr = new FileReader(ruta);
                br = new BufferedReader(fr);

                String linea;

                while ((linea = br.readLine()) != null) {
                    int tipo = linea.indexOf(",", 0);
                    String tipo_clase = "";
                    for (int j = 0; j < tipo; j++) {
                        tipo_clase += linea.charAt(j);
                    }
                    if (tipo_clase.equals("aula_equipo")) {
                        Aula_Equipo a = new Aula_Equipo();
                        String id_equipo = "";
                        int cont = linea.indexOf(",", tipo + 1);
                        for (int j = tipo + 1; j < cont; j++) {
                            id_equipo += linea.charAt(j);
                        }
                        a.setId_equipo(Integer.valueOf(id_equipo));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String id_aula = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            id_aula += linea.charAt(j);
                        }
                        a.setId_aula(id_aula);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String cantidad = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            cantidad += linea.charAt(j);
                        }
                        a.setCantidad(Integer.valueOf(cantidad));
                        aula_equipo.add(a);
                    } else if (tipo_clase.equals("aulas")) {
                        Aulas a = new Aulas();
                        int cont = linea.indexOf(",", tipo + 1);
                        String id_aula = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            id_aula += linea.charAt(j);
                        }
                        a.setId_aula(id_aula);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String nombre = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            nombre += linea.charAt(j);
                        }
                        a.setNombre(nombre);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String tipo_aula = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            tipo_aula += linea.charAt(j);
                        }
                        a.setTipo(tipo_aula);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String capacidad = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            capacidad += linea.charAt(j);
                        }
                        a.setCapacidad(Integer.valueOf(capacidad));
                        aulas.add(a);
                    } else if (tipo_clase.equals("carrera")) {
                        Carrera a = new Carrera();
                        int cont = linea.indexOf(",", tipo + 1);
                        String id_carrera = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            id_carrera += linea.charAt(j);
                        }
                        a.setId_carrera(Integer.valueOf(id_carrera));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String nombre_carrera = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            nombre_carrera += linea.charAt(j);
                        }
                        a.setNombre_carrera(nombre_carrera);
                        carrera.add(a);
                    } else if (tipo_clase.equals("categorias_equipo")) {
                        Categorias_Equipo a = new Categorias_Equipo();
                        int cont = linea.indexOf(",", tipo + 1);
                        String id = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            id += linea.charAt(j);
                        }
                        a.setId(Integer.valueOf(id));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String nombre = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            nombre += linea.charAt(j);
                        }
                        a.setNombre(nombre);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String descripcion = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            descripcion += linea.charAt(j);
                        }
                        a.setDescripcion(descripcion);
                        categorias_equipo.add(a);
                    } else if (tipo_clase.equals("disponibilidad")) {
                        Disponibilidad a = new Disponibilidad();
                        int cont = linea.indexOf(",", tipo + 1);
                        String dia = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            dia += linea.charAt(j);
                        }
                        a.setDia(Integer.parseInt(dia));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String espacio_tiempo = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            espacio_tiempo += linea.charAt(j);
                        }
                        a.setEspacio_tiempo(Integer.parseInt(espacio_tiempo));
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String clv_usuario = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        disponibilidad.add(a);
                    } else if (tipo_clase.equals("equipo")) {
                        Equipo a = new Equipo();
                        int cont = linea.indexOf(",", tipo + 1);
                        String id = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            id += linea.charAt(j);
                        }
                        a.setId(Integer.valueOf(id));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String nombre = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            nombre += linea.charAt(j);
                        }
                        a.setNombre(nombre);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String descripcion = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            descripcion += linea.charAt(j);
                        }
                        a.setDescripcion(descripcion);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String id_categoria = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            id_categoria += linea.charAt(j);
                        }
                        a.setId_categoria(Integer.valueOf(id_categoria));
                        equipo.add(a);
                    } else if (tipo_clase.equals("grupo_materia_profesor")) {
                        Grupo_Materia_Profesor a = new Grupo_Materia_Profesor();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_grupo = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_grupo += linea.charAt(j);
                        }
                        a.setClv_grupo(clv_grupo);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String clv_materia = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            clv_materia += linea.charAt(j);
                        }
                        a.setClv_materia(clv_materia);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String clv_usuario = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        grupo_materia_profesor.add(a);
                    } else if (tipo_clase.equals("grupos")) {
                        Grupos a = new Grupos();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_grupo = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_grupo += linea.charAt(j);
                        }
                        a.setClv_grupo(clv_grupo);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String turno = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            turno += linea.charAt(j);
                        }
                        a.setTurno(Boolean.parseBoolean(turno));
                        grupos.add(a);
                    } else if (tipo_clase.equals("login")) {
                        Login a = new Login();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_usuario = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String pass_usuario = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            pass_usuario += linea.charAt(j);
                        }
                        a.setPass_usuario(pass_usuario);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String tipo_usuario = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            tipo_usuario += linea.charAt(j);
                        }
                        a.setTipo_usuario(tipo_usuario);
                        login.add(a);
                    } else if (tipo_clase.equals("materia_usuario")) {
                        Materia_Usuario a = new Materia_Usuario();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_materia = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_materia += linea.charAt(j);
                        }
                        a.setClv_materia(clv_materia);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String clv_plan = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            clv_plan += linea.charAt(j);
                        }
                        a.setClv_plan(clv_plan);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String clv_usuario = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String puntos_confianza = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            puntos_confianza += linea.charAt(j);
                        }
                        a.setPuntos_confianza(Integer.valueOf(puntos_confianza));
                        int cont4 = linea.indexOf(",", cont3 + 1);
                        String puntos_director = "";
                        for (int j = cont3 + 1; j < cont4; j++) {
                            puntos_director += linea.charAt(j);
                        }
                        a.setPuntos_director(Integer.valueOf(puntos_director));
                        materia_usuario.add(a);
                    } else if (tipo_clase.equals("materias")) {
                        Materias a = new Materias();
                        int cont = linea.indexOf(",", tipo + 1);
                        String nombre_materia = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            nombre_materia += linea.charAt(j);
                        }
                        a.setNombre_materia(nombre_materia);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String clv_materia = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            clv_materia += linea.charAt(j);
                        }
                        a.setClv_materia(clv_materia);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String creditos = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            creditos += linea.charAt(j);
                        }
                        a.setCreditos(Integer.valueOf(creditos));
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String cuatrimestre = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            cuatrimestre += linea.charAt(j);
                        }
                        a.setCuatrimestre(Integer.parseInt(cuatrimestre));
                        int cont4 = linea.indexOf(",", cont3 + 1);
                        String posicion = "";
                        for (int j = cont3 + 1; j < cont4; j++) {
                            posicion += linea.charAt(j);
                        }
                        a.setPosicion(Integer.parseInt(posicion));
                        int cont5 = linea.indexOf(",", cont4 + 1);
                        String clv_plan = "";
                        for (int j = cont4 + 1; j < cont5; j++) {
                            clv_plan += linea.charAt(j);
                        }
                        a.setClv_plan(clv_plan);
                        int cont6 = linea.indexOf(",", cont5 + 1);
                        String horas_x_semana = "";
                        for (int j = cont5 + 1; j < cont6; j++) {
                            horas_x_semana += linea.charAt(j);
                        }
                        a.setHoras_x_semana(Integer.parseInt(horas_x_semana));
                        int cont7 = linea.indexOf(",", cont6 + 1);
                        String tipo_materia = "";
                        for (int j = cont6 + 1; j < cont7; j++) {
                            tipo_materia += linea.charAt(j);
                        }
                        a.setTipo_materia(tipo_materia);
                        materias.add(a);
                    } else if (tipo_clase.equals("plan_estudios")) {
                        Plan_Estudios a = new Plan_Estudios();
                        String clv_plan = "";
                        int cont = linea.indexOf(",", tipo + 1);
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_plan += linea.charAt(j);
                        }
                        a.setClv_plan(clv_plan);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String nombre_plan = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            nombre_plan += linea.charAt(j);
                        }
                        a.setNombre_plan(nombre_plan);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String nivel = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            nivel += linea.charAt(j);
                        }
                        a.setNivel(nivel);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String id_carrera = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            id_carrera += linea.charAt(j);
                        }
                        a.setId_carrera(Integer.parseInt(id_carrera));
                        plan_estudios.add(a);
                    } else if (tipo_clase.equals("prestamos")) {
                        Prestamos a = new Prestamos();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_usuario = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String id_carrera = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            id_carrera += linea.charAt(j);
                        }
                        a.setId_carrera(Integer.parseInt(id_carrera));
                        prestamos.add(a);
                    } else if (tipo_clase.equals("uso_aula_grupo")) {
                        Uso_Aula_Grupo a = new Uso_Aula_Grupo();
                        int cont = linea.indexOf(",", tipo + 1);
                        String dia = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            dia += linea.charAt(j);
                        }
                        a.setDia(Integer.parseInt(dia));
                        int cont1 = linea.indexOf(",", cont + 1);
                        String espacio_tiempo = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            espacio_tiempo += linea.charAt(j);
                        }
                        a.setEspacio_tiempo(Integer.parseInt(espacio_tiempo));
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String id_aula = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            id_aula += linea.charAt(j);
                        }
                        a.setId_aula(id_aula);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String clv_grupo = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            clv_grupo += linea.charAt(j);
                        }
                        a.setClv_grupo(clv_grupo);
                        int cont4 = linea.indexOf(",", cont3 + 1);
                        String clv_materia = "";
                        for (int j = cont3 + 1; j < cont4; j++) {
                            clv_materia += linea.charAt(j);
                        }
                        a.setClv_materia(clv_materia);
                        uso_aula_grupo.add(a);
                    } else if (tipo_clase.equals("usuarios")) {
                        Usuarios a = new Usuarios();
                        int cont = linea.indexOf(",", tipo + 1);
                        String clv_usuario = "";
                        for (int j = tipo + 1; j < cont; j++) {
                            clv_usuario += linea.charAt(j);
                        }
                        a.setClv_usuario(clv_usuario);
                        int cont1 = linea.indexOf(",", cont + 1);
                        String id_carrera = "";
                        for (int j = cont + 1; j < cont1; j++) {
                            id_carrera += linea.charAt(j);
                        }
                        int aux = Integer.valueOf(id_carrera);
                        a.setId_carrera(aux);
                        int cont2 = linea.indexOf(",", cont1 + 1);
                        String nombre_usuario = "";
                        for (int j = cont1 + 1; j < cont2; j++) {
                            nombre_usuario += linea.charAt(j);
                        }
                        a.setNombre_usuario(nombre_usuario);
                        int cont3 = linea.indexOf(",", cont2 + 1);
                        String nivel_ads = "";
                        for (int j = cont2 + 1; j < cont3; j++) {
                            nivel_ads += linea.charAt(j);
                        }
                        a.setNivel_ads(nivel_ads);
                        int cont4 = linea.indexOf(",", cont3 + 1);
                        String contrato = "";
                        for (int j = cont3 + 1; j < cont4; j++) {
                            contrato += linea.charAt(j);
                        }
                        a.setContrato(contrato);
                        usuarios.add(a);
                    }
                }
                System.out.println("*Lectura Realizada*");
                System.out.println("¿Que desea hacer?");
                System.out.println("1.- Cargar Base de Datos");
                System.out.println("2.- Cargar Base de Datos Temporal");
                carga = c.nextInt();
            } catch (FileNotFoundException e) {
                System.out.println("No se Encontro el Archivo");
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero");
                }
            }




        String tabla="", dato1="", dato2="", dato3="", dato4="", dato5="", dato6="", dato7="", dato8="";
        int numero, numero1, numero2, numero3;
        switch (carga){
            case 1:
                for (int i = 0; i < aulas.size(); i++){
                    dato1 = aulas.get(i).getId_aula();
                    dato2 = aulas.get(i).getNombre();
                    dato3 = aulas.get(i).getTipo();
                    dato4 = String.valueOf(aulas.get(i).getCapacidad());
                    numero = 1;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < aula_equipo.size(); i++){
                    dato1 = String.valueOf(aula_equipo.get(i).getId_equipo());
                    dato2 = aula_equipo.get(i).getId_aula();
                    dato3 = String.valueOf(aula_equipo.get(i).getCantidad());
                    numero = 2;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < carrera.size(); i++){
                    dato1 = String.valueOf(carrera.get(i).getId_carrera());
                    dato2 = carrera.get(i).getNombre_carrera();
                    numero = 3;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < categorias_equipo.size(); i++){
                    dato1 = String.valueOf(categorias_equipo.get(i).getId());
                    dato2 = categorias_equipo.get(i).getNombre();
                    dato3 = categorias_equipo.get(i).getDescripcion();
                    numero = 4;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < disponibilidad.size(); i++){
                    dato1 = String.valueOf(disponibilidad.get(i).getDia());
                    dato2 = String.valueOf(disponibilidad.get(i).getEspacio_tiempo());
                    dato3 = disponibilidad.get(i).getClv_usuario();
                    numero = 5;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < equipo.size(); i++){
                    dato1 = String.valueOf(equipo.get(i).getId());
                    dato2 = String.valueOf(equipo.get(i).getId_categoria());
                    dato3 = equipo.get(i).getNombre();
                    dato4 = equipo.get(i).getDescripcion();
                    numero = 6;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < grupos.size(); i++){
                    dato1 = String.valueOf(grupos.get(i).getClv_grupo());
                    dato2 = String.valueOf(grupos.get(i).getTurno());
                    numero = 7;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < grupo_materia_profesor.size(); i++){
                    dato1 = String.valueOf(grupo_materia_profesor.get(i).getClv_grupo());
                    dato2 = grupo_materia_profesor.get(i).getClv_materia();
                    dato3 = grupo_materia_profesor.get(i).getClv_usuario();
                    numero = 8;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < login.size(); i++){
                    dato1 = String.valueOf(login.get(i).getClv_usuario());
                    dato2 = login.get(i).getPass_usuario();
                    dato3 = login.get(i).getTipo_usuario();
                    numero = 9;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i <  materias.size(); i++){
                    dato1 = String.valueOf(materias.get(i).getNombre_materia());
                    dato2 = materias.get(i).getClv_materia();
                    dato3 = String.valueOf(materias.get(i).getCreditos());
                    dato4 = String.valueOf(materias.get(i).getCuatrimestre());
                    dato5 = String.valueOf(materias.get(i).getPosicion());
                    dato6 = materias.get(i).getClv_plan();
                    dato7 = String.valueOf(materias.get(i).getHoras_x_semana());
                    dato8 = materias.get(i).getTipo_materia();
                    numero = 10;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < materia_usuario.size(); i++){
                    dato1 = String.valueOf(materia_usuario.get(i).getClv_materia());
                    dato2 = materia_usuario.get(i).getClv_plan();
                    dato3 = materia_usuario.get(i).getClv_usuario();
                    dato4 = String.valueOf(materia_usuario.get(i).getPuntos_confianza());
                    dato5 = String.valueOf(materia_usuario.get(i).getPuntos_director());
                    numero = 11;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < plan_estudios.size(); i++){
                    dato1 = String.valueOf(plan_estudios.get(i).getClv_plan());
                    dato2 = plan_estudios.get(i).getNombre_plan();
                    dato3 = plan_estudios.get(i).getNivel();
                    dato4 = String.valueOf(plan_estudios.get(i).getId_carrera());
                    numero = 12;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < prestamos.size(); i++){
                    dato1 = String.valueOf(prestamos.get(i).getClv_usuario());
                    dato2 = String.valueOf(prestamos.get(i).getId_carrera());
                    numero = 13;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < uso_aula_grupo.size(); i++){
                    dato1 = String.valueOf(uso_aula_grupo.get(i).getDia());
                    dato2 = String.valueOf(uso_aula_grupo.get(i).getEspacio_tiempo());
                    dato3 = uso_aula_grupo.get(i).getId_aula();
                    dato4 = uso_aula_grupo.get(i).getClv_grupo();
                    dato5 = uso_aula_grupo.get(i).getClv_materia();
                    numero = 14;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
                for (int i = 0; i < usuarios.size(); i++){
                    dato1 = String.valueOf(usuarios.get(i).getClv_usuario());
                    dato2 = String.valueOf(usuarios.get(i).getId_carrera());
                    dato3 = usuarios.get(i).getNombre_usuario();
                    dato4 = usuarios.get(i).getNivel_ads();
                    dato5 = usuarios.get(i).getContrato();
                    numero = 15;
                    CRUD.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                }
            break;
            case 2:
                for (int i = 0; i < aulas.size(); i++){
                    dato1 = aulas.get(i).getId_aula();
                    dato2 = aulas.get(i).getNombre();
                    dato3 = aulas.get(i).getTipo();
                    numero = aulas.get(i).getCapacidad();
                    SQLite.insercion_aulas(dato1, dato2, dato3, numero, "" , "", SQLite.creacion_volatil());
                }
                for (int i = 0; i < aula_equipo.size(); i++){
                    numero = aula_equipo.get(i).getId_equipo();
                    dato2 = aula_equipo.get(i).getId_aula();
                    numero1 = aula_equipo.get(i).getCantidad();
                    SQLite.insercion_aula_equipo(numero, dato2, numero1, SQLite.creacion_volatil());
                }
                for (int i = 0; i < carrera.size(); i++){
                    dato1 = String.valueOf(carrera.get(i).getId_carrera());
                    dato2 = carrera.get(i).getNombre_carrera();
                    SQLite.insercion_carrera(dato1, dato2, SQLite.creacion_volatil());
                }
                for (int i = 0; i < categorias_equipo.size(); i++){
                    numero = categorias_equipo.get(i).getId();
                    dato2 = categorias_equipo.get(i).getNombre();
                    dato3 = categorias_equipo.get(i).getDescripcion();
                    SQLite.insercion_categorias_equipo(numero, dato2, dato3, SQLite.creacion_volatil());
                }
                for (int i = 0; i < disponibilidad.size(); i++){
                    numero = disponibilidad.get(i).getDia();
                    numero1 = disponibilidad.get(i).getEspacio_tiempo();
                    dato3 = disponibilidad.get(i).getClv_usuario();
                    SQLite.insercion_disponibilidad(numero,numero1,dato3,SQLite.creacion_volatil());
                }
                for (int i = 0; i < equipo.size(); i++){
                    numero = equipo.get(i).getId();
                    numero1 = equipo.get(i).getId_categoria();
                    dato3 = equipo.get(i).getNombre();
                    dato4 = equipo.get(i).getDescripcion();
                    SQLite.insercion_equipo(numero,numero1, dato3, dato4, SQLite.creacion_volatil());
                }
                for (int i = 0; i < grupos.size(); i++){
                    dato1 = grupos.get(i).getClv_grupo();
                    boolean b = grupos.get(i).getTurno();
                    SQLite.insercion_grupo(dato1, b, SQLite.creacion_volatil());
                }
                for (int i = 0; i < grupo_materia_profesor.size(); i++){
                    dato1 = String.valueOf(grupo_materia_profesor.get(i).getClv_grupo());
                    dato2 = grupo_materia_profesor.get(i).getClv_materia();
                    dato3 = grupo_materia_profesor.get(i).getClv_usuario();
                    SQLite.insercion_materia_profesor(dato1, dato2, dato3, SQLite.creacion_volatil());
                }
                for (int i = 0; i < login.size(); i++){
                    dato1 = String.valueOf(login.get(i).getClv_usuario());
                    dato2 = login.get(i).getPass_usuario();
                    dato3 = login.get(i).getTipo_usuario();
                    SQLite.insercion_login(dato1,dato2, SQLite.creacion_volatil());
                }
                for (int i = 0; i <  materias.size(); i++){
                    dato1 = String.valueOf(materias.get(i).getNombre_materia());
                    dato2 = materias.get(i).getClv_materia();
                    numero = materias.get(i).getCreditos();
                    numero1 = materias.get(i).getCuatrimestre();
                    numero2 = materias.get(i).getPosicion();
                    dato6 = materias.get(i).getClv_plan();
                    numero3 = materias.get(i).getHoras_x_semana();
                    dato8 = materias.get(i).getTipo_materia();
                    SQLite.insercion_materia(dato1, dato2, numero, numero1, numero2, dato6, numero3, dato8, SQLite.creacion_volatil());
                }
                for (int i = 0; i < materia_usuario.size(); i++){
                    dato1 = String.valueOf(materia_usuario.get(i).getClv_materia());
                    dato2 = materia_usuario.get(i).getClv_plan();
                    dato3 = materia_usuario.get(i).getClv_usuario();
                    numero = materia_usuario.get(i).getPuntos_confianza();
                    numero1 = materia_usuario.get(i).getPuntos_director();
                    SQLite.insercion_materia_usuarios(dato1, dato2,dato3,numero,numero1, SQLite.creacion_volatil());
                }
                for (int i = 0; i < plan_estudios.size(); i++){
                    dato1 = String.valueOf(plan_estudios.get(i).getClv_plan());
                    dato2 = plan_estudios.get(i).getNombre_plan();
                    dato3 = plan_estudios.get(i).getNivel();
                    numero = plan_estudios.get(i).getId_carrera();
                    SQLite.insercion_plan_estudios(dato1,dato2,dato3, numero, SQLite.creacion_volatil());
                }
                for (int i = 0; i < prestamos.size(); i++){
                    dato1 = String.valueOf(prestamos.get(i).getClv_usuario());
                    numero = prestamos.get(i).getId_carrera();
                    SQLite.insercion_prestamos(dato1, numero,SQLite.creacion_volatil());
                }
                for (int i = 0; i < uso_aula_grupo.size(); i++){
                    numero = uso_aula_grupo.get(i).getDia();
                    numero1 = uso_aula_grupo.get(i).getEspacio_tiempo();
                    dato3 = uso_aula_grupo.get(i).getId_aula();
                    dato4 = uso_aula_grupo.get(i).getClv_grupo();
                    dato5 = uso_aula_grupo.get(i).getClv_materia();
                    SQLite.insercion_uso_aula_grupo(numero, numero1, dato3, dato4, dato5, SQLite.creacion_volatil());
                }
                for (int i = 0; i < usuarios.size(); i++){
                    dato1 = String.valueOf(usuarios.get(i).getClv_usuario());
                    numero = usuarios.get(i).getId_carrera();
                    dato3 = usuarios.get(i).getNombre_usuario();
                    dato4 = usuarios.get(i).getNivel_ads();
                    dato5 = usuarios.get(i).getContrato();
                    SQLite.insercion_usuarios(dato1, numero, dato3, dato4, dato5, SQLite.creacion_volatil());
                }
                break;
            case 3:
                break;
        }

        return;
    }
}
