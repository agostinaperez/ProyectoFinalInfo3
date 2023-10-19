public class Inventario <Producto> {
    //El inventario es una lista enlazada, cada nodo es un producto
    public Producto elemento;
    public Inventario<Producto> siguiente;

    public Inventario(Producto elemento){ this(elemento, null);}
    public Inventario(Producto elemento, Inventario<Producto> sig){
        this.elemento=elemento;
        this.siguiente=sig;
    }
}
