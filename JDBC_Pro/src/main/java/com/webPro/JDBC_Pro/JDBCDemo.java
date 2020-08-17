package com.webPro.JDBC_Pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Info : MySQL database is used.
 * 1) Open JDBC Connection
 * 2) Read all the records from 'students' table and print on console
 * 3) Close the connection
 */
public class JDBCDemo 
{
    public static void main( String[] args )
    {
    	try
    	{
    		//Create jdbc driver instance
    		Class.forName("com.mysql.cj.jdbc.Driver");//Depreciated driver : com.mysql.jdbc.Driver()
    		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Vest@123");
    		Statement st = conn.createStatement();
    		ResultSet ResSet = st.executeQuery("SELECT * FROM students;");

    		while(ResSet.next()) {
    			int rollNo = ResSet.getInt("RollNo");
    			String name = ResSet.getString("Name");
    			String address = ResSet.getString("Address");
    			System.out.println(rollNo+ ", " +name+ ", " +address);
    		}
    		st.close();
    		conn.close();
    		System.out.println("Completed !");
    	}catch (Exception e) {
    		System.out.println("Exception : "+e.getLocalizedMessage());
		}
    }

    static {
        System.out.println("In Static");
    }
}