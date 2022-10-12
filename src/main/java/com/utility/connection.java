package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Java Program  to Retrieve Contents of a Table Using JDBC
//connection

//Showing linking of created database

//Importing SQL libraries to create database


public class connection {

 static Connection con = null;

 public static Connection connectDB() throws Throwable  {

     try {
         // Importing and registering drivers
    	 Class.forName("oracle.jdbc.driver.OracleDriver");

         Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");
         // here,root is the user name and 1234 is the
         // password,you can set your own user name and
         // password.
         return con;
     }
     catch (SQLException e) {

         System.out.println(e);
     }
	return con;
    
 }
}