package day4.week1;

import java.util.Scanner;

public class SimpleLoginProcess {
	private static final String user = "lohith.g";
	private static final String password = "LoHiTh.G11";

	public void authenticate(String user_name, String pass_word) throws AuthenticationException {
		if (!user_name.equals(user) || !pass_word.equals(password)) {
			throw new AuthenticationException("Incorrect Username & Password !!!");
		} else {
			System.out.println("Login Successfull !!");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		SimpleLoginProcess slp = new SimpleLoginProcess();
		int attempt = 3;
		while (attempt > 0) {
			System.out.println("Enter the Username :");
			String u = s.nextLine();
			System.out.println("Enter the Password :");
			String p = s.nextLine();
			try {
				slp.authenticate(u, p);
				break;
			} catch (AuthenticationException e) {
				attempt--;
				if (attempt == 0) {
					System.out.println("Account is locked");
				} else {
					System.out.println("Attempts left - " + attempt);
					System.out.println("Authentication failed , please try again");
				}

			}
		}

	}

}
