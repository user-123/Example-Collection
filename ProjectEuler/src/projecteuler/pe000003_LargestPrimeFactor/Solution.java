package projecteuler.pe000003_LargestPrimeFactor;

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
				long n = Long.parseLong(bufferedReader.readLine().trim());

				System.out.println(largestPrimeFactor(n));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}

	private static long largestPrimeFactor(long num) {
		long maxPrimeFactor=num;
		while(num%2==0) {num/=2;maxPrimeFactor=2;}
		for(long i=3; i<=Math.sqrt(num); i+=2) {
			while(num%i==0 && isPrime(i)) {maxPrimeFactor=i;num/=i;}
		}
		return isPrime(num) ? num : maxPrimeFactor;
	}

	private static boolean isPrime(long num) {
		if(num<2) {return false;}
		if(num%2==0) {return num==2;}
		for(long i=3; i<=Math.sqrt(num); i+=2) {
			if(num%i==0) {return false;}
		}
		return true;
	}
}
