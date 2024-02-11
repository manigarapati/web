package day5.week1;

import java.time.LocalDate;
import java.time.Period;

public class DateDifference {
    public static void main(String[] args) {
        
        LocalDate date1 = LocalDate.of(2023, 4, 15);
        LocalDate date2 = LocalDate.now();
        
        
        Period period = Period.between(date1, date2);
        
       
        System.out.println("Difference between the dates:");
        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
    }
}
