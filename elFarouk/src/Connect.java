/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author AbDUllRahmaN GaMal
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class Connect {

    public  static Connection connect()
    {
        try{
            //load Driver 
    Class.forName("com.mysql.jdbc.Driver");
    //get connection 
  Connection  con=DriverManager.getConnection("jdbc:Mysql://localhost/el_farouk?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8","root","");
//  JOptionPane.showMessageDialog(null, "Connected Successfully ");
  return con;
    
        }catch(Exception e)
    
        {
            JOptionPane.showMessageDialog(null, "Error In Connecting to data Base : "+e.getMessage());
        e.printStackTrace();
            return null;
        }    
    
    }
    
    
    
}
