package com.questionPaper;

import java.util.Scanner;

public class UserInput {

	Scanner scanner=new Scanner(System.in);
	
	public  String getInput()
	{
		
		String s=scanner.next();
		return s;
		
	}
	public  int getInput1()
	{
		int rollNumber=scanner.nextInt();
		return rollNumber;
	}
}
