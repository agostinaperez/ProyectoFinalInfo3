public class Inventario {
    private Producto primero;

    public Inventario() {
        primero = null;
    }

    public void insertar(Producto prod) {
        if (primero == null) {
            primero = prod;
        } else {
            Producto actual = primero;
            while (actual.getSig() != null) {
                actual = actual.getSig();

            }
            actual.setSiguiente(prod);
        }
        System.out.println("El producto se ha añadido al inventario con éxito");
    }


    //REVISAR Y PROBAR POR LAS DUDAS PORQUE ME MAREÉ
    public void borrar(String nombre) {
        if (primero == null) {
            System.out.println("El inventario ya está vacío!");
        } else {
            if (primero.getNombre().equals(nombre)) {
                primero = primero.getSig();
            } else {
                Producto temp = primero;
                while (temp.getSig() != null && !temp.getSig().getNombre().equals(nombre)) {
                    temp = temp.getSig();
                }
                if (temp.getSig() != null) {
                    temp.setSiguiente((temp.getSig()).getSig());
                } else {
                    System.out.println("El elemento '" + nombre + "' no se encuentra en el inventario.");
                }
                }

            }
            System.out.println("El elemento se ha borrado del inventario con éxito!");
        }

        public void mostrar () {
            Producto actual = primero;

            do {
                System.out.println("Nombre: "+ actual.getNombre() + ", Stock: "+ actual.getStock());
                actual = actual.getSig();

            } while (actual.getSig() != null);

        }
    }

