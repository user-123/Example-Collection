package prepare.tutorials.thirtyDaysOfCode.day8_DictionariesAndMaps;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Map<String, String> phoneBook = new HashMap<>();
		try (Scanner scanner = new Scanner(System.in)) {
			int caseCount = Integer.valueOf(scanner.nextLine());
			for(int i=0; i<caseCount; i++) {
				String name = scanner.next();
				String phoneNumber = scanner.next();
				phoneBook.put(name, phoneNumber);
				scanner.nextLine();
			}
			while(scanner.hasNext()) {
				String name = scanner.nextLine();
				String phoneNumber = phoneBook.get(name);
				System.out.println(phoneNumber!=null ? name+"="+phoneNumber : "Not found");
			}
		}
	}
}
