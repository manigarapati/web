package day5.week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class NumericElements {
	
	public double sum(Collection<? extends Number> numbers) {
		double sum = 0;
			for(Number num : numbers) {
				 sum += num.doubleValue();
			}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner s= new Scanner(System.in);
		NumericElements numeric = new NumericElements();
		List l = new ArrayList();
		l.add(2);
		l.add(3.5);
		l.add(2.8);
		l.add(5.7);
		/*
		 * System.out.println("Enter Numeric Values ( type 'done' once finish) :");
		 * String i =""; while(true) { i = s.next(); if(i.equals("done")) { break; }
		 * 
		 * try { //double num = Double.parseDouble(i); //for(int j=0;j<5;j++) {
		 * l.add(i); } catch(NumberFormatException e) { System.out.
		 * println("Invalid input. Please enter a valid number or type 'done' to finish."
		 * ); } }
		 */
		System.out.println(numeric.sum(l));
	}

}
