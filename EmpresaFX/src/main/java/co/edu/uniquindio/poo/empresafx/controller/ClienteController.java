package co.edu.uniquindio.poo.empresafx.controller;

import co.edu.uniquindio.poo.empresafx.model.Cliente;
import co.edu.uniquindio.poo.empresafx.model.Empresa;
import java.util.List;

public class ClienteController {

    private Empresa empresa;

    public ClienteController(Empresa empresa) {
        this.empresa = empresa;
    }

    public boolean crearCliente(Cliente cliente) {
        return empresa.agregarCliente(cliente);
    }

    public List<Cliente> obtenerListaClientes() {
        return empresa.getClientes();
    }

    public boolean eliminarCliente(String cedula) {
        return empresa.eliminarCliente(cedula);
    }

    public boolean actualizarCliente(String cedula, Cliente cliente) {
        return empresa.actualizarCliente(cedula, cliente);
    }
}