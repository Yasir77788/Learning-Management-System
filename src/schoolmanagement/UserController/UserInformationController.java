/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class UserInformationController implements Initializable {

    @FXML
    private Label txt_lastname;
    @FXML
    private Label txt_phonenumber;
    @FXML
    private Label txt_birthday;
    @FXML
    private Label txt_street;
    @FXML
    private Label txt_city;
    @FXML
    private Label txt_state;
    @FXML
    private Label txt_firstname;
    @FXML
    private Label txt_zip;
    @FXML
    public Label txt_id;
    @FXML
    private Label txt_email;

       
    ArrayList<String> user_information;
    DatabaseConnection database;
    @FXML
    private Label txt_major;
    @FXML
    private Label txt_degree;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database = new DatabaseConnection();
        user_information = new ArrayList<String>();
        //database = new DatabaseConnection();

    }    
    
    
    public void getInformation(String ID, String Role){
        
        this.txt_id.setText(ID);
        
        user_information = database.LoadUserFullInformation(ID, Role);
        txt_firstname.setText(user_information.get(1));
        txt_lastname.setText(user_information.get(2));
        txt_email.setText(user_information.get(3));
        txt_phonenumber.setText(user_information.get(4));
        txt_street.setText(user_information.get(5));
        txt_city.setText(user_information.get(6));
        txt_state.setText(user_information.get(7));
        txt_zip.setText(user_information.get(8));
        txt_birthday.setText(user_information.get(9));
        txt_degree.setText(user_information.get(10));
        txt_major.setText(user_information.get(11));

        
    }
    
    

    
}
