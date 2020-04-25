/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.ProfessorController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class AddNewCourseController implements Initializable {

    DatabaseConnection database;
    
    @FXML
    private ComboBox combo_subject;
    @FXML
    private CheckBox cbx_mon;
    @FXML
    private CheckBox cbx_tues;
    @FXML
    private CheckBox cbx_wed;
    @FXML
    private CheckBox cbx_thurs;
    @FXML
    private CheckBox cbx_fri;
    @FXML
    private CheckBox cbx_sat;
    @FXML
    private CheckBox cbx_sun;
    @FXML
    private Pane btn_container;
    @FXML
    private ComboBox combo_course;
    @FXML
    private TextField txt_meetfrom;
    @FXML
    private TextField txt_meetto;
    @FXML
    private TextField txt_roomno;
    @FXML
    private TextField txt_studentquantity;
    @FXML
    private ComboBox combo_location;
    @FXML
    private ComboBox combo_teachmode;
    @FXML
    private Button btn_add;
    @FXML
    private ComboBox combo_session;
    
    String User_ID;

    ArrayList<CheckBox> dayList;
    ArrayList<CheckBox> daySelected;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        LoadData();
    }    

    void dayControl(){
        dayList = new ArrayList<>();
        daySelected = new ArrayList<>();
        dayList.add(cbx_mon);
        dayList.add(cbx_tues);
        dayList.add(cbx_wed);
        dayList.add(cbx_thurs);
        dayList.add(cbx_fri);
        dayList.add(cbx_sat);
        dayList.add(cbx_sun);
        
        for(int i =0; i< dayList.size(); i++){
            if(dayList.get(i).isSelected() == true){
                System.out.println("Selected Day: "+dayList.get(i).getText().toString());
                daySelected.add(dayList.get(i));
            }
        }

    }
    public void getuserInformation(String User_ID){
        this.User_ID = User_ID;
    }
    void LoadData(){
        combo_subject.getItems().addAll(database.LoadAllSubject().get(1));
        combo_location.getItems().addAll(database.LoadAllSchoolLocation().get(1));
        combo_session.getItems().addAll(database.LoadAllSession().get(1));
        combo_teachmode.getItems().addAll(database.LoadAllMode().get(1));
        
    }

    @FXML
    private void OnCourseCBoxClicked(ActionEvent event) {
        
        
    }
    
    
    
    @FXML
    private void OnCoursseBoxClicked(MouseEvent event) {
        ArrayList<ArrayList<String>> course = new ArrayList<>();
        if(combo_subject.getSelectionModel().getSelectedIndex() > -1){
            course = database.LoadAllCourse(database.LoadAllSubject().get(0).get(database.LoadAllSubject().get(1).indexOf(combo_subject.getValue().toString())));
            System.out.println(course.size());
            if(!combo_subject.getSelectionModel().isEmpty()){
                combo_course.getItems().clear();
                combo_course.getItems().addAll(course.get(1));
            }
        }
    }

    @FXML
    private void OnAddNewCourseClicked(MouseEvent event) {
        // get subject id
        String Subject_Id =  database.LoadAllSubject().get(0).get(combo_subject.getSelectionModel().getSelectedIndex());
        
        // get course id
        String Course_Id = database.LoadAllCourse(Subject_Id).get(0).get(combo_course.getSelectionModel().getSelectedIndex());
        
        // get session id
        String Session_Id = database.LoadAllSession().get(0).get(combo_session.getSelectionModel().getSelectedIndex());
        
        // get location id
        String Location_Id = database.LoadAllSchoolLocation().get(0).get(combo_location.getSelectionModel().getSelectedIndex());
        
        // get mode ID
        String Mode_Id = database.LoadAllMode().get(0).get(combo_teachmode.getSelectionModel().getSelectedIndex());
        
        dayControl();
        String _2ndDay = "";
        if(daySelected.size() == 2){
            _2ndDay = daySelected.get(1).getText().toString();
        }
        
        database.ProAddNewCourse(Subject_Id, Course_Id, txt_meetfrom.getText(), txt_meetto.getText(), daySelected.get(0).getText(), _2ndDay, Session_Id, txt_roomno.getText(), Integer.parseInt(txt_studentquantity.getText()), Location_Id, Mode_Id, User_ID);
        //dayControl();
    }
    
}
