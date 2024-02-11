package day5.week1;

import java.util.Scanner;

public class Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter an Integer value :");
		int i = s.nextInt();
		
		//Box<Integer> b = new Box<>();
		//b.setValue(i);
		Box<Integer> b = new Box<Integer>(i);
		System.out.println(b.getValue());
		
		System.out.println("Enter an String value :");
		String value = s.next();
		//Box<String> box = new Box<>();
		//box.setValue(value);
		Box<String> box = new Box<String>(value);
		System.out.println(box.getValue());
		
	}

}
