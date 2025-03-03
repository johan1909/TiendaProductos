package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tienda {


    private String nombre;
    private String ubicacion;
    private String nit;
    private ArrayList <Producto> listaProductos;
    private ArrayList <Cliente> listaClientes;
    private ArrayList <Venta> listaVentas;



    public Tienda(String nombre, String ubicacion, String nit, ArrayList<Producto> listaProductos,
            ArrayList<Cliente> listaClientes, ArrayList<Venta> listaVentas) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.nit = nit;
        this.listaProductos = new ArrayList<Producto>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaVentas = new ArrayList<Venta>();
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getUbicacion() {
        return ubicacion;
    }



    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



    public String getNit() {
        return nit;
    }



    public void setNit(String nit) {
        this.nit = nit;
    }



    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }



    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }



    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }



    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }



    public ArrayList<Venta> getListaVentas() {
        return listaVentas;
    }



    public void setListaVentas(ArrayList<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }


    /**
     * Metodo Registra un nuevo cliente
     * @param nuevoCliente
     * @return
     */

    public String registrarCliente(Cliente nuevoCliente) {
        
    
        String mensaje = "";
        Cliente clienteEncontrado = buscarCliente(nuevoCliente.getIdentificacion());
    
        if (clienteEncontrado != null) {
            mensaje = "Ya existe";
        } else {
            listaClientes.add(nuevoCliente);
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }
    

    /**
     * Busca un cliente mediante la identificacion
     * @param identificacion
     * @return
     */

    private Cliente buscarCliente(String identificacion) {
        for (Cliente clienteAux : listaClientes) {
            if (clienteAux.getIdentificacion().equals(identificacion)) {
                return clienteAux;
            }
        }
        return null;
    }





    /**
     * elimina un cliente mediante el numero de identificacion
     * @param identificacion
     * @return
     */

    public String eliminarCliente(String identificacion){
        String mensaje="Cliente inexistente";
        for (Cliente clienteAux : listaClientes){
            if(clienteAux.getIdentificacion().equals(identificacion)){
                listaClientes.remove(clienteAux);
                mensaje=" El registro se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }



    /**
     * Actualiza un cliente mediante el numero de identificacion
     * @param nombre
     * @param identificacion
     * @param direccion
     * @param telefono
     * @param email
     * @param listaProductosComprados
     * @return
     */

    public String actualizarCliente( String nombre, String identificacion, String direccion, String telefono, String email, ArrayList <Producto> listaProductosComprados){

        String mensaje = " no encontrado";
        Cliente clienteEncontrado = buscarCliente(identificacion);
        if(clienteEncontrado != null){
            clienteEncontrado.setNombre(nombre);
            clienteEncontrado.setIdentificacion(identificacion);
            clienteEncontrado.setDireccion(direccion);
            clienteEncontrado.setTelefono(telefono);
            clienteEncontrado.setEmail(email);
            clienteEncontrado.setListaProductosComprados(listaProductosComprados);
            
            mensaje = " se actualizó correctamente";
        }
        return mensaje;
    }




    /**
     * registra una nueva venta
     * @param nuevoProducto
     * @param cantidad
     * @return
     */


    public String registrarVenta(Venta nuevaVenta) {
        
    
        String mensaje = "";
        Venta ventaEncontrada = buscarVenta(nuevaVenta.getCliente());
        Producto productoAux = nuevaVenta.getProducto();
        if (ventaEncontrada.getCantidad() >=productoAux.getStock() ) {
            mensaje = "No hay Stock suficiente";
        } else {
            listaVentas.add(nuevaVenta) ;
            productoAux.reducirStock(ventaEncontrada.getCantidad());
            Cliente cliente= ventaEncontrada.getCliente();
            cliente.agregarProducto(productoAux);
            mensaje = " se agregó correctamente";

        }
    
        return mensaje;
    }
    

    /**
     * Busca un producto mediante el codigo
     * @param codigo
     * @return
     */

    private Venta buscarVenta(Cliente cliente) {
        for (Venta ventaAux : listaVentas) {
            if (ventaAux.getCliente().equals(cliente)) {
                return ventaAux;
            }
        }
        return null;
    }


    public ArrayList<Venta> buscarVentaClientes(Cliente cliente) {
        ArrayList <Venta> ventasCliente = new ArrayList<Venta>();
        for (Venta ventaAux : listaVentas) {
            if (ventaAux.getCliente().equals(cliente)) {
                ventasCliente.add(ventaAux);
            }
        }
        return null;
    }


    /**
     * elimina un producto de la lista 
     * @param codigo
     * @return
     */

    public String eliminarVenta(Cliente cliente){
        String mensaje="venta inexistente";
        for (Venta ventaAux : listaVentas){
            if(ventaAux.getCliente().equals(cliente)){
                listaVentas.remove(ventaAux);
                mensaje=" El venta se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }



    /**
     * Actualiza la lista de ventas 
     * @param nombre
     * @param codigo
     * @param precio
     * @return
     */

    public String actualizarVenta( LocalDate fecha, Cliente cliente, Producto producto, int cantidad, Double montoTotal){

        String mensaje = " no encontrado";
        Venta ventaEncontrada = buscarVenta(cliente);
        if(ventaEncontrada != null){
            ventaEncontrada.setFecha(fecha);
            ventaEncontrada.setCliente(cliente);
            ventaEncontrada.setProducto(producto);
            ventaEncontrada.setCantidad(cantidad);
            ventaEncontrada.setMontoTotal(montoTotal);
            mensaje = " se actualizó correctamente";
        }
        return mensaje;
    }



    
    public String agregarProducto(Producto nuevoProducto) {
        
    
        String mensaje = "";
        Producto productoEncontrado = buscarProducto(nuevoProducto.getCodigo());
    
        if (productoEncontrado != null) {
            mensaje = "Ya existe";
        } else {
            listaProductos.add(nuevoProducto) ;
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }
    

    /**
     * Busca un producto mediante el codigo
     * @param codigo
     * @return
     */

    private Producto buscarProducto(String codigo) {
        for (Producto productoAux : listaProductos) {
            if (productoAux.getCodigo().equals(codigo)) {
                return productoAux;
            }
        }
        return null;
    }





    /**
     * elimina un producto de la lista 
     * @param codigo
     * @return
     */

    public String eliminarProducto(String codigo){
        String mensaje="Producto inexistente";
        for (Producto productoAux : listaProductos){
            if(productoAux.getCodigo().equals(codigo)){
                listaProductos.remove(productoAux);
                mensaje=" El Producto se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }



    /**
     * Actualiza la lista de productos 
     * @param nombre
     * @param codigo
     * @param precio
     * @return
     */

    public String actualizarProducto( String nombre, String codigo, Double precio, String categoria, int stock){

        String mensaje = " no encontrado";
        Producto productoEncontrado = buscarProducto(codigo);
        if(productoEncontrado != null){
            productoEncontrado.setNombre(nombre);
            productoEncontrado.setCodigo(codigo);
            productoEncontrado.setPrecio(precio);
            productoEncontrado.setCategoria(categoria);
            productoEncontrado.setStock(stock);
            mensaje = " se actualizó correctamente";
        }
        return mensaje;
    }



    @Override
    public String toString() {
        return "Tienda:" + nombre + "\nubicacion:" + ubicacion + "\nnit:" + nit + "\nlista de Productos:"
                + listaProductos + "\nlista de Clientes:" + listaClientes + "\nlistaVentas=" + listaVentas + "";
    }




    public Double calcularMontoTotal(Venta venta){
        Double montoTotal = venta.getMontoTotal();
        return montoTotal;

    }



    public void actualizarStockTienda(Producto producto,int cantidad){
        producto.actualizarStock(cantidad);
    }





    
}
