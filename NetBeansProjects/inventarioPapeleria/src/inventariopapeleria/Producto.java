package inventariopapeleria;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre, double precio, int cantidad){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void mostrarDetalles(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("Cantidad en stock: "+cantidad);
    }
    
    public void vender(int cantidadVendida) throws IllegalArgumentException{
        if(cantidadVendida <=0){
            throw new IllegalArgumentException("La cantidad vendida debe ser mayor que cero");
        }
        if(cantidadVendida > cantidad){
            throw new IllegalArgumentException("No hay suficiente stock para la venta");
        }
        cantidad -= cantidadVendida;
    }
}