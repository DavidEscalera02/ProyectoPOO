import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    public static void crearClienteDB(Cliente cliente){
        conexion db_connect = new conexion();
        try (Connection conexion =db_connect.get_conConnection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO `dbtienda`.`cliente` (`nombre`, `apellido`, `email`, `direccion`, `telefono`) VALUES (?,?,?,?,?)";
                ps= conexion.prepareStatement(query);
                ps.setNString(1, cliente.getNombre());
                ps.setNString(2, cliente.getApellido());
                ps.setNString(3, cliente.getEmail());
                ps.setNString(4, cliente.getDireccion());
                ps.setNString(5, cliente.getTelefono());
                ps.executeUpdate();
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void leerClienteDB(){
        conexion db_conexion = new conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try (Connection conexion = db_conexion.get_conConnection()){
            String query= "SELECT * FROM cliente";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID_CLIENTE: "+rs.getInt("id_cliente"));
                System.out.println("NOMBRE: "+rs.getString("nombre"));
                System.out.println("APELLIDO: "+rs.getString("apellido"));
                System.out.println("EMAIL: "+rs.getString("email"));
                System.out.println("DIRECCION: "+rs.getString("direccion"));
                System.out.println("TELEFONO: "+rs.getString("telefono"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e){
            System.out.println(e);
        }

    }
    public static void borrarClienteDB(int id_cliente){
        conexion db_connect = new conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query ="DELETE FROM `dbtienda`.`cliente` WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(0, id_cliente);

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el cliente con el id proporcionado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    public static void actualizarClienteDB(Cliente cliente){
        conexion db_connect = new conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `dbtienda`.`cliente` SET `nombre`=?, `apellido`=?, `email`=?, 'direccion'=?, 'telefono'=? WHERE  `id`=?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, cliente.getNombre());
                    ps.setString(2, cliente.getTelefono());
                    ps.setString(3, cliente.getDireccion());
                    ps.setString(4, cliente.getEmail());
                    ps.setInt(5, cliente.getId_cliente());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Cliente se  actualizo correctamente.");
                    } else {
                        System.out.println("No se encontro el cliente con el IN igresado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    }

