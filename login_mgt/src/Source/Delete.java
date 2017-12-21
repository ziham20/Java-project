/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.sql.PreparedStatement;

/**
 *
 * @author Ziham
 */
public class Delete {

    protected PreparedStatement pstmt;
    protected DbConnection connection;

    public Delete() {

        connection = new DbConnection();
    }

    public int Delete(String id, String type) {

        return 0;

    }

}
