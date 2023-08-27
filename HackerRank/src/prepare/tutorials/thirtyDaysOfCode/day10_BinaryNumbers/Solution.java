package prepare.tutorials.thirtyDaysOfCode.day10_BinaryNumbers;

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

		bufferedReader.close();


		int count = 0, maxCount=0;
		while(n!=0) {
			int bitDigit=n&1;
			if(bitDigit==1) {
				count+=n&1;
			}else {
				maxCount=Math.max(count, maxCount);
				count=0;
			}
			n=n>>>1;
		}
		maxCount=Math.max(count, maxCount);
		System.out.println(maxCount);
	}
}
