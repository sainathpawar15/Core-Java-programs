package com.questionPaper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionPaper {
	
	
    public int giveExam() throws SQLException
	{
		//HashMap<String,String> hm=new HashMap<String,String>();
		int result=0;
		
		Connection con=new GetConnectionObject().getConnectionObject();
		PreparedStatement ps=con.prepareStatement("select *from QuestionPaper order by rand()");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
		System.out.println(rs.getString(4));
		System.out.println(rs.getString(5));
		String s=new UserInput().getInput();
		if(s.equalsIgnoreCase(rs.getString(6)))
			result++;	
		}
		new Grade().gradeCheck(result);
		return result;
	}
    
    
    
}
