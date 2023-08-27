package prepare.tutorials.thirtyDaysOfCode.day7_Arrays;

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
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		bufferedReader.close();

		StringBuilder result = new StringBuilder();
		for(int i=arr.size()-1; i>=0; i--) {
			result.append(arr.get(i));
			result.append(" ");
		}
		result.setLength(result.length()-1);
		System.out.println(result);
	}
}
