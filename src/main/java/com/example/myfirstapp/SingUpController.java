package com.example.myfirstapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SingUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passField;

    @FXML
    private Button singUpBatton;

    @FXML
    private CheckBox singUpCheckBoxFemale;

    @FXML
    private CheckBox singUpCheckBoxMale;

    @FXML
    private TextField singUpLastName;

    @FXML
    private TextField singUpName;

    @FXML
    void initialize() {


    }

}
