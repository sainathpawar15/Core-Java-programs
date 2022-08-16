package com.questionPaper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
	
	String firstName;
	String lastName;
	
	String city;
	Scanner scanner=new Scanner(System.in);
	
//public static	int rollNumber;
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	 	
	GetConnectionObject connectionObject=new GetConnectionObject();
	public Student() {}
	public Student(String firstName,String lastName, String city)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.city=city;
		//this.rollNumber=rollNumber+5;
		
	}
	
	public void updateStudentData(String firstName,String lastName,String city,int marks) throws Exception
	{
		Student student= new Student(firstName, lastName, city);
	 con=connectionObject.getConnectionObject();
String sql="insert into student(firstName, lastName, city, marks) values(?,?,?,?)";
	ps=con.prepareStatement(sql);
	ps.setString(1, firstName);
	ps.setString(2, lastName);
	ps.setString(3, city);
	ps.setInt(4, marks);
	ps.executeUpdate();
	}
	public void checkStudentRecord() throws SQLException, NotRegistredStudent
	{
		System.out.println("Enter your Roll Number");
		int rollNumber1 =scanner.nextInt();
		//System.out.println("Hi");
		con =connectionObject.getConnectionObject();
		 	 ps = con.prepareStatement("select *from student");
		 rs = ps.executeQuery();
     	while (rs.next()) 
		{

			if (rs.getInt(1) == rollNumber1) 
			{
				if( rs.getInt(5)==0)
				{
			int marks=	new QuestionPaper().giveExam();
				new Student().updateMarks(marks,rollNumber1);
				}
				else 
			   {
				System.out.println("You have alread attempted Exam");
			   }
	     	}
			else
			{
				throw new NotRegistredStudent("You are not registered Student. Kindly do registration");
			}
		}
	}
	public void getAllRecords() throws SQLException
	{
		 con=connectionObject.getConnectionObject();
		 ps=con.prepareStatement("select *from student");
		  rs=ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Student Roll Number "+rs.getInt(1));
			System.out.println("First Name "+rs.getString(2));
			System.out.println("Last Name "+rs.getString(3));
			System.out.println("City Name "+rs.getString(4));
			System.out.println("Obtained Marks "+rs.getInt(5));
		}
		
	}
	public void updateMarks(int marks, int rollNumber) throws SQLException
	{
		Connection con=connectionObject.getConnectionObject();
		PreparedStatement	 ps=con.prepareStatement("update Student set Marks="+marks+"where rollNumber="+rollNumber);
		ps.executeUpdate();
	}
	public void getSpecificStudentMarks() throws SQLException, NotRegistredStudent,NullPointerException
	{
		
		 System.out.println("Enter your Roll Number");
		   int rollNumber1=new UserInput().getInput1();
		con = connectionObject.getConnectionObject();
		 	 ps = con.prepareStatement("select *from student");
		 rs = ps.executeQuery();
      boolean b=rs.next();
		if (!b) 
		{
			throw new NotRegistredStudent("RollNumber is not found in the records. Please enter correct Roll Number");
		}

		while (rs.next()) 
		{

			if (rs.getInt(1) == rollNumber1) 
			{
				System.out.println("Your Marks is "+rs.getInt(1));
			}

	}
}
}