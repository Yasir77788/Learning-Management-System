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
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import schoolmanagement.mylibs.AddNewworkController;
import schoolmanagement.mylibs.Control_PopupController;
import schoolmanagement.mylibs.WorkSubmitController;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class HomeworkListController implements Initializable {
    
    DatabaseConnection database;
    
    String UserID = "";
    String CourseID = "";
    String WorkType = "";
    @FXML
    private AnchorPane root;
    @FXML
    private Label lbl_currentcourse;
    @FXML
    private AnchorPane course_contain;
    @FXML
    private VBox course_container;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        course_container.setSpacing(20);
        
        
    }    
    
    public void getUserInformation(String UserID, String CourseID, String Worktype){
        this.UserID = UserID;
        this.CourseID = CourseID;
        this.WorkType = Worktype;
        
        LoadHomeworkList(UserID, Worktype, CourseID);
        
    }
    
    
    void LoadHomeworkList(String UserID, String Worktype, String CourseID){
        ArrayList<ArrayList<String>> homework_list = new ArrayList<>();
        homework_list = database.StudentLoadAllwork(UserID, Worktype, CourseID);
        System.out.println("ID: " + UserID + " Worktype: " + Worktype);
        
        System.out.println("List Size: " + homework_list.get(0).size());
        for(int i =0; i < homework_list.get(0).size(); i++){
            HBox item_container = new HBox();
            item_container.setPrefWidth(1230);
            item_container.setEffect(new DropShadow(10, (javafx.scene.paint.Color) Paint.valueOf("#666666")));
            item_container.getStyleClass().add("homework_item_container");
            
            
            
            String StudentWorkID = homework_list.get(0).get(i);
            String title = homework_list.get(1).get(i);
            String instrunction = homework_list.get(2).get(i);
            String gradeget = homework_list.get(5).get(i);
            String grademax = homework_list.get(6).get(i);
            String percentage = homework_list.get(3).get(i);
            String percentageaverage = "";
            if(gradeget !=null){
                percentageaverage = (Double.parseDouble(percentage) * Double.parseDouble(gradeget) / 100)+"";
            }else {
                percentageaverage = "--";
            }
            
            String due = homework_list.get(4).get(i);
            
            
            item_container.getChildren().add(SetTitle(title, instrunction));
            item_container.getChildren().add(SetGrade(gradeget, grademax));
            item_container.getChildren().add(SetPercentage(percentageaverage,percentage));
            item_container.getChildren().add(SetDueDate(due));
            
            item_container.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(gradeget != null){
                        Control_PopupController cp = new Control_PopupController();
                        cp.setTitle("Notice");
                        cp.setMessage("This work is already done!");
                        cp.Show();
                    }else {
                        WorkSubmitController controller = new WorkSubmitController();
                        controller.Show(UserID, StudentWorkID, title,instrunction, grademax,percentage,due);
                    }
                }
            });
            course_container.getChildren().add(item_container);
        }
        
        
    }
    VBox SetTitle(String title, String instruction){
        VBox column_detail = new VBox();
        column_detail.setPrefWidth(750);
        Label _Qheader = new Label();
        _Qheader.setPrefWidth(column_detail.getPrefWidth());
        _Qheader.getStyleClass().add("homework_header_left");
        _Qheader.setText("Description");
        Label _Qcontent = new Label();
        _Qcontent.getStyleClass().add("homework_content");
        String _description = "Title: "+ title;
        _Qcontent.setText(_description.replace("\\n", "\n"));
        _Qcontent.setWrapText(true);
        Label _Qinstruction = new Label();
        _Qinstruction.getStyleClass().add("homework_instruction");
        _Qinstruction.setText(instruction);
        
        
        column_detail.getChildren().add(_Qheader);
        column_detail.getChildren().add(_Qcontent);
        column_detail.getChildren().add(_Qinstruction);
        
        return column_detail;
    }
    
    VBox SetGrade(String grade, String Maxgrade){
        VBox column_detail = new VBox();
        column_detail.setPrefSize(150, 50);
        column_detail.setAlignment(Pos.TOP_CENTER);
        Label _Qheader = new Label();
        _Qheader.setPrefWidth(column_detail.getPrefWidth());
        _Qheader.getStyleClass().add("homework_header_center");
        _Qheader.setText("Grade");
        Label _Qcontent = new Label();
        _Qcontent.getStyleClass().add("homework_content");
        if(grade == null){
            grade = "--";
        }
        _Qcontent.setText(grade+"/"+Maxgrade);
        
        column_detail.getChildren().add(_Qheader);
        column_detail.getChildren().add(_Qcontent);
        
        return column_detail;
    }
    
    VBox SetPercentage(String average, String percentage){
        VBox column_detail = new VBox();
        column_detail.setPrefSize(200, 50);
        column_detail.setAlignment(Pos.TOP_CENTER);
        Label _Qheader = new Label();
        _Qheader.setPrefWidth(column_detail.getPrefWidth());
        _Qheader.getStyleClass().add("homework_header_center");
        _Qheader.setText("Percentage (%)");
        Label _Qcontent = new Label();
        _Qcontent.getStyleClass().add("homework_content");
        _Qcontent.setText(average+"/"+percentage);
        
        column_detail.getChildren().add(_Qheader);
        column_detail.getChildren().add(_Qcontent);
        
        return column_detail;
    }
    VBox SetDueDate(String DueDate){
        VBox column_detail = new VBox();
        column_detail.setPrefSize(250, 50);
        column_detail.setAlignment(Pos.TOP_CENTER);
        Label _Qheader = new Label();
        _Qheader.setPrefWidth(column_detail.getPrefWidth());
        _Qheader.getStyleClass().add("homework_header_center");
        _Qheader.setText("Due Date");
        Label _Qcontent = new Label();
        _Qcontent.getStyleClass().add("homework_content");
        _Qcontent.setText(DueDate);
        
        column_detail.getChildren().add(_Qheader);
        column_detail.getChildren().add(_Qcontent);
        
        return column_detail;
    }
    
    

    private void OnAddNewHWClicked(MouseEvent event) {
        AddNewworkController controller = new AddNewworkController();
        controller.Show(UserID, CourseID, "Homework");
    }
}
