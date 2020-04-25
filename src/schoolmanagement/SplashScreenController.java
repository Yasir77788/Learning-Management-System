/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane root;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        new LoadLoginScene().start();
    }    
    
    class LoadLoginScene extends Thread{
        
        @Override
        public void run(){
            try {
                Thread.sleep(3000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent parent = null;
                        try {
                            parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
                        } catch (IOException ex) {
                            Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        Scene scene = new Scene(parent);
                        scene.setFill(Color.TRANSPARENT);
                        Stage stage = new Stage();
                        stage.initStyle(StageStyle.TRANSPARENT);
                        stage.setScene(scene);
                        stage.show();
                        
                        root.getScene().getWindow().hide();
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        

        
        
    }
    
}
