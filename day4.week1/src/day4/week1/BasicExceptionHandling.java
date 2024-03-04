package day4.week1;

import java.util.Scanner;

public class BasicExceptionHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the first Number :");
		int num1 = s.nextInt();
		System.out.println("Enter the Second Number :");
		int num2 = s.nextInt();
		try {
			float result = num1/num2;
			System.out.println(result);
			throw new ArithmeticException("Arithematicexception");
		}
		catch(ArithmeticException e){
			System.err.println("Second number should not be zero !!!");
		}
		finally {
			System.out.println("Program has been Ended !!!");
		}

	}

}
