import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class InterfazGrafica
{
    private JFrame ventana;
    private JPanel panelCentral;

    /**
     * Crea un VisorDeImagen y lo muestra en la pantalla.
     */
    public InterfazGrafica()
    {
        construirVentana();
    }


    // ---- implementación de las funciones del menu ----


    /* Función Salir: sale de la aplicación.
     */
    private void salir()
    {
        System.exit(0);
    }

    // ---- Elementos de swing para construir la ventana y sus componentes ----

    /**
     * Crea la ventana Swing y su contenido.
     */
    private void construirVentana()
    {
        ventana = new JFrame("Controlador de inventario");
        construirBarraDeMenu(ventana);

        Container panelContenedor = ventana.getContentPane();
        // Creamos un panel central con un BorderLayout para colocar el texto en el centro
        // Creamos un panel central con un BoxLayout en eje Y
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.Y_AXIS));
        panelContenedor.add(panelCentral);

        // Creamos un JLabel para mostrar el texto en el centro
        JLabel etiqueta = new JLabel("Bienvenido al sistema de Gestión de Inventario! \n Por favor, seleccione una opción:");
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); // Centrar el texto
        Font fuente = etiqueta.getFont();
        etiqueta.setFont(new Font(fuente.getName(), Font.PLAIN, 24)); // Tamaño de fuente 24

        panelCentral.add(etiqueta);

        // Creamos 4 botones y los agregamos al panel central
        JButton boton1 = new JButton("Agregar un producto");
        JButton boton2 = new JButton("Borrar un producto");
        JButton boton3 = new JButton("Buscar un producto en el inventario");
        JButton boton4 = new JButton("Mostrar todo el inventario");

        // Centrar los botones en el eje X
        boton1.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton2.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton3.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton4.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentral.add(Box.createRigidArea(new Dimension(10, 10))); // Espacio vertical
        panelCentral.add(boton1);
        panelCentral.add(Box.createRigidArea(new Dimension(10, 10))); // Espacio vertical
        panelCentral.add(boton2);
        panelCentral.add(Box.createRigidArea(new Dimension(10, 10))); // Espacio vertical
        panelCentral.add(boton3);
        panelCentral.add(Box.createRigidArea(new Dimension(10, 10))); // Espacio vertical
        panelCentral.add(boton4);

        // Configuración final de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300); // Tamaño de la ventana

        // Construcción hecha - se acomodan los componentes y se muestran
        ventana.pack();
        ventana.setVisible(true);
    }

    /**
     * Crea la barra de menú de la ventana.
     * @param ventana  La ventana a la cual se debe agregar la barra de menú.
     */
    private void construirBarraDeMenu(JFrame ventana)
    {
        JMenuBar barraDeMenu = new JMenuBar();
        ventana.setJMenuBar(barraDeMenu);

        // crea el menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        barraDeMenu.add(menuArchivo);

        JMenuItem elementoSalir = new JMenuItem("Salir");
        elementoSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { salir(); }
        });
        menuArchivo.add(elementoSalir);

    }
}
