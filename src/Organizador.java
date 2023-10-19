//ARBOL
//HAY QUE VER SI FUNCIONA CORRECTAMENTE
public class Organizador {
    private Nodo<Producto> raiz;

    public Organizador(Producto data) {
        this.raiz = new Nodo<>(data);
        //this.depth = 0;
    }

    public void add(Producto x) {
        if ((x.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
            if (raiz.getLeft() == null) {
                raiz.setLeft(new Nodo<>(x));
            } else {
                add(x, raiz.getLeft());
            }
        } else {
            if (raiz.getRight() == null) {
                raiz.setRight(new Nodo<>(x));
            } else {
                add(x, raiz.getRight());
            }
        }
    }
    private void add(Producto x, Nodo<Producto> Nodo) {
        if ((x.getNombre().compareTo(raiz.getProducto().getNombre())) < 0) {
            if (Nodo.getLeft() == null) {
                Nodo.setLeft(new Nodo<>(x));
            } else {
                add(x, Nodo.getLeft());
            }
        } else {
            if (Nodo.getRight() == null) {
                Nodo.setRight(new Nodo<>(x));
            } else {
                add(x, Nodo.getRight());
            }
        }
    }
    public void delete (Producto x) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())){
            if(raiz.getLeft() == null && raiz.getRight() == null) raiz = null;
            else if (raiz.getRight() == null) raiz = raiz.getLeft();
            else if (raiz.getLeft() == null) raiz = raiz.getRight();
            else{
                Nodo<Producto> aux = raiz.getLeft();
                raiz = raiz.getRight();
                Nodo<Producto> aux2 = raiz.getLeft();
                if(aux2 != null){
                    while(aux2.getLeft() != null){
                        aux2 = aux2.getLeft();
                    }
                    aux2.setLeft(aux);
                }
                else raiz.setLeft(aux);
            }

        }
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getLeft() != null) raiz.setLeft(delete(x, raiz.getLeft()));
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getRight() != null) raiz.setRight(delete(x, raiz.getRight()));
        else throw new Exception("El elemento no esta en el arbol");
    }

    private Nodo<Producto> delete (Producto x, Nodo<Producto> Nodo) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())){
            if(Nodo.getLeft() == null && Nodo.getRight() == null) Nodo = null;
            else if (Nodo.getRight() == null) Nodo = Nodo.getLeft();
            else if (Nodo.getLeft() == null) Nodo = Nodo.getRight() ;
            else{
                Nodo<Producto> aux = Nodo.getLeft();
                Nodo = Nodo.getRight();
                Nodo<Producto> aux2 = Nodo.getLeft();
                if(aux2 != null){
                    while(aux2.getLeft() != null){
                        aux2 = aux2.getLeft();
                    }
                    aux2.setLeft(aux);
                }
                else Nodo.setLeft(aux);
            }
        }
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && Nodo.getLeft() != null) Nodo.setLeft(delete(x, Nodo.getLeft()));
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && Nodo.getRight() != null) Nodo.setRight(delete(x, Nodo.getRight()));
        else throw new Exception("El elemento no esta en el arbol");
        return Nodo;
    }
    public Producto search(Producto x) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())) return raiz.getProducto();
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && raiz.getLeft() != null) return search(x, raiz.getLeft());
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && raiz.getRight() != null) return search(x, raiz.getRight());
        else throw new Exception("El elemento no esta en el arbol");
    }

    private Producto search(Producto x, Nodo<Producto> node) throws Exception {
        if (x.getNombre().equals(raiz.getProducto().getNombre())) return node.getProducto();
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) < 0 && node.getLeft() != null) return search(x, node.getLeft());
        else if (x.getNombre().compareTo(raiz.getProducto().getNombre()) > 0 && node.getRight() != null) return search(x, node.getRight());
        else throw new Exception("El elemento no esta en el arbol");
    }
}

