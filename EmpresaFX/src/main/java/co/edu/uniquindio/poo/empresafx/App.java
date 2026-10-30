package co.edu.uniquindio.poo.empresafx;

import co.edu.uniquindio.poo.empresafx.model.Cliente;
import co.edu.uniquindio.poo.empresafx.model.Empresa;
import co.edu.uniquindio.poo.empresafx.model.Producto;
import co.edu.uniquindio.poo.empresafx.viewController.ClienteViewController;
import co.edu.uniquindio.poo.empresafx.viewController.PrimaryController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//ptoducto
import co.edu.uniquindio.poo.empresafx.viewController.ProductoViewController;

import java.io.IOException;

public class App extends Application {

    private Stage primaryStage;
    public static Empresa empresa = new Empresa("UQ");

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestion Clientes");
        cargardatosEjemplo();

        openViewPrincipal();
    }

    private void openViewPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("primary.fxml"));
            Parent root = loader.load();
            PrimaryController primaryController = loader.getController();
            primaryController.setApp(this);

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCrudCliente() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("crudCliente.fxml"));
            Parent root = loader.load();
            ClienteViewController clienteViewController = loader.getController();
            clienteViewController.setApp(this);

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //conectar producto
    public void conectarCrudProducto() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("crudProducto.fxml"));
            Parent root = loader.load();
            ProductoViewController productoViewController = loader.getController();
            productoViewController.setApp(this);

            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // prueba
    private void cargardatosEjemplo() {
        Cliente cliente = new Cliente("12233", "Juan", "ortiz");
        empresa.agregarCliente(cliente);

        empresa.agregarProducto(new Producto("fynk", "arroz", 4000));
    }




    public static void main(String[] args) {
        launch();
    }
}