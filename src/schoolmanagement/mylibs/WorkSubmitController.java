/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.mylibs;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
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
public class WorkSubmitController implements Initializable {
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
    private HBox content_container;


    String UserID = "";
    String WorkRecordID = "";
    String MaxGrader = "";
    
    @FXML
    private Label lbl_header;
    @FXML
    private Label lbl_title;
    @FXML
    private Label lbl_percentage;
    @FXML
    private Label lbl_due;
    @FXML
    private Label lbl_instruction;
    @FXML
    private TextArea txt_answer;
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
    public void getUserInformation(String UserID, String WorkRecordID, String title, String instruction, String grademax, String percentage, String due){
        this.UserID = UserID;
        this.WorkRecordID = WorkRecordID;
        this.MaxGrader = grademax;
        lbl_title.setText(title);
        lbl_percentage.setText(percentage+"%");
        lbl_due.setText(due);
        lbl_instruction.setText(instruction);

    }
    @FXML
    private void OnAddClicked(MouseEvent event) {
        AddHomework();
         Control_PopupController cp = new Control_PopupController();
         
         
         
        cp.setTitle("Submit Work");
        cp.setMessage("Submit work successfully!");
        cp.Show();
        
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    void AddHomework(){
        double gradeget = 0.00;
        int finalgrade = 0;
        do{
            gradeget = Math.random();
            finalgrade = (int) (gradeget*100);
        }while(finalgrade < 50);
        
        DateFormat dateformat = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        Date date = new Date();
        
        database.StudentSubmitWork( finalgrade+"", txt_answer.getText(), dateformat.format(date), WorkRecordID);
       
    }
    
    public void Show(String UserID, String WorkRecordID, String title, String instruction, String gradenmax, String percentage, String due){
        Parent parent = null;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkSubmit.fxml"));
        Scene scene = null;

        try {
            scene = new Scene(loader.load());

        } catch (IOException ex) {
            Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Stage stage = new Stage();
        scene.setFill(Color.TRANSPARENT);

        WorkSubmitController controller = loader.getController();
        controller.getUserInformation(UserID,WorkRecordID, title,instruction, gradenmax, percentage, due);

        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);   
        stage.show();
        
    }

}
