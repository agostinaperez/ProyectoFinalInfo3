public class Producto {

    private String nombre;
    private int stock;
    private Producto siguiente;

    public Producto(String nombre, int stock){
        this.nombre = nombre;
        this.stock = stock;
        this.siguiente=null;
    }
    public String getNombre(){
        return nombre;
    }

    public int getStock(){
        return stock;
    }
    public void setStock(int stock){
        this.stock = stock;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public Producto  getSig(){
        return this.siguiente;
    }

    public void setSiguiente(Producto p){
        this.siguiente = p;
    }

}
