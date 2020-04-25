/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.mylibs;

import com.sun.javafx.scene.control.skin.CustomColorDialog;
import com.sun.javafx.scene.control.skin.DatePickerContent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import schoolmanagement.SchoolManagement;

/**
 *
 * @author KevinHa
 */
public class CustomControl {
    public HBox Header(){
        double cNoSize = 100;
        double cNameSize = 400;
        double cMeetingSize = 200;
        double cRoomSize = 50;
        double cCreditSize = 60;
        double cInstructorSize = 180;
        double cModeSize = 130;
        double cStatusSize = 70;
        double cActionSize = 70;
        
            HBox _header_box = new HBox();
            
            Label _courseNo = new Label();
            _courseNo.setText("Course No#");
            _courseNo.setPrefWidth(cNoSize);
            _courseNo.getStyleClass().add("label_course_header");
            
            Label _courseName = new Label();
            _courseName.setText("Course Name");
            _courseName.setPrefWidth(cNameSize);
            _courseName.getStyleClass().add("label_course_header");
            
            Label _courseCredit = new Label();
            _courseCredit.setText("Credit");
            _courseCredit.setPrefWidth(cCreditSize);
            _courseCredit.getStyleClass().add("label_course_header");
            
            Label _courseMeeting = new Label();
            _courseMeeting.setText("Meeting");
            _courseMeeting.setPrefWidth(cMeetingSize);
            _courseMeeting.getStyleClass().add("label_course_header");
            
            Label _courseRoom = new Label();
            _courseRoom.setText("Room");
            _courseRoom.setPrefWidth(cRoomSize);
            _courseRoom.getStyleClass().add("label_course_header");
            
            Label _courseInstructor = new Label();
            _courseInstructor.setText("Instructor");
            _courseInstructor.setPrefWidth(cInstructorSize);
            _courseInstructor.getStyleClass().add("label_course_header");
            
            Label _courseMode = new Label();
            _courseMode.setText("Study Mode");
            _courseMode.setPrefWidth(cModeSize);
            _courseMode.getStyleClass().add("label_course_header");
            
            Label _courseStatus = new Label();
            _courseStatus.setText("Status");
            _courseStatus.setPrefWidth(cStatusSize);
            _courseStatus.getStyleClass().add("label_course_header");
            
            Label _courseAction = new Label();
            _courseAction.setText("Action");
            _courseAction.setPrefWidth(cActionSize);
            _courseAction.getStyleClass().add("label_course_header");
            
            _header_box.getChildren().add(_courseNo);
            _header_box.getChildren().add(_courseName);
            _header_box.getChildren().add(_courseCredit);
            _header_box.getChildren().add(_courseMeeting);
            _header_box.getChildren().add(_courseRoom);
            _header_box.getChildren().add(_courseInstructor);
            _header_box.getChildren().add(_courseMode);
            _header_box.getChildren().add(_courseStatus);
            _header_box.getChildren().add(_courseAction);
            
            return _header_box;
        }
        
        public HBox Detail(String UserID, String CourseID,String CourseNo, String CourseName,String Credit, String Meeting , String Room, String Instructor, String StudyMod, String Status, String Desc, String Prere, String Session, int i){
            
            double cNoSize = 100;
            double cNameSize = 400;
            double cMeetingSize = 200;
            double cRoomSize = 50;
            double cCreditSize = 60;
            double cInstructorSize = 180;
            double cModeSize = 130;
            double cStatusSize = 70;
            double cActionSize = 70;
            
            HBox _detail_box = new HBox();
            _detail_box.getStyleClass().add("course_detail_container");
            _detail_box.setPrefHeight(30);
            
            String ColorCode = "";
            if(i%2 == 0){
                ColorCode = "ffffff";
            }else {
                ColorCode = "f6f6f6";
            }
            _detail_box.setStyle("-fx-background-color: #"+ColorCode+";");
            
            
            Label _courseNo = new Label();
            _courseNo.setText(CourseNo);
            _courseNo.setPrefWidth(cNoSize);
            _courseNo.getStyleClass().add("label_course_detail");
            
            Label _courseName = new Label();
            _courseName.setText(CourseName);
            _courseName.setPrefWidth(cNameSize);
            _courseName.getStyleClass().add("label_course_detail");
            
            Label _courseCredit = new Label();
            _courseCredit.setText(Credit);
            _courseCredit.setPrefWidth(cCreditSize);
            _courseCredit.getStyleClass().add("label_course_detail");
            
            Label _courseMeeting = new Label();
            _courseMeeting.setText(Meeting);
            _courseMeeting.setPrefWidth(cMeetingSize);
            _courseMeeting.getStyleClass().add("label_course_detail");
            
            Label _courseRoom = new Label();
            _courseRoom.setText(Room);
            _courseRoom.setPrefWidth(cRoomSize);
            _courseRoom.getStyleClass().add("label_course_detail");
            
            Label _courseInstructor = new Label();
            _courseInstructor.setText(Instructor);
            _courseInstructor.setPrefWidth(cInstructorSize);
            _courseInstructor.getStyleClass().add("label_course_detail");
            
            Label _courseMode = new Label();
            _courseMode.setText(StudyMod);
            _courseMode.setPrefWidth(cModeSize);
            _courseMode.getStyleClass().add("label_course_detail");
            
            Label _courseStatus = new Label();
            _courseStatus.setText(Status);
            _courseStatus.setPrefWidth(cStatusSize);
            _courseStatus.getStyleClass().add("label_course_detail");
            
            String colorCode ="009900";
            if(Status.equals("Close")){
                colorCode = "e13939";
            }
            _courseStatus.setStyle("-fx-text-fill: #"+colorCode+";");
            
            Label _courseAction = new Label();
            _courseAction.setText("Select");
            _courseAction.setPrefWidth(cActionSize);
            _courseAction.getStyleClass().add("course_detail_link");
            
            _courseAction.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    Course_Detail_Popup(UserID, CourseID, CourseNo, CourseName, Desc, Prere, Credit, Meeting, Session, Room, Instructor, StudyMod, Status);
                }
            });
            
            _detail_box.getChildren().add(_courseNo);
            _detail_box.getChildren().add(_courseName);
            _detail_box.getChildren().add(_courseCredit);
            _detail_box.getChildren().add(_courseMeeting);
            _detail_box.getChildren().add(_courseRoom);
            _detail_box.getChildren().add(_courseInstructor);
            _detail_box.getChildren().add(_courseMode);
            _detail_box.getChildren().add(_courseStatus);
            _detail_box.getChildren().add(_courseAction);
            
            return _detail_box;
        }
        
        
        public void Course_Detail_Popup(String UserID, String CourseID, String code, String name, String desc, String prere, String credit, String meettime, String session, String room, String instr, String mode, String status){

            FXMLLoader parent = new FXMLLoader(getClass().getResource("Course_detail.fxml"));
            Scene scene = null;
        try {
            scene = new Scene(parent.load());
             
        } catch (IOException ex) {
            Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
            Stage stage = new Stage();
            scene.setFill(Color.TRANSPARENT);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            
            Course_detailController detail = parent.getController();
            detail.getInformation(UserID, CourseID, code, name, desc, prere, credit, meettime, session, room, instr, mode, status);
            stage.show();
            
          
        }
        
        // Dymanic ArrayList
        public ArrayList<ArrayList<String>> ctm_ArrayList(int size){
            ArrayList<ArrayList<String>> list = new ArrayList<>();
            for(int i = 0; i < size;i++){
                ArrayList<String> _list = new ArrayList<>();
                list.add(_list);
            }
            
            return list;
        }
        
        // Empty List Note
        public Label ListEmpty_note(String Message, double width){
            Label note = new Label();
            note.getStyleClass().add("list_empty_note");
            note.setPrefWidth(width);
            note.setText(Message);
            return note;
        }
        
        public void ExitApplication(){
            schoolmanagement.SchoolManagement m = new SchoolManagement();
            m.CloseApplication();
        }

        
}
