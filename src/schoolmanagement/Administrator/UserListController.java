/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagement.Administrator;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.table.TableColumn;
import schoolmanagement.DatabaseConnection;

/**
 * FXML Controller class
 *
 * @author KevinHa
 */
public class UserListController implements Initializable {
    
    DatabaseConnection connection;
    ArrayList<ArrayList<String>> list;

    @FXML
    private HBox Header_Container;
    @FXML
    private VBox List_container;
    
    String UserRole = "";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        connection = new DatabaseConnection();
        list = new ArrayList<>();

        // TODO
        
        //UserTableView.setItems(connection.LoadAllUser());
    }    
    public void GetRoleType(String UserRole){
        this.UserRole = UserRole;
        LoadData(UserRole);
    }
    void LoadData(String UserRole){
        
        list = connection.LoadAllUser(UserRole);
        DesignHeader();
        for(int i =0;i < list.get(0).size();i++){
            DesignContent(i,list.get(0).get(i),list.get(1).get(i), list.get(2).get(i),list.get(3).get(i),list.get(4).get(i),list.get(5).get(i),list.get(6).get(i));
        }
    }
    
    void DesignHeader(){
        // Header
        Header_Container.setAlignment(Pos.CENTER_LEFT);
        
        Label _userID = new Label();
        Label _firstname = new Label();
        Label _lastname = new Label();
        Label _phone = new Label();
        Label _email = new Label();
        Label _birthday = new Label();
        Label _address = new Label();
        
        _userID.setText("ID");
        _firstname.setText("Firstname");
        _lastname.setText("Lastname");
        _phone.setText("Phone");
        _email.setText("Email");
        _birthday.setText("Date of Birth");
        _address.setText("Address");
        
        _userID.getStyleClass().add("UserHeader");
        _firstname.getStyleClass().add("UserHeader");
        _lastname.getStyleClass().add("UserHeader");
        _phone.getStyleClass().add("UserHeader");
        _email.getStyleClass().add("UserHeader");
        _birthday.getStyleClass().add("UserHeader");
        _address.getStyleClass().add("UserHeader");
        
        _userID.setPrefWidth(120);
        _firstname.setPrefWidth(170);
        _lastname.setPrefWidth(170);
        _phone.setPrefWidth(150);
        _email.setPrefWidth(300);
        _birthday.setPrefWidth(200);
        _address.setPrefWidth(400);
        
        Header_Container.getChildren().add(_userID);
        Header_Container.getChildren().add(_firstname);
        Header_Container.getChildren().add(_lastname);
        Header_Container.getChildren().add(_phone);
        Header_Container.getChildren().add(_email);
        Header_Container.getChildren().add(_birthday);
        Header_Container.getChildren().add(_address);
        
    }
    void DesignContent(int i, String UserID, String firstname, String lastname, String phone, String email, String birthday, String address){
        // Header
        List_container.setAlignment(Pos.CENTER_LEFT);
        
        HBox detail = new HBox();
        
        String color = "";
        if(i%2 == 1){
            color = "f6f6f6";
            //System.out.println(i + " " +1);
        }else if(i%2 == 0){
            color = "ffffff";
            //System.out.println(i + " " +2);
        }
        
        detail.setStyle("-fx-background-color: #"+color+";");
        
        Label _id = new Label();
        Label _firstname = new Label();
        Label _lastname = new Label();
        Label _phone = new Label();
        Label _email = new Label();
        Label _birthday = new Label();
        Label _address = new Label();
        
        _id.setText(UserID);
        _firstname.setText(firstname);
        _lastname.setText(lastname);
        _phone.setText(phone);
        _email.setText(email);
        _birthday.setText(birthday);
        _address.setText(address);
        
        _id.getStyleClass().add("UserContent");
        _firstname.getStyleClass().add("UserContent");
        _lastname.getStyleClass().add("UserContent");
        _phone.getStyleClass().add("UserContent");
        _email.getStyleClass().add("UserContent");
        _birthday.getStyleClass().add("UserContent");
        _address.getStyleClass().add("UserContent");
        
        _id.setPrefWidth(100);
        _firstname.setPrefWidth(130);
        _lastname.setPrefWidth(135);
        _phone.setPrefWidth(110);
        _email.setPrefWidth(265);
        _birthday.setPrefWidth(165);
        _address.setPrefWidth(430);
        
        detail.getChildren().add(_id);
        detail.getChildren().add(_firstname);
        detail.getChildren().add(_lastname);
        detail.getChildren().add(_phone);
        detail.getChildren().add(_email);
        detail.getChildren().add(_birthday);
        detail.getChildren().add(_address);
        
        
        List_container.getChildren().add(detail);
    }
    
}
