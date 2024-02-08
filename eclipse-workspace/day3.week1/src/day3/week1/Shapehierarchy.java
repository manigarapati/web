package day3.week1;

import java.util.Scanner;

public class Shapehierarchy  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape shape=null;
		String shapetype="";
		Scanner s= new Scanner(System.in);
		for(;;) {
		System.out.println("Choice the Shape");
		System.out.println("1.Reactangle");
		System.out.println("2.Square");
		System.out.println("3. Circle");
		System.out.println("4.exit");
		int choice=s.nextInt();
		if(choice ==4) System.exit(0);
		if(choice<1 || choice>4) System.out.println("Invaild choice !!");
		switch (choice) {
		case 1: System.out.println("Enter the length");
		  		int length=s.nextInt();
		  		System.out.println("Enter the breadth");
		  		int breadth=s.nextInt();
		  		shapetype="Rectangle";
		  		shape=new Rectangle(length, breadth);
		  	break;
		case 2:System.out.println("Enter the Side"); 
				int side=s.nextInt();
				shapetype="Square";
				shape=new Square(side);
			break;
		case 3:System.out.println("Enter the Radius :");
		 		int radius=s.nextInt();
		 		shapetype="Circle";
		 		shape=new Circle(radius);
			break;
		}
		
		
		
		System.out.println("Area of the "+  shapetype +" is " + shape.area());
		
		System.out.println("Perimeter of the "+ shapetype + " is " + shape.perimeter());
		
		
		}
		
	}
	
	
	

}
