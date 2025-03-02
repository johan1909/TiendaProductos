package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Producto;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Producto producto = new Producto("Café", "64516", 5.000, "Bebidas", 20);

        JOptionPane.showMessageDialog(null,producto);
    }
}
