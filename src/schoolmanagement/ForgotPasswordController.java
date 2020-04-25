/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private Button btn_signin;
    @FXML
    private Hyperlink Link_BackToLogin;
    @FXML
    private TextField txt_Capcha;
    @FXML
    private Label lbl_capcha;

    /**
     * Initializes the controller class.
     */
    int capcha = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        CapchaControl();
    }    

    @FXML
    private void OnSigninClicked(MouseEvent event) {
    }

    @FXML
    private void onCloseButtonClicked(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    // Capcha Control
    void CapchaControl(){
        capcha = (int) ((Math.random()*(999999-100000)) + 100000);
        lbl_capcha.setText(capcha+"");
    }
    
    double xx, yy;
    @FXML
    private void rootMouseDragged(MouseEvent event) {
        root.getScene().getWindow().setX(event.getScreenX()-xx);
        root.getScene().getWindow().setY(event.getScreenY()-yy);
    }

    @FXML
    private void rootMousePressed(MouseEvent event) {
        xx = event.getSceneX();
        yy = event.getSceneY();
        
    }

    @FXML
    private void OnBackToLoginClicked(MouseEvent event) {
        SwitchScene("Main", event);
    }
    
    // ShortCut Method
    public void SwitchScene(String SceneName, MouseEvent event){
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource(SceneName+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(ForgotPasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       Scene scene = new Scene(parent);
       scene.setFill(Color.TRANSPARENT);
       Stage stage = new Stage();
       stage.initStyle(StageStyle.TRANSPARENT);
       stage.setScene(scene);
       stage.show();
       
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void OnCapchaTextChanged(InputMethodEvent event) {
        if(Integer.parseInt(txt_Capcha.getText()) == capcha){
            
        }
    }
    
}
