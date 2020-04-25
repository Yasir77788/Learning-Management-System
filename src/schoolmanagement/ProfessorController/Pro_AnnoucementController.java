/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.ProfessorController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import schoolmanagement.mylibs.AddNewAnnoucementController;
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;
import org.w3c.dom.Document;


/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class Pro_AnnoucementController implements Initializable {
    DatabaseConnection database;
    CustomControl cc;
    ArrayList<ArrayList<String>> annouceList;
    
    
    @FXML
    private VBox vbox_annouceList;
    

    String UserID;
    String UserRole;

    @FXML
    private AnchorPane main;
    @FXML
    private Button btn_newannoucement;
    @FXML
    private WebView webview;
    @FXML
    private ScrollPane scrollview;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        database = new DatabaseConnection();
        cc  = new CustomControl();
        annouceList= new ArrayList<>();
        scrollview.setPrefWidth(363);
    }    
    
    public void getInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        LoadAnnouceDynamic(UserID);
    }
    
    public void LoadAnnouceDynamic(String UserID){
        annouceList = database.ProLoadAnnoucements(UserID);
        String AnnouceID = "";
        String CourseCode = "";
        String CourseName = "";
        String AnnouceTitle = "";
        String AnnouceContent ="";
        String PostDate = "";
        String _postdateCopy = "0";
        for(int i = 0;i < annouceList.get(0).size();i++){
            AnnouceID = annouceList.get(0).get(i);
            CourseCode = annouceList.get(1).get(i)+" " + annouceList.get(2).get(i);
            CourseName = annouceList.get(3).get(i);
            AnnouceTitle = annouceList.get(4).get(i);
            AnnouceContent = annouceList.get(5).get(i);
            PostDate = annouceList.get(6).get(i);
            if(!_postdateCopy.equals(PostDate)){

                _postdateCopy = PostDate;
                annouceDesign(AnnouceID, CourseCode, CourseName, AnnouceTitle,AnnouceContent,PostDate);
            }
        }
    }
  
    
    public void annouceDesign(String annouceID, String CourseCode, String CourseName, String title, String Content,  String PostData){
            AnchorPane pane = new AnchorPane();
            
            pane.setId(title);

            pane.getStyleClass().add("Annouce_detail");
            VBox body = new VBox();
            HBox header = new HBox();
            Label _courseCode = new Label();
            _courseCode.setText(CourseCode);
            _courseCode.getStyleClass().add("Annouce_detail_header");
            
            Label _courseName = new Label();
            _courseName.setText(CourseName);
            _courseName.getStyleClass().add("Annouce_detail_header");
                 
            Label _title = new Label();
            _title.setPrefWidth(350);
            _title.setWrapText(true);
            _title.setText("Title: "+title);
            _title.getStyleClass().add("Annouce_detail_title");
            _title.setUnderline(true);
            
            WebEngine engine = webview.getEngine();

            Label _postdate = new Label();
            _postdate.setText("Posted: "+ PostData);
            _postdate.getStyleClass().add("Annouce_detail_postdate");   
            
            header.getChildren().add(_courseCode);
            header.getChildren().add(_courseName);
            
            body.getChildren().add(header);
            body.getChildren().add(_title);
            //body.getChildren().add(_content);
            body.getChildren().add(_postdate);
            
            pane.getChildren().add(body);
            
            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    engine.loadContent(Content);
                }
            });

            
            vbox_annouceList.getChildren().add(pane);
        }

    @FXML
    private void OnNewAnnoucementClicked(MouseEvent event) {
        AddNewAnnoucementController _new = new AddNewAnnoucementController();
        _new.Show(UserID);
    }
    
    
}
