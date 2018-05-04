/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.sql.*;
import java.util.Scanner;
import static lab5.QR.x;
import static lab5.QR.y;

/**
 *
 * @author Jadhushan Vivekanandan 500626549
 */
public class CCDatabase {
    
    public void menu(){
        System.out.println("\n*** Welcome to Canada Computers Database ***");
        System.out.println("Select From The Following Options: ");
        System.out.println("1) Perform a Table Modification");
        System.out.println("2) Perform a Query");
        System.out.println("3) Exit");
    }
    
    public static void main(String[] args){
        int option = 0; 
        int temp = 0; 
        int tmp = 0; 
        int tmp1 = 0;
        String select = "-1";
        String sel1 = "-1"; 
        String name = "";
        String cname = "";
        String ctype = "";
        String [] table = new String[10];
        String [] qry = new String[11];

        String sql = null;
        String sql2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        
        CCDatabase cd = new CCDatabase();
        QR q = new QR();
        Scanner input = new Scanner(System.in);
        
        while(option !=3){
            cd.menu();
            
            System.out.print("\nPlease enter option number here: ");
            select = input.nextLine();
            option = Integer.parseInt(select);
            
            if (option == 1){
                while (tmp!=3){
                    try{
                        System.out.println("\nTable Modification Menu ");
                        System.out.println("1 -> Table Modification");
                        System.out.println("2 -> Exit to Main Menu");
                        select = input.nextLine();
                        tmp = Integer.parseInt(select);
                        
                        if(tmp == 1){
                            System.out.println("Please enter the SQL statement for your table modification: ");
                            sql = input.nextLine();
                            q.customQR(sql);
                        }
                        else if(tmp == 2){
                            System.out.println("Taking you back to main menu ");
                            break; 
                        }
                        
                        else{
                            System.out.println("Invalid choice.. taking you back to main menu");   
                        }
                    }
                catch (Exception e){ 
                        System.err.println("[ERROR]: " + e.toString());
                }
                }
            }
            
            else if (option == 2){
                while (temp != 13){  
                    try{
                    System.out.print("\nPlease enter your selection here: ");
                    System.out.println("\n-*- Which of the following queries would you like to perform?: ");
                    System.out.println("1) Find Manufacturer Names and Numbers for a specific Country");
                    System.out.println("2) Find Manufacturer Address for specific Manufacturer Name");
                    System.out.println("3) Find Laptop Names with specific Screen Size");
                    System.out.println("4) Find gaming Laptop Names with specific Screen Size");
                    System.out.println("5) Find gaming Laptop Names from specific Manufacturer Name");
                    System.out.println("6) Find gaming Desktop Names from specific Manufacturer Name");
                    System.out.println("7) Find Desktop Names and Prices with specific amount of RAM and specific GPU");
                    System.out.println("8) Find Monitor Names and Prices in ascending order with specific Refresh Rate");
                    System.out.println("9) Find Store Names in specific Region");
                    System.out.println("10) Find Postal Code of specific Store");
                    System.out.println("11) Back to Main Menu");
                    System.out.print("\nPlease enter your selection here: ");
                    select = input.nextLine();
                    temp = Integer.parseInt(select);

                    if (temp ==1){
                        System.out.println("Please enter Country name for list of all Manufacturers from specified Country");
                        qry[0] = input.nextLine();
                        sql = "SELECT MFGR_Name, MFGR_PhoneNumb FROM MFGR WHERE MFGR_Country = '"+qry[0]+"'";
                        rs = q.qr(sql);
                        System.out.println(qry[0]+" has the following Manufacturers: ");
                        while(rs.next()){
                        System.out.println(rs.getString("MFGR_Name")+" "+ rs.getString("MFGR_PhoneNumb"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 2){
                        System.out.println("Please enter Manufacturer Name for their address ");
                        qry[1] = input.nextLine();
                        sql = "SELECT MFGR_Country, MFGR_State, MFGR_City, MFGR_StreetNumb, MFGR_StreetName, MFGR_PostalCode FROM MFGR WHERE MFGR_Name = '"+ qry[1] +"'";
                        rs = q.qr(sql);
                        System.out.println(qry[1]+"'s Address is as following: ");
                        while(rs.next()){
                        System.out.println(rs.getString("MFGR_Country")+" "+ rs.getString("MFGR_State")+" "+ rs.getString("MFGR_City")+" "+ rs.getString("MFGR_StreetNumb")+" "+ rs.getString("MFGR_StreetName")+" "+ rs.getString("MFGR_PostalCode"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 3){
                        System.out.println("Please enter desired Screen Size: ");
                        qry[2] = input.nextLine();
                        sql = "SELECT LP_Name FROM LP WHERE LP_ScreenSize = '"+ qry[2]+ "'";
                        rs = q.qr(sql);
                        System.out.println("Laptops with " + qry[2]+" inch screen sizes are: ");
                        while(rs.next()){
                        System.out.println(rs.getString("LP_Name"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 4){
                        System.out.println("Please enter desired Screen Size: ");
                        qry[3] = input.nextLine();
                        sql = "SELECT LP_Name FROM LP WHERE LP_Category = 'Gaming Laptop' AND LP_ScreenSize = '"+qry[3]+"'";
                        rs = q.qr(sql);
                        System.out.println("Gaming Laptops with " + qry[3]+" inch screen sizes are: ");
                        while(rs.next()){
                        System.out.println(rs.getString("LP_Name"));}                
                        select = input.nextLine();
                    }
                    
                    else if (temp == 5){
                        System.out.println("Please enter desired Manufacturer Name: ");
                        qry[4] = input.nextLine();
                        sql = "SELECT LP_Name FROM LP, MFGR WHERE LP.MFGR_ID = MFGR.MFGR_ID AND MFGR.MFGR_Name = '"+qry[4]+"'";
                        rs = q.qr(sql);
                        System.out.println("All Laptops from "+qry[4]+" are: ");
                        while(rs.next()){
                        System.out.println(rs.getString("LP_Name"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 6){
                        System.out.println("Please enter desired Manufacturer Name: ");
                        qry[5] = input.nextLine();
                        sql = "SELECT DT_Name FROM DT, MFGR WHERE DT.MFGR_ID = MFGR.MFGR_ID AND MFGR.MFGR_Name = '"+qry[5]+"'";
                        rs = q.qr(sql);
                        System.out.println("All Desktops from "+qry[4]+" are: ");
                        while(rs.next()){
                        System.out.println(rs.getString("DT_Name"));}
                        select = input.nextLine();
                        
                    }
                    
                    else if (temp == 7){
                        System.out.println("Please enter desired RAM Amount: ");
                        qry[6] = input.nextLine();
                        System.out.println("Please enter desired GPU: ");
                        qry[7] = input.nextLine();
                        sql = "SELECT DT_Name, DT_Price FROM DT WHERE DT_RAM = '"+qry[6]+"' AND DT_GPU = '"+qry[7]+"'";
                        rs = q.qr(sql);
                        System.out.println("All Desktops from with "+qry[6]+" and "+qry[7]+" are: ");
                        while(rs.next()){
                        System.out.println(rs.getString("DT_Name")+" "+ rs.getString("DT_Price"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 8){
                        System.out.println("Please enter desired Refresh Rate");
                        qry[8] = input.nextLine();
                        sql = "SELECT MT_Name, MT_Price FROM MT WHERE MT_RefreshRate = '"+qry[8]+"' ORDER BY MT_Price ASC";
                        rs = q.qr(sql) ;
                        while(rs.next()){
                        System.out.println(rs.getString("MT_Name")+" "+ rs.getString("MT_Price"));}
                        select = input.nextLine();
                    }
                    
                    else if (temp == 9){
                        System.out.println("Please enter Store Region");
                        qry[9] = input.nextLine();
                        sql = "SELECT Store_Name FROM Store WHERE Store_Region = '"+qry[9]+"'";
                        rs = q.qr(sql) ;
                        while(rs.next()){
                        System.out.println(rs.getString("Store_Name"));}
                        select = input.nextLine();
                    }
                    else if (temp == 10){
                        System.out.println("Please enter Store Name ");
                        qry[10] = input.nextLine();
                        sql = "SELECT Store_PostalCode FROM Store WHERE Store_Name = '"+qry[10]+"'";
                        rs = q.qr(sql) ;
                        while(rs.next()){
                        System.out.println(rs.getString("Store_PostalCode"));}
                        select = input.nextLine();
                    }

                    else if (temp == 11){
                        break;
                    }
                    else {
                        System.out.println("Wrong selection! Please try again!");
                        select = "-1";
                        option = 0; 
                        temp = 0;
                    }
                    
               
                    }
                    catch (Exception e){
                        System.err.println("!! DATA NOT RETREIVABLE !!\n Please check input\n: "+ e.toString());
                    }
                }
                select = "-1";
                option = 0;
                temp = 0;
            }
            
        }
    }
}
