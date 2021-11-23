/**
 * 
 */
package com.lti.application;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.Student;
import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;

/**
 * @author user250
 *
 */
public class AdminMenu {

	public static void showAdminMenu(){
		
		System.out.println("===========================Welcome to Admin Portal===========================");
		System.out.println("Please select from below operations");
		System.out.println("1.Add Course");
		System.out.println("2.Remove Course");
		System.out.println("3.Add Professor");
		System.out.println("4.Generate Report Card");
		System.out.println("5.Approve Student Registration");	
		System.out.println("6.Logout");
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = sc.nextInt();
		
		doAdminOperations(selectedOption);
		
		sc.close();
	}
	
	public static void doAdminOperations(int selectedOption) {
		
		AdminInterface admin = new AdminOperations();
		Scanner sc = new Scanner(System.in);
		boolean isoffered1,risoffered1;
		switch(selectedOption){
		case 1: 
			System.out.println("Enter course code");
			String courseCode = sc.next();
			System.out.println("Enter course name");
			String courseName = sc.next();
			System.out.println("Enter instructor name");
			String instructor = sc.next();
			System.out.println("is offered...press Y or N");
			String isoffered = sc.next();
			if("Y".equals(isoffered)){
				isoffered1 = true;
			}else{
				isoffered1 = false;
			}
			System.out.println("Enter Semester");
			int semester = sc.nextInt();
			Course c = new Course(courseCode, courseName, isoffered1, instructor, semester);
			admin.addCoursesInCatalogue(c);
			showAdminMenu();
			break; 
			
		case 2: 
			System.out.println("Enter course code");
			String rcourseCode = sc.next();
			System.out.println("Enter course name");
			String rcourseName = sc.next();
			System.out.println("Enter instructor name");
			String rinstructor = sc.next();
			System.out.println("is offered...press Y or N");
			String risoffered = sc.next();
			if("Y".equals(risoffered)){
				risoffered1 = true;
			}else{
				risoffered1 = false;
			}
			System.out.println("Enter Semester");
			int rsemester = sc.nextInt();
			Course c1 = new Course(rcourseCode, rcourseName, risoffered1, rinstructor, rsemester);
			admin.removeCoursesFromCatalogue(c1);
			showAdminMenu();
			break;
			 
		case 3: 
			System.out.println("Enter Professor name");
			String profName = sc.next();
			System.out.println("Enter Professor id");
			int profId = sc.nextInt();
			System.out.println("Enter department");
			String dept = sc.next();
			System.out.println("Enter designation");
			String designation = sc.next();
			System.out.println("Enter date of joining");
			String doj = sc.next();
			Professor professor = new Professor();
			professor.setDepartment(dept);
			professor.setDesignation(designation);
			Date date = Date.valueOf(doj);
//			 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//			 java.util.Date date = sdf.parse(doj);
//			 
			 java.sql.Date sqlDate = new Date(date.getTime());

			professor.setDoj(sqlDate);
			professor.setProfessorId(profId);
			professor.setProfessorName(profName);
			admin.addProfessor(professor );
			showAdminMenu();
			break;
			
		case 4: 
			System.out.println("Enter student Id");
			int stdId = sc.nextInt();
			System.out.println("Enter semester");
			int sem = sc.nextInt();
			admin.generateReportCard(stdId,sem);
			break;
			
		case 5: 
			System.out.println("Enter Student dtls for approval");
			int regisStdId = sc.nextInt();
			System.out.println("Enter Student name");
			String name = sc.next();
			System.out.println("Enter branch name");
			String branch = sc.next();
			System.out.println("Enter batch");
			int batch = sc.nextInt();
			Student std = new Student();
			std.setStudentId(regisStdId);
			std.setStudentName(name);
			std.setBatch(batch);
			std.setBranch(branch);
			List<Student> stdList = new ArrayList<>();
			stdList.add(std);
			admin.approveStudentRegistration(stdList);
			showAdminMenu();
			break;
		case 6:
			System.out.println("========Thank you========");
			break;
		default:     
		   System.out.println("Please select appropriate operation"); 
		} 
	}
}
