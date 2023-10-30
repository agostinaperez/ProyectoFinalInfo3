import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventario{
    private Nodo inicio;
    private int tamanio;

    public Inventario() {
        inicio = null;
        tamanio=0;
    }

    public void insertar(Producto p) {
        Nodo nuevo = new Nodo(p);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamanio++;
    }

    public void borrar(String nombre) throws Exception {
        if (inicio == null) {
            System.out.println("La lista está vacía! No se puede eliminar!");
        } else {

            if (inicio.getProducto().getNombre().replace(" ", "").equals(nombre)) {
                inicio = inicio.getSiguiente();
                tamanio--;
                System.out.println("El producto se ha eliminado del inventario con éxito!");
                return;
            }

            Nodo actual = inicio;
            while (actual.getSiguiente() != null) {
                if ((actual.getSiguiente().getProducto().getNombre().replace(" ", "")).equals(nombre)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    tamanio--;
                    System.out.println("El producto se ha eliminado del inventario con éxito!");
                    return;
                }
                actual = actual.getSiguiente();
            }
        }
        throw new Exception("El elemento no se encuentra en el inventario");
    }

    public int getTamanio(){ return tamanio; }

    public void mostrar () {
        System.out.println("\n-------------------------");
        System.out.println("INVENTARIO:");
        System.out.println("-------------------------");
        List<String> nombres = new ArrayList<>();
        Nodo actual = inicio;

        while (actual != null) {
            nombres.add(actual.getProducto().getNombre());
            actual = actual.getSiguiente();
        }

        Collections.sort(nombres);

        for (String nombre : nombres) {
            Nodo nodo = inicio;
            while (nodo != null) {
                if (nodo.getProducto().getNombre().equals(nombre)) {
                    System.out.println("Nombre: " + nodo.getProducto().getNombre() + ", Stock: " + nodo.getProducto().getStock());
                    System.out.println("--------------------------------- \n");
                    break;
                }
                nodo = nodo.getSiguiente();
            }
        }
    }

    private static class Nodo {
        private Producto producto;
        private Nodo siguiente;

        public Nodo(Producto p) {
            this.producto = p;
            this.siguiente = null;
        }

        public Producto getProducto() {
            return producto;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }
}
