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
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class SearchCourseController implements Initializable {
    CustomControl cc = new CustomControl();
    
    DatabaseConnection database;
    @FXML
    private TextField txt_courseno;
    @FXML
    private CheckBox cbx_showopenclass;
    @FXML
    private Button btn_search;
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
    private ComboBox combo_subject;
    @FXML
    private ComboBox combo_campus;
    @FXML
    private ComboBox combo_classmode;
    @FXML
    private HBox pnl_couses_header;
    @FXML
    private VBox vbox_content;
    @FXML
    private ScrollPane course_content_parent;
    @FXML
    private ScrollPane course_header_parent;

    ArrayList<ArrayList<String>> ListContainer;
    ArrayList<String> CourseNo;
    ArrayList<String> CourseName;
    ArrayList<String> CourseCredit;
    ArrayList<String> CourseMeeting;
    ArrayList<String> CourseRoom;
    ArrayList<String> CourseInstructor;
    ArrayList<String> CourseMode;
    ArrayList<String> CourseStatus;
    @FXML
    private Button btn_reset;
    
    ArrayList<CheckBox> _chb_list;
    
    String UserID;
    String UserRole;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListContainer = new ArrayList<>();
        CourseNo = new ArrayList<>();
        CourseName = new ArrayList<>();
        CourseCredit = new ArrayList<>();
        CourseMeeting = new ArrayList<>();
        CourseRoom = new ArrayList<>();
        CourseInstructor = new ArrayList<>();
        CourseMode = new ArrayList<>();
        CourseStatus = new ArrayList<>();
        
        ListContainer.add(CourseNo);
        ListContainer.add(CourseName);
        ListContainer.add(CourseCredit);
        ListContainer.add(CourseMeeting);
        ListContainer.add(CourseRoom);
        ListContainer.add(CourseInstructor);
        ListContainer.add(CourseMode);
        ListContainer.add(CourseStatus);
        
        _chb_list = new ArrayList<>();
        _chb_list.add(cbx_mon);
        _chb_list.add(cbx_tues);
        _chb_list.add(cbx_wed);
        _chb_list.add(cbx_thurs);
        _chb_list.add(cbx_fri);
        _chb_list.add(cbx_sat);
        _chb_list.add(cbx_sun);
        
        
        course_header_parent.hvalueProperty().bindBidirectional(course_content_parent.hvalueProperty());
        database = new DatabaseConnection();
        //LoadList("(All)","","(All)","(All)");
        LoadDataList();
        pnl_couses_header.getChildren().add(cc.Header());
        
        
        
        
    }    

    public void getInformation(String UserID, String UserRole  ){
        this.UserID = UserID;
        this.UserRole = UserRole;
    }

    
    void LoadDataList(){
        combo_subject.getItems().addAll("(All)");
        combo_subject.getItems().addAll(database.LoadAllSubject().get(1));
        combo_subject.getSelectionModel().selectFirst();
        combo_campus.getItems().addAll("(All)");
        combo_campus.getItems().addAll(database.LoadAllSchoolLocation().get(1));
        combo_campus.getSelectionModel().selectFirst();
        combo_classmode.getItems().addAll("(All)");
        combo_classmode.getItems().addAll(database.LoadAllMode().get(1));
        combo_classmode.getSelectionModel().selectFirst();
    }

    Label _courseNo;

    @FXML
    private void OnSearchClicked(MouseEvent event) {
        ListContainer.clear();
        System.out.println("Mode First: " + combo_classmode.getValue().toString());
        LoadList(combo_subject.getValue().toString(), txt_courseno.getText().toString(), combo_campus.getValue().toString(), combo_classmode.getValue().toString());
        //ListContainer = database.getCurrentCourseList(combo_subject.getValue().toString());
    }
    
    void LoadList(String subject, String courseNo, String Campus, String Mode){
        
        ListContainer.clear();
        vbox_content.getChildren().clear();
        ListContainer = database.getCurrentCourseList(subject, courseNo, Campus, Mode,_chb_list, cbx_showopenclass, false);
        for(int i = 0; i < ListContainer.get(0).size();i++){
            vbox_content.getChildren().add(cc.Detail(UserID,ListContainer.get(11).get(i),ListContainer.get(0).get(i), ListContainer.get(1).get(i), ListContainer.get(2).get(i), ListContainer.get(3).get(i) ,ListContainer.get(4).get(i),  ListContainer.get(5).get(i), ListContainer.get(6).get(i), ListContainer.get(7).get(i), ListContainer.get(8).get(i),ListContainer.get(9).get(i),ListContainer.get(10).get(i),i));
        }
    }


    @FXML
    private void OnClearClicked(MouseEvent event) {
        vbox_content.getChildren().clear();
        combo_subject.getSelectionModel().selectFirst();
        combo_campus.getSelectionModel().selectFirst();
        combo_classmode.getSelectionModel().selectFirst();
        txt_courseno.setText("");
        for(int i = 0; i< _chb_list.size();i++){
            _chb_list.get(i).setSelected(false);
        }
    }
    
    
}
