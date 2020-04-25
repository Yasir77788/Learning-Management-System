/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement;

import com.sun.org.apache.bcel.internal.generic.GOTO;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author KevinHa
 */
public class validation {
    void validateMesasge(String FieldName, TextField tf){
        Pane pane = (Pane) tf.getParent();
        
        //Label message = new Label();
        File file = new File("src\\schoolmanagement\\icons\\x-icon.png");
        Image image = new Image(file.toURI().toString());
        ImageView errorIcon = null;
        
        if(tf.getText().equals("")){
            errorIcon = new ImageView();
            errorIcon.setLayoutX(tf.getPrefWidth()-20);
            errorIcon.setFitWidth(20);
            errorIcon.setFitHeight(20);
            errorIcon.setId(FieldName);
            
            Tooltip tip = new Tooltip();
            tip.setText(FieldName + " is required");
            tip.setStyle("-fx-font-size: 15;");
            errorIcon.setId(FieldName);
            
            errorIcon.setImage(image);
            
            Tooltip.install(errorIcon, tip);
            //message.setStyle("-fx-padding: 0 10 0 0;-fx-text-fill: red;-fx-font-size: 15;-fx-alignment: top-right; -fx-border-size: 2; -fx-border-color: red; -fx-border-radius: 15;");
            pane.getChildren().add(errorIcon);
            
        }else {
            if(pane.getChildren().size()== 4){
                pane.getChildren().remove(pane.getChildren().get(pane.getChildren().size()-1));
            }
        }
    }
    
    public void TextField(String FieldName, TextField tf){
        validateMesasge(FieldName,tf);
    }
    public void PasswordField(String FieldName,PasswordField tf){
        validateMesasge(FieldName,tf);
    }

    
}

