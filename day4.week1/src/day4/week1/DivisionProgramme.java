package day4.week1;

import java.util.Scanner;

public class DivisionProgramme {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the First Number :");
		int num1 = s.nextInt();
		System.out.println("Enter the Second Number :");
		int num2 = s.nextInt();
		try {
			if (num2 == 0) {
				throw new InvalidInputException("Division by Zero is not allowed");
			}

			float result = num1 * 1f / num2;
			System.out.println("Result " + result);

		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} finally {
			s.close();
		}
	}

}
