//ARBOL
//HAY QUE VER SI FUNCIONA CORRECTAMENTE
public class Organizador {
    private Nodo raiz;

    public Organizador() {
        this.raiz = null;
    }
    public void agregar(Producto prod, Nodo Nodo) {
        if (this.raiz == null) {
            raiz = new Nodo(prod);
        } else {
            if ((prod.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
                if (Nodo.getIzquierdo() == null) {
                    Nodo.setIzquierdo(new Nodo(prod));
                } else {
                    agregar(prod, Nodo.getIzquierdo());
                }
            } else {
                if (Nodo.getDerecho() == null) {
                    Nodo.setDerecho(new Nodo(prod));
                } else {
                    agregar(prod, Nodo.getDerecho());
                }
            }
        }
    }
    public void borrar (Producto prod) throws Exception {
        if (prod.getNombre().equals(raiz.getProducto().getNombre())){
            if(raiz.getIzquierdo() == null && raiz.getDerecho() == null) raiz = null;
            else if (raiz.getDerecho() == null) raiz = raiz.getIzquierdo();
            else if (raiz.getIzquierdo() == null) raiz = raiz.getDerecho();
            else{
                Nodo aux = raiz.getIzquierdo();
                raiz = raiz.getDerecho();
                Nodo aux2 = raiz.getIzquierdo();
                if(aux2 != null){
                    while(aux2.getIzquierdo() != null){
                        aux2 = aux2.getIzquierdo();
                    }
                    aux2.setIzquierdo(aux);
                }
                else raiz.setIzquierdo(aux);
            }

        }
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getIzquierdo() != null) raiz.setIzquierdo(borrar(prod, raiz.getIzquierdo()));
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getDerecho() != null) raiz.setDerecho(borrar(prod, raiz.getDerecho()));
        else throw new Exception("El elemento no esta en el arbol");
    }


    private Nodo borrar (Producto prod, Nodo Nodo) throws Exception {
        if (prod.getNombre().equals(raiz.getProducto().getNombre())){
            if(Nodo.getIzquierdo() == null && Nodo.getDerecho() == null) Nodo = null;
            else if (Nodo.getDerecho() == null) Nodo = Nodo.getIzquierdo();
            else if (Nodo.getIzquierdo() == null) Nodo = Nodo.getDerecho() ;
            else{
                Nodo aux = Nodo.getIzquierdo();
                Nodo = Nodo.getDerecho();
                Nodo aux2 = Nodo.getIzquierdo();
                if(aux2 != null){
                    while(aux.getIzquierdo() != null){
                        aux2 = aux2.getIzquierdo();
                    }
                    aux2.setIzquierdo(aux);
                }
                else Nodo.setIzquierdo(aux);
            }
        }
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && Nodo.getIzquierdo() != null) Nodo.setIzquierdo(borrar(prod, Nodo.getIzquierdo()));
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && Nodo.getDerecho() != null) Nodo.setDerecho(borrar(prod, Nodo.getDerecho()));
        else throw new Exception("El elemento no esta en el arbol");
        return Nodo;
    }
    public Producto buscar(Producto prod) throws Exception {
        if (prod.getNombre().equals(raiz.getProducto().getNombre())) return raiz.getProducto();
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getIzquierdo() != null) return buscar(prod, raiz.getIzquierdo());
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getDerecho() != null) return buscar(prod, raiz.getDerecho());
        else throw new Exception("El elemento no esta en el arbol");
    }

    private Producto buscar(Producto prod, Nodo nodo) throws Exception {
        if (prod.getNombre().equals(raiz.getProducto().getNombre().trim())) return nodo.getProducto();
        int comparacion = prod.getNombre().compareTo(raiz.getProducto().getNombre().trim());
        if (comparacion < 0 && nodo.getIzquierdo() != null) return buscar(prod, nodo.getIzquierdo());
        else if (comparacion > 0 && nodo.getDerecho() != null) return buscar(prod, nodo.getDerecho());
        else throw new Exception("El elemento no esta en el arbol");
    }

    public Producto buscarPorNombre(String nombre) throws Exception {
        return buscarPorNombreRecursivo(raiz, nombre);
    }

    private Producto buscarPorNombreRecursivo(Nodo nodo, String nombre) throws Exception {
        if (nodo == null) throw new Exception("El producto no existe");
        if (nombre.equals(nodo.getProducto().getNombre().trim())) {
            return nodo.getProducto();
        }
        if (nombre.compareTo(nodo.getProducto().getNombre().trim()) < 0) {
            return buscarPorNombreRecursivo(nodo.getIzquierdo(), nombre);
        }
        return buscarPorNombreRecursivo(nodo.getDerecho(), nombre);
    }
}
