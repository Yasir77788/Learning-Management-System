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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
import schoolmanagement.mylibs.CustomControl;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class AnnoucementController implements Initializable {
    DatabaseConnection database;
    ArrayList<ArrayList<String>> annouceList;
    
    @FXML
    private VBox vbox_annouceList;
    

    String UserID;
    String UserRole;

    @FXML
    private AnchorPane main;
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
        annouceList= new ArrayList<>();

        scrollview.setPrefWidth(400);

    
        
        //annouceDesign("CS 4312","CS II-Introduction to Data Structures and Algorithms", "'Today''s Class Week Ten - Research Study Report Draft'","'This week, please proceed with the Rough Draft of your Research Study Report.  Full details of the requirements for Research Study Report are available under the \"Handouts\"\" button.  \"'");
    }    
    
    public void getInformation(String UserID, String UserRole){
        this.UserID = UserID;
        this.UserRole = UserRole;
        LoadAnnouceDynamic(UserID);
    }
    
    public void LoadAnnouceDynamic(String UserID){
        annouceList = database.LoadAnnoucements(UserID, true);
        for(int i = 0;i < annouceList.get(0).size();i++){
            String AnnouceID = annouceList.get(0).get(i);
            String CourseCode = annouceList.get(5).get(i)+" " + annouceList.get(1).get(i);
            String CourseName = annouceList.get(6).get(i);
            String AnnouceTitle = annouceList.get(2).get(i);
            String AnnouceContent = annouceList.get(3).get(i);
            String AnnouceNew = annouceList.get(7).get(i);
            String PostDate = annouceList.get(4).get(i);
            String PostBy = annouceList.get(8).get(i)+" " + annouceList.get(9).get(i);
            annouceDesign(AnnouceID, CourseCode, CourseName, AnnouceTitle,AnnouceContent,AnnouceNew,PostDate, PostBy);
        }
    }
    
    public void annouceDesign(String annouceID, String CourseCode, String CourseName, String title, String Content, String New, String PostData, String Instructor){
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
            _title.setPrefWidth(380);
            _title.setWrapText(true);
            _title.setText("Title: "+title);
            _title.getStyleClass().add("Annouce_detail_title");
            _title.setUnderline(true);
            
            WebEngine engine = webview.getEngine();
            
            Label _content = new Label();
            _content.setWrapText(true);
            _content.setText(Content.replace("\\n", "\n"));
            _content.getStyleClass().add("Annouce_detail_content");
            _content.setPrefWidth(1220);
            
            Label _postdate = new Label();
            _postdate.setWrapText(true);
            _postdate.setText(("Posted: "+ PostData + "\nBy: "+Instructor).toString().replace("\\n", "\n"));
            
            _postdate.getStyleClass().add("Annouce_detail_postdate");   
            
            header.getChildren().add(_courseCode);
            header.getChildren().add(_courseName);
            if(New.equals("0")){
                Label _new = new Label();
                _new.setText("New");
                _new.getStyleClass().add("Annouce_detail_new");   
                header.getChildren().add(_new);
            }
            
            body.getChildren().add(header);
            body.getChildren().add(_title);
            //body.getChildren().add(_content);
            body.getChildren().add(_postdate);
            
            pane.getChildren().add(body);
            
            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    engine.loadContent(Content);
                    database.AnnoucementRead(annouceID);
                    vbox_annouceList.getChildren().clear();
                    LoadAnnouceDynamic(UserID);
                }
            });
            
            vbox_annouceList.getChildren().add(pane);
        }
    
}
