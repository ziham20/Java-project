/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ziham
 */
public class Search extends Delete implements FindDetails {

    //PreparedStatement pstmt;
    Statement stmt;
    DbConnection conn;
    ResultSet rs = null;

    public Search() {
        conn = new DbConnection();
    }

    @Override
    public ResultSet findFurnitures() {
        try {
            String query = "SELECT "
                         + "* "                               //all       
                         + "FROM "
                         + "furnitures";                      //table name

            stmt = conn.connection.createStatement();

            rs = stmt.executeQuery(query);

            return rs;

        } catch (SQLException se) {

            System.out.println("SQL Exception in Searching Furniture " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Retrieving Furniture details failed", "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    @Override
    public ResultSet findSuppliers() {
        try {
            String query = "SELECT "
                         + "* "                              //all       
                         + "FROM "
                         + "suppliers";                      //table name

            stmt = conn.connection.createStatement();

            rs = stmt.executeQuery(query);

            return rs;
        } catch (SQLException se) {

            System.out.println("SQL Exception in Seaching Supplier " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Retrieving Supplier details failed", "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    //method overloading

    public ResultSet findFurnitures(String id) {
        try {
            String query = "SELECT "
                         + "* "                                 //all
                         + "FROM "
                         + "furnitures "                        //table name
                         + "WHERE id = ?";

            pstmt = conn.connection.prepareCall(query);

            pstmt.setString(1, id);                             //setting the value to the parameter in the query  

            rs = pstmt.executeQuery();                          //reutrns a result set

            return rs;

        } catch (SQLException se) {

            System.out.println("SQL Exception in Searching Furnitures " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Retrieving Furniture details failed", "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    public ResultSet findSuppliers(String id) {

        try {
            String query = "SELECT "
                         + "* "                                           //all                    
                         + "FROM "
                         + "suppliers "                                   //table name
                         + "WHERE id = ?";

            pstmt = conn.connection.prepareCall(query);

            pstmt.setString(1, id);                                 //setting the value to the parameter in the query     

            rs = pstmt.executeQuery();                              //returns a result set 

            return rs;

        } catch (SQLException se) {

            System.out.println("SQL Exception in Searching Supplier " + se.getMessage());
            JOptionPane.showMessageDialog(null, "Retrieving Supplier details failed", "Error", JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    @Override
    public int Delete(String id, String type) {
        try {
            String query;
            switch (type) {
                case "Furniture":                                       // case one
                    
                      query = "DELETE "
                            + "FROM "
                            + "furnitures "                             //table name
                            + "WHERE id = ?";
                    break;

                case "supplier":                                        //case two
                    
                      query = "DELETE "
                            + "FROM "
                            + "suppliers "                              //table name
                            + "WHERE id = ?";
                    break;

                default:
                    
                      query = null;

                    break;
            }

            pstmt = conn.connection.prepareStatement(query);

            pstmt.setString(1, id);                                  //setting values to the parameter in the query

            int returnVal = pstmt.executeUpdate();                   // returns a integer 

            return returnVal;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Deletion Failed", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("SQL Exception in Deleting " + type + " " + se.getMessage());

            return 0;
        }
    }

}
