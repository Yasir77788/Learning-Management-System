/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import schoolmanagement.UserController.UserInformationController;
import schoolmanagement.ProfessorController.UserInformationController_pro;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Duration;
import jdk.nashorn.internal.objects.NativeArray;
import schoolmanagement.Administrator.UserListController;
import schoolmanagement.ProfessorController.AddNewCourseController;
import schoolmanagement.ProfessorController.Pro_AnnoucementController;
import schoolmanagement.ProfessorController.Pro_CourcesController;
import schoolmanagement.ProfessorController.Pro_dashboardController;
import schoolmanagement.UserController.AnnoucementController;
import schoolmanagement.UserController.ChangePasswordController;
import schoolmanagement.UserController.CourcesController;
import schoolmanagement.UserController.CourseDetail_DashboardController;
import schoolmanagement.UserController.CoursesGradesController;
import schoolmanagement.UserController.DueDateController;
import schoolmanagement.UserController.Main_dashboardController;
import schoolmanagement.UserController.SearchCourseController;
import schoolmanagement.UserController.TranscriptController;
import schoolmanagement.UserController.UpdateInformationController;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class DashboardController implements Initializable {

    Boolean dragable = true;
    //private Stage stage;
    double xx, yy;
    @FXML
    private AnchorPane root;
    @FXML
    private Button btn_youraccount;
    @FXML
    private Button btn_courses;
    @FXML
    private Button btn_organizations;
    @FXML
    private Button btn_grades;
    @FXML
    private Button btn_duedates;
    @FXML
    private Button btn_settings;
    
    private Parent parent = null;
    @FXML
    private Button btn_close;
    @FXML
    private Button btn_signout1;
    @FXML
    private Button btn_dashboard;
    @FXML
    private Button btn_minimized;
    @FXML
    private Button btn_maximized;
    
    private double lastX = 0.0d;
    private double lastY = 0.0d;
    private double lastWidth = 0.0d;
    private double lastHeight = 0.0d;
    @FXML
    private Pane Button_YourAccount;
    @FXML
    private Pane Button_Dashboard;
    @FXML
    private Pane Button_ActivityStream;
    @FXML
    private Pane Button_Courses;
    @FXML
    private Pane Button_Organizations;
    @FXML
    private Pane Button_Grades;
    @FXML
    private Pane Button_DueDates;
    @FXML
    private Pane Button_Settings;
    private Pane Button_Back;
    @FXML
    private AnchorPane main_area;
    @FXML
    private Button btn_createstudentaccount;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button btn_searchStudent;
    
    public String user_Role;
    public String user_Id;
    ArrayList<String> user_information;
    
    DatabaseConnection database;
    @FXML
    private Pane Button_CreateAccount;
    private Pane Button_SearchStudent;
    @FXML
    private Pane Button_YourAccountDetail;
    @FXML
    private Button btn_youraccountdetail;
    @FXML
    private Pane Button_UpdateInformation;
    @FXML
    private Button btn_youraccountdetail1;
    @FXML
    private Pane Button_ChangePassword;
    @FXML
    private Button btn_youraccountdetail11;
    @FXML
    private Button btn_createprofessoraccount;
    @FXML
    private Pane Button_CreateProAccount;
    @FXML
    private Pane Button_SearchCourse;
    @FXML
    private Pane Button_ViewCourses;
    @FXML
    private Button btn_ViewCourse;
    @FXML
    private Button btn_searchcourses;
    @FXML
    private Pane Button_Dashboard_Admin;
    @FXML
    private Button btn_dashboard_admin;
    @FXML
    private Pane Button_AddNewCourse;
    @FXML
    private Button btn_AddnewCourse;
    @FXML
    private Button btn_annoucement;
    @FXML
    private Button btn_coursesgrade;
    @FXML
    private Pane Button_CoursesGrades;
    @FXML
    private Pane Button_GPA;
    @FXML
    private Button btn_transcript;
    @FXML
    private Button btn_searchStudent1;
    @FXML
    private Pane Button_StudentList;
    @FXML
    private Pane Button_ProfessorList;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        database = new DatabaseConnection();
        user_information = new ArrayList<String>();
        ButtonControl();
        GroupsControl();
        
        

    }    
    
    // Start SCene 
    
    public void getUserInformationFromLoginMain(String id, String role){
        //System.out.println(id + " " + role);
        user_information = database.LoadUserBasicInformation(id, role);
        if(role.equals("Student") || role.equals("Staff")){
            btn_youraccount.setText(user_information.get(0)+" "+user_information.get(1));
        }
        this.user_Role = role;
        this.user_Id = id;
        Main_dashboard_Load();
        MainMenuLoad(false, user_Role);
        
        
    }
    ArrayList<Pane> Role_Student;
    ArrayList<Pane> Role_Staff;
    ArrayList<Pane> Role_Administrator;
    ArrayList<Pane> User_Account;
    ArrayList<Pane> User_Courses;
    ArrayList<Pane> User_Grades;
    ArrayList<Pane> Staff_Courses;
    private void ButtonControl(){
        // User Account Group
        Role_Student = new ArrayList<>();
        Role_Staff = new ArrayList<>();
        Role_Administrator = new ArrayList<>();
        User_Account = new ArrayList<>();
        User_Courses = new ArrayList<>();
        User_Grades = new ArrayList<>();
        Staff_Courses = new ArrayList<>();
        
        Role_Student.add(Button_YourAccount);
        Role_Student.add(Button_Dashboard);
        Role_Student.add(Button_ActivityStream);
        Role_Student.add(Button_Courses);
        Role_Student.add(Button_Organizations);
        Role_Student.add(Button_Grades);
        Role_Student.add(Button_DueDates);
        Role_Student.add(Button_Settings);
        
        Role_Staff.add(Button_YourAccount);
        Role_Staff.add(Button_Dashboard);
        Role_Staff.add(Button_ActivityStream);
        Role_Staff.add(Button_Courses);
        
        Role_Administrator.add(Button_Dashboard_Admin);
        Role_Administrator.add(Button_CreateAccount);
        Role_Administrator.add(Button_StudentList);
        Role_Administrator.add(Button_CreateProAccount);
        Role_Administrator.add(Button_ProfessorList);
        
        // Sub Menu
        
        User_Account.add(Button_YourAccountDetail);
        User_Account.add(Button_UpdateInformation);
        User_Account.add(Button_ChangePassword);
        
        User_Courses.add(Button_SearchCourse);
        User_Courses.add(Button_ViewCourses);
        
        User_Grades.add(Button_CoursesGrades);
        User_Grades.add(Button_GPA);
        
        Staff_Courses.add(Button_ViewCourses);
        Staff_Courses.add(Button_AddNewCourse);
    }
    ArrayList<ArrayList<Pane>> GroupControl = new ArrayList<>();
    ArrayList<ArrayList<Pane>> SubGroupControl = new ArrayList<>();
    void GroupsControl(){
        GroupControl.add(Role_Student);
        GroupControl.add(Role_Staff);
        GroupControl.add(Role_Administrator);
        SubGroupControl.add(User_Account);
        SubGroupControl.add(User_Courses);
        SubGroupControl.add(User_Grades);
        SubGroupControl.add(Staff_Courses);
        
    }
    void MainMenuLoad(boolean HideSubmenu, String _role){
        GroupControl.forEach((n)->(n).forEach((m)->(m).setVisible(false)));
        GroupControl.forEach((n)->(n).forEach((m)->(m).setDisable(true)));
        GroupControl.forEach((n)->(n).forEach((m)->(m).setMaxHeight(0)));

        ArrayList<Pane> Group = new ArrayList<>();
        System.out.println(_role);
        switch (_role){
            case "Student":
                Group = Role_Student;
                break;
            case "Staff":
                Group = Role_Staff;
                break;
            case "Administrator":
                Group = Role_Administrator;
                break;
        }
        
        Group.forEach((n)->(n).setVisible(true));
        Group.forEach((n)->(n).setDisable(false));
        Group.forEach((n)->(n).setMaxHeight(45));
        
    }
    
    ArrayList<Pane> GroupTemp = new ArrayList<>();
    void ButtonGroupControl(ArrayList<Pane> Group ){
        if(GroupTemp != Group){
            
            SubGroupControl.forEach((n)->(n).forEach((m)->(m).setVisible(false)));
            SubGroupControl.forEach((n)->(n).forEach((m)->(m).setDisable(true)));
            SubGroupControl.forEach((n)->(n).forEach((m)->(m).setMaxHeight(0)));
            
            Group.forEach((n)->(n).setVisible(true));
            Group.forEach((n)->(n).setDisable(false));
            Group.forEach((n)->(n).setMaxHeight(45));
            
            GroupTemp = Group;
        }else {
            Group.forEach((n)->(n).setVisible(false));
            Group.forEach((n)->(n).setDisable(true));
            Group.forEach((n)->(n).setMaxHeight(0));
            
            GroupTemp = null;
        }
        
        

    }
    @FXML
    private void rootOnMouseDragged(MouseEvent event) {
        if(dragable == true){
            root.getScene().getWindow().setX(event.getScreenX()-xx);
            root.getScene().getWindow().setY(event.getScreenY()-yy);
        }
    }

    @FXML
    private void rootOnMousePressed(MouseEvent event) {
        if(dragable == true){
            xx = event.getSceneX();
            yy = event.getSceneY();
        }
    }

    @FXML
    private void OnRootDragged(MouseEvent event) {
    }

    @FXML
    private void OnRootClicked(MouseEvent event) {
    }

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node) (event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void OnSignoutClicked(MouseEvent event) throws IOException {
        Parent parent = null;
        
        parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void OnMinimizedClicked(MouseEvent event) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void onMaximizedClicked(MouseEvent event) {
        Node n = (Node)event.getSource(); 
 
      Window w = n.getScene().getWindow(); 
 
      double currentX = w.getX(); 
      double currentY = w.getY(); 
      double currentWidth = w.getWidth(); 
      double currentHeight = w.getHeight(); 
 
      Screen screen = Screen.getPrimary(); 
        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds(); 
 
       if( currentX != bounds.getMinX() && 
         currentY != bounds.getMinY() && 
         currentWidth != bounds.getWidth() && 
         currentHeight != bounds.getHeight() ) { 
 
         w.setX(bounds.getMinX()); 
         w.setY(bounds.getMinY()); 
         w.setWidth(bounds.getWidth()); 
         w.setHeight(bounds.getHeight()); 
 
         lastX = currentX;  // save old dimensions 
         lastY = currentY; 
         lastWidth = currentWidth; 
         lastHeight = currentHeight; 
         dragable = false;
 
       } else { 
 
         // de-maximize the window (not same as minimize) 
 
         w.setX(lastX); 
         w.setY(lastY); 
         w.setWidth(lastWidth); 
         w.setHeight(lastHeight); 
         dragable = true;
      } 
 
      event.consume();  // don't bubble up to title bar 
    }
    
    //FX Fading
    void FadingSceneOut(){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(200));
        fade.setNode(this.root);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }
    void FadingSceneIn(){
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(200));
        fade.setNode(this.root);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
    private void OnButtonBackClicked(MouseEvent event) {
        MainMenuLoad(false, user_Role);
    }

    @FXML
    private void OnYourDashboardClicked(MouseEvent event) {
        FadingSceneOut();
        Main_dashboard_Load();
    }
    void Main_dashboard_Load(){
        Parent parent = null;
        String Scene = "";
        System.out.println("Role: " + user_Role);
        if(user_Role.equals("Student"))
        {
            Scene = "UserController/Main_dashboard.fxml";
        }else if(user_Role.equals("Staff"))
        {
            Scene = "ProfessorController/Pro_dashboard.fxml";
        }else if(user_Role.equals("Administrator"))
        {
            Scene = "Administrator/Main_dashboard.fxml";
        }
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Scene));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(user_Role.equals("Student"))
        {
            Main_dashboardController controller = loader.getController();
            controller.getUserInformation(user_Id, user_Role);
        }else if(user_Role.equals("Staff"))
        {
            Pro_dashboardController controller = loader.getController();
            controller.getUserInformation(user_Id);
        }else if(user_Role.equals("Administrator"))
        {
            Scene = "Administrator/Main_dashboard.fxml";
        }
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnYourAccountClicked(MouseEvent event) {

        ButtonGroupControl(User_Account);
    }

    // SwitchScene
    void SwitchScene(String SceneName){
        Parent parent = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource(SceneName+".fxml"));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
        
    }

    @FXML
    private void OnCreateStudentAccountClicked(MouseEvent event) {
        FadingSceneOut();
        SwitchScene("Administrator/CreateStudentAccount");
    }


    @FXML
    private void OnYourInformationClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;

        String Scene = "";
        if(user_Role.equals("Student")){
            Scene = "UserController/UserInformation.fxml";
        }else if(user_Role.equals("Staff")){
            Scene = "ProfessorController/UserInformation_pro.fxml";
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Scene));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(user_Role.equals("Student")){
            UserInformationController userinfo = loader.getController();
            userinfo.getInformation(user_Id, user_Role);
        }else if(user_Role.equals("Staff")){
            UserInformationController_pro userinfo = loader.getController();
            userinfo.getInformation(user_Id, user_Role);
        }
        
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
    }

    @FXML
    private void OnUpdateInformationClicked(MouseEvent event) {
        FadingSceneOut();
         Parent parent = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserController/UpdateInformation.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        UpdateInformationController userinfo = loader.getController();
        userinfo.getUserInformation(user_Id, user_Role);
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnChangePasswordClicked(MouseEvent event) {
        FadingSceneOut();
         Parent parent = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserController/ChangePassword.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ChangePasswordController userinfo = loader.getController();
        userinfo.getUserInformation(user_Id, user_Role);
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnCreateProfessorAccountClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Administrator/CreateProfessorAccount.fxml"));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnCoursesClicked(MouseEvent event) {
       
        if(user_Role.equals("Student")){
            ButtonGroupControl(User_Courses);
        }else {
            ButtonGroupControl(Staff_Courses);
        }
        
        
    }

    @FXML
    private void OnViewCoursesClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;
        
        String Scene = "";
        if(user_Role.equals("Student")){
            Scene = "UserController/Cources.fxml";
        }else if(user_Role.equals("Staff")){
            Scene = "ProfessorController/Pro_Cources.fxml";
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource(Scene));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(user_Role.equals("Student")){
            CourcesController controller = loader.getController();
            controller.getStudentInformation(user_Id, user_Role);
        }else if(user_Role.equals("Staff")){
            Pro_CourcesController controller = loader.getController();
            controller.getUserInformation(user_Id, user_Role);
        }
        
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnSearchCoursesClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("UserController/SearchCourse.fxml"));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        SearchCourseController controller = loader.getController();
        controller.getInformation(user_Id, user_Role);
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
    }

    @FXML
    private void OnAdminDashboardClicked(MouseEvent event) {
        FadingSceneOut();
        Main_dashboard_Load();
    }

    // Professor ----------------------------------------------------------------------------
    private void OnProfessorDashboardClicked(MouseEvent event) {
        FadingSceneOut();
        Main_dashboard_Load();
    }

    @FXML
    private void OnAddNewCourseClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;
        
        FXMLLoader loader= new FXMLLoader(getClass().getResource("ProfessorController/AddNewCourse.fxml"));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddNewCourseController controller = loader.getController();
        controller.getuserInformation(user_Id);
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnAnnoucementClicked(MouseEvent event) {
        FadingSceneOut();
 
        String Scene = "";
        if(user_Role.equals("Student")){
            Scene = "UserController/Annoucement.fxml";
        }else if(user_Role.equals("Staff")){
            Scene = "ProfessorController/Pro_Annoucement.fxml";
        }
        FXMLLoader loader= new FXMLLoader(getClass().getResource(Scene));
        
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(user_Role.equals("Student")){
            AnnoucementController controller = loader.getController();
        controller.getInformation(user_Id, user_Role);
        }else if(user_Role.equals("Staff")){
            Pro_AnnoucementController controller = loader.getController();
            controller.getInformation(user_Id, user_Role);
        }
        
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
    }

    @FXML
    private void OnCoursesGradesClicked(MouseEvent event) {
        FadingSceneOut();
 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserController/CoursesGrades.fxml"));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CoursesGradesController controller = loader.getController();
        controller.getInformation(user_Id, user_Role);
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
    }


    @FXML
    private void OnGradesClicked(MouseEvent event) {
        ButtonGroupControl(User_Grades);
    }

    @FXML
    private void OnTranscriptClicked(MouseEvent event) {
        FadingSceneOut();
 
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserController/Transcript.fxml"));
        
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TranscriptController controller = loader.getController();
        controller.getUserInformation(user_Id, user_Role);
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
        
    }

    @FXML
    private void OnDueDatesClicked(MouseEvent event) {
        FadingSceneOut();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserController/DueDate.fxml"));
                
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(CourseDetail_DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        DueDateController controller = loader.getController();
        controller.getInformation(user_Id, null);
        FadingSceneIn();
        borderPane.setCenter(root);
    }

    @FXML
    private void OnStudentListClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrator/UserList.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserListController controller = loader.getController();
        controller.GetRoleType("Student");
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

    @FXML
    private void OnStaffListClicked(MouseEvent event) {
        FadingSceneOut();
        Parent parent = null;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Administrator/UserList.fxml"));
        try {
            this.root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(DashboardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UserListController controller = loader.getController();
        controller.GetRoleType("Staff");
        
        FadingSceneIn();
        borderPane.setCenter(this.root);
    }

}
