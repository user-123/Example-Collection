package prepare.tutorials.thirtyDaysOfCode.day4_ClassVsInstance;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try (Scanner scanner = new Scanner(System.in)) {
			int caseCount = Integer.valueOf(scanner.nextLine());
			while(scanner.hasNext()) {
				int input = Integer.valueOf(scanner.nextLine());
				Person person = new Person(input);
				person.amIOld();
				person.yearPasses(3);
				person.amIOld();
				if(scanner.hasNext()) {System.out.println();}
			}
		}
	}

}

class Person {

	private int age;

	public Person(int initialAge) {
		if(initialAge<0) {
			age=0;
			System.out.println("Age is not valid, setting age to 0.");
		}else {
			age=initialAge;
		}
	}

	void yearPasses(int year) {
		//for(int i=0; i<year; i++) {age++;}
		age+=year;
	}

	void amIOld() {
		String result = age<13 ? "You are young." : age<18 ? "You are a teenager." : "You are old.";
		System.out.println(result);
	}
}
