package day3.week1;

import java.util.Scanner;

public class Userauthentication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String u="manigarapati007@gmail.com";
		String p="MaNiGaRaPaTi112";
		Boolean flag = true;
		Scanner s = new Scanner(System.in);
		
		do {
			System.out.println("Enter the Login Credentials");
			System.out.println("Enter the USERNAME :");
			String user = s.nextLine();
			System.out.println("Enter the password :");
			String password = s.nextLine();
			if(user.equals(u) && password.equals(p) ) {
				System.out.println("your login is Successfull !!");
				flag = false;
			}else {
				System.out.println("Invaild user Credentials , Try again !!");
			}
		}while (flag);
	}

}
