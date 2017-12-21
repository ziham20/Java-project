/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ziham
 */
public abstract class AbstractInsert {
    
    PreparedStatement pstmt;
    DbConnection conn;
    
    public  AbstractInsert() {
        conn = new DbConnection();
    }
    
    //public abstract int InsertFurniture(); 
    public abstract int InsertFurniture(String id, String name,String sup_name,String type, int ws, int retail, String avail);         // abstract method
 
    
    public int InsertSupplier(String id, String name , String producttype, String address, String contactnumber,  String email){
        try {
            
          
              String query =   "INSERT "
                             + "INTO "
                             + "suppliers "                         //table name
                             + "VALUES(?,?,?,?,?,?)";
                    pstmt = conn.connection.prepareCall(query);     //passing the query as a parameter

                        //setting values to the parameters for the query
                        pstmt.setString(1, id);
                        pstmt.setString(2, name);
                        pstmt.setString(3, producttype);
                        pstmt.setString(4, address);
                        pstmt.setString(5, contactnumber);
                        pstmt.setString(6, email);     

             int num  = pstmt.executeUpdate();                      // returns an integer if the query is was succeded
          return num;
               
        } catch (SQLException ex) {
            
               JOptionPane.showMessageDialog(null, "Supplier ID already exists.\n Insert another ID", "Already Exists", JOptionPane.ERROR_MESSAGE);
               System.out.println("SQL Exception (Cannot insert to suppliers)  "+ex.getMessage());
            
          return 0;
        }
    }

    
}
