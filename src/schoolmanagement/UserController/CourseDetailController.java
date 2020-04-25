/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class CourseDetailController implements Initializable {

    @FXML
    private Label txt_course_name;
    @FXML
    private Label txt_professor_name;
    @FXML
    private Label txt_meeting_time;
    @FXML
    private Label txt_meeting_day;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void GetInformation(String coursecode, String coursename, String professorname, String meetingtime, String meetingday){
        txt_course_name.setText(coursecode+ ": "+ coursename);
        txt_professor_name.setText(professorname);
        txt_meeting_time.setText(meetingtime);
        txt_meeting_day.setText(meetingday);
    }
    
}
