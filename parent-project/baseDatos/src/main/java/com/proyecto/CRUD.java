package com.proyecto;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import java.sql.SQLException;

public class CRUD {

    public static void Insertar(String dato1, String dato2, String dato3, String dato4, String dato5, String dato6, String dato7, String dato8, int numero) throws SQLException {

        try{

        String query = "";
        Conexion bd = new Conexion();
        Statement sentencia = (Statement) bd.conexion().createStatement();
        if (numero == 1){
            query = "INSERT INTO aulas(id_aula, nombre, tipo, capacidad) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '" + dato4 + "');";

        }else if (numero == 2){
            query = "INSERT INTO aula_equipo(id_equipo, id_aula, cantidad) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "');";

        }else if (numero == 3){
            query = "INSERT INTO carrera(idcarrera, nombre_carrera) VALUES ('" + dato1 + "', '" + dato2 + "');";

        }else if (numero == 4){
            query = "INSERT INTO categorias_equipos(id_categorias, nombre, descripcion) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "');";

        }else if (numero == 5){
            query = "INSERT INTO disponibilidad(dia, espacio_tiempo, clv_usuarios) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "');";

        }else if (numero == 6){
            query = "INSERT INTO equipo(id_equipo, id_categoria, nombre, descripcion) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '" + dato4 + "');";

        }else if (numero == 7){
            query = "INSERT INTO grupos(clv_grupo, turno) VALUES ('" + dato1 + "', '" + dato2 + "');";

        }else if (numero == 8){
            query = "INSERT INTO grupo_materia_profesor(clv_grupo, clv_materia, clv_usuarip) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "');";

        }else if (numero == 9){
            query = "INSERT INTO login(clv_usuario, pass_usuario, tipo_usuario) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "');";

        }else if (numero == 10){
            query = "INSERT INTO materias(nombre_materia, clv_materia, creditos, cuatrimestre, posicion, clv_plan, hora_x_semana, tipo_materia) " +
                    "VALUES ('"+dato1+"', '"+dato2+"', '"+dato3+"', '"+dato4+"', '"+dato5+"', '"+dato6+"', '"+dato7+"', '"+dato8+"');";

        }else if (numero == 11){
            query = "INSERT INTO materia_usuario(clv_materia, clv_plan, clv_usuario, puntos_confianza, puntos_director) " +
                    "VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '"+dato4+"', '"+dato5+"');";

        }else if (numero == 12){
            query = "INSERT INTO plan_estudios(clv_plan, nombre_plan, nivel, idcarrera) VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '"+dato4+"');";

        }else if (numero == 13){
            query = "INSERT INTO prestamos(clv_usuario, idcarrera) VALUES ('" + dato1 + "', '" + dato2 + "');";

        }else if (numero == 14){
            query = "INSERT INTO uso_aula_grupo(dia, espacio_tiempo, id_aula, clv_grupo, clv_materia) " +
                    "VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '"+dato4+"', '"+dato5+"');";

        }else if (numero == 15){
            query = "INSERT INTO usuarios(clv_usuario, idcarrera, nombre_usuario, nivel_ads, contrato) " +
                    "VALUES ('" + dato1 + "', '" + dato2 + "', '" + dato3 + "', '"+dato4+"', '"+dato5+"');";

        }


        if (sentencia.executeUpdate(query) > 0) {
            System.out.println("El registro se insertó exitosamente.");
        } else {
            System.out.println("No se pudo insertar el registro.");
        }

        System.out.println(query);
        sentencia.close();
        bd.conexion().close();
        }catch (MySQLIntegrityConstraintViolationException e){
            System.out.println("Registro Repetido");
        }

    }

    public void Eliminar(String dato, String where, String tabla){

        Conexion bd = new Conexion();
        String query = "";
        try {
            query = "DELETE FROM " + tabla +" WHERE " +  where + "= ?;";
            PreparedStatement sentenciaP = (PreparedStatement) bd.conexion().prepareStatement(query);
            sentenciaP.setString(1,dato);

            sentenciaP.execute();
            System.out.println("El registro se eliminó exitosamente.");
            sentenciaP.close();
            bd.conexion().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void Actualizar(String tabla, String set, String where, String actualizar, String dato){
        String query = "";
        Conexion bd = new Conexion();

        try {
            query = "UPDATE " +  tabla + " SET " + set + " = ? Where " + where + " = ?;";
            PreparedStatement sentenciaP = (PreparedStatement) bd.conexion().prepareStatement(query);
            sentenciaP.setString(1, dato);
            sentenciaP.setString(2, actualizar);

            sentenciaP.executeUpdate();
            System.out.println("El registro se actualizó exitosamente.");
            sentenciaP.close();
            bd.conexion().close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }


}
