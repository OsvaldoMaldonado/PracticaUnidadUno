package boros;

import java.sql.*;
import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Conexion es el alfitrion de la B.D y se ocupa mandar y retornar en todas las funciones sino se quedaria
        // En el metodo que fue enviado y moririan ai los datos enves de regresar para poder volver a ser usados
        Connection conexion = creacion_volatil();//esta madre crea la B.D
        String var1="xd",var2="xd2",var3="xd3",var4="xd4",var5="xd5";
        String ruta,usuario,contra = null;
        boolean var7 = true;
        int opcionpitera,var6=10,var8=20,var9=30,var10=40;
        Scanner superescaner = new Scanner(System.in);
        System.out.println("Aulas:");
       conexion = insercion_aulas(var1,var2,var3,var6,var4,var5,conexion);
        System.out.println("Grupo:");
       conexion = insercion_grupo(var1,var7,conexion);
        System.out.println("Materias");
       conexion = insercion_materia(var1,var2,var6,var8,var9,var3,var10,var4,conexion);
        System.out.println("usuarios");
       conexion = insercion_usuarios(var1,var6,var3,var4,var5,conexion);
        System.out.println("materia profesor");
       conexion = insercion_materia_profesor(var1,var2,var3,conexion);
        System.out.println("login");
       conexion = insercion_login(var1,var2,conexion);
        System.out.println("Disponibilidad");
        conexion = insercion_disponibilidad(var6,var8,var3,conexion);
        System.out.println("carrera");
        conexion = insercion_carrera(var2,var1,conexion);
        System.out.println("Prestamos");
        conexion = insercion_prestamos(var1,var6,conexion);
        System.out.println("plan de estudios");
        conexion = insercion_plan_estudios(var1,var2,var3,var6,conexion);
        System.out.println("materia usuarios");
        conexion = insercion_materia_usuarios(var1,var2,var3,var6,var8,conexion);
        System.out.println("uso aula grupos");
        conexion = insercion_uso_aula_grupo(var6,var8,var1,var2,var3,conexion);
        System.out.println("aula equipo");
        conexion = insercion_aula_equipo(var6,var1,var8,conexion);
        System.out.println("equipo");
        conexion = insercion_equipo(var6,var8,var1,var2,conexion);
        System.out.println("categorias de equipo");
        conexion = insercion_categorias_equipo(var6,var1,var2,conexion);






    }
    //TLDR.-Recibe la conexion de la B.D temporal, junto con los valores para poder ser insertados y luego se muestran en la consola para asegurar que si estan xd
    //1.- Primero con el string se prepara la sentencia que se usara en la b.d
    //2.- LA sentencia es almacenada en pstmt y es preparada con el .prepareStatement donde agarra el string
    //3.- el pstmt se le agregan de 1 en 1 los valores que fueron recibidos cuando fue llamada la funcion
    //4.- se use el pstmt.setString o .setInt(Depende del tipo enviado) para insertar los valores a las ? del sql
    //5.- se usa .executeUpdate() para realizar el statement y que se haga
    //6.- Se selecciona los datos que se acaban de agregar para ver si se agregaron o no
    //7.- se hace otro statement normal no preparado
    //8.- se hace un ResultSet para poder ver todos los datos que tenga la tabla
    //9.- .executeQuery para realizar la accion de 8
    //10.- Se usan el mismo result query(rs) para que muestre los datos que se encuentre en base al titulo
    //11.- Retorna la conexion para que se guarden para futuras generaciones
    // al chile todos los metodos de insercion son casi que lo mismo lo unico que varia son los datos que se insertaran
    public static Connection insercion_aulas(String idaula, String nombrez, String tipoz, int capacidadz, String descripcionz, String ubicacionz, Connection conexion){
        String sql2 = "INSERT INTO aulas(id_aula,nombre,tipo,capacidad,descripcion,ubicacion) VALUES(?,?,?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, idaula);
            pstmt.setString(2, nombrez);
            pstmt.setString(3, tipoz);
            pstmt.setInt(4,capacidadz);
            pstmt.setString(5,descripcionz);
            pstmt.setString(6,ubicacionz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT id_aula, nombre, tipo, capacidad FROM aulas";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("id_aula")+ "\n"+
                        rs.getInt("capacidad")+ "\n" +
                        rs.getString("nombre")+ "\n" +
                        rs.getString("tipo"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }

    public static Connection insercion_grupo(String clvaula, boolean turnoz, Connection conexion){

        String sql2 = "INSERT INTO grupo(clv_grupo,turno) VALUES(?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clvaula);
            pstmt.setBoolean(2, turnoz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT clv_grupo,turno FROM grupo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_grupo")+ "\n"+
                        rs.getBoolean("turno"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_materia(String nombremateriaz, String clv_materiaz, int creditoz, int cuatrimestrez,
                                               int posicionz, String clv_planz, int horasxsemanaz, String tipodemateriaz , Connection conexion ){
        String sql2 = "INSERT INTO materia(nombre_materia,clv_materia,creditos,cuatrimestre,posicion,clv_plan,horas_x_semana,tipo_materia) VALUES(?,?,?,?,?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, nombremateriaz);
            pstmt.setString(2, clv_materiaz);
            pstmt.setInt(3, creditoz);
            pstmt.setInt(4,cuatrimestrez);
            pstmt.setInt(5,posicionz);
            pstmt.setString(6, clv_planz);
            pstmt.setInt(7,horasxsemanaz);
            pstmt.setString(8,tipodemateriaz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT nombre_materia,clv_materia,creditos,cuatrimestre,posicion,clv_plan,horas_x_semana,tipo_materia  FROM materia";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("nombre_materia")+ "\n"+
                        rs.getString("clv_materia")+ "\n" +
                        rs.getInt("creditos")+ "\n" +
                        rs.getInt("cuatrimestre")+ "\n"+
                        rs.getInt("posicion")+ "\n" +
                        rs.getString("clv_plan")+ "\n" +
                        rs.getInt("horas_x_semana")+ "\n" +
                        rs.getString("tipo_materia"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_usuarios(String clv_usuarioz, int carreraz, String nombreusuarioz, String nivelz, String contratoz, Connection conexion){
        String sql2 = "INSERT INTO usuarios(clv_usuario,idcarrera,nombre_usuario,nivel_ads,contrato) VALUES(?,?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_usuarioz);
            pstmt.setInt(2, carreraz);
            pstmt.setString(3, nombreusuarioz);
            pstmt.setString(4,nivelz);
            pstmt.setString(5,contratoz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT clv_usuario,idcarrera,nombre_usuario,nivel_ads,contrato FROM usuarios";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_usuario")+ "\n"+
                        rs.getInt("idcarrera")+ "\n" +
                        rs.getString("nombre_usuario")+ "\n" +
                        rs.getString("nivel_ads")+ "\n" +
                        rs.getString("contrato"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_materia_profesor(String clv_grupoz, String clv_materiaz, String clv_usuarioz, Connection conexion){
        String sql2 = "INSERT INTO grupo_materia_profesor(clv_grupo,clv_materia,clv_usuario) VALUES(?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_grupoz);
            pstmt.setString(2, clv_materiaz);
            pstmt.setString(3, clv_usuarioz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT clv_grupo,clv_materia,clv_usuario FROM grupo_materia_profesor";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_grupo")+ "\n"+
                        rs.getString("clv_materia")+ "\n" +
                        rs.getString("clv_usuario"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_login(String clv_usuarioz, String pass_usuarioz, Connection conexion){
        String sql2 = "INSERT INTO login(clv_usuario,pass_usuario,tipo_usuario) VALUES(?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_usuarioz);
            pstmt.setString(2, pass_usuarioz);
            pstmt.setString(3, "Ing.");
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT clv_usuario,pass_usuario,tipo_usuario  FROM login";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_usuario")+ "\n"+
                        rs.getString("pass_usuario")+ "\n" +
                        rs.getString("tipo_usuario"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_disponibilidad(int diaz, int espacio_tiempoz, String clv_usuarioz, Connection conexion){
        String sql2 = "INSERT INTO disponibilidad(dia,espacio_tiempo,clv_usuario) VALUES(?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setInt(1, diaz);
            pstmt.setInt(2, espacio_tiempoz);
            pstmt.setString(3, clv_usuarioz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT dia,espacio_tiempo,clv_usuario FROM disponibilidad";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getInt("dia")+ "\n"+
                        rs.getInt("espacio_tiempo")+ "\n" +
                        rs.getString("clv_usuario"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_carrera(String id_carreraz, String nombre_carreraz, Connection conexion){
        String sql2 = "INSERT INTO carrera(idcarrera,nombre_carrera) VALUES(?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, id_carreraz);
            pstmt.setString(2, nombre_carreraz);
            pstmt.executeUpdate();
            String sql3 = "SELECT idcarrera,nombre_carrera FROM carrera";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("idcarrera")+ "\n"+
                        rs.getString("nombre_carrera"));
            }
            return conexion;
            //Se executa el statement para que se agreguen los datos
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_prestamos(String clv_usuarioz, int idcarreraz, Connection conexion){
        String sql2 = "INSERT INTO prestamos(clv_usuarios,idcarrera) VALUES(?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_usuarioz);
            pstmt.setInt(2, idcarreraz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT clv_usuarios,idcarrera FROM prestamos";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getInt("idcarrera")+ "\n"+
                        rs.getString("clv_usuarios"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_plan_estudios(String clv_planz, String nombre_planz, String nivelz, int idcarreraz, Connection conexion){
        String sql2 = "INSERT INTO plan_estudios(clv_plan,nombre_plan,nivel,idcarrera) VALUES(?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_planz);
            pstmt.setString(2, nombre_planz);
            pstmt.setString(3, nivelz);
            pstmt.setInt(4, idcarreraz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT clv_plan,nombre_plan,nivel,idcarrera FROM plan_estudios";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_plan")+ "\n"+
                        rs.getInt("idcarrera")+ "\n" +
                        rs.getString("nombre_plan")+ "\n" +
                        rs.getString("nivel"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_materia_usuarios(String clv_materiaz, String clv_planz, String clv_usuarioz, int puntos_confianzaz, int puntos_directorz, Connection conexion){
        String sql2 = "INSERT INTO materia_usuario(clv_materia,clv_plan,clv_usuario,puntos_confianza,puntos_director) VALUES(?,?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setString(1, clv_materiaz);
            pstmt.setString(2, clv_planz);
            pstmt.setString(3, clv_usuarioz);
            pstmt.setInt(4, puntos_confianzaz);
            pstmt.setInt(5, puntos_directorz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT clv_materia,clv_plan,clv_usuario,puntos_confianza,puntos_director FROM materia_usuario";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("clv_materia")+ "\n"+
                        rs.getInt("puntos_confianza")+ "\n" +
                        rs.getInt("puntos_director")+ "\n" +
                        rs.getString("clv_plan")+ "\n" +
                        rs.getString("clv_usuario"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_uso_aula_grupo(int diaz, int espacio_tiempoz, String id_aulaz, String clv_grupoz, String clv_materiaz, Connection conexion){
        //El statement que sera usado para correr las query en sqlite
        String sql2 = "INSERT INTO uso_aula_grupo(dia,espacio_tiempo,id_aula,clv_grupo,clv_materia) VALUES(?,?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setInt(1, diaz);
            pstmt.setInt(2, espacio_tiempoz);
            pstmt.setString(3, id_aulaz);
            pstmt.setString(4, clv_grupoz);
            pstmt.setString(5, clv_materiaz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT dia,espacio_tiempo,id_aula,clv_grupo,clv_materia FROM uso_aula_grupo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("id_aula")+ "\n"+
                        rs.getInt("dia")+ "\n" +
                        rs.getInt("espacio_tiempo")+ "\n" +
                        rs.getString("clv_grupo")+ "\n" +
                        rs.getString("clv_materia"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_aula_equipo(int id_equipoz, String id_aulaz, int cantidadz, Connection conexion){
        String sql2 = "INSERT INTO aula_equipo(id_equipo,id_aula,cantidad) VALUES(?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setInt(1, id_equipoz);
            pstmt.setString(2, id_aulaz);
            pstmt.setInt(3, cantidadz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 = "SELECT id_equipo,id_aula,cantidad FROM aula_equipo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getInt("id_equipo")+ "\n"+
                        rs.getInt("cantidad")+ "\n" +
                        rs.getString("id_aula"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_equipo(int id_equipoz, int id_categoriaz, String nombrez, String descripcionz,Connection conexion){
        String sql2 = "INSERT INTO equipo(id_equipo,id_categoria,nombre,descripcion) VALUES(?,?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setInt(1, id_equipoz);
            pstmt.setInt(2, id_categoriaz);
            pstmt.setString(3, nombrez);
            pstmt.setString(4, descripcionz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT id_equipo,id_categoria,nombre,descripcion FROM equipo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getString("nombre")+ "\n"+
                        rs.getInt("id_equipo")+ "\n" +
                        rs.getInt("id_categoria")+ "\n" +
                        rs.getString("descripcion"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection insercion_categorias_equipo(int id_categoriaz, String nombrez, String descripcionz, Connection conexion){
        String sql2 = "INSERT INTO categorias_equipo(id_categoria,nombre,descripcion) VALUES(?,?,?)";
        //Preparacion del query para la agregacion de datos
        PreparedStatement pstmt = null;
        try {
            pstmt = conexion.prepareStatement(sql2);
            //asignacion de datos
            pstmt.setInt(1, id_categoriaz);
            pstmt.setString(2, nombrez);
            pstmt.setString(3, descripcionz);
            //Se executa el statement para que se agreguen los datos
            pstmt.executeUpdate();
            String sql3 =  "SELECT id_categoria,nombre,descripcion FROM categorias_equipo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql3);
            while (rs.next()) {
                System.out.println(rs.getInt("id_categoria")+ "\n"+
                        rs.getString("nombre")+ "\n" +
                        rs.getString("descripcion"));
            }
            return conexion;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return conexion;
        }
    }
    public static Connection creacion_volatil() {
        //Para cualquiera que este leyendo esto: el try catch es obligatorio amenos que sea usado en
        // THOWS SQLExeption en el main significa que recomiendo no quitarlo
        // jdbc:sqlite::memory: esta url es necesaria para crear la B.D en memoria y no ser dedicada
        try { //Para cualquiera que este leyendo esto: el try catch es obligatorio amenos que sea usado en
            // THOWS SQLExeption en el main significa que recomiendo no quitarlo
            // jdbc:sqlite::memory: esta url es necesaria para crear la B.D en memoria y no ser dedicada
            Connection conexion = DriverManager.getConnection("jdbc:sqlite::memory:");
            //El statement que sera usado para correr las query en sqlite
            Statement stat = conexion.createStatement();
            //Creacion de tablas es pura sintaxis de sqlite, la sintaxis de sqlite y sql no es 100% la misma
            //debido a que sqlite no sporta poner multiples tabla en un query se tienen que hacer por separado
            String sql =
                    "CREATE TABLE aula_equipo (\n" +
                            "  id_equipo int(11) DEFAULT  NULL,\n" +
                            "  id_aula varchar(10) DEFAULT  NULL,\n" +
                            "  cantidad int(11) DEFAULT NULL\n" +
                            ");";
            String sql4 = "CREATE TABLE aulas (\n" +
                    "  id_aula varchar(10) DEFAULT NULL,\n" +
                    "  nombre varchar(100) DEFAULT NULL,\n" +
                    "  tipo varchar(20) DEFAULT NULL,\n" +
                    "  capacidad int(11) DEFAULT NULL,\n" +
                    "  descripcion varchar(100) DEFAULT NULL,\n " +
                    "  ubicacion varchar (30) DEFAULT NULL\n " +
                    ");";
            String sql5 = "CREATE TABLE carrera (\n" +
                    "  idcarrera varchar(100) DEFAULT NULL,\n" +
                    "  nombre_carrera varchar(100) DEFAULT NULL\n" +
                    ");";
            String sql6 = "CREATE TABLE `categorias_equipo` (\n" +
                    "  `id_categoria` int(10) NOT NULL,\n" +
                    "  `nombre` varchar(100)  NOT NULL,\n" +
                    "  `descripcion` varchar(300)  NULL\n" +
                    ");";
            String sql7 = "CREATE TABLE disponibilidad (\n" +
                    "  dia int(10) DEFAULT NULL,\n" +
                    "  espacio_tiempo int(10) DEFAULT NULL,\n" +
                    "  clv_usuario varchar(50) DEFAULT NULL\n" +
                    ");";
            String sql8 = "CREATE TABLE login (\n" +
                    "  clv_usuario varchar(10) DEFAULT  NULL,\n" +
                    "  pass_usuario varchar(100) DEFAULT  NULL,\n" +
                    "tipo_usuario CHAR(4) NOT NULL \n " +
                    ");";
            String sql9 = "CREATE TABLE prestamos (\n" +
                    "  clv_usuarios varchar(50) DEFAULT NULL,\n" +
                    "  idcarrera int(10) DEFAULT  NULL\n" +
                    ");";
            String sql10 = "CREATE TABLE plan_estudios (\n" +
                    " clv_plan VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    nombre_plan VARCHAR(45) NOT NULL,\n" +
                    "    nivel VARCHAR(3) NOT NULL,\n" +
                    "    idcarrera TINYINT NOT NULL " +
                    ");";
            String sql11 = "CREATE TABLE equipo(\n" +
                    "    id_equipo INT(11) NOT NULL,\n" +
                    "    id_categoria INT(11) NOT NULL,\n" +
                    "    nombre VARCHAR(100) NOT NULL,\n" +
                    "    descripcion VARCHAR(100) NOT NULL    \n" +
                    "    );";
            String sql12 = "CREATE TABLE grupo(\n" +
                    "    clv_grupo VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    turno BOOLEAN  \n" +
                    "    );";
            String sql13 = "CREATE TABLE materia(\n " +
                    "    nombre_materia VARCHAR(50) NOT NULL,\n" +
                    "    clv_materia VARCHAR(10) NOT NULL PRIMARY KEY,\n" +
                    "    creditos TINYINT NULL,\n" +
                    "    cuatrimestre TINYINT NOT NULL,\n" +
                    "    posicion TINYINT NOT NULL,\n" +
                    "    clv_plan VARCHAR(10) NOT NULL,\n" +
                    "    horas_x_semana TINYINT NOT NULL,\n" +
                    "    tipo_materia CHAR(3) NOT NULL  \n" +
                    "    );";
            String sql14 = "CREATE TABLE usuarios(\n" +
                    "    clv_usuario VARCHAR(50) NOT NULL PRIMARY KEY,\n" +
                    "    idcarrera TINYINT NOT NULL,\n" +
                    "    nombre_usuario VARCHAR(50),\n" +
                    "    nivel_ads VARCHAR(5) NOT NULL,\n" +
                    "    contrato VARCHAR(3) NOT NULL    \n" +
                    "    );";
            String sql15 = "CREATE TABLE grupo_materia_profesor(\n" +
                    "    clv_grupo VARCHAR(10) NOT NULL,\n" +
                    "    clv_materia VARCHAR(10) NOT NULL,\n" +
                    "    clv_usuario VARCHAR(50) NOT NULL,\n" +
                    "    PRIMARY KEY(clv_grupo, clv_materia, clv_usuario)    \n" +
                    "    );\n";
            String sql16 = "CREATE TABLE materia_usuario(\n" +
                    "    clv_materia VARCHAR(10) NOT NULL,\n" +
                    "    clv_plan VARCHAR(10) NOT NULL,\n" +
                    "    clv_usuario VARCHAR(50) NOT NULL,\n" +
                    "    puntos_confianza TINYINT,\n" +
                    "    puntos_director TINYINT\n" +
                    "    );";
            String sql17 = "CREATE TABLE uso_aula_grupo(\n" +
                    "    dia TINYINT NOT NULL,\n" +
                    "    espacio_tiempo TINYINT NOT NULL,\n" +
                    "    id_aula VARCHAR(10) NOT NULL,\n" +
                    "    clv_grupo VARCHAR(10) NOT NULL,\n" +
                    "    clv_materia VARCHAR(10) NOT NULL\n" +
                    "    );";
            //se executan los querys para la creacion de todas las tablas
            stat.execute(sql);
            stat.execute(sql4);
            stat.execute(sql5);
            stat.execute(sql6);
            stat.execute(sql7);
            stat.execute(sql8);
            stat.execute(sql9);
            stat.execute(sql10);
            stat.execute(sql11);
            stat.execute(sql12);
            stat.execute(sql13);
            stat.execute(sql14);
            stat.execute(sql15);
            stat.execute(sql16);
            stat.execute(sql17);
            return conexion;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            Connection conexion = null;
            return conexion;
        }
    }
    public static void insertar_basededatos(String ruta, String usuario, String contrasena) throws SQLException {
        int var1, var2, var3, var9;
        boolean var8;
        String var4, var5, var6, var7;
        Connection conexion = DriverManager.getConnection("jdbc:sqlite::memory:");
        //El statement que sera usado para correr las query en sqlite
        String sql3 = "SELECT clv_grupo, turno FROM grupos";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            //Cada vez que inicie va a buscar dentro de la tabla todos los valores y los guardara en
            //varias variables de diferentes tipos dependiendo de lo que se saque
            var4 = rs.getString("clv_grupo");
            var8 = rs.getBoolean("turno");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                //esto esta dentro del ciclo RS significando que agarra los datos y enviara todo el contenido
                //de esa fila hacia la b.d hasta que se agoten las filas
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql5 = "INSERT INTO grupo(clv_grupo,estudios, nombre) VALUES (?,?,?)";
                pstmt = con.prepareStatement(sql5);
                pstmt.setString(1, var4);
                pstmt.setBoolean(2, var8);
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql4 = "SELECT nombre_materia,clv_materia,creditos,cuatrimestre,posicion,clv_plan,horas_x_semana,tipo_materia  FROM materia";
        Statement stmt2 = conexion.createStatement();
        ResultSet rs2 = stmt2.executeQuery(sql4);
        while (rs2.next()) {
            var4 = rs.getString("nombre_materia");
            var5 = rs.getString("clv_materia");
            var1 = rs.getInt("creditos");
            var2 = rs.getInt("cuatrimestre");
            var3 = rs.getInt("posicion");
            var6 = rs.getString("clv_plan");
            var9 = rs.getInt("horas_x_semana");
            var7 = rs.getString("tipo_materia");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql5 = "INSERT INTO materia(nombre_materia,clv_materia,creditos,cuatrimestre,posicion,clv_plan,horas_x_semana,tipo_materia) VALUES(?,?,?,?,?,?,?,?)";
                pstmt = con.prepareStatement(sql5);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setInt(3, var1);
                pstmt.setInt(4, var2);
                pstmt.setInt(5, var3);
                pstmt.setString(6, var6);
                pstmt.setInt(7, var9);
                pstmt.setString(8, var7);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql5 = "SELECT clv_usuario,idcarrera,nombre_usuario,nivel_ads,contrato FROM usuarios";
        Statement stmt3 = conexion.createStatement();
        ResultSet rs3 = stmt3.executeQuery(sql5);
        while (rs3.next()) {
            var4 = rs.getString("clv_usuario");
            var1 = rs.getInt("idcarrera");
            var6 = rs.getString("nombre_usuario");
            var5 = rs.getString("nivel_ads");
            var7 = rs.getString("contrato");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql6 = "INSERT INTO usuarios(clv_usuario,idcarrera,nombre_usuario,nivel_ads,contrato) VALUES(?,?,?,?,?)";
                pstmt = con.prepareStatement(sql6);
                pstmt.setString(1, var4);
                pstmt.setInt(2, var1);
                pstmt.setString(3, var6);
                pstmt.setString(4, var5);
                pstmt.setString(5, var7);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql8 = "SELECT clv_usuario,pass_usuario,tipo_usuario  FROM login";
        Statement stmt4 = conexion.createStatement();
        ResultSet rs4 = stmt4.executeQuery(sql8);
        while (rs4.next()) {
            var4 = rs.getString("clv_usuario");
            var5 = rs.getString("pass_usuario");
            var6 = rs.getString("tipo_usuario");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql7 = "INSERT INTO login(clv_usuario,pass_usuario,tipo_usuario) VALUES(?,?,?)";
                pstmt = con.prepareStatement(sql7);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql6 = "SELECT clv_grupo,clv_materia,clv_usuario FROM grupo_materia_profesor";
        Statement stmt5 = conexion.createStatement();
        ResultSet rs5 = stmt5.executeQuery(sql6);
        while (rs5.next()) {
            var4 = rs.getString("clv_grupo");
            var5 = rs.getString("clv_materia");
            var6 = rs.getString("clv_usuario");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql7 = "INSERT INTO grupo_materia_profesor(clv_grupo,clv_materia,clv_usuario) VALUES(?,?,?)";
                pstmt = con.prepareStatement(sql7);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql9 = "SELECT dia,espacio_tiempo,clv_usuario FROM disponibilidad";
        Statement stmt6 = conexion.createStatement();
        ResultSet rs6 = stmt6.executeQuery(sql9);
        while (rs6.next()) {
            var1 = rs.getInt("dia");
            var2 = rs.getInt("espacio_tiempo");
            var6 = rs.getString("clv_usuario");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql10 = "INSERT INTO disponibilidad(dia,espacio_tiempo,clv_usuario) VALUES(?,?,?)";
                pstmt = con.prepareStatement(sql10);
                pstmt.setInt(1, var1);
                pstmt.setInt(2, var2);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql11 = "SELECT idcarrera,nombre_carrera FROM carrera";
        Statement stmt7 = conexion.createStatement();
        ResultSet rs7 = stmt7.executeQuery(sql11);
        while (rs7.next()) {
            var3 = rs.getInt("idcarrera");
            var6 = rs.getString("nombre_carrera");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql12 = "INSERT INTO carrera(id_carrera,nombre_carrera) VALUES(?,?)";
                pstmt = con.prepareStatement(sql12);
                pstmt.setInt(1, var3);
                pstmt.setString(2, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql12 = "SELECT clv_usuario,idcarrera FROM prestamos";
        Statement stmt8 = conexion.createStatement();
        ResultSet rs8 = stmt8.executeQuery(sql12);
        while (rs8.next()) {
            var3 = rs.getInt("idcarrera");
            var6 = rs.getString("clv_usuario");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql13 = "INSERT INTO prestamos(clv_usuarios,idcarrera) VALUES(?,?)";
                pstmt = con.prepareStatement(sql13);
                pstmt.setInt(2, var3);
                pstmt.setString(1, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql14 = "SELECT clv_plan,nombre_plan,nivel,idcarrera FROM plan_estudios";
        Statement stmt9 = conexion.createStatement();
        ResultSet rs9 = stmt9.executeQuery(sql14);
        while (rs9.next()) {
            var4 = rs.getString("clv_plan");
            var5 = rs.getString("nombre_plan");
            var1 = rs.getInt("idcarrera");
            var6 = rs.getString("nivel");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql16 = "INSERT INTO plan_estudios(clv_plan,nombre_plan,nivel,idcarrera) VALUES(?,?,?,?)";
                pstmt = con.prepareStatement(sql16);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setInt(4, var1);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql17 = "SELECT id_aula,nombre,tipo,capacidad FROM aulas";
        Statement stmt10 = conexion.createStatement();
        ResultSet rs10 = stmt10.executeQuery(sql17);
        while (rs10.next()) {
            var4 = rs.getString("id_aula");
            var5 = rs.getString("nombre");
            var1 = rs.getInt("capacidad");
            var6 = rs.getString("tipo");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql18 =  "INSERT INTO aulas(id_aula,nombre,tipo,capacidad) VALUES(?,?,?,?)";
                pstmt = con.prepareStatement(sql18);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setInt(4, var1);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql19 = "SELECT clv_materia,clv_plan,clv_usuario,puntos_confianza,puntos_director FROM materia_usuario";
        Statement stmt11 = conexion.createStatement();
        ResultSet rs11 = stmt11.executeQuery(sql19);
        while (rs11.next()) {
            var4 = rs.getString("clv_materia");
            var5 = rs.getString("clv_plan");
            var6 = rs.getString("clv_usuario");
            var2 = rs.getInt("puntos_confianza");
            var3 = rs.getInt("puntos_director");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql20 =  "INSERT INTO materia_usuario(clv_materia,clv_plan,clv_usuario,puntos_confianza,puntos_director) VALUES(?,?,?,?,?)";
                pstmt = con.prepareStatement(sql20);
                pstmt.setString(1, var4);
                pstmt.setString(2, var5);
                pstmt.setString(3, var6);
                pstmt.setInt(4, var2);
                pstmt.setInt(5, var3);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql23 = "SELECT id_equipo,id_categoria,nombre,descripcion FROM equipo";
        Statement stmt13 = conexion.createStatement();
        ResultSet rs13 = stmt13.executeQuery(sql23);
        while (rs13.next()) {
            var1 = rs.getInt("id_equipo");
            var2 = rs.getInt("id_categoria");
            var4 = rs.getString("nombre");
            var6 = rs.getString("descripcion");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql24 =  "INSERT INTO equipo(id_equipo,id_categoria,nombre,descripcion) VALUES(?,?,?,?)";
                pstmt = con.prepareStatement(sql24);
                pstmt.setInt(1, var1);
                pstmt.setInt(2, var2);
                pstmt.setString(3, var4);
                pstmt.setString(4, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql20 = "SELECT dia,espacio_tiempo,id_aula,clv_grupo,clv_materia FROM uso_aula_grupo";
        Statement stmt12 = conexion.createStatement();
        ResultSet rs12 = stmt12.executeQuery(sql20);
        while (rs12.next()) {
            var4 = rs.getString("id_aula");
            var5 = rs.getString("clv_grupo");
            var6 = rs.getString("clv_materia");
            var2 = rs.getInt("dia");
            var3 = rs.getInt("espacio_tiempo");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql21 = "INSERT INTO uso_aula_grupo(dia,espacio_tiempo,id_aula,clv_grupo,clv_materias) VALUES(?,?,?,?,?)";
                pstmt = con.prepareStatement(sql21);
                pstmt.setInt(1, var2);
                pstmt.setInt(2, var3);
                pstmt.setString(3, var4);
                pstmt.setString(4, var5);
                pstmt.setString(5, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql21 = "SELECT id_equipo,id_aula,cantidad FROM aula_equipo";
        Statement stmt14 = conexion.createStatement();
        ResultSet rs14 = stmt14.executeQuery(sql21);
        while (rs14.next()) {
            var1 = rs.getInt("id_equipo");
            var2 = rs.getInt("cantidad");
            var6 = rs.getString("id_aula");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql22 = "INSERT INTO aula_equipo(id_equipo,id_aula,cantidad) VALUES(?,?,?)";
                pstmt = con.prepareStatement(sql22);
                pstmt.setInt(1, var1);
                pstmt.setInt(3, var2);
                pstmt.setString(2, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        //
        String sql24 = "SELECT id_categoria,nombre,descripcion FROM categorias_equipo";
        Statement stmt15 = conexion.createStatement();
        ResultSet rs15 = stmt15.executeQuery(sql24);
        while (rs15.next()) {
            var1 = rs.getInt("id_categorias");
            var4 = rs.getString("nombre");
            var6 = rs.getString("descripcion");
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
            try {
                //Aqui ya se esta hablando de la B.D del SQL normal que ya deberia estar montada
                Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
                PreparedStatement pstmt = null;
                String sql22 = "INSERT INTO categorias_equipo(id_categoria,nombre,descripcion) VALUES(?,?,?)";
                pstmt = con.prepareStatement(sql22);
                pstmt.setInt(1, var1);
                pstmt.setString(2, var4);
                pstmt.setString(3, var6);
                //Se executa el statement para que se agreguen los datos
                pstmt.executeUpdate();
                // pstmt.setString(3,variable3);
                pstmt.executeUpdate();
                con.close();
                if (con != null) {
                }
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    //Las busquedas son basicamente lo que viste arriba para mostrar texto

    public static void busqueda_volatil2(Connection conexion) throws SQLException {
        //El statement que sera usado para correr las query en sqlite
        Statement stat = conexion.createStatement();
        String sql3 = "SELECT id, name, capacity FROM warehouses";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getDouble("capacity"));
        }
    }
    public static void busqueda_materia(Connection conexion) throws SQLException {
        String sql3 = "SELECT nombre_materia,clv_materia,creditos,cuatrimestre,posicion,clv_plan,horas_x_semana,tipo_materia  FROM materia";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("nombre_materia")+ "\n"+
            rs.getString("clv_materia")+ "\n" +
            rs.getInt("creditos")+ "\n" +
            rs.getInt("cuatrimestre")+ "\n"+
            rs.getInt("posicion")+ "\n" +
            rs.getString("clv_plan")+ "\n" +
            rs.getInt("horas_x_semana")+ "\n" +
            rs.getString("tipo_materia"));
        }

    }
    public static void busqueda_usuario(Connection conexion) throws SQLException{
        String sql3 = "SELECT clv_usuario,idcarrera,nombre_usuario,nivel_ads,contrato FROM usuarios";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("clv_usuario")+ "\n"+
                    rs.getInt("idcarrera")+ "\n" +
                    rs.getInt("cuatrimestre")+ "\n"+
                    rs.getString("nombre_usuario")+ "\n" +
                    rs.getString("nivel_ads")+ "\n" +
                    rs.getString("tipo_contrato"));
        }
    }
    public static void busqueda_grupo_materia_profesor(Connection conexion) throws SQLException{
        String sql3 = "SELECT clv_grupo,clv_materia,clv_usuario FROM grupo_materia_profesor";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("clv_grupo")+ "\n"+
                    rs.getString("clv_materia")+ "\n" +
                    rs.getString("clv_usuario"));
        }
    }
    public static void busqueda_login(Connection conexion) throws SQLException{
        String sql3 = "SELECT clv_usuario,pass_usuario,tipo_usuario  FROM login";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("clv_usuario")+ "\n"+
                    rs.getString("pass_usuario")+ "\n" +
                    rs.getString("tipo_usuario"));
        }
    }
    public static void busqueda_disponibilidad(Connection conexion) throws SQLException{
        String sql3 = "SELECT dia,espacio_tiempo,clv_usuario FROM disponibilidad";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("dia")+ "\n"+
                    rs.getInt("espacio_tiempo")+ "\n" +
                    rs.getString("clv_usuario"));
        }
    }
    public static void busqueda_carrera(Connection conexion) throws SQLException{
        String sql3 = "SELECT idcarrera,nombre_carrera FROM carrera";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("idcarrera")+ "\n"+
                    rs.getString("nombre_carrera"));
        }
    }
    public static void busqueda_prestamo(Connection conexion) throws SQLException{
        String sql3 = "SELECT clv_usuario,idcarrera FROM prestamos";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("idcarrera")+ "\n"+
                    rs.getString("clv_usuario"));
        }
    }
    public static void busqueda_plan_estudios(Connection conexion) throws SQLException{
        String sql3 =  "SELECT clv_plan,nombre_plan,nivel,idcarrera FROM plan_estudios";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("clv_plan")+ "\n"+
                    rs.getInt("idcarrera")+ "\n" +
                    rs.getString("nombre_plan")+ "\n" +
                    rs.getString("nivel"));
        }
    }
    public static void busqueda_aulas(Connection conexion) throws SQLException{
        String sql3 =  "SELECT id_aula, nombre, tipo, capacidad FROM aulas";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("id_aula")+ "\n"+
                    rs.getInt("capacidad")+ "\n" +
                    rs.getString("nombre")+ "\n" +
                    rs.getString("tipo"));
        }
    }
    public static void busqueda_materia_usuario(Connection conexion) throws SQLException{
        String sql3 =  "SELECT clv_materia,clv_plan,clv_usuario,puntos_confianza,puntos_director FROM materia_usuario";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("clv_materia")+ "\n"+
                    rs.getInt("puntos_confianza")+ "\n" +
                    rs.getInt("puntos_director")+ "\n" +
                    rs.getString("clv_plan")+ "\n" +
                    rs.getString("clv_usuario"));
        }
    }
    public static void uso_aula_grupo(Connection conexion) throws SQLException{
        String sql3 =  "SELECT dia,espacio_tiempo,id_aula,clv_grupo,clv_materia FROM uso_aula_grupo";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("id_aula")+ "\n"+
                    rs.getInt("dia")+ "\n" +
                    rs.getInt("espacio_tiempo")+ "\n" +
                    rs.getString("clv_grupo")+ "\n" +
                    rs.getString("clv_materia"));
        }
    }
    public static void busqueda_aula_equipo(Connection conexion) throws SQLException{
        String sql3 = "SELECT id_equipo,id_aula,cantidad FROM aula_equipo";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("id_equipo")+ "\n"+
                    rs.getInt("cantidad")+ "\n" +
                    rs.getString("id_aula"));
        }
    }
    public static void busqueda_equipo(Connection conexion) throws SQLException{
        String sql3 =  "SELECT id_equipo,id_categoria,nombre,descripcion FROM equipo";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getString("nombre")+ "\n"+
                    rs.getInt("id_equipo")+ "\n" +
                    rs.getInt("id_categoria")+ "\n" +
                    rs.getString("descripcion"));
        }
    }
    public static void busqueda_categorias_equipo(Connection conexion) throws SQLException{
        String sql3 =  "SELECT id_categoria,nombre,descripcion FROM categorias_equipo";
        Statement stmt = conexion.createStatement();
        ResultSet rs = stmt.executeQuery(sql3);
        while (rs.next()) {
            System.out.println(rs.getInt("id_categorias")+ "\n"+
                    rs.getString("nombre")+ "\n" +
                    rs.getString("descripcion"));
        }
    }
    public static void conexionBD(String ruta, String usuario, String contrasena){
        //Para el que este leyendo esto: Estos prints son para poder agarrar los datos del usuario
        //estan predefinidos ya porque chingo a mi madre si voy a escribir la pinche ruta tamaño de pito
        //que ya tenia por el proyecto anterior
        //Try catch para ver si el Driver existe es lo mismo said no le gusta que arriba diga THOW SQLEXEPTION
        //Tambien sirve que lo compadeces mas poniendo try catch supongo
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //Lo de arriba x2 hey si quieres ver algo mejor almenos si sirve para ver si existe la cosa esa
        try {
            Connection con = DriverManager.getConnection(ruta, usuario, contrasena);
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
