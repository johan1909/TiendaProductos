package co.edu.uniquindio.poo.model;

public class Producto {

    private String nombre;
    private String codigo;
    private Double precio; 
    private String categoria;
    private int stock;


    public Producto(String nombre, String codigo, Double precio, String categoria, int stock) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.stock = stock;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getCodigo() {
        return codigo;
    }


    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Double getPrecio() {
        return precio;
    }


    public void setPrecio(Double precio) {
        if (precio <= 0) {
            System.out.println("Elprecio no puede ser menor a 0");
      
        }else{
            this.precio = precio;
        }
    }


    public String getCategoria() {
        return categoria;
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public int getStock() {
        return stock;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }







    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
        Producto other = (Producto) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }


    @Override
    public String toString() {
    return "Producto: " + nombre + "\ncodigo:" + codigo + "\nprecio:" + precio + "\ncategoria:" + categoria
                + "\nstock" + stock + "";
    }




    public void actualizarStock(int cantidad) {
        if (cantidad >= 0) {
            this.stock = cantidad;
        } else {
            System.out.println("La cantidad no puede ser menor a 0.");
        }
    }

    

    public void reducirStock(int cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            System.out.println("Stock insuficiente.");
        }
    }


    
    

}
