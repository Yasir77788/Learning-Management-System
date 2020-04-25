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
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class TranscriptController implements Initializable {

    DecimalFormat df ;
    
    DatabaseConnection database;
    String UserID;
    String UserRole;
    double CumAttempted = 0;
    double CumEarned = 0;
    double CumPoints = 0;
    double CumGrade = 0;
    double CumGPA = 0;
    
    ArrayList<ArrayList<String>> Course_list;
    ArrayList<ArrayList<String>> Term_list;
    @FXML
    private VBox vbox_coursesList;
    @FXML
    private VBox vbox_finalgrade;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        df = new DecimalFormat("0.000");
        database = new DatabaseConnection();
        Course_list = new ArrayList<>();
        Term_list = new ArrayList<>();
    }
    
    public void getUserInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        
        SemesterDetail(UserID);
        vbox_finalgrade.getChildren().add(CurrentGPADetail("Cum GPA","Cum Totals",CumGPA,CumAttempted,CumEarned,CumGrade,CumPoints));
    }
    
    // Semester Header
    void SemesterDetail(String UserID){
        
        CustomControl cc = new CustomControl();

        Term_list = database.GetTranscriptTermOrderList(true);
        
        for(int i = 0; i< Term_list.get(0).size();i++){ // loop term order
             
            
            Course_list = database.GetTranscriptInformation(UserID, Term_list.get(0).get(i), Term_list.get(1).get(i));
            if(Course_list.get(0).size()> 0){
                ArrayList<String> Subject_ID = Course_list.get(0);
                ArrayList<String> Course_Number = Course_list.get(1);
                ArrayList<String> Course_Name = Course_list.get(2);
                ArrayList<String> Attempted = Course_list.get(3);
                ArrayList<String> Earned = Course_list.get(4);
                ArrayList<String> Final_letter_grade = Course_list.get(5);
                ArrayList<String> Points = Course_list.get(6);
                ArrayList<String> Term_name = Course_list.get(7);
                ArrayList<String> Term_year = Course_list.get(8);

                VBox termDetail = new VBox();

                String _term = Term_list.get(0).get(i) + " " +Term_list.get(1).get(i) + " (" + Term_list.get(2).get(i) + " - " + Term_list.get(3).get(i)+")";
                termDetail.getChildren().add(Term(_term ));
                termDetail.getChildren().add(Header());

                int TermAttempted = 0;
                int TermEarned = 0;
                int TermPoints = 0;
                int TermGrade = 0;
                double TermGPA = 0;
                
                for(int k = 0; k < Subject_ID.size(); k++){
                        String _subject_id = Subject_ID.get(k) + " " + Course_Number.get(k);
                        String _course_name = Course_Name.get(k);
                        
                        double _attempted = Double.parseDouble(Attempted.get(k));
                        TermAttempted += _attempted;
                        
                        String _final = Final_letter_grade.get(k);
                        
                        double _earned = 0;
                        if(!_final.equals("F")){
                            _earned = _attempted;
                        }
                        TermEarned += _earned;
                        
                        int _point = Integer.parseInt(Points.get(k));
                        TermPoints += _point;
                        
                        termDetail.getChildren().add(CourseDetail(_subject_id, _course_name, _attempted, _earned, _final, _point));
                }
                TermGrade = TermEarned;
                
                CumAttempted += TermAttempted;
                CumEarned += TermEarned;
                CumGrade += TermGrade;
                CumPoints += TermPoints;
                
                
                TermGPA = (double)TermPoints/ (double)TermEarned;
                CumGPA = (double)CumPoints/(double)CumEarned;
                        
                termDetail.getChildren().add(CurrentGPAHeader());
                termDetail.getChildren().add(CurrentGPADetail("Term GPA","Term Totals",TermGPA,TermAttempted,TermEarned,TermGrade,TermPoints));
                termDetail.getChildren().add(CurrentGPAHeader());
                termDetail.getChildren().add(CurrentGPADetail("Cum GPA","Cum Totals",CumGPA,CumAttempted,CumEarned,CumGrade,CumPoints));
                termDetail.setPadding(new Insets(0, 0, 20, 0));

                vbox_coursesList.getChildren().add(termDetail);
            }
        }
    }
    // Term 
    Label Term(String term){
        
        //  Term Start
        Label _term = new Label();
        _term.setAlignment(Pos.CENTER);
        _term.setPrefWidth(900);
        _term.setText(term);
        _term.getStyleClass().add("term");
        
        return _term;
    }
    
    // Header
    HBox Header(){
        HBox _header = new HBox();
        
        Label _code = new Label(); // Code
        _code.setPrefWidth(150);
        _code.setUnderline(true);
        _code.getStyleClass().add("header");
        _code.setText("Course Code");
        
        Label _name = new Label(); // Name
        _name.setPrefWidth(630);
        _name.setUnderline(true);
        _name.getStyleClass().add("header");
        _name.setText("Course Name");
        
        Label _attempted = new Label(); // Attempted
        _attempted.setPrefWidth(130);
        _attempted.setUnderline(true);
        _attempted.getStyleClass().add("header");
        _attempted.setText("Attempted");
        
        Label _earned = new Label(); // Earned
        _earned.setPrefWidth(130);
        _earned.setUnderline(true);
        _earned.getStyleClass().add("header");
        _earned.setText("Earned");
        
        Label _grade = new Label(); // Grade
        _grade.setPrefWidth(90);
        _grade.setUnderline(true);
        _grade.getStyleClass().add("header");
        _grade.setText("Grade");
        
        Label _point = new Label(); // Point
        _point.setPrefWidth(80);
        _point.setUnderline(true);
        _point.getStyleClass().add("header");
        _point.setText("Point");
        
        _header.getChildren().add(_code);
        _header.getChildren().add(_name);
        _header.getChildren().add(_attempted);
        _header.getChildren().add(_earned);
        _header.getChildren().add(_grade);
        _header.getChildren().add(_point);
        
        return _header;
    }
    
    // Course Detail
    HBox CourseDetail(String code, String name, double attempted, double earned, String grade, double points){
        HBox _container = new HBox();
        _container.setPrefHeight(50);
        
        Label _code = new Label(); // Code
        _code.setPrefWidth(150);
        _code.getStyleClass().add("header");
        _code.setText(code);
        
        Label _name = new Label(); // Name
        _name.setPrefWidth(630);
        _name.getStyleClass().add("header");
        _name.setText(name);
        
        Label _attempted = new Label(); // Attempted
        _attempted.setPrefWidth(130);
        _attempted.getStyleClass().add("header");
        _attempted.setText(df.format(attempted));
        
        Label _earned = new Label(); // Earned
        _earned.setPrefWidth(130);
        _earned.getStyleClass().add("header");
        _earned.setText(df.format(earned));
        
        Label _grade = new Label(); // Grade
        _grade.setPrefWidth(90);
        _grade.getStyleClass().add("header");
        _grade.setText(grade);
        
        Label _point = new Label(); // Point
        _point.setPrefWidth(80);
        _point.getStyleClass().add("header");
        _point.setText(df.format(points));
        
        _container.getChildren().add(_code);
        _container.getChildren().add(_name);
        _container.getChildren().add(_attempted);
        _container.getChildren().add(_earned);
        _container.getChildren().add(_grade);
        _container.getChildren().add(_point);
        
        
        return _container;
        
    }
    
    // Current GPA Header
    HBox CurrentGPAHeader(){
        HBox _header = new HBox();
        
        Label _code = new Label(); // Code
        _code.setPrefWidth(150);
        _code.setUnderline(true);
        _code.getStyleClass().add("header");
        _code.setText("");
        
        Label _name = new Label(); // Name
        _name.setPrefWidth(630);
        _name.setUnderline(true);
        _name.getStyleClass().add("header");
        _name.setText("");
        
        Label _attempted = new Label(); // Attempted
        _attempted.setPrefWidth(130);
        _attempted.setUnderline(true);
        _attempted.getStyleClass().add("header");
        _attempted.setText("Attempted");
        
        Label _earned = new Label(); // Earned
        _earned.setPrefWidth(130);
        _earned.setUnderline(true);
        _earned.getStyleClass().add("header");
        _earned.setText("Earned");
        
        Label _grade = new Label(); // Grade
        _grade.setPrefWidth(90);
        _grade.setUnderline(true);
        _grade.getStyleClass().add("header");
        _grade.setText("Grade");
        
        Label _point = new Label(); // Point
        _point.setPrefWidth(80);
        _point.setUnderline(true);
        _point.getStyleClass().add("header");
        _point.setText("Point");
        
        _header.getChildren().add(_code);
        _header.getChildren().add(_name);
        _header.getChildren().add(_attempted);
        _header.getChildren().add(_earned);
        _header.getChildren().add(_grade);
        _header.getChildren().add(_point);
        
        return _header;
    }
    
    // Current GPA Detail
    HBox CurrentGPADetail(String GPATitle, String TotalTitle,double termGPA, double attempted, double earned, double grade, double points){
        HBox _container = new HBox();
        _container.setPrefHeight(50);
        
        Label _termGPA = new Label(); // Code
        _termGPA.setPrefWidth(150);
        _termGPA.getStyleClass().add("header");
        _termGPA.setText(GPATitle);
        
        Label _termGPAValue = new Label(); // Name
        _termGPAValue.setPrefWidth(480);
        _termGPAValue.getStyleClass().add("header");
        _termGPAValue.setText(df.format(termGPA));
        
        Label _termTotal = new Label(); // Name
        _termTotal.setPrefWidth(150);
        _termTotal.getStyleClass().add("header");
        _termTotal.setText(TotalTitle);
        
        Label _attempted = new Label(); // Attempted
        _attempted.setPrefWidth(130);
        _attempted.getStyleClass().add("header");
        _attempted.setText(df.format(attempted));
        
        Label _earned = new Label(); // Earned
        _earned.setPrefWidth(130);
        _earned.getStyleClass().add("header");
        _earned.setText(df.format(earned));
        
        Label _grade = new Label(); // Grade
        _grade.setPrefWidth(90);
        _grade.getStyleClass().add("header");
        _grade.setText(df.format(grade));
        
        Label _point = new Label(); // Point
        _point.setPrefWidth(80);
        _point.getStyleClass().add("header");
        _point.setText(df.format(points));
        
        _container.getChildren().add(_termGPA);
        _container.getChildren().add(_termGPAValue);
        _container.getChildren().add(_termTotal);
        _container.getChildren().add(_attempted);
        _container.getChildren().add(_earned);
        _container.getChildren().add(_grade);
        _container.getChildren().add(_point);
        
        
        return _container;
        
    }
    

}
