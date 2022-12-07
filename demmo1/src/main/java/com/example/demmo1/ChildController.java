package com.example.demmo1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.jar.Attributes;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;



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
    private TableColumn<?, ?> columnAgeChild;

    @FXML
    private TableColumn<PojoChild, String> columnGenderChild;

    @FXML
    private TableColumn<?, ?> columnGroupChild;

    @FXML
    private TableColumn<PojoChild, String> columnNameChild;

    @FXML
    private TableColumn<PojoChild, String> columnSecondNameChild;

    @FXML
    private TableColumn<PojoChild, String> columnThirdNameChild;

    @FXML
    private TableView<?> tableChild;

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
    private TableView<PojoChild> TableColm;
    DataBaseHandler dataBaseHandler = new DataBaseHandler();
    Info info = new Info();
    private final ObservableList<Object> dataChild= FXCollections.observableArrayList();

    @FXML
    void initialize() {
        setData();
        buttonAdd.setOnAction(e -> {
            Parent root;
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ChildPage.fxml"));
                root = loader.load();
                Stage stage = new Stage();
                //stage.initStyle(StageStyle.DECORATED); <-----------
                stage.setResizable(false);
                stage.setTitle("Добавление отдела");
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.initOwner(buttonAdd.getScene().getWindow());
                stage.showAndWait();
                TableColm.getItems().clear();
                TableColm.getColumns().clear();
                //DataBaseHandler.Update("staff"); <---------------
                setData();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        });

            try {
                TableColm.getItems().clear();
                TableColm.getColumns().clear();
                setData();

            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }


    private void setData(){
        //создание колонок
        TableColumn<PojoChild, String> id = new TableColumn<PojoChild, String>("Имя");
        TableColumn<PojoChild, String> department = new TableColumn<PojoChild, String>("Фамилия");
        TableColumn<PojoChild, String> qow  = new TableColumn<PojoChild, String>("Отчество");
        //dataChild(); <---------------------------
        //установление значений
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        department.setCellValueFactory(new PropertyValueFactory<>("NameOfDepartment"));
        qow.setCellValueFactory(new PropertyValueFactory<>("quantityWorkers"));
        //TableColm.setItems(dataChild);  <----------------------
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
