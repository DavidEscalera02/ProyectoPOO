import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class EmpleadoDAO {
    public static void crearEmpleadoDB(Empleado empleado) {
        conexion db_connect = new conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "INSERT INTO `dbtienda`.`empleados` ('nombre`, `apellido`, `empleo`, `direcion`, `telefono`) VALUES (?,?,?,?,?,?)";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, empleado.getNombre());
                    ps.setString(2, empleado.getApellido());
                    ps.setString(3, empleado.getEmpleo());
                    ps.setString(4, empleado.getDireccion());
                    ps.setString(5, empleado.getTelefono());
                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("empleado ingresado correctamente.");
                    } else {
                        System.out.println("No se pudo ingresar al empleado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }catch (SQLException e) {
                System.out.println(e);
        }
    }
    public static void leerEmpleadoDB(){
        conexion db_conexion = new conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try (Connection conexion = db_conexion.get_conConnection()){
            String query= "SELECT * FROM `empleados`";
            ps = conexion.prepareStatement(query);
            rs= ps.executeQuery();
            while (rs.next()){
                System.out.println("ID_CLIENTE: "+rs.getInt("id_cliente"));
                System.out.println("NOMBRE: "+rs.getString("Nombre"));
                System.out.println("APELLIDO: "+rs.getString("Apellido"));
                System.out.println("EMPLEO: "+rs.getString("empleo"));
                System.out.println("DIRECCION: "+rs.getString("Direccion"));
                System.out.println("TELEFONO: "+rs.getString("Telefono"));
                System.out.println("---------------------");
            }

        } catch (SQLException e){
            System.out.println(e);
        }
    }
    public static void BorrarEmpleadoDB(int nombreEmpleado) {
        conexion db_connect = new conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "DELETE FROM `dbtienda`.`empleados` WHERE `id` = ?";

                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(1, nombreEmpleado);

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el empleado con el id ingresado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public static void actualizarEmpleado(Empleado empleado) {
        conexion db_connect = new conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `dbtienda`.`empleados` SET `Nombre` = ?, `Apellido` = ?, `Empleo` = ?, 'Direccion' = ?, `Telefono` = ? WHERE `id` = ?";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, empleado.getNombre());
                    ps.setString(2, empleado.getApellido());
                    ps.setString(3, empleado.getEmpleo());
                    ps.setString(4, empleado.getDireccion());
                    ps.setString(5, empleado.getTelefono());
                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("Empleado se actualizo correctamente.");
                    } else {
                        System.out.println("No se encontro el empleado con la ID ingresado.");
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




