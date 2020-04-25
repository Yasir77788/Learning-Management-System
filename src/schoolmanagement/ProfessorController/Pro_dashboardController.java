/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.ProfessorController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Pro_dashboardController implements Initializable {
    DatabaseConnection database;
    
    @FXML
    private ScrollPane scrollpane;
    @FXML
    private VBox vbox_sourselist;
    
    String UserID = "";
    
    ArrayList<ArrayList<String>> course_list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        database = new DatabaseConnection();
        course_list = new ArrayList<>();
    }    
    
    public void getUserInformation(String UserID){
        this.UserID = UserID;
        loadCourseList(UserID);
    }
    
    void loadCourseList(String UserID){
        
        course_list = database.ProfessorLoadTeachingCourses(UserID);
        AddCourse_Dynamic();
    }
    void AddCourse_Dynamic(){
        System.out.println("List size: " + course_list.get(0).size());
        for(int i = 0; i < course_list.get(0).size(); i++){
            String CourseCode = course_list.get(1).get(i) + " " + course_list.get(2).get(i);
            String CourseName = course_list.get(3).get(i);
            String MeetTime = course_list.get(4).get(i) + "-" + course_list.get(5).get(i);
            String add = "-";
            if(course_list.get(7).get(i).equals("")){
                add = "";
            }
            String MeetDay = course_list.get(6).get(i) + add + course_list.get(7).get(i);
            AddCourse_Item(CourseCode, CourseName, MeetTime, MeetDay);
        }
    }

    void AddCourse_Item(String coursecode, String coursename, String meetingtime, String meetingday){
        AnchorPane container = new AnchorPane();
        container.setPrefHeight(30);
        container.setPrefWidth(container.USE_COMPUTED_SIZE);
        container.getStyleClass().add("Dashboard_course_item_pane");

        Label course_text = new Label();
        course_text.getStyleClass().add("Dashboard_course_item_text");
        course_text.setText(coursecode+": " + coursename+ " | " + meetingtime + " | " + meetingday);


        container.getChildren().add(course_text);

        vbox_sourselist.getChildren().add(container);

        AnchorPane.setLeftAnchor(course_text, 10.0);
        AnchorPane.setTopAnchor(course_text, 5.0);

    }
        
}
