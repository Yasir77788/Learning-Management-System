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
import javafx.scene.control.Label;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Main_dashboardController implements Initializable {

    DatabaseConnection database;
    @FXML
    private Label lbl_totalStudent;
    @FXML
    private Label lbl_totalProfessor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database =new DatabaseConnection();
        LoadTotalInformation();
    }    
    
    void LoadTotalInformation(){
        lbl_totalStudent.setText("Quantity: "+database.CountTotalUser("student_information").toString());
        lbl_totalProfessor.setText("Quantity: "+database.CountTotalUser("staff_information").toString());
    }
    
}
