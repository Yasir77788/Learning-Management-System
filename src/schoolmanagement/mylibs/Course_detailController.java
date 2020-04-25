/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.mylibs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Course_detailController implements Initializable {

    DatabaseConnection database;
    @FXML
    private Label lbl_code;
    @FXML
    private Label lbl_name;
    @FXML
    private Label lbl_desc;
    @FXML
    private Label lbl_prere;
    @FXML
    private Label lbl_credit;
    @FXML
    private Label lbl_meetTime;
    @FXML
    private Label lbl_session;
    @FXML
    private Label lbl_room;
    @FXML
    private Label lbl_instr;
    @FXML
    private Label lbl_mode;
    @FXML
    private Label lbl_status;
    @FXML
    private Button btn_add;
    @FXML
    private Button btn_close;

    String UserID;
    String CourseID;
    
    @FXML
    private AnchorPane container;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        
    }    

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public void getInformation(String UserID, String CourseID,String code, String name, String desc, String prere, String credit, String meettime, String session, String room, String instr, String mode, String status){
        lbl_code.setText(code);
        lbl_name.setText(name);
        lbl_desc.setText(desc);
        lbl_prere.setText(prere);
        lbl_credit.setText(credit);
        lbl_meetTime.setText(meettime);
        lbl_session.setText(session);
        lbl_room.setText(room);
        lbl_instr.setText(instr);
        lbl_mode.setText(mode);
        lbl_status.setText(status);
        
        if(status.equals("Close")){
            //btn_add.setMaxSize(0, 0);
            btn_add.setMinSize(0, 0);
            btn_add.setPrefSize(0, 0);
        }
        
        this.UserID = UserID;
        this.CourseID = CourseID;
    }
    
    boolean Addstatus;
    String message = "Add Course Successfully";
    @FXML
    private void OnAddClicked(MouseEvent event) {
        System.out.println("UserID: " + UserID + " - CourseID: " + CourseID);
        Addstatus = database.StudentAddNewCourse(UserID, CourseID);
        
        if(Addstatus == true){ // if this course is already in list
            message = "Add new course Fail!\nThis course is already in your list!";
        }
        Control_PopupController cpc = new Control_PopupController();
        cpc.setTitle("Add Course");
        cpc.setMessage(message.replace("\\n", "\n"));
        cpc.Show();
        
        CustomControl cc = new CustomControl();
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
