package day3.week1;

import java.util.Scanner;

public class CustomStringRepresentationforShapes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Shape shape=null;
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
		  		shape=new Rectangle(length, breadth);
		  	break;
		case 2:System.out.println("Enter the Side"); 
				int side=s.nextInt();
				shape=new Square(side);
			break;
		case 3:System.out.println("Enter the Radius :");
		 		int radius=s.nextInt();
		 		shape=new Circle(radius);
			break;
		}
		String shapetype="";
		if(shape instanceof Square) {
			shapetype="Square";
		} else if(shape instanceof Rectangle) {
			shapetype = "Rectangle";
		} else if (shape instanceof Circle) {
			shapetype = "Circle";
		} else {
			shapetype = "Invalid shape";
		}
		
		
		System.out.println("Area of the "+  shapetype +" is " + shape.area());
		
		System.out.println("Perimeter of the "+ shapetype + " is " + shape.perimeter());
		
		System.out.println(shape);
		}
		
	}
}
