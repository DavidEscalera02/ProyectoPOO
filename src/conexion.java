import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public Connection get_conConnection() {
        Connection conection = null;
        try {
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbTienda", "root", "");
            if (conection != null) {
                System.out.println("conexion exitosa....");

            }

        } catch (SQLException e) {
            System.out.println("error: " + e);

        }
        return conection;
    }
}

