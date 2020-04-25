/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.Administrator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class CreateProfessorAccountController implements Initializable {

    @FXML
    private TextField txt_firstname;
    @FXML
    private TextField txt_lastname;
    @FXML
    private TextField txt_phonenumber;
    @FXML
    private DatePicker txt_birthday;
    @FXML
    private TextField txt_street;
    @FXML
    private TextField txt_city;
    @FXML
    private TextField txt_state;
    @FXML
    private TextField txt_zipcode;
    @FXML
    private TextField txt_salary;
    @FXML
    private Pane btn_container;
    @FXML
    private Button btn_create;
    @FXML
    private Pane btn_container1;
    @FXML
    private Button btn_clear;
    
    DatabaseConnection con;
    Alert a;
    @FXML
    private Pane Textfield_container;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        con = new DatabaseConnection();
        a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Create Professor");
    }    

    @FXML
    private void OnCreateClicked(MouseEvent event) {
        String error = "";
        if(txt_firstname.getText().toString().equals("")){
          error = "* First name is required";
        }
        if(txt_lastname.getText().toString().equals("")){
          error = error + "\n* Last name is required";
        }
        if(txt_phonenumber.getText().toString().equals("")){
          error = error + "\n* Phone number is required";
        }else if(!txt_phonenumber.getText().toString().matches("[0-9]+$")){
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
        }
        if(!txt_salary.getText().toString().matches("[0-9]+$")){
            error = error + "\n* Salary contains number only.";
        }
        if(error.equals("")){
            con.CreateProfessorAccount(txt_firstname.getText().toString(), txt_lastname.getText().toString(), txt_phonenumber.getText().toString(), txt_street.getText().toString(), txt_city.getText().toString(), txt_state.getText().toString(), txt_zipcode.getText().toString(), txt_birthday.getValue(), Integer.parseInt(txt_salary.getText().toString()));
            a.setContentText("Staff '"+txt_firstname.getText().toString()+ " " +txt_lastname.getText().toString() +"' has been created successfully!");
        }else{
            a.setContentText(error);
            
        }
        a.show();
    }

    @FXML
    private void OnClearClicked(MouseEvent event) {
        txt_firstname.setText("");
        txt_lastname.setText("");
        txt_phonenumber.setText("");
        txt_birthday.setValue(null);
        txt_city.setText("");
        txt_street.setText("");
        txt_state.setText("");
        txt_zipcode.setText("");
        txt_salary.setText("");
    }
    
}
