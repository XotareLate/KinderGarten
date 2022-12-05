module com.example.kindergarten {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    requires java.sql;

    opens com.example.kindergarten to javafx.fxml;
    exports com.example.kindergarten;
}