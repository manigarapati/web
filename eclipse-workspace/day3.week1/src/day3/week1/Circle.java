package day3.week1;

public class Circle extends Shape{
	private int radius;
	Circle(int radius){
		this.radius=radius;
	}
	Circle(){}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		super.area();
		return Math.PI*radius*radius;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		displayPerimeterMessage();
		return 2*Math.PI*radius;
	}
	@Override
	public String toString() {
		return "Circle  with "+ radius +" has an area :"+ area();
	}

}
