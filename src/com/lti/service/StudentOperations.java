/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;
import com.lti.dao.PaymentInterfaceDao;
import com.lti.dao.PaymentOperationDao;
import com.lti.exception.CourseFoundinCatalagException;
import com.lti.exception.CourseNotFoundException;
import com.lti.exception.CourseRegisteredAlreadyException;

/**
 * @author user252
 *
 */
public class StudentOperations implements StudentInterface{
	
	final int courseMoney=500;
	 Scanner sc=new Scanner(System.in);
	//GradeCard r = new GradeCard();
	List<Course> courses = new ArrayList<>();
/*	Course c1=new Course(1001,"c1","course1",true,"professor1");
    Course c2=new Course(1002,"c2","course2",true,"professor2");
    Course c3=new Course(1003,"c3","course3",true,"professor3");*/
    
    
	public void registerForCourse() throws Exception{
		  /* courses.add(c1);    
		   courses.add(c2);  
		   courses.add(c3);*/
		   System.out.println("Courses that are available currently: ");
		   for(Course c : courses){
				 
		   	     System.out.println( c.getCourseId()+ " "+c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());
		   	 
		   	     }
		System.out.println("Select the no.of courses you need");
		int k=sc.nextInt();
		System.out.println("Enter the courseid's you want to enroll");
		int a[]=new int[k];
		for(int i=0;i<k;i++){
			a[i]=sc.nextInt(); 
		}
		for(int i=0;i<k;i++){
			if(a[i]!=courses.get(0).getCourseId())
				throw new CourseNotFoundException(a[i]);
		}
		List<Course> selectedCourses=new ArrayList<>();
		for(Course cs : courses){
			for(int i=0;i<k;i++){
				Integer j=a[i];
		           if(j.equals(cs.getCourseId())){
		           selectedCourses.add(cs);
		   }
			}
		}
		System.out.println("Selected courses are: ");
		for(Course c : selectedCourses){
			 
	   	     System.out.println( c.getCourseId()+ " "+c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());
	   	    
	   	     }
		 addCourses(selectedCourses);
		System.out.println("\n Registration is done suucessfully");
	}
	
	public void addCourses(List<Course> pselectedCourses) throws CourseFoundinCatalagException, CourseRegisteredAlreadyException{
	   Student s = new Student(101, "Computer", 1, null,null);
	   List<Course> aselectedCourses=new ArrayList<>();
	   System.out.println("Enter the no.of extra courses to be added");
	   int noofExtraCourses=sc.nextInt();
	   System.out.println(" \n Please enter the extra courseid's to be added");
	   int a[]=new int[noofExtraCourses];
		for(int i=0;i<noofExtraCourses;i++){
			a[i]=sc.nextInt(); 
		}
		for(int i=0;i<noofExtraCourses;i++){
	      if(null!=pselectedCourses && a[i]==pselectedCourses.get(0).getCourseId()){
	    	  throw new CourseRegisteredAlreadyException("Course is already present in catalogue");
	      }
	      else{
	    	  for(Course cs : courses){
	    		  Integer j=a[i];
		           if(j.equals(cs.getCourseId())){
		        	   aselectedCourses.add(cs);
		   }
	    	  }
	      }
		}
		s.setPrimarySelectedCourses(pselectedCourses);
		s.setAlternativeSelectedCourses(aselectedCourses);
		 boolean dropCourse=false;
		   System.out.println("Please type yes/no to drop the courses");
		   Scanner sc=new Scanner(System.in);
		   String ans=sc.next();
		   if("no".equalsIgnoreCase(ans)){ 
	    	  System.out.println("primary selected courses are:" );
	    	  for(Course c : pselectedCourses){
	 			 
	 	   	     System.out.println( c.getCourseId()+ " "+c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());
	 	   	    
	 	   	     }
	    	  System.out.println("Alternate selected courses are:" );
	    	  for(Course c : aselectedCourses){
		 			 
		 	   	     System.out.println( c.getCourseId()+ " "+c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());
		 	   	    
		 	   	     }
		   }
		   else{
		    dropCourses(s);
	      }
	}

	public void dropCourses(Student s){
		List<Course> selectedCourses=new ArrayList<>();
		selectedCourses.addAll(s.getPrimarySelectedCourses());
		selectedCourses.addAll(s.getAlternativeSelectedCourses());
		System.out.println("Enter the courseid that you wish to drop");
		Scanner sc=new Scanner(System.in);
		Integer id=sc.nextInt();
		for(int i=0;i<selectedCourses.size();i++){
		if(selectedCourses.get(i).getCourseId()==id)
			selectedCourses.remove(i);
		}
		
		System.out.println("Final course list after removing the selected course:\n");
		for(Course ca : selectedCourses){
			System.out.println( ca.getCourseId()+ " "+ca.getCourseCode()+" "+ca.getName()+" "+ca.getInstructor());
		}
		payFees(s);
	}
	
	public void viewGrades(){
		
		
	}

	/* (non-Javadoc)
	 * @see com.lti.service.StudentInterface#payFees()
	 */
	@Override
	public void payFees(Student s) {
		// TODO Auto-generated method stub
		List<Course> selectedCourses=s.getPrimarySelectedCourses();
		//PaymentDetails paymentDetails=new PaymentDetails();
		PaymentInterfaceDao payment = new PaymentOperationDao();
		int count=selectedCourses.size();
		Scanner sc=new Scanner(System.in);
		System.out.println("Total money for the courses that you have selected: "+ " "+(count*courseMoney));
		System.out.println("\n Enter the payment mode: ");
		System.out.println("\n DebitCard  NetBanking");
		if(sc.next().equalsIgnoreCase("DebitCard")){
			System.out.println("\n Enter the cardNumber");
			//paymentDetails.setCardNumber(sc.nextInt());
			System.out.println("Enter card details : "+sc.next());
			System.out.println("\n Enter the cvv: ");
			System.out.println("Enter CVV : "+sc.next());
			//paymentDetails.setCvv(sc.nextInt());
			//payment method needs to be added
			System.out.println("Processosing Payment");
			payment.StudentCoursePayment(s.getStudentId(), "Debit card", (count*courseMoney));
		}else{
			System.out.println("Enter the mode of netbanking among the given options:"+"\n"+ "NEFT or IMPS");
			String mode=sc.next();
			System.out.println("Enter the account Number");
			//paymentDetails.setAccountNumber(sc.nextInt());
			System.out.println("Enter account details : "+sc.next());
			//payment method needs to be added
			payment.StudentCoursePayment(s.getStudentId(), "NEFT", (count*courseMoney));
			System.out.println("details are noted successfully");
		}
			
		
		
	}
	
}
