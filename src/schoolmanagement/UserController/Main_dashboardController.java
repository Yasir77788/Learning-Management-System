/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import com.sun.javafx.scene.control.skin.DatePickerContent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;
import sun.font.GraphicComponent;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Main_dashboardController implements Initializable {
    CustomControl cc;
    DatabaseConnection database;
    ArrayList<ArrayList<String>> course_list;
    ArrayList<ArrayList<String>> annouce_list;
    
    ArrayList<String> coursecode;
    ArrayList<String>  coursename;
    ArrayList<String>  professorname;
    ArrayList<String>  meetingtime;
    ArrayList<String>  meetingday;
    @FXML
    private VBox vbox_sourselist;
    @FXML
    private ScrollPane scrollpane;
    
    String UserID = "";
    String UserRole = "";
    @FXML
    private VBox vbox_annouce;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        course_list = new ArrayList<>();
        annouce_list = new ArrayList<>();
        cc = new CustomControl();

        
        
    }    
  
    public void getUserInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        loadCourseList(UserID);
        loadAnnouceList(UserID);
    }
    void loadCourseList(String UserID){
        course_list = database.StudentViewCourses(UserID);
        AddCourse_Dynamic();
    }
        void AddCourse_Dynamic(){
            for(int i = 0; i < course_list.get(0).size(); i++){
                String CourseCode = course_list.get(1).get(i) + " " + course_list.get(2).get(i);
                String CourseName = course_list.get(3).get(i);
                String Instructor = course_list.get(9).get(i) + " " + course_list.get(10).get(i);
                String MeetTime = course_list.get(4).get(i) + "-" + course_list.get(5).get(i);
                String add = "-";
                if(course_list.get(7).get(i).equals("")){
                    add = "";
                }
                String MeetDay = course_list.get(6).get(i) + add + course_list.get(7).get(i);
                AddCourse_Item(CourseCode, CourseName, Instructor, MeetTime, MeetDay);
            }
        }
        
        void AddCourse_Item(String coursecode, String coursename, String professorname, String meetingtime, String meetingday){
            AnchorPane container = new AnchorPane();
            container.setPrefHeight(30);
            container.setPrefWidth(container.USE_COMPUTED_SIZE);
            container.getStyleClass().add("Dashboard_course_item_pane");
            
            Label course_text = new Label();
            course_text.getStyleClass().add("Dashboard_course_item_text");
            course_text.setText(coursecode+": " + coursename+ " | " +professorname + " | " + meetingtime + " | " + meetingday);
            
            
            container.getChildren().add(course_text);
            
            vbox_sourselist.getChildren().add(container);
            
            AnchorPane.setLeftAnchor(course_text, 10.0);
            AnchorPane.setTopAnchor(course_text, 5.0);
            
        }
        
        
    void loadAnnouceList(String UserID){
        annouce_list = database.LoadAnnoucements(UserID, false);
        AddAnnouce_Dynamic();
    }
        void AddAnnouce_Dynamic(){
            for(int i = 0; i < annouce_list.get(0).size(); i++){
                String CourseName = annouce_list.get(6).get(i);
                String Title = annouce_list.get(2).get(i);
                String Time = annouce_list.get(4).get(i);
                String Read = annouce_list.get(5).get(i);
                LoadAnnouce_Item(CourseName, Title, Time,Read);
            }
            System.out.println("Annouce Size:" + annouce_list.get(0).size());
            if(annouce_list.get(0).size() == 0){
                vbox_annouce.getChildren().add(cc.ListEmpty_note("There is no new annoucement", vbox_annouce.getPrefWidth()));
            }
        }
        
        void LoadAnnouce_Item(String coursename, String annouce_title, String date, String read){
            //AnchorPane container = new AnchorPane();
            VBox box = new VBox();
            box.setEffect(new DropShadow(10, (javafx.scene.paint.Color) Paint.valueOf("#666666")));
            Label _title = new Label();
            Separator s = new Separator(Orientation.HORIZONTAL);
            Label _content = new Label();
            Label _new = new Label();
            Label _time = new Label();
            
            
            if(read.equals("0")){
                            
                _new.setText("New");
                _new.getStyleClass().add("Annouce_item_new");
                
                
            }
            
            _title.setText(coursename);
            _title.getStyleClass().add("Annouce_item_header");
            _title.setWrapText(true);
            _title.setPrefWidth(300);
            
            _content.setText(annouce_title);
            _content.setWrapText(true);
            _content.getStyleClass().add("Annouce_item_content");
            
            _time.setText("Post: " + date);
            _time.getStyleClass().add("Annouce_item_bottom");
            _time.setPrefWidth(300);
            
            box.getChildren().add(_title);
            box.getChildren().add(_content);
            box.getChildren().add(_time);
            box.getChildren().add(_new);
            box.getStyleClass().add("Annouce_item");
            
            
            vbox_annouce.getChildren().add(box);
        }
        
        
}
