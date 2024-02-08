package day3.week1;

public class Rectangle extends Shape {
	private int length;
	private int breadth;
	Rectangle(int length, int breadth){  //constructor
		this.length =length;
		this.breadth=breadth;
	}
	Rectangle(){}
	@Override
	public double area() {
		super.displayAreaMessage();
		return length*breadth;
		
	}
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		displayPerimeterMessage(); // No need of super keyword because subclass inherits method from the Base-class 
		return 2*(length+breadth);
	}
	@Override
	public String toString() {
		return "Rectangle  with length "+ length +" and Breadth "+ breadth +" has an area :"+ area();
	}

}
