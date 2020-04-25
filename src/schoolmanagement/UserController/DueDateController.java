/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.UserController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class DueDateController implements Initializable {
    DatabaseConnection database;
    ArrayList<ArrayList<String>> List;
    
    private VBox vbox_annouceList;
    

    String UserID;
    String UserRole;

    @FXML
    private AnchorPane main;
    @FXML
    private ScrollPane scrollview;
    @FXML
    private VBox vbox_List;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        List= new ArrayList<>();
        vbox_List.setSpacing(0);
        for(int i =0; i < 5;i++){
            
        }

    }    
    
    public void getInformation(String UserID, String CourseID){
        this.UserID = UserID;
        LoadDate(UserID, CourseID);

    }
    
    void LoadDate(String UserID, String CourseID){
        List = database.LoadWorkDueDate(UserID, CourseID);
        
        for(int i = 0; i < List.get(0).size();i++){
            String duedate = List.get(2).get(i);
            String title = List.get(1).get(i);
            String worktype = List.get(6).get(i);
            String course = "Course: ["+List.get(3).get(i) + " " + List.get(4).get(i)+"] "+ List.get(5).get(i);
            Design(duedate,title,worktype,course);
        }
    }
    void Design(String duedate, String title, String worktype, String course){
        HBox container = new HBox();
        container.setPrefHeight(100);
        container.setAlignment(Pos.CENTER_LEFT);
        
        
        Separator s = new Separator(Orientation.VERTICAL);
        
        VBox level = new VBox();
        level.setPrefHeight(container.getPrefHeight());
        level.setAlignment(Pos.CENTER_LEFT);
        HBox levelno1 = new HBox();
        HBox levelno2 = new HBox();
        Button circle = new Button();
        circle.getStyleClass().add("Duedate_circle");
        
        circle.setText("");
        circle.setPrefSize(25, 25);
        
        Label _duedate = new Label();
        _duedate.setPadding(new Insets(0, 10, 0, 5));
        _duedate.setText(duedate);
        _duedate.getStyleClass().add("Duedate");
        
        Label _worktitle = new Label();
        _worktitle.setPrefWidth(900);
        _worktitle.setPadding(new Insets(0, 0, 0, 20));
        _worktitle.setText(title);
        _worktitle.getStyleClass().add("Duedate");
        
        
        Label _worktype = new Label();
        _worktype.setPrefWidth(200);
        _worktype.setPadding(new Insets(0, 0, 0, 30));
        _worktype.setText(worktype);
        _worktype.getStyleClass().add("Duedate");
        
        
        Label _course = new Label();
        _course.setPadding(new Insets(0, 0, 0, 50));
        _course.setText(course);
        _course.getStyleClass().add("Duedate_course");
        
        
        
        levelno1.getChildren().add(_worktitle);
        levelno1.getChildren().add(_worktype);
        levelno2.getChildren().add(_course);
        
        level.getChildren().add(levelno1);
        level.getChildren().add(levelno2);
        
        container.getChildren().add(circle);
        container.getChildren().add(_duedate);
        container.getChildren().add(s);
        container.getChildren().add(level);
        vbox_List.getChildren().add(container);
    }
    
    
    
}
