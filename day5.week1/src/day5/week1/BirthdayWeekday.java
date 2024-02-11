package day5.week1;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthdayWeekday {
	public static void main(String[] args) {

		String dobString = "1998-08-08";
		LocalDate dob = LocalDate.parse(dobString);

		DayOfWeek dobDayOfWeek = dob.getDayOfWeek();
		System.out.println("Day of the week for birthdate: " + dobDayOfWeek);

		LocalDate today = LocalDate.now();
		LocalDate nextBirthday = dob.withYear(today.getYear());

		DayOfWeek nextBirthdayDayOfWeek = nextBirthday.getDayOfWeek();
		System.out.println("Next birthday falls on: " + nextBirthday.format(DateTimeFormatter.ofPattern("EEEE")));
		System.out.println("Next birthday date: " + nextBirthday);
	}
}
