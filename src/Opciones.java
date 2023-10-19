import java.util.Scanner;

public class Opciones {

    public void menu(){
        Scanner sc= new Scanner(System.in);

        int seleccion=0;

        do {
            System.out.println("Bienvenido al sistema de Gestión de Inventario! \n Por favor, seleccione una opción: \n 1.Agregar producto \n 2.Eliminar producto \n 3.Buscar producto \n 4.Mostrar inventario \n 9.Salir");
            seleccion = sc.nextInt();
            switch (seleccion) {
                case 1 -> agregar();
                case 2 -> borrar();
                case 3 -> buscar();
                case 4 -> mostrar();
                case 9 -> System.out.println("¡Muchas gracias por usar nuestro sistema!");
            }
        } while (seleccion!=9);
    }
    public void agregar(){

    }

    public void borrar(){}

    public void mostrar(){}

    public void buscar(){

    }
}
