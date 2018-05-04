/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Jadhushan Vivekanandan 500626549
 */
public class QR {
    
    public static Connection x = null;
    public static Statement y = null;
    
    public void dbconnect(){
        
        try{
            Class.forName("org.sqlite.JDBC");
            x = DriverManager.getConnection("jdbc:sqlite:MFGR5.db");
            
        }
        catch (Exception e){
            System.err.println("!!Encountered a Problem!!");
            System.out.println("[ERROR]: " + e.toString());
        }
    }
    
    public void customQR(String sql){
        dbconnect();
        
        try{
            y = x.createStatement();
            y.executeUpdate(sql);
            y.close();
            //x.commit();
            x.close();}
        
        catch (Exception e){
            System.err.println(e.getClass().getName()+":"+e.getMessage());
            System.exit(0);}
        System.out.println("**SQL Query Completed Successfully**");
    }
    
    public ResultSet qr(String sql){
        ResultSet rs = null;
        dbconnect();
        try{
            y = x.createStatement();
            rs = y.executeQuery(sql);}
        
        catch (Exception e){
            System.err.println("ERROR: Data not retreived");
            System.err.println("[ERROR]: " + e.toString());}
        
        return rs;
    }
    
 
}
