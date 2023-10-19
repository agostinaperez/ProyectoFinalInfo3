import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();

    }

    public static void menu(){
        Scanner sc= new Scanner(System.in);

        System.out.println("Bienvenido al sistema de Gestión de Inventario! \n Por favor, seleccione una opción: \n 1.Agregar producto \n 2.");
        int op=sc.nextInt();
    }

}
