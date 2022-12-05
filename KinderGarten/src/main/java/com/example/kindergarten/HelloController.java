package com.example.kindergarten;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private TextField addField;

    @FXML
    private VBox allField;

    @FXML
    private Button deleteButton;

    Database db = null;

    @FXML
    void initialize() {
        db = new Database();

        addButton.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    if(!addField.getText().trim().equals("")) {
                        db.insertTask(addField.getText());
                        addField.setText("");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        });
        loadInfo();
    }
    private void loadInfo() {
        try {
            allField.getChildren().clear();

            ArrayList<String> tasks = db.getTasks();
            for(int i = 0; i < tasks.size(); i++)
                allField.getChildren().add(new Label(tasks.get(i)));

        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}