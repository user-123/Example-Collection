package projecteuler.pe000001_MultiplesOf3And5;

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

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				//long m=n;
				//long multipleOf3Sum=(3+(m-1)/3*3) * ((m-1)/3) /2;
				//long multipleOf5Sum=(5+(m-1)/5*5) * ((m-1)/5) /2;
				//long multipleOf15Sum=(15+(m-1)/15*15) * ((m-1)/15) /2;
				long multipleOf3Sum=sumOfmultiples(n, 3);
				long multipleOf5Sum=sumOfmultiples(n, 5);
				long multipleOf15Sum=sumOfmultiples(n, 3*5);
				System.out.println(multipleOf3Sum+multipleOf5Sum-multipleOf15Sum);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

	private static long sumOfmultiples (long n, int m) {
		return (m+(n-1)/m*m) * ((n-1)/m) /2;
	}

}
