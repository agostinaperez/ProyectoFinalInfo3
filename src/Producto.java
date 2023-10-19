public class Producto {

    private String nombre;
    private int stock;

    public Producto(String nombre, int stock){
        this.nombre = nombre;
        this.stock = stock;
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
    //Colocar dentro de la implementacion de la lista
    /*
    public Producto  getSig(){
        return this.siguiente;
    }

    public void setSiguiente(Producto p){
        this.siguiente = p;
    }*/

}
