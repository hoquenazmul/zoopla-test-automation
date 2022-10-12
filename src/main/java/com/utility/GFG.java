package com.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Java Program retrieving contents of

// Table Using JDBC connection

// Java code producing output which is based

// On values stored inside the "cuslogin" table in DB

// Importing SQL libraries to create database

public class GFG {

// Step 1: Main driver method
 public static void main(String[] args) throws Throwable {
// Step 2: Making connection using
// Connection type and in built function on
     Connection con = null;
     PreparedStatement p = null;
     ResultSet rs = null;

     con = connection.connectDB();
// Try block to catch exception/s
     try {
// SQL command data stored in String data type
         String sql = "select * from employees";
         p = con.prepareStatement(sql);
         rs = p.executeQuery();

// Printing ID, name, email of customers
// of the SQL command above
         System.out.println("EMPLOYEE-ID\t\tFIRST-NAME\t\tEMAIL-ADDRESS");
     // Condition check
         while (rs.next()) {

             int EMPLOYEE_ID = rs.getInt("EMPLOYEE_ID");
             String FIRST_NAME = rs.getString("FIRST_NAME");
             String LAST_NAME = rs.getString("LAST_NAME");
             System.out.println(EMPLOYEE_ID + "\t\t" + FIRST_NAME + "\t\t" + LAST_NAME);
         }
     }
// Catch block to handle exception
     catch (SQLException e) {

    // Print exception pop-up on screen
         System.out.println(e);
     }
 }
}