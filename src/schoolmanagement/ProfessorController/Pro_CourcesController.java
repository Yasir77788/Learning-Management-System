/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.ProfessorController;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import schoolmanagement.mylibs.Course_detailController;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DashboardController;
import schoolmanagement.DatabaseConnection;
import static sun.java2d.loops.SurfaceType.Custom;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Pro_CourcesController implements Initializable {
    DatabaseConnection database;
    ArrayList<ArrayList<String>> professor_courses;

    @FXML
    private VBox course_container;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane course_contain;
    @FXML
    private Label lbl_currentcourse;
    
    String UserID = "";
    String UserRole = "";
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        professor_courses = new ArrayList<>();

    }    
    
    public void getUserInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        LoadCourseList();
    }
    
    void LoadCourseList(){
        professor_courses = database.ProfessorLoadTeachingCourses(UserID);
        AddCourse_Dynamic();
        lbl_currentcourse.setText(lbl_currentcourse.getText() + " ("+professor_courses.get(0).size()+")");
    }
    
    void AddCourse_Dynamic(){
        
        for(int i = 0; i < professor_courses.get(0).size();i++){
            String CourseID = professor_courses.get(0).get(i);
            String SubjectId = professor_courses.get(1).get(i);
            String CourseCode = professor_courses.get(2).get(i);
            String CourseName = professor_courses.get(3).get(i);
            String MeetTime = professor_courses.get(4).get(i) + "-" + professor_courses.get(5).get(i);
            
            String add = "-";
            if(professor_courses.get(7).get(i).equals("")){
                add = "";
            }
            String MeetDay = professor_courses.get(6).get(i) + add + professor_courses.get(7).get(i);
            AddCourse_Item(CourseID, SubjectId, CourseCode,CourseName, MeetTime, MeetDay);
        }
    }
    
    void AddStudentCourseItem(){
 
        
    }
    
    void AddCourse_Item(String CourseID, String SubjectId, String coursecode, String coursename, String meetingtime, String meetingday){
        AnchorPane pane = new AnchorPane();
        pane.setId(coursecode);
        
        pane.setPrefSize(1200, 100);
        pane.getStyleClass().add("Courses_Panel");
        pane.setEffect(new DropShadow(10, (javafx.scene.paint.Color) Paint.valueOf("#666666")));

        HBox container = new HBox();
        VBox LeftColumn = new VBox();
        LeftColumn.getStyleClass().add("Course_left_column");
        LeftColumn.setPrefSize(150, pane.getPrefHeight());
        LeftColumn.setAlignment(Pos.CENTER);
        VBox RightColumn = new VBox();
        RightColumn.setAlignment(Pos.CENTER_LEFT);
        // Subject ID
        Label SubID = new Label();
        SubID.setText(SubjectId);
        SubID.getStyleClass().add("Courses_idcode");
        
        // Course Code
        Label CourseCode = new Label();
        CourseCode.setText(coursecode);
        CourseCode.getStyleClass().add("Courses_idcode");
        
        LeftColumn.getChildren().add(SubID);
        LeftColumn.getChildren().add(CourseCode);
        
        // Course code & Name
        Label c_codename = new Label();
        c_codename.getStyleClass().add("Courses_Panel_Title");
        c_codename.setUnderline(true);
        c_codename.setText(coursename);
        
        
        // Course Meeting time
        Label c_meetingtime = new Label();
        c_meetingtime.getStyleClass().add("Courses_Panel_Content");
        c_meetingtime.setText("Meeting Time: " + meetingtime);
        
        // Course Meeting day
        Label c_meetingday = new Label();
        c_meetingday.getStyleClass().add("Courses_Panel_Content");
        c_meetingday.setText("Meeting Day: " + meetingday);

        RightColumn.getChildren().add(c_codename);
        RightColumn.getChildren().add(c_meetingtime);
        RightColumn.getChildren().add(c_meetingday);
        
        container.getChildren().add(LeftColumn);
        container.getChildren().add(RightColumn);
        
        pane.getChildren().add(container);

        
        pane.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
        
                public void handle(MouseEvent e){
                    FXMLLoader parent = new FXMLLoader(getClass().getResource("Pro_CourseDetail_Dashboard.fxml"));
                    Scene scene = null;
                try {
                    scene = new Scene(parent.load());

                } catch (IOException ex) {
                    Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                    Stage stage = new Stage();
                    scene.setFill(javafx.scene.paint.Color.TRANSPARENT);

                    stage.initStyle(StageStyle.TRANSPARENT);
                    stage.setScene(scene);

                    Pro_CourseDetail_DashboardController detail = parent.getController();
                    detail.getUserID(UserID, CourseID);
                    stage.show();
                }
        });
        
        
        course_container.getChildren().add(pane);
        /*
        AnchorPane.setTopAnchor(c_codename, 5.0);
        AnchorPane.setLeftAnchor(c_codename, 10.0);
        AnchorPane.setTopAnchor(c_professor, 40.0);
        AnchorPane.setLeftAnchor(c_professor, 25.0);
        AnchorPane.setTopAnchor(c_meetingtime, 70.0);
        AnchorPane.setLeftAnchor(c_meetingtime, 25.0);
        AnchorPane.setTopAnchor(c_meetingday, 100.0);
        AnchorPane.setLeftAnchor(c_meetingday, 25.0);
        AnchorPane.setBottomAnchor(c_meetingday, 5.0);
        */
       
    }

    
}
