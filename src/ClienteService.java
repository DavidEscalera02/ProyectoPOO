import java.util.Scanner;

public class ClienteService {
    public static void crearCliente(){
        Scanner sc= new Scanner(System.in);
        System.out.println("INGRESE EL NOMBRE: ");
        String nombre= sc.nextLine();
        System.out.println("INGRESE EL APELLIDO: ");
        String apellido =sc.nextLine();
        System.out.println("INGRESE EL EMAIL: ");
        String email= sc.nextLine();
        System.out.println("INGRESE lA DIRECION: ");
        String direccion= sc.nextLine();
        System.out.println("INGRESE SU NUMERO DE TELEFONO: ");
        String telefono = sc.nextLine();
        Cliente cliente=new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setEmail(email);
        cliente.setDireccion(direccion);
        cliente.setTelefono(telefono);
        ClienteDAO.crearClienteDB(cliente);

    }
    public static void listarCliente(){

    }
    public static void borrarCliente(){

    }
    public static void editarCliente(){

    }
}
