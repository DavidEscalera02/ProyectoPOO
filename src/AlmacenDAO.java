import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlmacenDAO {
    public static void AlmacenDB(Almacen almacen) {
        conexion db_connect = new conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String B_datos = "INSERT INTO `dbtienda`.`almacen` (`nombre`, `direccion`, `telefono`) VALUES (?,?,?)";
                try (PreparedStatement ps = conexion.prepareStatement(B_datos)) {
                    ps.setString(1, almacen.getNombre());
                    ps.setString(1, almacen.getDireccion());
                    ps.setString(1, almacen.getTelefono());

                    ps.executeUpdate();
                }
                System.out.println("Almacen insertado correctamente");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void ListarAlmacenDB() {
        conexion db_connect = new conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try (Connection conexion = db_connect.get_conConnection()) {
            String query = "SELECT * FROM almacen";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("ID_ALMACEN: " + rs.getInt("id_almacen"));
                System.out.println("NOMBRE: " + rs.getString("Nombre"));
                System.out.println("DIRECCION: " + rs.getString("Direccion"));
                System.out.println("TELEFONO: " + rs.getString("Telefono"));
                System.out.println("------------------------------");
            }

        } catch (SQLException e) {
            System.out.println(e);

        }
    }

    public static void eliminarAlmacenDB(int nombreProveedor) {
        conexion db_connect = new conexion();
        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "DELETE FROM `dbtienda`.`almacen` WHERE `id` = ?";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setInt(1, nombreProveedor);
                    int filasAfectadas = ps.executeUpdate();
                    if (filasAfectadas > 0) {
                        System.out.println("Almacen eliminado correctamente.");
                    } else {
                        System.out.println("No se encontro el Almacen con el id ingresado.");
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizaralmacenDB(Almacen almacen) {
        conexion db_connect = new conexion();

        try (Connection conexion = db_connect.get_conConnection()) {
            try {
                String query = "UPDATE `frigobas`.`proveedor` SET `Nombre` = ?, `Direccion` = ?, `CorreoElectronico`= ?, `Telefono` = ? WHERE `id` = ?";
                try (PreparedStatement ps = conexion.prepareStatement(query)) {
                    ps.setString(1, almacen.getNombre());
                    ps.setString(2, almacen.getDireccion());
                    ps.setString(3, almacen.getTelefono());
                    ps.setInt(4, almacen.getId_almacen());

                    int filasAfectadas = ps.executeUpdate();

                    if (filasAfectadas > 0) {
                        System.out.println("El Almacen se actualizo correctamente.");
                    } else {
                        System.out.println("No se encontro el almacen con la ID ingresado.");
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
