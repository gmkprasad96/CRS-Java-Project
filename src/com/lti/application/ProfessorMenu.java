/**
 * 
 */
package com.lti.application;

import java.util.Scanner;

import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;

/**
 * @author user252
 *
 */
public class ProfessorMenu {

public static void showProfessorMenu(){
		
		System.out.println("===========================Welcome to Professor Portal===========================");
		System.out.println("Please select from below operations");
		System.out.println("1.View Enrolled Student");
		System.out.println("2.Add Student Grade");
		System.out.println("3.View Courses");
		System.out.println("4.Logout");
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = sc.nextInt();
		doProfessorOperations(selectedOption);
		sc.close();
	}

	public static void doProfessorOperations(int selectedOption){
		
		ProfessorInterface professor = new ProfessorOperations();
		Scanner sc = new Scanner(System.in);
		switch(selectedOption){
		case 1: 
			
			professor.viewEnrolledStudents();
			showProfessorMenu();
			break; 
			
		case 2: 
			System.out.println("Please enter student Id");
			int studentId = sc.nextInt();
			System.out.println("Please enter report Id");
			int reportId = sc.nextInt();
			System.out.println("Please enter grade");
			String grade = sc.next();
			professor.addStudentGradeInReport(studentId,reportId,grade);
			showProfessorMenu();
			break;
			 
		case 3: 
			professor.viewCourses();
			showProfessorMenu();
			break;
		case 4:
			System.out.println("========Thank you========");
			break;
		default:     
		   System.out.println("Please select appropriate operation"); 
		}  
		
	}
}
