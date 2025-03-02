package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class Venta {

    private LocalDate fecha;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;
    private Double montoTotal;


    public Venta(LocalDate fecha, Cliente cliente, Producto producto, int cantidad, Double montoTotal) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.montoTotal = producto.getPrecio()*cantidad;
    }


    public LocalDate getFecha() {
        return fecha;
    }


    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public Producto getProducto() {
        return producto;
    }


    public void setProducto(Producto producto) {
        this.producto = producto;
    }


    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public Double getMontoTotal() {
        return montoTotal;
    }


    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }


    


    

}
