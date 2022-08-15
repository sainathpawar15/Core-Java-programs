package com.questionPaper;

public class Grade {

	public void gradeCheck(int result)
	{
		if(result>=8 && result<=10)
		{
			System.out.println("Your Grade is A with marks of "+result);
		}
		else if(result >=6 && result<=8)
		{
			System.out.println("Your Grade is B with marks of "+result);
		}else if(result==5)
		{
			System.out.println("Pass with marks of "+result);
		}else
		{
			System.out.println("Fail and your marks is "+result);
		}
	}
	
}
