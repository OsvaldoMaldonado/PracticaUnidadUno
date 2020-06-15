package com.proyecto;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RunXLSX {

    public static void lecturaXLSX(String archivo) throws SQLException {

        File ruta = null;
        FileReader fr = null;
        BufferedReader br = null;
        Scanner c = new Scanner(System.in);
        String tipoArchivo;
        String terminar = "Si";

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

        int longitud;
            try{
                ruta = new File(archivo);
                longitud = archivo.length();
                tipoArchivo = archivo.substring(longitud-4,longitud);

                if(tipoArchivo.equals("xlsx")){
                    FileInputStream file = new FileInputStream(new File(archivo));
                    XSSFWorkbook worbook = new XSSFWorkbook(file);
                    XSSFSheet sheet = worbook.getSheetAt(0);
                    Iterator<Row> rowIterator = sheet.iterator();
                    Row row;
                    Aula_Equipo au_eq;
                    Aulas au;
                    Carrera ca;
                    Categorias_Equipo ca_eq;
                    Disponibilidad di;
                    Equipo eq;
                    Grupo_Materia_Profesor gr_ma_pr;
                    Grupos gr;
                    Login lo;
                    Materia_Usuario ma_us;
                    Materias ma;
                    Plan_Estudios pl_es;
                    Prestamos pr;
                    Uso_Aula_Grupo us_au_gr;
                    Usuarios us;

                    while (rowIterator.hasNext()) {
                        row = rowIterator.next();
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell cell = cellIterator.next();
                        String tipo = cell.getStringCellValue();
                        if(tipo.equals("aula_equipo")){
                            au_eq = new Aula_Equipo();
                            cell = cellIterator.next();
                            au_eq.setId_equipo(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            au_eq.setId_aula(cell.getStringCellValue());
                            cell = cellIterator.next();
                            au_eq.setCantidad(Integer.parseInt(cell.getStringCellValue()));
                            aula_equipo.add(au_eq);
                        }
                        else if(tipo.equals("aulas")){
                            au = new Aulas();
                            cell = cellIterator.next();
                            au.setId_aula(cell.getStringCellValue());
                            cell = cellIterator.next();
                            au.setNombre(cell.getStringCellValue());
                            cell = cellIterator.next();
                            au.setTipo(cell.getStringCellValue());
                            cell = cellIterator.next();
                            au.setCapacidad(Integer.parseInt(cell.getStringCellValue()));

                            aulas.add(au);
                        }
                        else if(tipo.equals("carreras")){
                            ca = new Carrera();
                            cell = cellIterator.next();
                            ca.setId_carrera(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ca.setNombre_carrera(cell.getStringCellValue());

                            carrera.add(ca);
                        }
                        else if(tipo.equals("categorias_equipo")){
                            ca_eq = new Categorias_Equipo();
                            cell = cellIterator.next();
                            ca_eq.setId(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ca_eq.setNombre(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ca_eq.setDescripcion(cell.getStringCellValue());
                            categorias_equipo.add(ca_eq);
                        }
                        else if(tipo.equals("disponibilidad")){
                            di = new Disponibilidad();
                            cell = cellIterator.next();
                            di.setDia(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            di.setEspacio_tiempo(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            di.setClv_usuario(cell.getStringCellValue());
                            disponibilidad.add(di);
                        }
                        else if(tipo.equals("equipo")){
                            eq = new Equipo();
                            cell = cellIterator.next();
                            eq.setId(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            eq.setNombre(cell.getStringCellValue());
                            cell = cellIterator.next();
                            eq.setDescripcion(cell.getStringCellValue());
                            cell = cellIterator.next();
                            eq.setId_categoria(Integer.parseInt(cell.getStringCellValue()));
                            equipo.add(eq);
                        }
                        else if(tipo.equals("grupo_materia_profesor")){
                            gr_ma_pr = new Grupo_Materia_Profesor();
                            cell = cellIterator.next();
                            gr_ma_pr.setClv_grupo(cell.getStringCellValue());
                            cell = cellIterator.next();
                            gr_ma_pr.setClv_materia(cell.getStringCellValue());
                            cell = cellIterator.next();
                            gr_ma_pr.setClv_usuario(cell.getStringCellValue());
                            grupo_materia_profesor.add(gr_ma_pr);
                        }
                        else if(tipo.equals("grupos")){
                            gr = new Grupos();
                            cell = cellIterator.next();
                            gr.setClv_grupo(cell.getStringCellValue());
                            cell = cellIterator.next();
                            gr.setTurno(Boolean.parseBoolean(cell.getStringCellValue()));
                            grupos.add(gr);
                        }
                        else if(tipo.equals("login")) {
                            lo = new Login();
                            cell = cellIterator.next();
                            lo.setClv_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            lo.setPass_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            lo.setTipo_usuario(cell.getStringCellValue());
                            login.add(lo);
                        }
                        else if(tipo.equals("materia_usuario")){
                            ma_us = new Materia_Usuario();
                            cell = cellIterator.next();
                            ma_us.setClv_materia(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma_us.setClv_plan(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma_us.setClv_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma_us.setPuntos_confianza(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ma_us.setPuntos_director(Integer.parseInt(cell.getStringCellValue()));
                            materia_usuario.add(ma_us);
                        }
                        else if(tipo.equals("materias")){
                            ma = new Materias();
                            cell = cellIterator.next();
                            ma.setNombre_materia(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma.setClv_materia(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma.setCreditos(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ma.setCuatrimestre(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ma.setPosicion(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ma.setClv_plan(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma.setHoras_x_semana(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            ma.setTipo_materia(cell.getStringCellValue());
                            cell = cellIterator.next();
                            ma.setClv_materia(cell.getStringCellValue());
                            materias.add(ma);
                        }
                        else if(tipo.equals("plan_estudios")){
                            pl_es = new Plan_Estudios();
                            cell = cellIterator.next();
                            pl_es.setClv_plan(cell.getStringCellValue());
                            cell = cellIterator.next();
                            pl_es.setNombre_plan(cell.getStringCellValue());
                            cell = cellIterator.next();
                            pl_es.setNivel(cell.getStringCellValue());
                            cell = cellIterator.next();
                            pl_es.setId_carrera(Integer.parseInt(cell.getStringCellValue()));

                            plan_estudios.add(pl_es);
                        }
                        else if(tipo.equals("prestamos")){
                            pr = new Prestamos();
                            cell = cellIterator.next();
                            pr.setClv_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            pr.setId_carrera(Integer.parseInt(cell.getStringCellValue()));
                        }
                        else if(tipo.equals("uso_aula_grupo")){
                            us_au_gr = new Uso_Aula_Grupo();
                            cell = cellIterator.next();
                            us_au_gr.setDia(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            us_au_gr.setEspacio_tiempo(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            us_au_gr.setId_aula(cell.getStringCellValue());
                            cell = cellIterator.next();
                            us_au_gr.setClv_grupo(cell.getStringCellValue());
                            cell = cellIterator.next();
                            us_au_gr.setClv_materia(cell.getStringCellValue());
                            uso_aula_grupo.add(us_au_gr);
                        }
                        else if(tipo.equals("usuarios")){
                            us = new Usuarios();
                            cell = cellIterator.next();
                            us.setClv_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            us.setId_carrera(Integer.parseInt(cell.getStringCellValue()));
                            cell = cellIterator.next();
                            us.setNombre_usuario(cell.getStringCellValue());
                            cell = cellIterator.next();
                            us.setNivel_ads(cell.getStringCellValue());
                            cell = cellIterator.next();
                            us.setContrato(cell.getStringCellValue());
                            usuarios.add(us);

                        }
                    }
                }

            } catch (FileNotFoundException e) {
                System.out.println("No se encontro el archivo");
            } catch (IOException e) {
                System.out.println("Fallo al leer");
            }catch (IllegalStateException e) {
                System.out.println("Tipo de dato Incorrecto dentro del excel");
            }catch (NumberFormatException e){

            }finally{
                try{
                    if( null != fr ){
                        fr.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error al cerrar el fichero");
                }
            }

        int carga;
        System.out.println("¿Que desea hacer?");
        System.out.println("1.- Cargar Base de Datos");
        System.out.println("2.- Cargar Base de Datos Temporal");
        carga = c.nextInt();

        String tabla="", dato1="", dato2="", dato3="", dato4="", dato5="", dato6="", dato7="", dato8="";
        int numero;
        System.out.println(aulas.size());
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

                break;

        }
        return;
    }
}
