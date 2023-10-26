//ARBOL
//HAY QUE VER SI FUNCIONA CORRECTAMENTE
public class Organizador {
    private Nodo<Producto> raiz;

    public Organizador(Producto data) {
        this.raiz = new Nodo<>(data);
        //this.depth = 0;
    }

    public void agregar(Producto x) {
        if ((x.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
            if (raiz.getIzquierdo() == null) {
                raiz.setIzquierdo(new Nodo<>(x));
            } else {
                agregar(x, raiz.getIzquierdo());
            }
        } else {
            if (raiz.getDerecho() == null) {
                raiz.setDerecho(new Nodo<>(x));
            } else {
                agregar(x, raiz.getDerecho());
            }
        }
    }
    private void agregar(Producto x, Nodo<Producto> Nodo) {
        if ((x.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
            if (Nodo.getIzquierdo() == null) {
                Nodo.setIzquierdo(new Nodo<>(x));
            } else {
                agregar(x, Nodo.getIzquierdo());
            }
        } else {
            if (Nodo.getDerecho() == null) {
                Nodo.setDerecho(new Nodo<>(x));
            } else {
                agregar(x, Nodo.getDerecho());
            }
        }
    }
    public void borrar (Producto x) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())){
            if(raiz.getIzquierdo() == null && raiz.getDerecho() == null) raiz = null;
            else if (raiz.getDerecho() == null) raiz = raiz.getIzquierdo();
            else if (raiz.getIzquierdo() == null) raiz = raiz.getDerecho();
            else{
                Nodo<Producto> aux = raiz.getIzquierdo();
                raiz = raiz.getDerecho();
                Nodo<Producto> aux2 = raiz.getIzquierdo();
                if(aux2 != null){
                    while(aux2.getIzquierdo() != null){
                        aux2 = aux2.getIzquierdo();
                    }
                    aux2.setIzquierdo(aux);
                }
                else raiz.setIzquierdo(aux);
            }

        }
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getIzquierdo() != null) raiz.setIzquierdo(delete(x, raiz.getIzquierdo()));
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getDerecho() != null) raiz.setDerecho(delete(x, raiz.getDerecho()));
        else throw new Exception("El elemento no esta en el arbol");
    }

    private Nodo<Producto> borrar (Producto x, Nodo<Producto> Nodo) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())){
            if(Nodo.getIzquierdo() == null && Nodo.getDerecho() == null) Nodo = null;
            else if (Nodo.getDerecho() == null) Nodo = Nodo.getIzquierdo();
            else if (Nodo.getIzquierdo() == null) Nodo = Nodo.getDerecho() ;
            else{
                Nodo<Producto> aux = Nodo.getIzquierdo();
                Nodo = Nodo.getDerecho();
                Nodo<Producto> aux2 = Nodo.getIzquierdo();
                if(aux2 != null){
                    while(aux2.getIzquierdo() != null){
                        aux2 = aux2.getIzquierdo();
                    }
                    aux2.setIzquierdo(aux);
                }
                else Nodo.setIzquierdo(aux);
            }
        }
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && Nodo.getIzquierdo() != null) Nodo.setIzquierdo(delete(x, Nodo.getIzquierdo()));
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && Nodo.getDerecho() != null) Nodo.setDerecho(delete(x, Nodo.getDerecho()));
        else throw new Exception("El elemento no esta en el arbol");
        return Nodo;
    }
    public Producto buscar(Producto x) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())) return raiz.getProducto();
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getIzquierdo() != null) return buscar(x, raiz.getIzquierdo());
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getDerecho() != null) return buscar(x, raiz.getDerecho());
        else throw new Exception("El elemento no esta en el arbol");
    }

    private Producto buscar(Producto x, Nodo<Producto> node) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())) return node.getProducto();
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && node.getIzquierdo() != null) return buscar(x, node.getIzquierdo());
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && node.getDerecho() != null) return buscar(x, node.getDerecho());
        else throw new Exception("El elemento no esta en el arbol");
    }
}

