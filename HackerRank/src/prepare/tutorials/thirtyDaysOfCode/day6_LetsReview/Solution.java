package prepare.tutorials.thirtyDaysOfCode.day6_LetsReview;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		try (Scanner scanner = new Scanner(System.in)) {
			int caseCount = Integer.valueOf(scanner.nextLine());
			while(scanner.hasNext()) {
				String input = scanner.nextLine();
				StringBuilder result = new StringBuilder(), EvenIndexSubString = new StringBuilder(), oddIndexSubString = new StringBuilder();
				for(int i=0; i<input.length(); i++) {
					if(i%2==0) {
						EvenIndexSubString.append(input.charAt(i));
					}else {
						oddIndexSubString.append(input.charAt(i));
					}
				}
				result.append(EvenIndexSubString);
				result.append(" ");
				result.append(oddIndexSubString);
				System.out.println(result);
			}
		}
	}
}
