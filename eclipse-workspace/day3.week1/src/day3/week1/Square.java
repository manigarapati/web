package day3.week1;

public  class Square extends Rectangle {
	private int side;
	Square(int side){
		super(side,side);
		this.side=side;
	}
	Square(){}

	/*
	 * @Override public double area() { // TODO Auto-generated method stub return
	 * side*side; }
	 * 
	 * @Override public double perimeter() { // TODO Auto-generated method stub
	 * return 4*side; }
	 */
	@Override
	public String toString() {
		return "Square  with "+ side +" has an area :"+ area();
	}

}
