package com.lti.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lti.bean.Course;
import com.lti.bean.User;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;
import com.lti.dao.UserInterfaceDao;
import com.lti.dao.UserOperationDao;
import com.lti.exception.UserIdAlreadyExistedException;
import com.lti.exception.UserNotFoundException;
import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;
import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;
import com.lti.service.StudentInterface;
import com.lti.service.StudentOperations;
import com.lti.service.UserInterface;
import com.lti.service.UserOperations;

public class CRSApplication {

	/**
	 * @author user250
	 */
	static int selectedOption;
	static boolean isNotExit = true;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("====WELCOME TO COURSE REGISTRATION SYSTEM===");
		mainMenu();
	}
	
	public static void mainMenu(){
		Scanner s1 = null;
		int choice = 0;
		do{
			System.out.println("Please select from below operations");
		
			System.out.println("1. Login");
			System.out.println("2. Student Registration");
			System.out.println("3. Update Password");
			System.out.println("4. Exit");
			s1 = new Scanner(System.in);
			try{
				 choice = s1.nextInt();
				}catch(InputMismatchException ex){
					System.out.println("\n Please select options from above given menu \n");
				}catch(Exception ex){
					System.out.println("\n Please select options from above given menu \n");
				}
		
			if(choice == 1){
				 loginOperation();
				 isNotExit = false;
			}else if(choice == 2){
				studentRegistartion();
				isNotExit = false;
			}else if(choice == 3){
				updatepassword();
				isNotExit = false;
			}else if(choice == 4){
				System.out.println("========Thank you========");
				isNotExit = false;
			}
			else{
				System.out.print(" Please select in between 1 - 4 \n");
			}
		}while(isNotExit);
		s1.close();
	}
	////////////////////////////////////////////////////////////////////////
	 public static void loginOperation(){
		 
		 
		 System.out.println("Please Login to start");
			
			System.out.println("Please select Role");
			 
			List<String> roles = new ArrayList<>(Arrays.asList("Admin","Student","Professor"));
			
			for(String role : roles){
				System.out.println(role);
			}
			
			Scanner s2 = new Scanner(System.in);
			String role = s2.next();
			
			if(Pattern.matches("[a-zA-Z]+", role) == false){
				System.out.println("\n Please select options from above given menu \n");
				loginOperation();
			}else{
			System.out.println("Enter Username");
			String userName = s2.next();
			
			System.out.println("Enter Password");
			String password = s2.next();
			
			UserInterface user = new UserOperations();
			
			User login = new User();
			login.setUserName(userName);
			login.setPassword(password);
			login.setRole(role);
			
			boolean isLogin = false;
			try {
				isLogin = user.doLogin(login);
			} catch (UserNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println("Invalid User");
			}
			
			if(isLogin){
				switch(role){ 
				
				case "Admin": 
					
					AdminMenu.showAdminMenu();
					break; 
					
				case "Student":    
					
				   StudentMenu.showStudentMenu();
				   break;  
				   
				case "Professor":    
					
					ProfessorMenu.showProfessorMenu();
					break;
				default:     
				   System.out.println("Please select appropriate user"); 
				} 
			}else{
				try {
					throw new UserNotFoundException(userName);
				} catch (UserNotFoundException e) {
					System.out.println("------Invalid credentials-----\n"+e.getMessage()+"\n");
					loginOperation();
				}
			}
			s2.close();
	 }
	 }
	 
	 public static void updatepassword(){
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Username");
		    String userName = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
		
			if(userName.isEmpty() && password.isEmpty()){
				System.out.println("\n Please enter username and password \n");
				loginOperation();
			}else{	
					System.out.println("Enter New Password");
					String newPassword = sc.next();
					UserInterface user = new UserOperations();
					user.updatePassword(userName, password, newPassword);
					
					CRSApplication.mainMenu();
			}
			sc.close();
			}
	 
	 public static void loginRegistartion(){
			
		    UserInterfaceDao dao = new UserOperationDao();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter roll No");
		    int rollNo = sc.nextInt();
			
			System.out.println("Enter Name");
			String name = sc.next();
			
			System.out.println("Enter Branch");
			String branch = sc.next();
		
			System.out.println("Enter batch");
			int batch = sc.nextInt();
			
			if(name.isEmpty()){
				System.out.println("\n Please enter details correct \n");
				loginOperation();
			}else{	
				try{
					dao.verifyUserNameexistsForReg(rollNo, name, branch,batch, "Pending");
					throw new UserIdAlreadyExistedException(name);
				}catch(UserIdAlreadyExistedException ex){
					System.out.println("\n"+ex.getMessage());
					CRSApplication.mainMenu();
				}
			}
			sc.close();
			}
	 
	 public static void studentRegistartion(){
			
		    UserInterfaceDao dao = new UserOperationDao();
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter Username");
		    String userName = sc.next();
			
			System.out.println("Enter Password");
			String password = sc.next();
			
			System.out.println("Enter role like Student,Professor,Admin");
			String role = sc.next();
			
			if(userName.isEmpty() && password.isEmpty()){
				System.out.println("\n Please enter username and password \n");
				loginOperation();
			}else{	
				try{
					if(role.equalsIgnoreCase("Admin")){
						dao.verifyUserNameexists(userName, password, 1);
					}else if(role.equalsIgnoreCase("Student")){
						dao.verifyUserNameexists(userName, password, 2);
					}else if(role.equalsIgnoreCase("Professor")){
						dao.verifyUserNameexists(userName, password, 3);
					}else {
						System.out.println("Please select appropriate user");
					}
					throw new UserIdAlreadyExistedException(userName);
				}catch(UserIdAlreadyExistedException ex){
					System.out.println("\n"+ex.getMessage());
					CRSApplication.mainMenu();
				}catch(Exception ex){
					System.out.println("\n"+ex.getMessage());
					CRSApplication.mainMenu();
				}
			}
			sc.close();
			}
}
