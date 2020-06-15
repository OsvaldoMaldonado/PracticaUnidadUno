package com.proyecto;

import java.sql.SQLException;
import java.util.Scanner;

public class RunDB {

    public static void baseDeDatos() throws SQLException {
        int ciclo = 0, acccion, numero = 0;
        String tabla = "", cerrar = "", eliminar = "", where = "", set = "", dato = "", actualizar = "";
        String dato1 = "", dato2 = "", dato3 = "", dato4 = "",
                dato5 = "", dato6 = "", dato7 = "", dato8 = "";
        Scanner scanner = new Scanner(System.in);
        Tabla t = new Tabla();
        Conexion c = new Conexion();
        CRUD crud = new CRUD();

        do {

            System.out.println("1--Insertar, 2--Eliminar, 3--Actualizar");
            acccion = scanner.nextInt();
            System.out.println("Elige una tabla:");
            System.out.println("-aulas");
            System.out.println("-aulas_equipo");
            System.out.println("-carrera");
            System.out.println("-categorias_equipos");
            System.out.println("-disponibilidad");
            System.out.println("-equipo");
            System.out.println("-grupos");
            System.out.println("-grupo_materia_profesor");
            System.out.println("-login");
            System.out.println("-materias");
            System.out.println("-materia_usuario");
            System.out.println("-plan_estudios");
            System.out.println("-prestamos");
            System.out.println("-uso_aula_grupo");
            System.out.println("-usuarios");
            System.out.print(":");
            tabla = scanner.next();

            switch (acccion) {
                case 1:
                    if (tabla.equals("aulas")) {
                        System.out.println("ID_aula:");
                        dato1 = scanner.next();
                        System.out.println("Nombre");
                        dato2 = scanner.next();
                        System.out.println("Tipo");
                        dato3 = scanner.next();
                        System.out.println("Capacidad");
                        dato4 = scanner.next();
                        numero = 1;
                    } else if (tabla.equals("aula_equipo")) {
                        System.out.println("ID_equipo");
                        dato1 = scanner.next();
                        System.out.println("ID_aula");
                        dato2 = scanner.next();
                        System.out.println("Cantidad");
                        dato3 = scanner.next();
                        numero = 2;
                    } else if (tabla.equals("carrera")) {
                        System.out.println("ID_carrera");
                        dato1 = scanner.next();
                        System.out.println("nombre_carrera");
                        dato2 = scanner.next();
                        numero = 3;
                    } else if (tabla.equals("categorias_equipos")) {
                        System.out.println("ID_categorias");
                        dato1 = scanner.next();
                        System.out.println("Nombre");
                        dato2 = scanner.next();
                        System.out.println("Descripción");
                        dato3 = scanner.next();
                        numero = 4;
                    } else if (tabla.equals("disponibilidad")) {
                        System.out.println("Dia");
                        dato1 = scanner.next();
                        System.out.println("Espacio_tiempo");
                        dato2 = scanner.next();
                        System.out.println("clv_usuarios");
                        dato3 = scanner.next();
                        numero = 5;
                    } else if (tabla.equals("equipo")) {
                        System.out.println("ID_equipo");
                        dato1 = scanner.next();
                        System.out.println("ID_categoria");
                        dato2 = scanner.next();
                        System.out.println("Nombre");
                        dato3 = scanner.next();
                        System.out.println("Descripción");
                        dato4 = scanner.next();
                        numero = 6;
                    } else if (tabla.equals("grupos")) {
                        System.out.println("clv_grupo");
                        dato1 = scanner.next();
                        System.out.println("turno");
                        dato2 = scanner.next();
                        numero = 7;
                    } else if (tabla.equals("grupo_materia_profesor")) {
                        System.out.println("clv_grupo");
                        dato1 = scanner.next();
                        System.out.println("clv_materia");
                        dato2 = scanner.next();
                        System.out.println("clv_usuario");
                        dato3 = scanner.next();
                        numero = 8;
                    } else if (tabla.equals("login")) {
                        System.out.println("clv_usuario");
                        dato1 = scanner.next();
                        System.out.println("pass_usuario");
                        dato2 = scanner.next();
                        System.out.println("tipo_usuario");
                        dato3 = scanner.next();
                        numero = 9;
                    } else if (tabla.equals("materias")) {
                        System.out.println("nombre_materia");
                        dato1 = scanner.next();
                        System.out.println("clv_materia");
                        dato2 = scanner.next();
                        System.out.println("creditos");
                        dato3 = scanner.next();
                        System.out.println("cuatrimestre");
                        dato4 = scanner.next();
                        System.out.println("posicion");
                        dato5 = scanner.next();
                        System.out.println("clv_plan");
                        dato6 = scanner.next();
                        System.out.println("hora_x_semana");
                        dato7 = scanner.next();
                        System.out.println("tpo_materia");
                        dato8 = scanner.next();
                        numero = 10;
                    } else if (tabla.equals("materia_usuario")) {
                        System.out.println("clv_materia");
                        dato1 = scanner.next();
                        System.out.println("clv_plan");
                        dato2 = scanner.next();
                        System.out.println("clv_usuario");
                        dato3 = scanner.next();
                        System.out.println("puntos_confianza");
                        dato4 = scanner.next();
                        System.out.println("puntos_director");
                        dato5 = scanner.next();
                        numero = 11;
                    } else if (tabla.equals("plan_estudios")) {
                        System.out.println("clv_plan");
                        dato1 = scanner.next();
                        System.out.println("nombre_plan");
                        dato2 = scanner.next();
                        System.out.println("nivel");
                        dato3 = scanner.next();
                        System.out.println("idcarrera");
                        dato4 = scanner.next();
                        numero = 12;
                    } else if (tabla.equals("prestamos")) {
                        System.out.println("clv_usuario");
                        dato1 = scanner.next();
                        System.out.println("idcarrera");
                        dato2 = scanner.next();
                        numero = 13;
                    } else if (tabla.equals("uso_plan_grupo")) {
                        System.out.println("dia");
                        dato1 = scanner.next();
                        System.out.println("espacio_tiempo");
                        dato2 = scanner.next();
                        System.out.println("id_aula");
                        dato3 = scanner.next();
                        System.out.println("clv_grupo");
                        dato4 = scanner.next();
                        System.out.println("clv_materia");
                        dato5 = scanner.next();
                        numero = 14;
                    } else if (tabla.equals("usuarios")) {
                        System.out.println("clv_usuarios");
                        dato1 = scanner.next();
                        System.out.println("idcarrera");
                        dato2 = scanner.next();
                        System.out.println("nombre_usuario");
                        dato3 = scanner.next();
                        System.out.println("nivel_ads");
                        dato4 = scanner.next();
                        System.out.println("contrato");
                        dato5 = scanner.next();
                        numero = 15;
                    } else {
                        System.out.println("NO SE ENCONTRO LA TABLA");
                    }
                    crud.Insertar(dato1, dato2, dato3, dato4, dato5, dato6, dato7, dato8, numero);
                    break;
                case 2:

                    if (tabla.equals("aulas")) {
                        System.out.println("id_aula a eliminar");
                        eliminar = scanner.next();
                        where = "id_aula";

                    } else if (tabla.equals("aula_equipo")) {
                        System.out.println("id_equipo a eliminar");
                        eliminar = scanner.next();
                        where = "id_equipo";

                    } else if (tabla.equals("carrera")) {
                        System.out.println("id_carrera a eliminar");
                        eliminar = scanner.next();
                        where = "id_carrera";

                    } else if (tabla.equals("categorias_equipos")) {
                        System.out.println("id_categorias a eliminar");
                        eliminar = scanner.next();
                        where = "id_categorias";

                    } else if (tabla.equals("disponibilidad")) {
                        System.out.println("Dia a eliminar");
                        eliminar = scanner.next();
                        where = "dia";

                    } else if (tabla.equals("equipo")) {
                        System.out.println("ID_equipo a eliminar");
                        eliminar = scanner.next();
                        where = "id_equipo";

                    } else if (tabla.equals("grupos")) {
                        System.out.println("clv_grupo a eliminar");
                        eliminar = scanner.next();
                        where = "clv_grupo";

                    } else if (tabla.equals("grupo_materia_profesor")) {
                        System.out.println("clv_grupo a eliminar");
                        eliminar = scanner.next();
                        where = "clv_grupo";

                    } else if (tabla.equals("login")) {
                        System.out.println("clv_usuario a eliminar");
                        eliminar = scanner.next();
                        where = "clv_usuario";

                    } else if (tabla.equals("materias")) {
                        System.out.println("nombre_materia a eliminar");
                        eliminar = scanner.next();
                        where = "nombre_materia";

                    } else if (tabla.equals("materia_usuario")) {
                        System.out.println("clv_materia a eliminar");
                        eliminar = scanner.next();
                        where = "clv_materia";

                    } else if (tabla.equals("plan_estudios")) {
                        System.out.println("clv_plan a eliminar");
                        eliminar = scanner.next();
                        where = "clv_plan";

                    } else if (tabla.equals("prestamos")) {
                        System.out.println("clv_usuario a eliminar");
                        eliminar = scanner.next();
                        where = "clv_usuario";

                    } else if (tabla.equals("uso_plan_grupo")) {
                        System.out.println("dia a eliminar");
                        eliminar = scanner.next();
                        where = "dia";

                    } else if (tabla.equals("usuarios")) {
                        System.out.println("clv_usuarios a eliminar");
                        eliminar = scanner.next();
                        where = "clv_usuarios";

                    } else {
                        System.out.println("NO SE ENCONTRO LA TABLA");
                    }
                    crud.Eliminar(eliminar, where, tabla);
                    break;
                case 3:
                    if (tabla.equals("aulas")) {
                        System.out.println("id_aula a actualizar");
                        actualizar = scanner.next();
                        System.out.println("Dato a actualizar");
                        System.out.println("id_aula:");
                        System.out.println("nombre");
                        System.out.println("tipo");
                        System.out.println("capacidad");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "id_aula";

                    } else if (tabla.equals("aula_equipo")) {
                        System.out.println("id_equipo a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("ID_equipo");
                        System.out.println("ID_aula");
                        System.out.println("Cantidad");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "id_equipo";
                    } else if (tabla.equals("carrera")) {
                        System.out.println("idcarrera a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("ID_carrera");
                        System.out.println("nombre_carrera");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "idcarrera";
                    } else if (tabla.equals("categorias_equipos")) {
                        System.out.println("id_categorias a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("ID_categorias");
                        System.out.println("Nombre");
                        System.out.println("Descripción");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "id_categorias";
                    } else if (tabla.equals("disponibilidad")) {
                        System.out.println("dia a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("Dia");
                        System.out.println("Espacio_tiempo");
                        System.out.println("clv_usuarios");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "dia";
                    } else if (tabla.equals("equipo")) {
                        System.out.println("id_equipo a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("ID_equipo");
                        System.out.println("ID_categoria");
                        System.out.println("Nombre");
                        System.out.println("Descripción");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "id_equipo";
                    } else if (tabla.equals("grupos")) {
                        System.out.println("clv_grupo a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_grupo");
                        System.out.println("turno");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_grupo";
                    } else if (tabla.equals("grupo_materia_profesor")) {
                        System.out.println("clv_grupo a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_grupo");
                        System.out.println("clv_materia");
                        System.out.println("clv_usuario");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_grupo";
                    } else if (tabla.equals("login")) {
                        System.out.println("clv_usuario a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_usuario");
                        System.out.println("pass_usuario");
                        System.out.println("tipo_usuario");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_usuario";
                    } else if (tabla.equals("materias")) {
                        System.out.println("nombre_materia a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("nombre_materia");
                        System.out.println("clv_materia");
                        System.out.println("creditos");
                        System.out.println("cuatrimestre");
                        System.out.println("posicion");
                        System.out.println("clv_plan");
                        System.out.println("hora_x_semana");
                        System.out.println("tpo_materia");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "nombre_materia";
                    } else if (tabla.equals("materia_usuario")) {
                        System.out.println("clv_materia a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_materia");
                        System.out.println("clv_plan");
                        System.out.println("clv_usuario");
                        System.out.println("puntos_confianza");
                        System.out.println("puntos_director");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_materia";
                    } else if (tabla.equals("plan_estudios")) {
                        System.out.println("clv_plan a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_plan");
                        System.out.println("nombre_plan");
                        System.out.println("nivel");
                        System.out.println("idcarrera");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_plan";
                    } else if (tabla.equals("prestamos")) {
                        System.out.println("clv_usuario a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("clv_usuario");
                        System.out.println("idcarrera");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_usuarios";
                    } else if (tabla.equals("uso_aula_grupo")) {
                        System.out.println("dia a actualizar");
                        actualizar = scanner.next();

                        System.out.println("Dato a actualizar");
                        System.out.println("dia");
                        System.out.println("espacio_tiempo");
                        System.out.println("id_aula");
                        System.out.println("clv_grupo");
                        System.out.println("clv_materia");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "dia";
                    } else if (tabla.equals("usuarios")) {
                        System.out.println("clv_usuarios a actualizar");
                        actualizar = scanner.next();
                        System.out.println("Dato a actualizar");
                        System.out.println("clv_usuarios");
                        System.out.println("idcarrera");
                        System.out.println("nombre_usuario");
                        System.out.println("nivel_ads");
                        System.out.println("contrato");
                        set = scanner.next();
                        System.out.println("Ingresa el cambio a:");
                        dato = scanner.next();
                        where = "clv_usuarios";
                    } else {
                        System.out.println("NO SE ENCONTRO LA TABLA");
                    }
                    crud.Actualizar(tabla, set, where, actualizar, dato);
                    break;
            }
            System.out.println("¿Terminar Consultas? S/N");
            cerrar = scanner.next();

            if (cerrar.equals("S")) {
                ciclo = 1;
            }

        } while (ciclo == 0);

    }
}
