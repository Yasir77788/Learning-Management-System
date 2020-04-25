/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.Administrator;

import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import schoolmanagement.DatabaseConnection;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class CreateStudentAccountController implements Initializable {
    DatabaseConnection database;
    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_phonenumber;
    @FXML
    private TextField txt_street;
    @FXML
    private TextField txt_city;
    @FXML
    private TextField txt_state;
    @FXML
    private TextField txt_zipcode;
    @FXML
    private Pane btn_container;
    @FXML
    private Button btn_create;
    @FXML
    private Pane btn_container1;
    @FXML
    private Button btn_clear;
    @FXML
    private DatePicker txt_birthday;
    @FXML
    private ComboBox combo_degree;
    
    private ArrayList<String> DegreeList;
    private ArrayList<String> MajorList;
    @FXML
    private ComboBox combo_major;
    
    Alert a;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Create Student Account");
        LoadDegreeList();
        LoadMajorList();
        

    }    

    private void LoadDegreeList(){
        DegreeList = new ArrayList<>();
        DegreeList = database.GetDegreeList();
        database = new DatabaseConnection();
        combo_degree.getItems().addAll(DegreeList);
    }
    private void LoadMajorList(){
        MajorList = new ArrayList<>();
        MajorList = database.GetMajorList();
        database = new DatabaseConnection();
        combo_major.getItems().addAll(MajorList);
    }
    
    @FXML
    private void OnCreateClicked(MouseEvent event) {
        //database = new DatabaseConnection();
        String error = "";
        if(txt_firstname.getText().toString().equals("")){
          error = "* First name is required";
        }
        if(txt_lastname.getText().toString().equals("")){
          error = error + "\n* Last name is required";
        }
        if(txt_phonenumber.getText().toString().equals("")){
          error = error + "\n* Phone number is required";
        }else if(txt_phonenumber.getText().toString().matches("[0-9]+$")){
            error = error + "\n* Phone number contains number only";
        }else if(txt_phonenumber.getText().toString().length() != 9){
            error = error + "\n* Phone number is not correct format. (9 numbers)";
        }
        if(txt_birthday.getValue() == null){
          error = error + "\n* Birthday is required";
        }
        if(txt_street.getText().toString().equals("")){
          error = error + "\n* Street is required";
        }
        if(txt_city.getText().toString().equals("")){
          error = error + "\n* City is required";
        }
        if(txt_state.getText().toString().equals("")){
          error = error + "\n* State is required";
        }
        if(txt_zipcode.getText().toString().equals("")){
          error = error + "\n* Zipcode is required";
        }else if(!txt_zipcode.getText().toString().matches("[0-9]+$")){
            error = error + "\n* Zipcode contains number only.";
        }else if(txt_zipcode.getText().toString().length() != 5){
            error = error + "\n* Zipcode is not correct format. (5 numbers)";
        }if(combo_degree.getSelectionModel().isEmpty()){
            error = error + "\n* Degree is required";
        }
        if(combo_major.getSelectionModel().isEmpty()){
            error = error + "\n* Major is required";
        }
        if(error.equals("")){
            database.CreateStudentAccount(txt_firstname.getText(), txt_lastname.getText(), txt_phonenumber.getText(), txt_street.getText(), txt_city.getText(), txt_state.getText(), txt_zipcode.getText(), txt_birthday.getValue(),combo_degree.getValue().toString(), combo_major.getValue().toString());
            a.setContentText("Student '"+txt_firstname.getText().toString()+ " " +txt_lastname.getText().toString() +"' has been created successfully!");
        }
        else{
            a.setContentText(error);
        }
        a.show();
    }

    @FXML
    private void OnClearClicked(MouseEvent event) {
        txt_firstname.setText("");
        txt_lastname.setText("");
        txt_phonenumber.setText("");
        txt_street.setText("");
        txt_city.setText("");
        txt_state.setText("");
        txt_zipcode.setText("");
        txt_birthday.setValue(null);
        combo_degree.setValue(null);
        combo_major.setValue(null);
    }
    
}
