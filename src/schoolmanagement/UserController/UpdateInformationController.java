/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import schoolmanagement.mylibs.Control_PopupController;
import schoolmanagement.DatabaseConnection;
import schoolmanagement.validation;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class UpdateInformationController implements Initializable {

    @FXML
    private Label txt_firstname;
    @FXML
    private Label txt_lastname;
    @FXML
    private Label txt_email;
    @FXML
    private Label txt_birthday;
    @FXML
    private Label txt_id;
    @FXML
    private TextField txt_street;
    @FXML
    private TextField txt_city;
    @FXML
    private TextField txt_state;

    ArrayList<String> userlist;
    DatabaseConnection database;
    
    String role;
    @FXML
    private TextField txt_phone;
    @FXML
    private TextField txt_zip;
    @FXML
    private Button btn_update;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        userlist = new ArrayList<String>();
        
    }    

    
    public void getUserInformation(String ID, String Role){
        userlist = database.LoadUserFullInformation(ID, Role);
        txt_id.setText(userlist.get(0));
        txt_firstname.setText(userlist.get(1));
        txt_lastname.setText(userlist.get(2));
        txt_email.setText(userlist.get(3));
        txt_phone.setText(userlist.get(4));
        txt_street.setText(userlist.get(5));
        txt_city.setText(userlist.get(6));
        txt_state.setText(userlist.get(7));
        txt_zip.setText(userlist.get(8));
        txt_birthday.setText(userlist.get(9));
        role = Role;
        

    }

    @FXML
    private void OnUpdateClicked(MouseEvent event) {
        Control_PopupController cpc = new Control_PopupController();
        cpc.setTitle("Update User Information");
        
        validation val = new validation();
      
        val.TextField("Phone Number", txt_phone);
        val.TextField("Street", txt_street);
        val.TextField("City", txt_city);
        val.TextField("State", txt_state);
        val.TextField("Zipcode", txt_zip);
        database.UpdateUserInformation(userlist.get(0), role, txt_phone.getText().toString() , txt_street.getText().toString(), txt_city.getText().toString(), txt_state.getText().toString(), Integer.parseInt(txt_zip.getText().toString()) );
        cpc.setMessage("Update User Information Successfully!");
        cpc.Show();
    }


    
}
