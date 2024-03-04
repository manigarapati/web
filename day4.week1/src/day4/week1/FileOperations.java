package day4.week1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOperations {
	FileWriter fw;
	FileReader fr;
	BufferedReader br;
	Scanner writeScanner = new Scanner(System.in);

	public void writeToFile() {

		try {
			fw = new FileWriter("D:\\output.txt", true);
			System.out.println("Enter a piece of Text:");
			String text = writeScanner.nextLine();
			fw.write(text);
			fw.write("\n"); // Add a newline for clarity in the file
			fw.flush();
		} catch (IOException e) {
			System.out.println("There was an error writing to the file: " + e.getMessage());
		}
		readFromFile();

	}

	public void readFromFile() {

		// TODO Auto-generated method stub
		try {
			fr = new FileReader("D:\\output.txt");
			br = new BufferedReader(fr);

			try {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error occured in reading the file" + e.getMessage());
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(" File could not be found or accessed." + e.getMessage());
		} finally {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		FileOperations f = new FileOperations();
		try {
			int choice = 1;
			boolean continueOperation = true;
			do {
				switch (choice) {
				case 1:
					f.writeToFile();
					break;
				case 2:
					continueOperation = false;
					break;
				default:
					System.err.println("Invalid choice. Please enter a valid numbers");
				}
				if (continueOperation) {
					System.out.println("Choose an operation:");
					System.out.println("1. Continue");
					System.out.println("2. Exit");
					System.out.print("Enter your choice: ");
					String value = s.next();
					if (value.equals("1")) {
						choice = 1;
					} else if (value.equals("2")) {
						choice = 2;
					} else {
						choice = 3;
					}
				}
			} while (continueOperation);
			System.out.println("Exiting the program.");
		} finally {
			try {
				f.writeScanner.close();
				s.close();
				if (f.fw != null) {
					f.fw.close();
					System.out.println("fileWriter closed Successfully !!");
				}
				if (f.fr != null) {
					f.fr.close();
					System.out.println("filereader closed successfully !!");
				}
				if (f.br != null) {
					f.br.close();
					System.out.println("reader closed successfully !!");
				}
				Files.delete(Paths.get("D:\\output.txt"));
				System.out.println("File deleted ");
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}

		}
	}

}
