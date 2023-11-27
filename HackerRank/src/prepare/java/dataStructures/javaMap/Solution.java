package prepare.java.dataStructures.javaMap;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Map<String, String> phoneBook;
		try(Scanner scanner = new Scanner(System.in)) {
			int entryCount = scanner.nextInt();
			phoneBook = new HashMap<>(entryCount);
			scanner.nextLine();
			for(int i=0; i<entryCount; i++) {
				phoneBook.put(scanner.nextLine(), scanner.nextLine());
			}
			while(scanner.hasNext()) {
				String name=scanner.nextLine(), phoneNum=phoneBook.get(name);
				System.out.println(phoneNum!=null ? name+"="+phoneNum : "Not found");
				//System.out.println(phoneBook.getOrDefault(scanner.nextLine(), "Not found"));
			}
		}
	}
}