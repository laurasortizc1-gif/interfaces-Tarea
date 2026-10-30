module co.edu.uniquindio.poo.empresafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.empresafx to javafx.fxml;
    exports co.edu.uniquindio.poo.empresafx;

    opens co.edu.uniquindio.poo.empresafx.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.empresafx.viewController;
}