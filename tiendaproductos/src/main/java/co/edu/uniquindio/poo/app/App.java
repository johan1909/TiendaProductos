package co.edu.uniquindio.poo.app;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Producto;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Producto producto = new Producto("asjd", "64516", 15.1, "caefea", 4);

        JOptionPane.showMessageDialog(null,producto);
    }
}
