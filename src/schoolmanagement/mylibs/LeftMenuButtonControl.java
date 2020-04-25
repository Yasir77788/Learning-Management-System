/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibs;

import com.sun.javafx.scene.control.skin.CustomColorDialog;
import java.awt.Button;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 *
 * @author KevinHa
 */
public class LeftMenuButtonControl {
    public ArrayList<HBox> AddNewButton(ArrayList<String> ButtonNameList){
        ArrayList<HBox> container = new ArrayList<>();
        
        for(int i  = 0; i < ButtonNameList.size();i++){
            HBox _item = null;
            // Add Main Menu

                _item = new HBox();
                _item.setAlignment(Pos.CENTER_LEFT);
                _item.getStyleClass().add("course_menu_button");
                _item.setPrefHeight(40);

                Label _buttonnname = new Label();
                _buttonnname.getStyleClass().add("course_menu_text");
                _buttonnname.setText(ButtonNameList.get(i));

                _item.getChildren().add(_buttonnname);


            container.add(_item);
            
        }
        return container;
        
    }   
}
