
import java.util.Scanner;

public class EmpleadoService {
    public static void crearEmpleado(){
    Scanner sc= new Scanner(System.in);
    System.out.println("Ingrese el nuevo nombre del  empleado: ");
    String nombre;
    nombre=sc.nextLine();
    System.out.println("Ingrese el nuevo apellido del  empleado: ");
    String apellido;
    apellido=sc.nextLine();
    System.out.println("Ingrese el nuevo empleo del empleado: ");
    String empleo;
    empleo= sc.nextLine();
    System.out.println("Ingrese Direccion: ");
    String direccion;
    direccion= sc.nextLine();
    System.out.println("Ingrese Telefono: ");
    String telefono;
    telefono= sc.nextLine();



    Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setEmpleo(empleo);
        empleado.setDireccion(direccion);
        empleado.setTelefono(telefono);
        EmpleadoDAO.crearEmpleadoDB(empleado);
}

    public static void listarEmpleados(){
        EmpleadoDAO.leerEmpleadoDB();
    }
    public static void borrarEmpleado() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("INGRESE EL ID DEL EMPLEADO QUE DESEA ELIMINAR: ");
        int nombreEmpleadoEliminar = scanner.nextInt();
        EmpleadoDAO.BorrarEmpleadoDB(nombreEmpleadoEliminar);
    }



    public static void editarEmpleado(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre: ");
        String nombre= sc.nextLine();
        System.out.println("Ingrese el nuevo apellido: ");
        String apellido = sc.nextLine();
        System.out.println("Ingrese el nuevo empleo: ");
        String empleo = sc.nextLine();
        System.out.println("Ingrese la nueva direccion: ");
        String direccion= sc.nextLine();
        System.out.println("Ingrese el nuevo telefono: ");
        String telefono= sc.nextLine();

        System.out.println("Indica el ID del empleado a editar: ");
        int id_emp= sc.nextInt();
        Empleado actuaEmpleado = new Empleado();
        actuaEmpleado.setNombre(nombre);
        actuaEmpleado.setApellido(apellido);
        actuaEmpleado.setEmpleo(empleo);
        actuaEmpleado.setDireccion(direccion);
        actuaEmpleado.setTelefono(telefono);
        actuaEmpleado.setId_empleado(id_emp);

        EmpleadoDAO.actualizarEmpleado(actuaEmpleado);
    }

}
