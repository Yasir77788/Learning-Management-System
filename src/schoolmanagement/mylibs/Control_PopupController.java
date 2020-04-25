/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.mylibs;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Control_PopupController implements Initializable {

    @FXML
    private Label lbl_title;
    @FXML
    private Button btn_close;
    @FXML
    private Label lbl_content;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnCloseClicked(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
    public void setPopupDetail(String Title, String Message){
        lbl_title.setText(Title);
        lbl_content.setText(Message);
        lbl_content.setWrapText(true);
    }
    // Show 
    String Title = "";
    String Message = "";
    public void setTitle(String Title){
        this.Title = Title;
    }
    public void setMessage(String Message){
        this.Message = Message;
    }
    
    public void Show(){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Control_Popup.fxml"));
            Scene scene = null;
            
            try {
                scene = new Scene(loader.load());

            } catch (IOException ex) {
                Logger.getLogger(CustomControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = new Stage();
            scene.setFill(Color.TRANSPARENT);

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);   
            
            Control_PopupController controller = loader.getController();
            controller.setPopupDetail(Title, Message);
            stage.show();
    }

}
