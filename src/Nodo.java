//NODO ARBOL
public class Nodo<Producto> {
    private Producto prod;
    private Nodo<Producto> nextleft;
    private Nodo<Producto> nextright;

    public Nodo(Producto p){

        prod= p;
        nextleft = null;
        nextright= null;
    }

    public Producto getProducto(){

        return prod;
    }

    public Nodo<Producto> getLeft(){
        return nextleft;
    }
    public Nodo<Producto> getRight(){
        return nextright;
    }

    public void setLeft(Nodo<Producto> l){
        nextleft= l;
    }
    public void setRight(Nodo<Producto> r){
        nextright= r;
    }

}

