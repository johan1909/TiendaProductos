package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private String identificacion; 
    private String diteccion; 
    private String telefono; 
    private String email;
    private ArrayList <Producto> listaProductosComprados;



    public Cliente(String nombre, String identificacion, String diteccion, String telefono, String email, ArrayList <Producto> listaProductosComprados) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.diteccion = diteccion;
        this.telefono = telefono;
        this.email = email;
        this.listaProductosComprados = new ArrayList<Producto>();
    }



    public String getNombre() {
        return nombre;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getIdentificacion() {
        return identificacion;
    }



    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }



    public String getDiteccion() {
        return diteccion;
    }



    public void setDiteccion(String diteccion) {
        this.diteccion = diteccion;
    }



    public String getTelefono() {
        return telefono;
    }



    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public ArrayList<Producto> getListaProductosComprados() {
        return listaProductosComprados;
    }



    public void setListaProductosComprados(ArrayList<Producto> listaProductosComprados) {
        this.listaProductosComprados = listaProductosComprados;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        if (identificacion == null) {
            if (other.identificacion != null)
                return false;
        } else if (!identificacion.equals(other.identificacion))
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "Cliente: " + nombre + "\nidentificacion:" + identificacion + "\nditeccion:" + diteccion
                + "\ntelefono" + telefono + "\nemail" + email + "\nlistaProductosComprados" + listaProductosComprados
                + "";
    }
    

    

    /**
     * 
     * @param nuevoProducto
     * @return
     */

    public String agregarProducto(Producto nuevoProducto) {
        
    
        String mensaje = "";
        Producto productoEncontrado = buscarProducto(nuevoProducto.getCodigo());
    
        if (productoEncontrado != null) {
            mensaje = "Ya existe";
        } else {
            listaProductosComprados.add(nuevoProducto) ;
            mensaje = " se agregó correctamente";
        }
    
        return mensaje;
    }
    

    /**
     * Busca un producto del cliente mediante el codigo
     * @param codigo
     * @return
     */

    private Producto buscarProducto(String codigo) {
        for (Producto productoAux : listaProductosComprados) {
            if (productoAux.getCodigo().equals(codigo)) {
                return productoAux;
            }
        }
        return null;
    }





    /**
     * elimina un producto de la lista del cliente
     * @param codigo
     * @return
     */

    public String eliminarProducto(String codigo){
        String mensaje="Producto inexistente";
        for (Producto productoAux : listaProductosComprados){
            if(productoAux.getCodigo().equals(codigo)){
                listaProductosComprados.remove(productoAux);
                mensaje=" El Producto se elimino correctamente";
                return mensaje;
            }
        }

        return mensaje;
    }



    /**
     * Actualiza la lista de productos del cliente
     * @param nombre
     * @param codigo
     * @param precio
     * @return
     */

    public String actualizarProducto( String nombre, String codigo, Double precio){

        String mensaje = " no encontrado";
        Producto productoEncontrado = buscarProducto(codigo);
        if(productoEncontrado != null){
            productoEncontrado.setNombre(nombre);
            productoEncontrado.setCodigo(codigo);
            productoEncontrado.setPrecio(precio);
            
            mensaje = " se actualizó correctamente";
        }
        return mensaje;
    }
    






}
