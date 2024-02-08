package day3.week1;

import java.util.Random;
import java.util.Scanner;

public class Guessinggame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int guess ,answer;
		Scanner s= new Scanner(System.in);
		
				
		Random r = new Random();
		answer =r.nextInt(100);
		
		Boolean match = false;
		while(!match) {
			System.out.println("Enter a random number between 1 - 100 (match the number & win the price) :");
			guess = s.nextInt();
			if(answer < guess) {
				System.out.println("Guess is TOO HIGH , Try again !!");
			} else if(answer > guess) {
				System.out.println("Guess is TOO LOW , Try again !!");
			} else {
				System.out.println("CORRECT , WON THE PRICE");
				match = true;
			}
		}
		
	}

}
