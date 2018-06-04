package basedatos;

/**
 *
 * @author Alejo
 */
//import Controller.Imagen;
//import behind.Estudiante;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import modelo.Preguntas;
import modelo.Usuario;

/**
 * Esta clase define las conexiones a la base de datos y los métodos para el
 * CRUD
 *
 * @author: David Alejandro Castro Benavides
 * @version: 1.0
 */
public class BaseDatos {

    Connection conexion;
    Statement st;

    public BaseDatos() {
        //conexion
    }

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método utilizado para establecer la conexión con la base de datos
     *
     * @return estado regresa el estado de la conexión, true si se estableció la
     * conexión, falso en caso contrario
     */
    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");                                      //user  //pass
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/juegoserio", "root", "root");
            st = conexion.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar las instrucciones: INSERT, DELETE y UPDATE
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return estado regresa el estado de la ejecución, true(éxito) o
     * false(error)
     *
     */
    public boolean ejecutarSQL(String sql) {
        try {
            Statement sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     *
     * Método utilizado para realizar la instrucción SELECT
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     *
     */
    public Usuario ejecutarSQLSelectBuscarUsuario(String sql) {
        ResultSet rs;
        String idu;
        String nombre1u;
        String nombre2u;
        String apellidou1;
        String apellidou2;
        String correou;
        String contraseniau;
        // System.out.println("esta es la con: "+contraseniau);
        String celularu;
        boolean adminu = true;
        Usuario obj = null;

        try {
            Statement sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                idu = rs.getNString("idU");
                nombre1u = rs.getNString("nombreu1");
                nombre2u = rs.getNString("nombreu2");
                apellidou1 = rs.getNString("apellidou1");
                apellidou2 = rs.getNString("apellidou2");
                correou = rs.getNString("correou");
                contraseniau = rs.getNString("contraseniau");
                celularu = rs.getNString("celularu");
                adminu = rs.getBoolean("adminu");

                obj = new Usuario(idu, nombre1u, nombre2u, apellidou1, apellidou2, correou, contraseniau, celularu, adminu);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return obj;
    }

//    public boolean UpdateEstudiante(Estudiante estudiantemod, Imagen imagen) throws SQLException, IOException {
//        boolean modificar = false;
//        FileInputStream fis = null;
//        String update = "update estudiantes set idestudiantes = ?,"
//                + "codigoestudiante=?,"
//                + "nombreestudiante=?,"
//                + "apellidoestudiante=?,"
//                + "telefonoestudiante=?,"
//                + "direccionestudiante=?,"
//                + "correoestudiante=?,"
//                + "imagenestudiante=? where codigoestudiante = ?";
//        PreparedStatement preparedStmt = conexion.prepareStatement(update);
//        preparedStmt.setString(1, estudiantemod.getIdestudiantes());
//        preparedStmt.setString(2, estudiantemod.getCodigoestudiante());
//        preparedStmt.setString(3, estudiantemod.getNombreestudiante());
//        preparedStmt.setString(4, estudiantemod.getApellidoestudiante());
//        preparedStmt.setString(5, estudiantemod.getTelefonoestudiante());
//        preparedStmt.setString(6, estudiantemod.getDireccionestudiante());
//        preparedStmt.setString(7, estudiantemod.getCorreoestudiante());
//
//      
//        
//        if (!"".equals(estudiantemod.getRutaImagenestudiante())) {
//            File file = new File(estudiantemod.getRutaImagenestudiante());
//            try {
//                fis = new FileInputStream(file);
//                preparedStmt.setBinaryStream(8, fis, (int) file.length());
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            preparedStmt.setString(9, estudiantemod.getCodigoestudiante());
//
//            preparedStmt.executeUpdate();
//            preparedStmt.close();
//            modificar = true;
//        } else {
//            if (imagen != null) { //tengan cuidado con estas rutas... deben cambiarlas
//                ImageIO.write((RenderedImage) imagen.getImagen(), "jpg", new File("C://Users//Alejo//Documents//David//david.jpg"));
//                File imageFile = new File("C://Users//Alejo//Documents//David//david.jpg");
//                fis = new FileInputStream(imageFile);
//                preparedStmt.setBinaryStream(8, fis, (int) imageFile.length());
//
//                preparedStmt.setString(9, estudiantemod.getCodigoestudiante());
//
//                preparedStmt.executeUpdate();
//                preparedStmt.close();
//                modificar = true;
//            }
//        }
//
//        return modificar;
//    }
    public void storeProcedious() {
        CallableStatement statemen;
        try {
            statemen = conexion.prepareCall("{call INSERT_USUARIO(%,%,%)}");
            statemen.setString(1, "Gloria");
            statemen.setString(2, "3344");
            statemen.setString(3, "CAlle Medellin 7345");
            if (statemen.execute()) {
                System.out.println("si se realizó ");
            }

        } catch (Exception ex) {

        }
    }

    public void storeProcediousImage(String ruta) {
        CallableStatement statemen;
        FileInputStream fis = null;

        try {
            statemen = conexion.prepareCall("{call INSERT_USUARIO_PICTURE(?,?,?,?)}");
            File file = new File(ruta);
            System.out.println("ruta " + ruta);
            fis = new FileInputStream(file);
            statemen.setString(1, "Maria");
            statemen.setString(2, "555");
            statemen.setString(3, "Itagui");
            statemen.setBinaryStream(4, fis, (long) file.length());
            if (!statemen.execute()) {
                System.out.println("si se realizó ");
            }

        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean sqlInsertWithImage(String ruta, String insert) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, "1135");
            ps.setString(2, "David");
            ps.setString(3, "Benavides");
            ps.setString(4, "30156");
            ps.setBinaryStream(5, fis, (int) file.length());
            //ps.setString(2, nombre);
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public boolean sqlInsertWithImageEstudiante(String ruta, String insert, String idestudiantes, String codigoestudiante, String nombreestudiante, String apellidoestudiante, String telefonoestudiante, String direccionestudiante, String correoestudiante) {
        // String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
        FileInputStream fis = null;
        PreparedStatement ps = null;
        try {

            conexion.setAutoCommit(false);
            File file = new File(ruta);
            fis = new FileInputStream(file);
            ps = conexion.prepareStatement(insert);
            ps.setString(1, idestudiantes);
            ps.setString(2, codigoestudiante);
            ps.setString(3, nombreestudiante);
            ps.setString(4, apellidoestudiante);
            ps.setString(5, telefonoestudiante);
            ps.setString(6, direccionestudiante);
            ps.setString(7, correoestudiante);
            ps.setBinaryStream(8, fis, (int) file.length());
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                fis.close();
            } catch (Exception ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

//    public ArrayList buscarCodigo(String buscarpor) throws IOException {
//        ArrayList arrElementos = new ArrayList();
//        String cadena = "";
//        try {
//            ResultSet rs = st.executeQuery("SELECT * FROM estudiantes WHERE codigoestudiante=" + buscarpor + "");
//            while (rs.next()) {
//                Imagen imagen = new Imagen();
//                String idestudiantes = rs.getObject("idestudiantes").toString();
//                String codigoestudiante = rs.getObject("codigoestudiante").toString();
//                String nombreestudiante = rs.getObject("nombreestudiante").toString();
//                String apellidoestudiante = rs.getObject("apellidoestudiante").toString();
//                String telefonoestudiante = rs.getObject("telefonoestudiante").toString();
//                String direccionestudiante = rs.getObject("direccionestudiante").toString();
//                String correoestudiante = rs.getObject("correoestudiante").toString();
//                Blob blob = rs.getBlob("imagenestudiante");
//
//                arrElementos.add(idestudiantes);
//                arrElementos.add(codigoestudiante);
//                arrElementos.add(nombreestudiante);
//                arrElementos.add(apellidoestudiante);
//                arrElementos.add(telefonoestudiante);
//                arrElementos.add(direccionestudiante);
//                arrElementos.add(correoestudiante);
//
//                byte[] data = blob.getBytes(1, (int) blob.length());
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(new ByteArrayInputStream(data));
//                } catch (IOException ex) {
//                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//                }
////
//                imagen.setImagen(img);
//
//                arrElementos.add(imagen.getImagen());
////                imagen.setNombre(nombre);
////                lista.add(imagen);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return arrElementos;
//    }
//    public ArrayList<Imagen> getImagenes() throws IOException {
//        ArrayList<Imagen> lista = new ArrayList();
//        try {
//            ResultSet rs = st.executeQuery("SELECT nombreusuario,imagenusuario FROM usuario WHERE idusuario=11");
//            while (rs.next()) {
//                Imagen imagen = new Imagen();
//                Blob blob = rs.getBlob("imagenusuario");
//                String nombre = rs.getObject("nombreusuario").toString();
//                byte[] data = blob.getBytes(1, (int) blob.length());
//                BufferedImage img = null;
//                try {
//                    img = ImageIO.read(new ByteArrayInputStream(data));
//                } catch (IOException ex) {
//                    Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//                }
//
//                imagen.setImagen(img);
//                imagen.setNombre(nombre);
//                lista.add(imagen);
//            }
//            rs.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lista;
//    }
    public boolean insertarUsuarioJ(Usuario obju) {
        int valor = 0;
        boolean r = false;
        if (obju.isAdminu()) {
            valor = 1;
        } else {
            valor = 0;
        }
        String sql = "INSERT INTO usuarios (idU, nombreu1, nombreu2, apellidou1, apellidou2, correou, contraseniau, celularu,adminu)"
                + "VALUES('" + obju.getIdu() + "', '" + obju.getNombre1u() + "', '" + obju.getNombre2u() + "', '" + obju.getApellidou1() + "', '" + obju.getApellidou2()
                + "', '" + obju.getCorreou() + "', '" + obju.getContraseniau() + "', '" + obju.getCelularu() + "', " + valor + " );";

        if (crearConexion()) {
            r = ejecutarSQL(sql);
        }

        return r;
    }

    public int ejecutarSQLSelectTrivia(String sql) {
        int idtrivia = 0;
        String nomT = "";
        ResultSet rs;

        try {
            Statement sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                idtrivia = rs.getInt("idtrivia");
                nomT = rs.getNString("temat");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return idtrivia;
    }

    public boolean insertarPreguntas(LinkedList<Preguntas> listaPreguntas) {
        boolean insert = false;
        for (int i = 0; i < listaPreguntas.size(); i++) {
            String sql = "INSERT INTO preguntas (preguntap, respuesta1p, respuesta2p, respuesta3p, respuestacorrectap, idtpfk)"
                    + "VALUES('" + listaPreguntas.get(i).getPregunta() + "', '" + listaPreguntas.get(i).getRespuesta1() + "', '"
                    + listaPreguntas.get(i).getRespuesta2() + "', '" + listaPreguntas.get(i).getRespuesta3() + "', '"
                    + listaPreguntas.get(i).getRespuestacorrecta() + "', " + listaPreguntas.get(i).getFkTrivia() + ");";
            if (crearConexion()) {
                insert = ejecutarSQL(sql);
            }
        }

        return insert;
    }

    /**
     *
     * Método que busca todas las trivias en la BD juegoSerio
     *@return un hashMap con la pk de cada trivia y el nombre de la trivia
     */
    public HashMap<Integer, String> buscarTrivias() {
        String sql = "Select * from trivias;";
        HashMap<Integer, String> lt = new HashMap<>();
        ResultSet rs;
        String nomt;
        int pk;
        try {
            Statement sentencia = conexion.createStatement();
            rs = sentencia.executeQuery(sql);
            while (rs.next()) {
                pk = rs.getInt("idtrivia");
                nomt = rs.getNString("temat");
                lt.put(pk, nomt);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            //return null;
        }

        return lt;
    }
}
