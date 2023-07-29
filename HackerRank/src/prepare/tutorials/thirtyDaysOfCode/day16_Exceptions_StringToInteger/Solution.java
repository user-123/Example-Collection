package prepare.tutorials.thirtyDaysOfCode.day16_Exceptions_StringToInteger;

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

		String S = bufferedReader.readLine();

		bufferedReader.close();


		try{
			int inputValue = Integer.parseInt(S);
			System.out.println(inputValue);
		}catch (NumberFormatException ex) {
			System.out.println("Bad String");
			//System.err.println("Bad String");
		}
	}
}
