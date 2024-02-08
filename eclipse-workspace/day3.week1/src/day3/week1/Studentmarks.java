package day3.week1;

import java.util.Scanner;

public class Studentmarks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s= new Scanner(System.in);
		System.out.println("Enter Student Marks :");
		int marks=s.nextInt();
		
		  if(marks >= 90) { 
			  System.out.println(" GRADE : A"); 
		  } else if(marks>=80 && marks<90) { 
			  System.out.println("GRADE :B"); 
		  } else if(marks>=70 && marks<80){ 
			  System.out.println("GRADE : C");
		  } else if (marks>=60 && marks<70) {
		      System.out.println("GRADE : D"); 
		  } else { 
			  System.out.println("FAIL"); 
			  }
		 

	}

}
