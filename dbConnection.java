/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class dbConnection 
{
    Connection conn = null;
    public static Connection javaDb() 
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            // use the local of the sqlite file or its name.
            Connection conn = DriverManager.getConnection("jdbc:sqlite:login1.db");
            System.out.println("\nAllah Kareem, Good Connection.");
            return conn;
        }
        catch(Exception e)
        {
            
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
