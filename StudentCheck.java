package com.questionPaper;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentCheck {

	Student student=new Student();
	UserInput userinput=new UserInput();
	Scanner scanner=new Scanner(System.in);
//	int marks=0;
	static int rollNumber;
	public void studentCheck() throws SQLException, NotRegistredStudent {
		System.out.println("If you are new Student, then choose 1 for doing registration");
		System.out.println("If your registration is already done then choose 2");
		System.out.println("If you would like to know your marks, then type 3");
		System.out.println("If you would like to get all student result, then type 4");
		int choice = new UserInput().getInput1();
		switch (choice) {

		case 1:
			System.out.println("Enter your first name");
			String firstName =userinput.getInput();
			System.out.println("Enter your last name");
			String lastName=userinput.getInput();
			System.out.println("Enter your city");
			String city=userinput.getInput();
		int	marks=new QuestionPaper().giveExam();
			
			try {
			
				student.updateStudentData(firstName,lastName,city,marks);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//new Student().updateMarks(marks, rollNumber);
			break;

		case 2:
			student.checkStudentRecord();
			break;
		case 3:
		   
		    student.getSpecificStudentMarks();
		case 4:
			new Student().getAllRecords();	
		    break;
		
		default:
			System.out.println(
					"Kindly enter 1 if you are not registreed student and enter 2 if your regisration is already done");

		}

	}


}
