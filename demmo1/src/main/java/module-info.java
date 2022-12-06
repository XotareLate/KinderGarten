module com.example.demmo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.demmo1 to javafx.fxml;
    exports com.example.demmo1;
}