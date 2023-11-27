package prepare.java.dataStructures.javaHashset;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		int quantity;
		Set<String> set = new HashSet<>();
		try(Scanner scanner = new Scanner(System.in)) {
			quantity=scanner.nextInt();
			scanner.nextLine();
			while(quantity-- >0) {
				set.add(scanner.nextLine());
				System.out.println(set.size());
			}
		}
	}
}