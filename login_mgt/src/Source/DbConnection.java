/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Ziham
 */
public class DbConnection {

    //JDBC NAME AND URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/moratufurnitures";

    //DATABASE USERNAME AND PASSWORD
    private static final String USER = "root";
    private static final String PASSWORD = "";

    Connection connection = null; //connecton is used in login validation so cant make it private

    //private Statement statement = null;
            //private ResultSet result_set = null;
    // private String query;
    public DbConnection() {

        try {
            //JDBC Driver
            //Class.forName(Db_connection.JDBC_DRIVER).newInstance();
            Class.forName(JDBC_DRIVER);

            //connection
            System.out.println("connecting to DB");
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

         // }catch (InstantiationException ex) {
            // System.out.println("InstantiationException");
            // System.out.println(ex.getMessage());
            // } catch (IllegalAccessException ex) {
            //   System.out.println("IllegalAccessException");
            //   System.out.println(ex.getMessage());
        } catch (ClassNotFoundException cnfe) {

            System.out.println("Class Not Found Exception");
            System.out.println(cnfe.getMessage());

        } catch (SQLException se) {

            System.out.println("SQL Exception");
            System.out.println(se.getMessage());

        }
    }

}
