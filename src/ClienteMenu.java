import java.util.Scanner;

public class ClienteMenu {
    public static void menuClientes() {
        Scanner sc = new Scanner(System.in);
        int opCliente;

        do {
            System.out.println("--------------");
            System.out.println("MENU CLIENTES");
            System.out.println("1- Crear cliente");
            System.out.println("2- Listar cliente");
            System.out.println("3- Editar cliente");
            System.out.println("4- Eliminar cliente");
            System.out.println("5- Volver al menu principal");

            opCliente = sc.nextInt();
            sc.nextLine();

            switch (opCliente) {
                case 1:
                    ClienteService.crearCliente();
                    break;
                case 2:
                    ClienteService.listarCliente();
                    break;
                case 3:
                    ClienteService.editarCliente();
                    break;
                case 4:
                    ClienteService.borrarCliente();
                    break;
                case 5:
                    System.out.println("Volviendo al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
            }
        } while (opCliente != 5);
    }
}
