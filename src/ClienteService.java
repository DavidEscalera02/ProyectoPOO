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
        ClienteDAO.leerClienteDB();

    }
    public static void borrarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("INGRESE EL ID DEL CLIENTE QUE DESEA ELIMINAR: ");
        int id_Cliente_eliminar = sc.nextInt();
        ClienteDAO.borrarClienteDB(id_Cliente_eliminar);

    }
    public static void editarCliente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre: ");
        String nombre= sc.nextLine();
        System.out.println("Ingrese el nuevo apellido");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el nuevo email: ");
        String correo= sc.nextLine();
        System.out.println("Ingrese la nueva direccion: ");
        String direccion= sc.nextLine();
        System.out.println("Ingrese el nuevo telefono: ");
        String telefono= sc.nextLine();


        System.out.println("Indica el ID del cliente a editar: ");
        int id_cli= sc.nextInt();
        Cliente actuaCliente = new Cliente();
        actuaCliente.setNombre(nombre);
        actuaCliente.setApellido(apellido);
        actuaCliente.setEmail(correo);
        actuaCliente.setDireccion(direccion);
        actuaCliente.setTelefono(telefono);
        actuaCliente.setId_cliente(id_cli);

        ClienteDAO.actualizarClienteDB(actuaCliente);
    }

    }

