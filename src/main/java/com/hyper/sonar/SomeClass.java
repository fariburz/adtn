package com.hyper.sonar;
import java.sql.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class SomeClass {

	public SomeClass() {

	}

	public void printHyper() {
		System.out.println("Hyper");

	}

	public String printHyper(String text) {
		System.out.println(text);

		return "success";

	}

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/naft";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "78810033";

	public static void fileio() {

		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("c:/newfile.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			//fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
		//finally {
		//	try {
		//		if (fop != null) {
		//			fop.close();
		//		}
		//	} catch (IOException e) {
		//		e.printStackTrace();
			//}
		//}
	}
	
	
	
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		fileio();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT alstat, text FROM naft.db_alarmtext";
			 rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int alstat = rs.getInt("alstat");
				String text = rs.getString("text");

				// Display values
				System.out.print("alstat: " + alstat);
				System.out.print(", text: " + text);

			}
			// STEP 6: Clean-up environment
			 rs.close();
			 //stmt.close();
			 //conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
		//finally {
			// finally block used to close resources
		//	try {
			//	if (stmt != null) {
			//	stmt.close();
			//	}

			//} catch (SQLException se2) {
			//}// nothing we can do
			//try {
			//	if (conn != null) {
			//		conn.close();
			//	}
				
			//} catch (SQLException se) {
			//	se.printStackTrace();
			//}// end finally try
			
			//try {
			///	if (rs != null) {
			//		rs.close();
			//	}
				
			//} catch (SQLException se) {
			//	se.printStackTrace();
		//	}
			
		//}// end try
		System.out.println("Goodbye!");
	}// end main
}// end FirstExample

