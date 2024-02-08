package day3.week1;

import java.util.Scanner;

public class Multiplicationtablegenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter a NUMBER to show Multiplication Table :");
		int num =s.nextInt();
		
		for(int i=1;i<=10;i++) {
			System.out.println("Multiplication Table for "+ i +  "x"  + num +  "="  + i*num);
		}
	}

}
