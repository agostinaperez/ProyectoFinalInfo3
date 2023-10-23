import java.util.Scanner;

public class Opciones {
    Inventario inv = new Inventario();
    Scanner sc= new Scanner(System.in);

    public void agregar(){
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        String nombre=sc.nextLine().toUpperCase();
        System.out.println("Ingrese la cantidad de stock del producto a añadir: \n");
        int stock=sc.nextInt();
        inv.insertar(new Producto(nombre, stock));

        //falta agregarlo al arbol binario
    }

    public void borrar(){
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        String nombre=sc.nextLine().toUpperCase().trim();
        inv.borrar(nombre);

        //falta borrar del árbol binario
    }

    public void mostrar(){
        inv.mostrar();
    }

    public void buscar(){
        System.out.println("Ingrese el nombre del producto a añadir: \n");
        String nombre=sc.nextLine().toUpperCase().trim();


    }
}
