public class Nodo {
    private Producto prod;
    private Nodo izquierdo;
    private Nodo derecho;

    public Nodo(Producto p){

        prod= p;
        izquierdo = null;
        derecho = null;
    }

    //Retorna un producto
    public Producto getProducto(){

        return prod;
    }

    //Retorna el Nodo izquierdo
    public Nodo getIzquierdo(){
        return izquierdo;
    }

    ////Retorna el Nodo izquierdo
    public Nodo getDerecho(){
        return derecho;
    }

    //Recibe un Nodo y lo setea en el Nodo izquierdo
    public void setIzquierdo(Nodo izquierdo){ this.izquierdo= izquierdo; }

    //Recibe un Nodo y lo setea el Nodo derecho
    public void setDerecho(Nodo derecho){
        this.derecho= derecho;
    }

}

