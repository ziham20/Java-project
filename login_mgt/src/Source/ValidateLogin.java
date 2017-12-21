/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ziham
 */
public class ValidateLogin {

    DbConnection conn;
    PreparedStatement pstmt;

    private ResultSet result_set = null;

    public ValidateLogin() {

        conn = new DbConnection();

    }

    public boolean validateUser() {

        boolean value;

        try {

            String username = EncapLogin.getUsername();
            String password = EncapLogin.getPassword();

            String query = "SELECT "
                         + "* "
                         + "FROM `admin` "
                         + "WHERE username=? AND password=?";

            pstmt = conn.connection.prepareCall(query);

            pstmt.setString(1, username);//arugement number and the value

            pstmt.setString(2, password);//arugement number and the value

            result_set = pstmt.executeQuery();

            value = result_set.next();

            return value;

        } catch (SQLException se) {

            System.out.println("Error occured in Validate user method ");
            System.out.println(se.getMessage());
        }

        return false;
    }

}
