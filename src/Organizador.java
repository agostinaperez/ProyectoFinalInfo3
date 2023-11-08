public class Organizador {
    private Nodo raiz;

    public Organizador() {
        this.raiz = null;
    }

    //Recibe un producto e iniciliza un nodo con ese producto
    //que luego lo agrega al arbol.
    public void agregar(Producto prod) {
        if(raiz==null){
            this.raiz = new Nodo(prod);
        }
        if ((prod.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
            if (raiz.getIzquierdo() == null) {
                raiz.setIzquierdo(new Nodo(prod));
            } else {
                agregar(prod, raiz.getIzquierdo());
            }
        } else {
            if (raiz.getDerecho() == null) {
                raiz.setDerecho(new Nodo(prod));
            } else {
                agregar(prod, raiz.getDerecho());
            }
        }
    }
    private void agregar(Producto prod, Nodo Nodo) {
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

    //Recibe un producto y lo elimina del arbol si es que encuentra
    //coincidencia de el nombre del producto con algun producto ya guardado.
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


    private Nodo borrar (Producto prod, Nodo nodo) throws Exception {
        if (prod.getNombre().equals(nodo.getProducto().getNombre())){
            if(nodo.getIzquierdo() == null && nodo.getDerecho() == null) nodo = null;
            else if (nodo.getDerecho() == null) nodo = nodo.getIzquierdo();
            else if (nodo.getIzquierdo() == null) nodo = nodo.getDerecho() ;
            else{
                Nodo aux = nodo.getIzquierdo();
                nodo = nodo.getDerecho();
                Nodo aux2 = nodo.getIzquierdo();
                if(aux2 != null){
                    while(aux.getIzquierdo() != null){
                        aux2 = aux2.getIzquierdo();
                    }
                    aux2.setIzquierdo(aux);
                }
                else nodo.setIzquierdo(aux);
            }
        }
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && nodo.getIzquierdo() != null) nodo.setIzquierdo(borrar(prod, nodo.getIzquierdo()));
        else if (prod.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && nodo.getDerecho() != null) nodo.setDerecho(borrar(prod, nodo.getDerecho()));
        else throw new Exception("El elemento no esta en el arbol");
        return nodo;
    }

    //Recibe el nombre de un producto y lo busca en el arbol, si
    //lo encuentra retorna dicho producto.
    public Producto buscarPorNombre(String nombre) throws Exception {
        return buscarPorNombreRecursivo(raiz, nombre);
    }

    private Producto buscarPorNombreRecursivo(Nodo nodo, String nombre) throws Exception {
        if (nodo == null) throw new Exception("El producto no existe");
        if (nombre.equals(nodo.getProducto().getNombre().replace(" ", ""))) {
            return nodo.getProducto();
        }
        if (nombre.compareTo(nodo.getProducto().getNombre().replace(" ", "")) < 0) {
            return buscarPorNombreRecursivo(nodo.getIzquierdo(), nombre);
        }
        return buscarPorNombreRecursivo(nodo.getDerecho(), nombre);
    }
}
