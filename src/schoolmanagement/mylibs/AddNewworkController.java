/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.mylibs;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class AddNewworkController implements Initializable {
    DatabaseConnection database;
    CustomControl cc;
    ArrayList<ArrayList<String>> course_list;
    ArrayList<String> StudentID;
    ArrayList<String> course_id;
    ArrayList<String> subject_id;
    ArrayList<String> course_code;
    ArrayList<String> course_name;
    
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_close;

    @FXML
    private TextField txt_title;
    @FXML
    private HBox content_container;


    String UserID = "";
    String CourseID ="";
    String WorktypeID = "";
    @FXML
    private DatePicker duedate_picker;
    @FXML
    private TextArea txt_instructions;
    @FXML
    private TextField txt_percentage;
    @FXML
    private Label lbl_header;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        
        cc = new CustomControl();
        course_list = new ArrayList<>();
        StudentID = new ArrayList<>();
        
    }    
    public void getUserInformation(String UserID, String CourseID, String WorktypeID){
        this.UserID = UserID;
        this.CourseID = CourseID;
        this.WorktypeID = WorktypeID;
        lbl_header.setText("Add New " + WorktypeID);
        System.out.println("Course ID: " + CourseID);
    }
    @FXML
    private void OnAddClicked(MouseEvent event) {
        AddHomework();
         Control_PopupController cp = new Control_PopupController();
         
         
         
        cp.setTitle("Add New " + WorktypeID);
        cp.setMessage("Add New "+ WorktypeID +" successfully!");
        cp.Show();
        
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    public void LoadStudentList(String CourseID){
        StudentID = database.ProfessorGetAllStudentID(CourseID);
    }
    void AddHomework(){
        LoadStudentList(CourseID);
        database.ProfessorAddNewHomework(StudentID, CourseID, WorktypeID, txt_title.getText(), txt_instructions.getText(), txt_percentage.getText(), duedate_picker.getValue());
       
    }
    
    public void Show(String UserID, String CourseID, String WorktypeID){
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewwork.fxml"));
        Scene scene = null;

        try {
            scene = new Scene(loader.load());

        } catch (IOException ex) {
            Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);

        AddNewworkController controller = loader.getController();
        controller.getUserInformation(UserID,CourseID,WorktypeID);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);   
        stage.show();
        
    }

}
