package day3.week1;

import java.util.Scanner;

public class Weekdaynamefinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a Number(1-7) implements the days of the Week :");
		int num =s.nextInt();
		
		switch (num) {
		case 1: System.out.println("1 represents - MONDAY ");
			
			break;
		case 2: System.out.println("2 represents - TUESDAY");
		    break;
		case 3: System.out.println("3 represents - WEDNESDAY ");
		
			break;
		case 4: System.out.println("4 represents - THURSDAY");
	    	break; 
		case 5: System.out.println("5 represents - FRIDAY");
	    	break;
		case 6: System.out.println("6 represents - SATURDAY ");
	
			break;
		case 7: System.out.println("7 represents - SUNDAY");
    		break;
		default: System.out.println("INVAILD Input");
			break;
		}
	}

}
