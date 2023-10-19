import java.util.Scanner;

public class Opciones {
    Inventario inv = new Inventario();
    Scanner sc= new Scanner(System.in);
    public void menu(){

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
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        String nombre=sc.nextLine().toUpperCase();
        System.out.println("Ingrese la cantidad de stock del producto a añadir: \n");
        int stock=sc.nextInt();
        inv.insertar(new Producto(nombre, stock));

        //falta agregarlo al árbol binario
    }

    public void borrar(){
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        String nombre=sc.nextLine().toUpperCase();
        inv.borrar(nombre);

        //falta borrar del árbol binario
    }

    public void mostrar(){
        inv.mostrar();
    }

    public void buscar(){

        //me da fiaca hacer esto

    }
}
