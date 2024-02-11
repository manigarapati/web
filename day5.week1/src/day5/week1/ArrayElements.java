package day5.week1;

public class ArrayElements {
	
	    public static <T> T getFirstElement(T[] array) {
	        if (array == null || array.length == 0) {
	            return null; 
	        }
	        return array[0]; 
	    }

	    public static void main(String[] args) {
	        
	        Integer[] intArray = {1, 2, 3, 4, 5};
	        String[] stringArray = {"apple", "banana", "cherry"};

	        Integer firstInt = ArrayElements.getFirstElement(intArray);
	        System.out.println("First element of intArray: " + firstInt);

	        String firstString = ArrayElements.getFirstElement(stringArray);
	        System.out.println("First element of stringArray: " + firstString);

	        
	        Double[] emptyArray = {};
	        Double firstDouble = ArrayElements.getFirstElement(emptyArray);
	        System.out.println("First element of emptyArray: " + firstDouble); 
	    }
	

}
