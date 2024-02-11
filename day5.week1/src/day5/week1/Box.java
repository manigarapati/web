package day5.week1;

public class Box<T> {
	private T value;
	
	public void setValue(T value) {
		this.value = value;
	}

	Box(T value){
		
		this.value = value;
	}
	Box(){}

	public T getValue() {
		return value;
	}
}
