package co.edu.uniquindio.poo.empresafx.controller;

import co.edu.uniquindio.poo.empresafx.model.Empresa;
import co.edu.uniquindio.poo.empresafx.model.Producto;
import java.util.List;

public class ProductoController {

    private Empresa empresa;

    public ProductoController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearProducto(Producto producto) {
        return empresa.agregarProducto(producto);
    }

    public List<Producto> obtenerListaProductos() {
        return empresa.getProductos();
    }

    public boolean eliminarProducto(String codigo) {
        return empresa.eliminarProducto(codigo);
    }

    public boolean actualizarProducto(String codigo, Producto producto) {
        return empresa.actualizarProducto(codigo, producto);
    }
}