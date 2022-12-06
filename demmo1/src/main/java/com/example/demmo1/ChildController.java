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
import javafx.stage.Stage;

public class ChildController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAdd;

    @FXML
    private Button buttonDelete;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField fieldAge;

    @FXML
    private TextField fieldGender;

    @FXML
    private TextField fieldGroup;

    @FXML
    private TextField fieldName;

    @FXML
    private TextField fieldSecondName;

    @FXML
    private TextField fieldThirdName;

    @FXML
    void initialize() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        buttonAdd.setOnAction(actionEvent -> {
            dbHandler.singUpChild(fieldName.getText(),fieldSecondName.getText(),fieldThirdName.getText(),fieldGender.getText(),
                    fieldAge.getText(),fieldGroup.getText());
        });
        buttonBack.setOnAction(actionEvent -> {
            FXMLLoader loaderChild = new FXMLLoader();
            loaderChild.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                loaderChild.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Parent root = loaderChild.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

    }

}
