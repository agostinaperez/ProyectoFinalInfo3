import java.util.Scanner;

import static java.lang.System.exit;

public class Opciones {
    Inventario inv = new Inventario();

    Organizador organizador = new Organizador();
    Scanner sc = new Scanner(System.in);

    public void menu() {

        int seleccion = 0;

        do {
            System.out.println("\nBienvenido al sistema de Gestión de Inventario! \nPor favor, seleccione una opción: \n");
            System.out.println("--------------------------");
            System.out.println("1.Agregar producto");
            System.out.println("--------------------------");
            System.out.println("2.Eliminar producto");
            System.out.println("--------------------------");
            System.out.println("3.Buscar producto");
            System.out.println("--------------------------");
            System.out.println("4.Mostrar inventario");
            System.out.println("--------------------------");
            System.out.println("5.Modificar el stock de un producto");
            System.out.println("--------------------------");
            System.out.println("9.Salir");
            System.out.println("--------------------------\n");
            seleccion = sc.nextInt();
            switch (seleccion) {
                case 1 -> agregar();
                case 2 -> borrar();
                case 3 -> buscar();
                case 4 -> mostrar();
                case 5 -> cambiarStock();
                case 9 -> salir();
                default -> System.out.println("¡Ups! La opción seleccionada no es válida. Inténtelo de nuevo");
            }
        } while (seleccion != 9);
    }

    public void agregar() {
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        sc.nextLine();
        String nombre = sc.nextLine();
        nombre = nombre.toUpperCase();
        System.out.println("Ingrese la cantidad de stock del producto a añadir: \n");
        int stock = sc.nextInt();

        Producto prod = new Producto(nombre, stock);
        inv.insertar(prod);
        organizador.agregar(prod, null);
    }

    public void borrar()  {
        System.out.println("Ingrese el nombre del producto a eliminar: \n");
        String nombre = sc.nextLine().toUpperCase().trim();

        try{
            Producto producto = organizador.buscarPorNombre(nombre);
            organizador.borrar(producto);
            inv.borrar(nombre);
        } catch (Exception e){
            System.out.println("El elemento que se desea eliminar no existe, o no se encuentra en el inventario!");
        }
    }

    public void mostrar() {
        inv.mostrar();
    }

    public void buscar() {
        System.out.println("Ingrese el nombre del producto a buscar: \n");
        String nombre = sc.nextLine().toUpperCase().trim();
        try {
            organizador.buscarPorNombre(nombre);
        }catch (Exception e){
            System.out.println("Aparentemente el elemento que buscas no existe! Intenta nuevamente");
        }

    }


    public  void cambiarStock(){
        System.out.println("Ingrese el nombre del producto cuyo stock desea cambiar: ");
        String nombre = sc.nextLine().toUpperCase().trim();
        try {
            Producto prod = organizador.buscarPorNombre(nombre);
            System.out.println("El stock actual del producto es de: " + prod.getStock() + " unidades.");

            System.out.println("Ingrese el nuevo stock del producto: ");
            int nuevoStock = sc.nextInt();
            prod.setStock(nuevoStock);
            System.out.println("El stock del producto ha sido actualizado!");
        } catch (Exception e) {
            System.out.println("Aparentemente el elemento que buscas no existe! Intenta nuevamente");
        }

    }

    public void salir(){
        System.out.println("\n¡Muchas gracias por usar nuestro sistema!");
        exit(0);
    }
}
