package co.edu.uniquindio.poo.app;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Producto;
import co.edu.uniquindio.poo.model.Tienda;
import co.edu.uniquindio.poo.model.Venta;


public class App {
    public static void main(String[] args) {

        String nombretienda =JOptionPane.showInputDialog(null, " Ingresar el nombre de la tienda");
        String ubicacion =JOptionPane.showInputDialog(null, " Ingresar la ubicacion de la tienda");
        String nit =JOptionPane.showInputDialog(null, " Ingresar el nit de la tienda");

        ArrayList <Producto> listaProductos = new ArrayList<Producto>();
        ArrayList <Cliente> listaCliente = new ArrayList<Cliente>();
        ArrayList <Venta> listaVentas = new ArrayList<Venta>();
        
        
        


        String nombreProducto =JOptionPane.showInputDialog(null, " Ingresar el nombre del producto");
        String codigo = JOptionPane.showInputDialog(null, " Ingresar el codigo del producto");
        Double precio = Double.parseDouble(JOptionPane.showInputDialog(null, " Ingresar el precio del producto"));
        String categoria = JOptionPane.showInputDialog(null, " Ingresar la categoria del producto");
        int stock = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingresar el stock del producto"));

        

        String nombreCliente =JOptionPane.showInputDialog(null, " Ingresar el nombre del Cliente");
        String Identificacion =JOptionPane.showInputDialog(null, " Ingresar el nombre del Cliente");
        String Direccion =JOptionPane.showInputDialog(null, " Ingresar el nombre del Cliente");
        String telefono =JOptionPane.showInputDialog(null, " Ingresar el nombre del Cliente");
        String Email =JOptionPane.showInputDialog(null, " Ingresar el nombre del Cliente");
        ArrayList <Producto> listaProductosComprados = new ArrayList<Producto>();



        


        Tienda tienda = new Tienda(nombretienda, ubicacion, nit, listaProductos, listaCliente, listaVentas);
        Producto producto = new Producto(nombreProducto, codigo,  precio , categoria, stock);
        Producto producto2 = new Producto(nombreProducto, codigo, precio, categoria, stock);
        Cliente cliente = new Cliente(nombreCliente, Identificacion, Direccion, telefono, Email, listaProductosComprados);
        Cliente cliente2 = new Cliente(nombreCliente, Identificacion, Direccion, telefono, Email, listaProductosComprados);


        LocalDate fecha = LocalDate.parse(JOptionPane.showInputDialog(null, " Ingresar la fecha de la venta"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, " Ingresar la cantidad del producto comprado "));
        



        Venta venta = new Venta(fecha, cliente2, producto2, cantidad);


        tienda.agregarProducto(producto2);
        tienda.agregarProducto(producto);
        tienda.registrarCliente(cliente);
        tienda.registrarCliente(cliente2);
        tienda.registrarVenta(venta);

        
        JOptionPane.showMessageDialog(null, tienda );





    }
}
