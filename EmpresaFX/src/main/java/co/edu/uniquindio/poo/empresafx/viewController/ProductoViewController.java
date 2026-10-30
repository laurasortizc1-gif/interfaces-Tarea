package co.edu.uniquindio.poo.empresafx.viewController;

import co.edu.uniquindio.poo.empresafx.App;
import co.edu.uniquindio.poo.empresafx.controller.ProductoController;
import co.edu.uniquindio.poo.empresafx.model.Producto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ProductoViewController {

    private App app;
    private ProductoController productoController;
    private ObservableList<Producto> listProductos = FXCollections.observableArrayList();
    private Producto sProducto;

    @FXML private TextField txtCodigo;
    @FXML private TextField txtNombre;
    @FXML private TextField txtPrecio;

    @FXML private Button btnAgregarProducto;
    @FXML private Button btnActualizarProducto;
    @FXML private Button btnLimpiar;
    @FXML private Button btnEliminar;

    @FXML private TableView<Producto> tblListProducto;
    @FXML private TableColumn<Producto, String> tbcCodigo;
    @FXML private TableColumn<Producto, String> tbcNombre;
    @FXML private TableColumn<Producto, String> tbcPrecio;

    @FXML
    void initialize() {
        productoController = new ProductoController(App.empresa);
        initView();
    }

    private void initView() {
        initDataBinding();
        listProductos.addAll(productoController.obtenerListaProductos());
        tblListProducto.setItems(listProductos);
        listenerSelection();
    }

    private void initDataBinding() {
        tbcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));
        tbcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        // El precio es float, por eso lo convertimos a texto para mostrarlo
        tbcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrecio())));
    }

    private void listenerSelection() {
        tblListProducto.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            sProducto = newSel;
            mostrarInformacionProducto(sProducto);
        });
    }

    private void mostrarInformacionProducto(Producto producto) {
        if (producto != null) {
            txtCodigo.setText(producto.getCodigo());
            txtNombre.setText(producto.getNombre());
            txtPrecio.setText(String.valueOf(producto.getPrecio()));
        }
    }

    @FXML
    void onAgregarProducto() {
        Producto producto = crearProductoDesdeCampos();
        if (producto != null && productoController.crearProducto(producto)) {
            listProductos.add(producto);
            limpiarCamposProducto();
        }
    }

    @FXML
    void onActualizarProducto() {
        Producto producto = crearProductoDesdeCampos();
        if (sProducto != null && producto != null &&
                productoController.actualizarProducto(sProducto.getCodigo(), producto)) {
            tblListProducto.refresh();
            limpiarSeleccion();
        }
    }

    @FXML
    void onEliminar() {
        if (sProducto != null &&
                productoController.eliminarProducto(sProducto.getCodigo())) {
            listProductos.remove(sProducto);
            limpiarSeleccion();
        }
    }

    @FXML
    void onLimpiar() {
        limpiarSeleccion();
    }

    // Convierte el texto een num
    private Producto crearProductoDesdeCampos() {
        try {
            float precio = Float.parseFloat(txtPrecio.getText());
            return new Producto(txtCodigo.getText(), txtNombre.getText(), precio);
        } catch (NumberFormatException e) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setHeaderText("Precio inválido");
            alerta.setContentText("Escribe un número");
            alerta.showAndWait();
            return null;
        }
    }

    private void limpiarSeleccion() {
        tblListProducto.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
    }

    public void setApp(App app) {
        this.app = app;
    }
}