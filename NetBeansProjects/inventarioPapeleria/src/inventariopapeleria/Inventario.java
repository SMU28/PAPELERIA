package inventariopapeleria;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos; //almacena los productos en el inventario

    public Inventario() { // el constructor que inicializa el ArrayList
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) { // aqui agrega un producto a el inventario si dicho producto no es nulo y si lo es lanza una excepcion
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) { //elimina el producto del inventario si este existe en la lista de productos y sucesivamente lanza la excepcion en dado caso que no se encuentre en el inventario 
        if (!productos.contains(producto)) {
            throw new IllegalArgumentException("El producto no esta en el inventario");
        }
        productos.remove(producto);
    }

    public void venderProducto(Producto producto, int cantidadVendida) throws IllegalArgumentException { //vende la cantidad del producto si el mismo existe en la lista
        if (!productos.contains(producto)) {
            throw new IllegalArgumentException("El producto no está en el inventario.");
        }

        producto.vender(cantidadVendida);
    }

    public Producto buscarProductoPorNombre(String nombre) {   //busca el producto en el inventario por su nombre
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    public ArrayList<Producto> getProductos() { //devuelve la lista de productos en el inventario 
        return productos;
    }

    public void mostrarInventario() { // muestra los detalles del producto en el inventario 
        System.out.println("Inventario: ");
        for (Producto producto : productos) {
            producto.mostrarDetalles();
            System.out.println("------------------");
        }
    }
}
