import java.sql.Connection;
import java.sql.PreparedStatement;
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

    }
    public static void borrarClienteDB(int id_cliente){

    }
    public static void actualizarClienteDB(Cliente cliente){

    }
}
