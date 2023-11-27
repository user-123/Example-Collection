package prepare.java.dataStructures.javaArraylist;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		List<List<Integer>> arraysList;
		try(Scanner scanner = new Scanner(System.in)) {
			int size = scanner.nextInt();
			arraysList = new ArrayList<>(size);
			for(int i=0; i<size; i++) {
				int length = scanner.nextInt();
				List<Integer> array = new ArrayList<>(length);
				for(int j=0; j<length; j++) {
					array.add(scanner.nextInt());
				}
				arraysList.add(array);
			}

			int caseQuantity = scanner.nextInt();
			for(int k=0; k<caseQuantity; k++) {
				try {
					System.out.println(arraysList.get(scanner.nextInt()-1).get(scanner.nextInt()-1));
				}catch(IndexOutOfBoundsException ex) {
					System.out.println("ERROR!");
				}
			}
		}
	}
}