//NODO ARBOL
public class Nodo {
    private Producto prod;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(Producto p){

        prod= p;
        izquierdo = null;
        derecho = null;
    }

    public Producto getProducto(){

        return prod;
    }

    public Nodo getIzquierdo(){
        return izquierdo;
    }
    public Nodo getDerecho(){
        return derecho;
    }

    public void setIzquierdo(Nodo izquierdo){ this.izquierdo= l; }
    public void setDerecho(Nodo derecho){
        this.derecho= r;
    }

}

