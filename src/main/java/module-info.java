module com.example.myfirstapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.myfirstapp to javafx.fxml;
    exports com.example.myfirstapp;
}