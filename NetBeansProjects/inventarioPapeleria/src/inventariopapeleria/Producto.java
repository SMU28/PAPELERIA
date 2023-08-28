package inventariopapeleria;

public class Producto { // los atributos donde se almacenan el nombre, el precio y la cantidad
    private String nombre;
    private double precio;
    private int cantidad;
    
    public Producto(String nombre, double precio, int cantidad){ //en el constructor se inicializa los atributos 
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() { // los metodos getter y setter permiten la modificacion y acceso a los atributos privados 
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
    
    public void mostrarDetalles(){  //muestra los detalles del producto por consola 
        System.out.println("Nombre: "+nombre);
        System.out.println("Precio: "+precio);
        System.out.println("Cantidad en stock: "+cantidad);
    }
    
    public void vender(int cantidadVendida) throws IllegalArgumentException{ //permite vender la cantidad especifica de productos, verifica que la cantidad vendida sea valida y si lo anterior se cumple, la cantidad se reduce 
        if(cantidadVendida <=0){
            throw new IllegalArgumentException("La cantidad vendida debe ser mayor que cero");
        }
        if(cantidadVendida > cantidad){
            throw new IllegalArgumentException("No hay suficiente stock para la venta");
        }
        cantidad -= cantidadVendida;
    }
}