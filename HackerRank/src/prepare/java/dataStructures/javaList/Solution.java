package prepare.java.dataStructures.javaList;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		List<Integer> list = new ArrayList<>();
		try(Scanner scanner = new Scanner(System.in)) {
			int quantity=scanner.nextInt();
			while(quantity-- >0) {
				list.add(scanner.nextInt());
			}
			quantity=scanner.nextInt();
			while(quantity-- >0) {
				scanner.nextLine();
				String command = scanner.nextLine();
				if(command.equals("Insert")) {
					list.add(scanner.nextInt(), scanner.nextInt());
				}
				if(command.equals("Delete")) {
					list.remove(scanner.nextInt());
				}
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int element : list) {
			stringBuilder.append(element).append(" ");
		}
		stringBuilder.setLength(stringBuilder.length()-1);
		System.out.println(stringBuilder);
	}
}