import java.util.Scanner;

public class AlmacenService {
    public static void crearAlmacen(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Ingrese el Nombre: ");
        String nombre;
        nombre= sc.nextLine();
        System.out.println("Ingrese la direccion: ");
        String direccion;
        direccion= sc.nextLine();
        System.out.println("Ingrese su telefono: ");
        String telefono;
        telefono= sc.nextLine();

        Almacen almacen =new Almacen();

        almacen.setNombre(nombre);
        almacen.setDireccion(direccion);
        almacen.setTelefono(telefono);
        AlmacenDAO.AlmacenDB(almacen);
    }
    public static void listarAlmacen(){
        AlmacenDAO.ListarAlmacenDB();
    }

    public static void Borraralmacen() {
        Scanner sc = new Scanner(System.in);

        System.out.print("INGRESE EL ID DEL ALMACEN QUE DESEA ELIMINAR: ");
        int nombreAlmacenAEliminar = sc.nextInt();
        AlmacenDAO.eliminarAlmacenDB(nombreAlmacenAEliminar);
    }
    public static void editarAlmacen(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nuevo nombre: ");
        String nombre= sc.nextLine();
        System.out.println("Escribe el nuevo direccion: ");
        String direccion= sc.nextLine();
        System.out.println("Escribe el nuevo telefono: ");
        String telefono= sc.nextLine();
        System.out.println("Indica el ID del almacen a editar: ");
        int id_Almacen = sc.nextInt();
        Almacen actualmacen =new Almacen();
        actualmacen.setNombre(nombre);
        actualmacen.setDireccion(direccion);
        actualmacen.setTelefono(telefono);
        actualmacen.setId_almacen(id_Almacen);
        AlmacenDAO.actualizaralmacenDB(actualmacen);


    }

}
