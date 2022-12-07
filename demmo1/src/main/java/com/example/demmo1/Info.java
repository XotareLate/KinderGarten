package com.example.demmo1;

import javafx.scene.control.Alert;

public class Info {
    public void informationWindow(String info,String Title) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }}