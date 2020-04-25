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
public class AddNewAnnoucementController implements Initializable {
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
    private ComboBox<String> cbx_courseList;
    @FXML
    private TextField txt_title;
    @FXML
    private HBox content_container;
    @FXML
    private HTMLEditor editor_message;

    String UserID = "";
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
    public void getUserInformation(String UserID){
        this.UserID = UserID;
        LoadCourses(UserID);
    }
    @FXML
    private void OnAddClicked(MouseEvent event) {
        AddAnnoucement();
         Control_PopupController cp = new Control_PopupController();
        cp.setTitle("Add New Annoucement");
        cp.setMessage("New Annoucement has been added!");
        cp.Show();
        
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    public void LoadCourses(String UserID){
        course_list = database.ProfessorLoadTeachingCourses(UserID);

        course_id = new ArrayList<> (course_list.get(0));
        subject_id = new ArrayList<> (course_list.get(1));
        course_code = new ArrayList<> (course_list.get(2));
        course_name = new ArrayList<> (course_list.get(3));
        ArrayList<String> course_list = new ArrayList<>();
        //course_list.add("Select Course...");
        for(int  i= 0; i < course_id.size();i++){
            course_list.add("["+subject_id.get(i)+ " " + course_code.get(i)+ "]" + " - " + course_name.get(i));
        }
        cbx_courseList.getItems().addAll(course_list);
        
        
    }
    public void LoadStudentList(String CourseID){
        StudentID = database.ProfessorGetAllStudentID(CourseID);
    }
    void AddAnnoucement(){
        String CourseID = course_id.get(cbx_courseList.getSelectionModel().getSelectedIndex());
        LoadStudentList(CourseID);
        for(int i =0;i< StudentID.size();i++){
            database.ProfessorAddNewAnnoucement(StudentID.get(i), CourseID, txt_title.getText(), editor_message.getHtmlText());
        }
       
    }
    
    public void Show(String UserID){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNewAnnoucement.fxml"));
            Scene scene = null;
            
            try {
                scene = new Scene(loader.load());

            } catch (IOException ex) {
                Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            scene.setFill(Color.TRANSPARENT);
            
            AddNewAnnoucementController controller = loader.getController();
            controller.getUserInformation(UserID);
            
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);   
            stage.show();
    }

}
