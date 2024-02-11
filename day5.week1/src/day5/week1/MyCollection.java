package day5.week1;

import java.lang.reflect.Array;

public class MyCollection<T> {

	private T[] elements;
	private int index;

	MyCollection(int size) {
		index = -1;
		elements = (T[]) Array.newInstance(Object.class, size);
	}
	MyCollection(){}

	public void add(T element) {
		add(index+1, element);
		
		
	}

	public T get(int index) {
		return elements[index];
	}

	public void remove(int index) {
		elements[index] = null;

	}

	public void add(int index, T element) {
		elements[index] = element;
		
		if( index >= this.index ) {
			this.index = index ;
		} 
	}

	public void remove() {
		elements[index] = null;
		this.index--;
	}
	public T[] getCollection() {
		return elements;
	}
	@Override
	public String toString() {
		int i = 0;
		String value = "[";
		for( i = 0; i<elements.length-1; i++) {
			if(elements[i] == null) {
				value = value+  null  + ", "  ;
			} else {
				value = value +elements[i].toString()+ ", ";
			}
		}
		if(elements[i] == null) {
			value = value+  null  + "]"  ;
		} else {
			value = value +elements[i].toString()+ "]";
		}
//		for(T element : elements) {
//			if(element == null) {
//				value = value+  null  + " "  ;
//			} else {
//				value = value +element.toString()+ " ";
//			}
//			
//		}
		return value;
	}
}
