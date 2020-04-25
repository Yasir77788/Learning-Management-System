/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.ProfessorController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import schoolmanagement.mylibs.AddNewAnnoucementController;
import schoolmanagement.mylibs.CustomControl;
import mylibs.LeftMenuButtonControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Pro_CourseDetail_DashboardController implements Initializable {
    DatabaseConnection database;
    LeftMenuButtonControl lm;
    
    @FXML
    private AnchorPane root;
    @FXML
    private BorderPane borderPane;
    @FXML
    private VBox vbox_buttonList;
    @FXML
    private AnchorPane main_area;
    
    ArrayList<HBox> _buttonList;
    
    public String UserID = "";
    public String CourseID = "";
    @FXML
    private Button btn_back;
    @FXML
    private Label lbl_coursename;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        lm = new LeftMenuButtonControl();
        _buttonList = new ArrayList<>();
        loadButtonList();
    }    
    
    public void getUserID(String UserID, String CourseID){
        this.UserID = UserID;
        this.CourseID = CourseID;
        LoadCourseDetail(CourseID);
    }
// Load course detail
    ArrayList<String> coursedetail;
    void LoadCourseDetail(String CourseID){
        coursedetail = new ArrayList<>();
        coursedetail = database.LoadCourseDetail(CourseID);
        
        String meeting = " | "+coursedetail.get(3)+"-"+coursedetail.get(4)+" " + coursedetail.get(5);
        if(!coursedetail.get(6).equals("")){
            meeting += "-"+coursedetail.get(6);
        }
        lbl_coursename.setText("Course: ["+coursedetail.get(0) + " " + coursedetail.get(1)+"] " + coursedetail.get(2)+meeting);
    }
    
    ArrayList<String> ButtonName;

    void loadButtonList(){

        ButtonName =new ArrayList<>();
        ButtonName.add("Dashboard"); // 0
        ButtonName.add("Homework"); // 1
        ButtonName.add("Quiz"); // 2
        ButtonName.add("Exam"); // 3

       
        _buttonList = lm.AddNewButton(ButtonName);
        vbox_buttonList.getChildren().addAll(_buttonList);
        
        // Dashboard Click
        _buttonList.get(0).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Dashboard Click");
                System.out.println("UserID: " + UserID);
            }
        });
                // Homework Click
        _buttonList.get(1).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Homework Click");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Pro_HomeworkList.fxml"));
                
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(Pro_CourseDetail_DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pro_HomeworkListController controller = loader.getController();
                controller.getUserInformation(UserID, CourseID, "Homework");
                
                borderPane.setCenter(root);
            }
        });
        // Quiz Click
        _buttonList.get(2).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Quiz Click");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Pro_QuizList.fxml"));
                
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(Pro_CourseDetail_DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pro_QuizListController controller = loader.getController();
                controller.getUserInformation(UserID, CourseID, "Quiz");
                
                borderPane.setCenter(root);
            }
        });
        // Exam Click
        _buttonList.get(3).setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("Exam Click");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Pro_ExamList.fxml"));
                
                try {
                    root = loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(Pro_CourseDetail_DashboardController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Pro_ExamListController controller = loader.getController();
                controller.getUserInformation(UserID, CourseID, "Exam");
                
                borderPane.setCenter(root);
            }
        });
        
    }
    
    
    

    @FXML
    private void rootOnMouseDragged(MouseEvent event) {
    }

    @FXML
    private void rootOnMousePressed(MouseEvent event) {
    }

    @FXML
    private void OnRootDragged(MouseEvent event) {
    }

    @FXML
    private void OnRootClicked(MouseEvent event) {
    }
    
    public void Show(){
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Pro_CourseDetail_Dashboard.fxml"));
            Scene scene = null;
            
            try {
                scene = new Scene(loader.load());

            } catch (IOException ex) {
                Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            scene.setFill(Color.TRANSPARENT);
            
            //AddNewAnnoucementController controller = loader.getController();
            //controller.getUserInformation(UserID);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);   
            stage.show();
    }

    @FXML
    private void OnBackClicked(MouseEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }
    
}
