package co.edu.uniquindio.poo.empresafx.viewController;

import co.edu.uniquindio.poo.empresafx.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    private App app;

    @FXML
    private Button primaryButton;

    @FXML
    void onOpenCrudCliente() {
        app.openCrudCliente();
    }
    //agg metodo crud producto
    @FXML
    void onOpenCrudProducto() {
        app.conectarCrudProducto();
    }
    public void setApp(App app) {
        this.app = app;
    }
}
