package prepare.java.dataStructures.java1dArray;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class Solution {
	public static void main(String[] args) throws IOException {
		int[] array;
		try(Scanner scanner = new Scanner(System.in)) {
			int quantity=scanner.nextInt(), index=0;
			array = new int[quantity];
			while(quantity-- >0) {
				array[index++]=scanner.nextInt();
			}
		}
		for(int num : array) {
			System.out.println(num);
		}
	}
}
