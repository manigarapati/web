package day5.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WildcardWithUpperBound {

	public void doubleNumber(List<? extends Number> number) {

		for (Number num : number) {
			double doubled =  num.doubleValue() * 2;
			System.out.println("Orginal Number " + num + "Doubled Number " + doubled);
		}

//		for(int i = 0; i<number.size(); i++) {
//			Double doubled = ((Double)(number.get(i)))*2;
//			System.out.println("Orginal Number "+number.get(i) +"Doubled Number "+ doubled);
//		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Scanner s = new Scanner(System.in);
		WildcardWithUpperBound w = new WildcardWithUpperBound();
		List l = new ArrayList();
		l.add(1);
		l.add(2);
		l.add(5);
		l.add(3);
		/*
		 * System.out.println("Enter Numeric Values ( type 'done' once finish) :");
		 * String i =""; while(true) { i = s.next(); if(i.equals("done")) { break; }
		 * 
		 * try { double num = Double.parseDouble(i); //for(int j=0;j<5;j++) {
		 * l.add(num); } catch(NumberFormatException e) { System.out.
		 * println("Invalid input. Please enter a valid number or type 'done' to finish."
		 * ); } }
		 */
		w.doubleNumber(l);

	}

}
