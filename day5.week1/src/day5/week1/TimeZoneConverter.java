package day5.week1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {
	public static void main(String[] args) {
		String sourceTimeZone = "America/New_York";
		String targetTimeZone = "Asia/Kolkata";
		ZonedDateTime localDateTime = LocalDateTime.now().atZone(ZoneId.of("America/New_York"));
		String inputDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z"));

		ZonedDateTime targetZonedDateTime = localDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));

		String formattedTargetDateTime = targetZonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm z"));
		System.out.println("Source time in " + sourceTimeZone + " : " + inputDateTime);
		System.out.println("Converted time in " + targetTimeZone + ": " + formattedTargetDateTime);
	}
}