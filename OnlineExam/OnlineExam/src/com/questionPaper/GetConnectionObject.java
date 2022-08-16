package com.questionPaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionObject {
	Connection con=null;
	public  Connection getConnectionObject() throws SQLException {
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con= DriverManager.getConnection("JDBC:mysql://localhost:3306/sys",
					 "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
}
