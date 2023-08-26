package inventariopapeleria;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        productos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        if (!productos.contains(producto)) {
            throw new IllegalArgumentException("El producto no esta en el inventario");
        }
        productos.remove(producto);
    }

    public void venderProducto(Producto producto, int cantidadVendida) throws IllegalArgumentException {
        if (!productos.contains(producto)) {
            throw new IllegalArgumentException("El producto no está en el inventario.");
        }

        producto.vender(cantidadVendida);
    }

    public Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }
    
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void mostrarInventario() {
        System.out.println("Inventario: ");
        for (Producto producto : productos) {
            producto.mostrarDetalles();
            System.out.println("------------------");
        }
    }
}
