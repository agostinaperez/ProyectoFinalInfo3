# Proyecto Final Info 3
Instituto Universitario Aeronáutico
Proyecto final Informática 3, año 2023.
Agostina Pérez y Tomás Tissera.

# Logica y Funcionamiento Del Proyecto
Para este sistema de gestion de inventario se utilizan
seis clases ademas del main. 

La clase Producto tiene como
atributos el nombre y el stock del producto. 

La clase
inventario es una lista enlazada que almacena productos
utilizando la subclase Nodo. 

La clase Organizador es 
un arbol binario que utiliza la clase Nodo para almacenar 
productos. 

El programa nos permite agregar o borrar un 
producto que se realizara tanto en el arbol como en 
la lista. Podremos buscar un producto, se utiliza el
arbol para ello. Para mostrar un producto se utilizara
la lista. y ademas, se podra modificar el stock de un
producto.
# Compilacion Del Programa
Para utilizar el programa desde la terminal del sistema, se debe abrir la terminal y navegar hasta el directorio src en donde está el proyecto.
Allí, ejecutar el comando "javac Main.java". Esto compilará el programa. Para ejecutarlo, tipear en la misma terminal "java Main"
Para utilizar el programa desde la terminal del IDE, se debe abrir el archivo MAIN.java y compilarlo. 
Una vez compilado se desplegara un menu de opciones.
