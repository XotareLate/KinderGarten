package com.example.demmo1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GroupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonDelete;

    @FXML
    private TextField fieldGroup;

    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();

        buttonAdd.setOnAction(actionEvent -> {
            dbHandler.singUpGroup(fieldGroup.getText());
                });

        buttonBack.setOnAction(actionEvent -> {
            FXMLLoader loaderGroup = new FXMLLoader();
            loaderGroup.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                loaderGroup.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loaderGroup.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}