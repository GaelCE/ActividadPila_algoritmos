module com.example.actividadpila {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.actividadpila to javafx.fxml;
    exports com.example.actividadpila;
}