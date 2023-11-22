public class Main {
    public static void main(String[] args) {
        System.out.println("hola undo");
        conexion cox= new conexion();
        try {
            cox.get_conConnection();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
