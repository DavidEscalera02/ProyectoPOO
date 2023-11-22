import java.util.Scanner;

public class ALmacenMenu {
    public static void menuAlmacen(){
        Scanner sc =new Scanner(System.in);
        int opalma=0;
        do{
            System.out.println("----MENU ALMACEN--");
            System.out.println("1. Crear nuevo almacen: ");
            System.out.println("2. Listar almacenes");
            System.out.println("3. Editar almacen");
            System.out.println("4. Eliminar almacen");
            System.out.println("5. Volver al menu principal");
            opalma = sc.nextInt();

            switch (opalma) {
                case 1:
                    AlmacenService.crearAlmacen();
                    break;
                case 2:
                    AlmacenService.listarAlmacen();
                    break;
                case 3:
                    AlmacenService.editarAlmacen();
                    break;
                case 4:
                    AlmacenService.Borraralmacen();
                    break;
                case 5:
                    System.out.println("Volver al menu principal");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                    break;
            }
        }while (opalma!=5);

    }

}
