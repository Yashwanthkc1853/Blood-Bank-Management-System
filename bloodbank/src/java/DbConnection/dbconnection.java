/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nithin S R
 */
public class dbconnection {
        public static Connection getConnectTobloodbank() throws SQLException, ClassNotFoundException
   {
       Class.forName("com.mysql.jdbc.Driver");
       Connection con=null;
       String url="jdbc:mysql://localhost:3306/";
       String dbName="bloodbank";
       String userName="root";
       String password="MySQL@20";
       con=DriverManager.getConnection(url+dbName,userName, password);
       return con; 
}
    
}
