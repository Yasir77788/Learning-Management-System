/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author KevinHa
 */
public class MainController implements Initializable {
    
    private Label label;
    private Button btn_exit;
    @FXML
    private Button btn_signin;
    @FXML
    private AnchorPane root;
    @FXML
    private Hyperlink btn_forgotpassword;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_password;
    @FXML
    private Pane btn_container;
    @FXML
    private ProgressIndicator loading;
    @FXML
    private RadioButton rad_student;
    @FXML
    private ToggleGroup role;
    @FXML
    private RadioButton rad_staff;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void OnExitClicked(MouseEvent event) {
        Stage stage = (Stage) btn_exit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void OnSigninClicked(MouseEvent event) throws InterruptedException {
        loading.setVisible(true);
        validation val = new validation();
        val.TextField("ID",txt_username);
        val.PasswordField("Password",txt_password);
        
        ChangeScene("Dashboard");
        

    }
    
    
    String UserID = "";
    void ChangeScene(String Scene){
        RadioButton roleGroup = (RadioButton) role.getSelectedToggle();
        class SwitchScene extends Thread{
            @Override
            public void run(){
                try {
                    Thread.sleep(500);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run(){
                            DatabaseConnection db_con = new DatabaseConnection();
                            UserID = db_con.Signin(txt_username.getText(), txt_password.getText(), roleGroup.getText());
                            System.out.println(UserID);
                            if(UserID.equals("")){
                                System.out.println("Signin Fail");
                                loading.setVisible(false);
                                

                            }        
                            else{
                                System.out.println("Signin Successed");
                                System.out.println(UserID);
                                
                                Parent parent = null;
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource(Scene+".fxml"));
                                try {
                                    loader.load();
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                                }  
                                DashboardController dashboard = loader.getController();
                                dashboard.getUserInformationFromLoginMain(UserID, roleGroup.getText());
                                
                                
                                
                                parent = loader.getRoot();
                                Scene scene = new Scene(parent);
                                scene.setFill(Color.TRANSPARENT);
                                Stage stage = new Stage();
                                stage.initStyle(StageStyle.TRANSPARENT);
                                stage.setScene(scene);
                                root.getScene().getWindow().hide();
                                stage.showAndWait();

                                

                            }
                    }
                    });
                } catch (InterruptedException ex) {
                    Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        new SwitchScene().start();
    }
    double xx, yy;
    @FXML   
    private void rootMouseDragged(MouseEvent event) {
        root.getScene().getWindow().setX(event.getScreenX() - xx);
        root.getScene().getWindow().setY(event.getScreenY() - yy);
    }

    @FXML
    private void rootMousePressed(MouseEvent event) {
        xx = event.getSceneX();
        yy = event.getSceneY();
    }

    @FXML
    private void onCloseButtonClicked(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void OnForgotPasswordClicked(MouseEvent event) throws IOException {
        Parent parent = null;
        
        parent = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
        
        Scene scene = new Scene(parent);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.setX(root.getScene().getWindow().getX());
        stage.setY(root.getScene().getWindow().getY());
        stage.show();
        
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    



    
}
