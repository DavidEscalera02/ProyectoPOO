import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int opcion = 0;


            do {
                System.out.println("-------MENU PRINCIPAL------");
                System.out.println("1-  Clientes");
                System.out.println("2-  Empleados");
                System.out.println("3-  almacen");
                System.out.println("4-  Salir");
                System.out.print("Seleccione una opcion: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        ClienteMenu.menuClientes();
                        break;
                    case 2:
                        EmpleadoMenu.menuEmpleado();
                        break;
                    case 3:
                        ALmacenMenu.menuAlmacen();
                        break;
                    case 4:
                        System.out.println("Saliendo del programa. ¡Que tenga un buen dia...!");
                        break;
                    default:
                        System.out.println("Opcion no valida... Por favor, seleccione una opcion valida.");
                }

            } while (opcion != 4);{
                sc.close();
            }
        }
}
