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
public class Update {

    PreparedStatement pstmt;
    DbConnection conn;

    public Update() {

        conn = new DbConnection();

    }

    public int furniture(String id, String name, String sup_name, String type, int ws, int retail, String avail) {

        try {

            String query = "UPDATE "
                         + "furnitures "
                         + "SET "
                         + "name=?,type=?,supplier_name=?,whoesale=?,retail=?,availability=? "
                         + "WHERE id=?";

            pstmt = conn.connection.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, type);
            pstmt.setString(3, sup_name);
            pstmt.setInt(4, ws);
            pstmt.setInt(5, retail);
            pstmt.setString(6, avail);
            pstmt.setString(7, id);

               int num = pstmt.executeUpdate();
            return num;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Furniture ID exist.\n Enter a New Furniture ID", "Already Exist", JOptionPane.ERROR_MESSAGE);

            System.out.println("SQL Exception in insert furniture " + se.getMessage());

            return 0;
        }
    }

    public int Supplier(String id, String name, String product_name, String address, String contact_number, String email) {

        try {
            String query = "UPDATE "
                         + "suppliers "
                         + "SET "
                         + "name=?,product_name=?,address=?,telephone=?,email=? "
                         + "WHERE id=?";

            pstmt = conn.connection.prepareStatement(query);

            pstmt.setString(1, name);
            pstmt.setString(2, product_name);
            pstmt.setString(3, address);
            pstmt.setString(4, contact_number);
            pstmt.setString(5, email);
            pstmt.setString(6, id);

               int num = pstmt.executeUpdate();
            return num;

        } catch (SQLException se) {

            JOptionPane.showMessageDialog(null, "Supplier ID exists.\n Enter a new Supplier ID", "Already Exists", JOptionPane.ERROR_MESSAGE);

            System.out.println("SQL Exception in inserting Supplier " + se.getMessage());

            return 0;
        }
    }
}
