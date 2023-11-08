public class Producto {

    private String nombre;
    private int stock;

    public Producto(String nombre, int stock) {
        this.nombre = nombre;
        this.stock = stock;
    }

    //retorna el nombre del producto
    public String getNombre() {
        return nombre;
    }

    //Retorna el stock del producto
    public int getStock() {
        return stock;
    }

    //Recibe un valor stock y setea el stock del producto.
    public void setStock(int stock) {
        this.stock = stock;
    }

    //Recibe un nombre y setea el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
