/**
 * 
 */
package com.lti.application;

import java.util.Scanner;

import com.lti.bean.Student;
import com.lti.dao.PaymentInterfaceDao;
import com.lti.dao.PaymentOperationDao;
import com.lti.dao.StudentInterfaceDao;
import com.lti.dao.StudentOperationDao;
import com.lti.exception.PaymentFailedException;
import com.lti.service.StudentInterface;
import com.lti.service.StudentOperations;

/**
 * @author user252
 *
 */
public class StudentMenu {

public static void showStudentMenu(){
	
		System.out.println("===========================Welcome to Student Portal===========================");
		System.out.println("Please select from below operations");
		System.out.println("1.register for course");
//		System.out.println("2.add course");
		System.out.println("2.remove course");
		System.out.println("3.view report card");
		System.out.println("4.payment");
		System.out.println("5.Logout");
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = sc.nextInt();
		doStudentOperations(selectedOption);
		sc.close();
	}
	
public static void doStudentOperations(int selectedOption){

	Student s = new Student();
	PaymentInterfaceDao payment = new PaymentOperationDao();
		
	StudentInterfaceDao student = new StudentOperationDao();
	StudentInterface stu = new StudentOperations();
	
	switch(selectedOption){
	case 1: 
		student.registerForCourse();
		showStudentMenu();
		
		break; 
		
	/*
	 * case 2: student.addcourses(); showStudentMenu(); break;
	 */
		 
	case 2: 
	student.dropCourses();
	showStudentMenu();
	break;
	
	case 3: 
		student.viewReportCard();
		showStudentMenu();
		break;
		
	case 4: 
		payment.StudentCoursePayment(1, "Debit card", 500);
//		stu.payFees(s);
		showStudentMenu();
		break;
	
	case 5: 
		System.out.println("========Thank you========");
		break;
	default:     
	   System.out.println("Please select appropriate operation"); 
	}  
	}

}
