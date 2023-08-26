package inventariopapeleria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainApp {

    private JFrame frame;
    private Inventario inventario;

    public MainApp() {
        inventario = new Inventario();

        frame = new JFrame("INVENTARIO DE PAPELERIA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JButton agregarButton = new JButton("Agregar producto");
        JButton mostrarButton = new JButton("Mostrar inventario");
        JButton venderButton = new JButton("Vender");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarFormularioAgregar();
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarInventario();
            }
        });

        venderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                venderProducto();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(agregarButton);
        buttonPanel.add(mostrarButton);
        buttonPanel.add(venderButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private void mostrarFormularioAgregar() {
        String nombre = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto: ");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(frame, "Ingrese el precio del producto: "));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(frame, "Ingrese la cantidad en stock: "));
        try {
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            inventario.agregarProducto(nuevoProducto);
            JOptionPane.showMessageDialog(frame, "Producto agregado correctamente");
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarInventario() {
        StringBuilder inventarioStr = new StringBuilder("INVENTARIO:\n");

        for (Producto producto : inventario.getProductos()) {
            inventarioStr.append(producto.getNombre()).append(" - ").append(producto.getPrecio()).append(" - ").append(producto.getCantidad()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, inventarioStr.toString(), "Inventario", JOptionPane.PLAIN_MESSAGE);
    }

    private int obtenerEntero(String mensaje) {
        int numero = 0;
        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(frame, mensaje);
                numero = Integer.parseInt(entrada);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese un valor numerico valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return numero;
    }

    private double obtenerDouble(String mensaje) {
        double numero = 0;

        while (true) {
            try {
                String entrada = JOptionPane.showInputDialog(frame, mensaje);
                numero = Double.parseDouble(entrada);
                break;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese un valor numerico valido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return numero;
    }

    private void venderProducto() {
        String nombreProducto = JOptionPane.showInputDialog(frame, "Ingrese el nombre del producto a vender: ");
        Producto producto = inventario.buscarProductoPorNombre(nombreProducto);

        if (producto != null) {
            int cantidadVendida = obtenerEntero("Ingrese la cantidad a vender: ");
            try {
                inventario.venderProducto(producto, cantidadVendida);
                JOptionPane.showMessageDialog(frame, "Venta realizada correctamente!");
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Producto no encontrado en el inventario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainApp();
            }
        });
    }
}