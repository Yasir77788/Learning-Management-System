/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import com.sun.javafx.scene.control.skin.CustomColorDialog;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javax.swing.SpringLayout;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class CoursesGradesController implements Initializable {

    DatabaseConnection database;
    ArrayList<String> CourseIDList;
    ArrayList<ArrayList<String>> GradesList;
    ArrayList<Integer> FinalGrade;
    @FXML
    private VBox vbox_coursecontainer;

    
    String UserID= "";
    String UserRole = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        CourseIDList = new ArrayList<>();
        GradesList = new ArrayList<>();
        FinalGrade = new ArrayList<>();
    }    
    public void getInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        GetDataFromDatabase(UserID);
        
    }
    
    void GetDataFromDatabase(String UserID){
        CourseIDList = database.GetStudentCourseIDList(UserID);
        System.out.println("Current Courses ID: " + CourseIDList);
            for(int j =0; j< CourseIDList.size();j++){
                int max = 0;
                int get = 0;
                int per = 0;
                double peraverage = 0.0;
                GradesList = database.GetStudentCourseGradeList(UserID, CourseIDList.get(j));   
                if(GradesList.get(0).size() > 0){
                    for(int i =0; i< GradesList.get(0).size();i++){

                        if(GradesList.get(1).get(i) != null){
                            max += Integer.parseInt(GradesList.get(0).get(i));
                            get += Integer.parseInt(GradesList.get(1).get(i));
                            per += Integer.parseInt(GradesList.get(2).get(i));
                            
                            
                            peraverage += Double.parseDouble(GradesList.get(2).get(i)) * Double.parseDouble(GradesList.get(1).get(i)) / 100;
                        }
                    }


                    double GradeAverage = (peraverage*100/per);
                    String GradeLetter = "--";
                    

                    String Code = GradesList.get(3).get(0) + " " + GradesList.get(4).get(0);
                    String Name = GradesList.get(5).get(0);
                    String Grade = "--/--";
                    if(max>0){
                        if(GradeAverage > 89){GradeLetter = "A";}
                        else if(GradeAverage > 79){GradeLetter = "B";}
                        else if(GradeAverage > 69){GradeLetter = "C";}
                        else if(GradeAverage > 59){GradeLetter = "D";}
                        else {GradeLetter = "F";}
                        
                        DecimalFormat dformat = new DecimalFormat("##.00");
                        
                         Grade = dformat.format(peraverage)+"/" + per;
                    }
                    Course_grade_item_Design(Code, Name, Grade,GradeLetter);
                }

           }
    }
    
    public void Course_grade_item_Design(String _Code, String _Name, String _Grade, String _Letter){
        AnchorPane pane = new AnchorPane();
        
        pane.setId(_Code);
        pane.getStyleClass().add("Grade_container");
        pane.setPrefSize(1200, 80);
        pane.setEffect(new DropShadow(5, (javafx.scene.paint.Color) Paint.valueOf("#666666")));
        
        HBox _hbox = new HBox();
        _hbox.setPrefHeight(pane.getPrefHeight());
        //_hbox.getStyleClass().add("Grade_course_box");
        
        // Course Code
        VBox _code_container = new VBox();
        _code_container.setPrefSize(130, 0);
        _code_container.setAlignment(Pos.CENTER);
        _code_container.getStyleClass().add("Grade_code_container");
        
        Label _code_header = new Label();
        _code_header.setPrefWidth(_code_container.getPrefWidth());
        _code_header.setText("Course Number");
        _code_header.getStyleClass().add("Grade_course_header");
        
        Label Code = new Label();
        //Code.setPrefSize(170,50);
        Code.getStyleClass().add("Grade_course_code");
        Code.setText(_Code);
        
        _code_container.getChildren().add(_code_header);
        _code_container.getChildren().add(Code);
        
        // Course Name
        VBox _name_container = new VBox();
        _name_container.setPrefWidth(815);
        _name_container.setAlignment(Pos.CENTER_LEFT);
        
        Label _name_header = new Label();
        _name_header.setPrefWidth(_name_container.getPrefWidth());
        _name_header.setText("Course Name");
        _name_header.getStyleClass().add("Grade_course_header_name");
        
        Label Name = new Label();
        //Name.setPrefSize(780, 100);
        Name.getStyleClass().add("Grade_course_name");
        Name.setText(_Name);
        
        _name_container.getChildren().add(_name_header);
        _name_container.getChildren().add(Name);
        
        
        // Course Grade
        VBox _grade_container = new VBox();
        _grade_container.setPrefWidth(170);
        _grade_container.setAlignment(Pos.CENTER);
        
        Label _grade_header = new Label();
        _grade_header.setPrefWidth(_grade_container.getPrefWidth());
        _grade_header.setText("Average(%)");
        _grade_header.getStyleClass().add("Grade_course_header_other");
        
        Label Grade = new Label();
        //Grade.setPrefSize(170, 100);
        Grade.getStyleClass().add("Grade_course_grade");
        Grade.setText(_Grade);
        
        _grade_container.getChildren().add(_grade_header);
        _grade_container.getChildren().add(Grade);
        
        // Course Grade Letter
        VBox _gradeletter_container = new VBox();
        _gradeletter_container.setPrefWidth(100);
        _gradeletter_container.setAlignment(Pos.CENTER);
        
        Label _gradeletter_header = new Label();
        _gradeletter_header.setText("Letter Grade");
        _gradeletter_header.setPrefWidth(_gradeletter_container.getPrefWidth());
        _gradeletter_header.getStyleClass().add("Grade_course_header_other");
        
        Label GradeLetter = new Label();
        //GradeLetter.setPrefSize(100, 100);
        GradeLetter.getStyleClass().add("Grade_course_grade_letter");
        GradeLetter.setText(_Letter);
        
        _gradeletter_container.getChildren().add(_gradeletter_header);
        _gradeletter_container.getChildren().add(GradeLetter);
        
        Separator s_top = new Separator(Orientation.HORIZONTAL);

        
        Separator s_bottom = new Separator(Orientation.HORIZONTAL);
        s_bottom.setPadding(new Insets(0, 0, 5, 0));
        
        _hbox.getChildren().add(_code_container);
        _hbox.getChildren().add(_name_container);
        _hbox.getChildren().add(_grade_container);
        _hbox.getChildren().add(_gradeletter_container);
        
        
        pane.getChildren().add(_hbox);
       // vbox_coursecontainer.getChildren().add(s_top);
        vbox_coursecontainer.getChildren().add(pane);
        //vbox_coursecontainer.getChildren().add(s_bottom);

    }
    
}
