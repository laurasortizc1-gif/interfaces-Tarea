package co.edu.uniquindio.poo.empresafx.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Cliente> clientes;
    private List<Producto> productos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean agregarCliente(Cliente cliente) {
        boolean Existe= false;
        if (!verificarCliente(cliente.getCedula())) {
            clientes.add(cliente);
            Existe= true;
        }
        return Existe;
    }

    public boolean eliminarCliente(String cedula) {
        boolean Eliminado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                clientes.remove(cliente);
                Eliminado = true;
                break;
            }
        }
        return Eliminado;
    }

    public boolean actualizarCliente(String cedula, Cliente actualizado) {
        boolean Actualizado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                cliente.setCedula(actualizado.getCedula());
                cliente.setNombre(actualizado.getNombre());
                cliente.setApellido(actualizado.getApellido());
                Actualizado = true;
                break;
            }
        }
        return Actualizado;
    }

    public boolean verificarCliente(String cedula) {
        boolean Verificado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                Verificado = true;
            }
        }
        return Verificado;
    }

    //productos
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) { this.productos = productos; }

    public boolean agregarProducto(Producto producto) {
        boolean agregado = false;
        if (!verificarProducto(producto.getCodigo())) {
            productos.add(producto);
            agregado = true;
        }
        return agregado;
    }

    public boolean eliminarProducto(String codigo) {
        boolean eliminado = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                productos.remove(producto);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }

    public boolean actualizarProducto(String codigo, Producto actualizado) {
        boolean actualizadoO = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setCodigo(actualizado.getCodigo());
                producto.setNombre(actualizado.getNombre());
                producto.setPrecio(actualizado.getPrecio());
                actualizadoO = true;
                break;
            }
        }
        return actualizadoO;
    }

    public boolean verificarProducto(String codigo) {
        boolean verificado = false;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                verificado = true;
            }
        }
        return verificado;
    }
}