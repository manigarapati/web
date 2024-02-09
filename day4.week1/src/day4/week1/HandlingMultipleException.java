package day4.week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HandlingMultipleException {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		// TODO Auto-generated method stub
		try {
			fr = new FileReader("C:\\Users\\lohit\\eclipse-workspace\\day4.week1\\resources\\input.txt");
			br = new BufferedReader(fr);

			String num1 = br.readLine();
			int i = Integer.parseInt(num1);
			System.out.println("First Number : " + i);
			String num2 = br.readLine();
			int j = Integer.parseInt(num2);
			System.out.println("Second Number : " + j);
			Float result = i * 1F / j;
			if (result.isInfinite()) {
				throw new ArithmeticException();
			}
			System.out.println("Result value :" + result);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("Input file not found");
		} catch (NumberFormatException nfe) {
			System.err.println("Input Value should be a Number..");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Value not found in the file");
		} catch (ArithmeticException e) {
			System.err.println("Second Number should not be Zero !! ");
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
				if (br != null) {
					br.close();
				}
				System.out.println("Resources closed Successfully !!");
			} catch (IOException e) {
				System.err.println("Unable to close Readers..");
			}
		}

	}

}
