package prepare.tutorials.thirtyDaysOfCode.day26_NestedLogic;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		LocalDate returnDate, exceptDate;	//except/due date
		try (Scanner scanner = new Scanner(System.in)) {
			returnDate=readDate(scanner);
			exceptDate=readDate(scanner);
		}
		int fine;
		if(!returnDate.isAfter(exceptDate)) {
			fine=0;
		}else if(returnDate.getMonth()==exceptDate.getMonth() && returnDate.getYear()==exceptDate.getYear()) {
			fine=(returnDate.getDayOfMonth()-exceptDate.getDayOfMonth())*15;
		}else if(returnDate.getYear()==exceptDate.getYear()) {
			fine=(returnDate.getMonthValue()-exceptDate.getMonthValue())*500;
		}else {
			fine=10000;
		}
		System.out.println(fine);
	}

	private static LocalDate readDate(Scanner scanner) {
		int day=scanner.nextInt(), month=scanner.nextInt(), year=scanner.nextInt();
		return LocalDate.of(year, month, day);
	}
}