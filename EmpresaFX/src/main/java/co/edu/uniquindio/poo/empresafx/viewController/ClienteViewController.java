package co.edu.uniquindio.poo.empresafx.viewController;

import co.edu.uniquindio.poo.empresafx.App;
import co.edu.uniquindio.poo.empresafx.controller.ClienteController;
import co.edu.uniquindio.poo.empresafx.model.Cliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ClienteViewController {

    private App app;
    private ClienteController clienteController;
    private ObservableList<Cliente> listClientes = FXCollections.observableArrayList();
    private Cliente selectedCliente;

    @FXML private TextField txtCedula;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;

    @FXML private Button btnAgregarCliente;
    @FXML private Button btnActualizarCliente;
    @FXML private Button btnLimpiar;
    @FXML private Button btnEliminar;

    @FXML private TableView<Cliente> tblListCliente;
    @FXML private TableColumn<Cliente, String> tbcCedula;
    @FXML private TableColumn<Cliente, String> tbcNombre;
    @FXML private TableColumn<Cliente, String> tbcApellido;

    // para que Se ejecuta automáticamente al cargar el fml
    @FXML
    void initialize() {
        clienteController = new ClienteController(App.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        listClientes.addAll(clienteController.obtenerListaClientes());
        tblListCliente.setItems(listClientes);
        listenerSelection();
    }

    // Dice a cada columna qué dato del Cliente debe mostrar
    private void initDataBinding() {
        tbcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
    }

    // Cuando se selecciona una fila los datos pasan a los campos ""
    private void listenerSelection() {
        tblListCliente.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            selectedCliente = newSel;
            mostrarInformacionCliente(selectedCliente);
        });
    }

    private void mostrarInformacionCliente(Cliente cliente) {
        if (cliente != null) {
            txtCedula.setText(cliente.getCedula());
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
        }
    }

    //  metodos de los botones
    @FXML
    void onAgregarCliente() {
        Cliente cliente = leeerdatoscliente();
        if (clienteController.crearCliente(cliente)) {
            listClientes.add(cliente);
            limpiarCamposCliente();
        }
    }

    @FXML
    void onActualizarCliente() {
        if (selectedCliente != null &&
                clienteController.actualizarCliente(selectedCliente.getCedula(), leeerdatoscliente())) {
            tblListCliente.refresh();
            limpiarSeleccion();
        }
    }

    @FXML
    void onEliminar() {
        if (selectedCliente != null &&
                clienteController.eliminarCliente(selectedCliente.getCedula())) {
            listClientes.remove(selectedCliente);
            limpiarSeleccion();
        }
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    // Métodos
    private Cliente leeerdatoscliente() {
        return new Cliente(txtCedula.getText(), txtNombre.getText(), txtApellido.getText());
    }

    private void limpiarSeleccion() {
        tblListCliente.getSelectionModel().clearSelection();
        limpiarCamposCliente();
    }

    private void limpiarCamposCliente() {
        txtCedula.clear();
        txtNombre.clear();
        txtApellido.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}