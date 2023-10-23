//NODO ARBOL
public class Nodo<Producto> {
    private Producto prod;
    private Nodo<Producto> izquierdo;
    private Nodo<Producto> derecho;

    public Nodo(Producto p){

        prod= p;
        izquierdo = null;
        derecho = null;
    }

    public Producto getProducto(){

        return prod;
    }

    public Nodo<Producto> getIzquierdo(){
        return izquierdo;
    }
    public Nodo<Producto> getDerecho(){
        return derecho;
    }

    public void setIzquierdo(Nodo<Producto> l){ izquierdo= l; }
    public void setDerecho(Nodo<Producto> r){
        derecho= r;
    }

}

