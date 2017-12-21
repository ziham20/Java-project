/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

//import GUI.DbConnection;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ziham
 */
public class Insert extends AbstractInsert {
     

    
    public Insert() {
        conn = new DbConnection();
    }

     //public int InsertFurniture(){
     //return 0;
     //} 
    
    @Override
     public int InsertFurniture(String id, String name,String sup_name,String type, int ws, int retail, String avail){
        try {

                String query = "INSERT "            
                             + "INTO "            
                             + "furnitures "                         //table name
                             + "VALUES(?,?,?,?,?,?,?)";


            
                pstmt = conn.connection.prepareStatement(query);    //passing the query as a parameter
                
                        //setting values to the parameters for the query
                        pstmt.setString(1, id);
                        pstmt.setString(2, name);
                        pstmt.setString(3, sup_name);
                        pstmt.setString(4, type);
                        pstmt.setInt(5, ws);
                        pstmt.setInt(6, retail);
                        pstmt.setString(7, avail);
            
             int num  = pstmt.executeUpdate();                     // returns an integer if the query is was succeded
          return num;
            
        } catch (SQLException ex) {
            
                 JOptionPane.showMessageDialog(null, "Furniture ID Already Exist.\n Insert another ID", "Already Exist", JOptionPane.ERROR_MESSAGE);
                 System.out.println("SQL Exception (Cannot insert to furnitures)  "+ex.getMessage());
            
                 return 0;
        }
    }
    
       
   
 
  
    

}
