package prepare.java.strings.javaSubstringComparisons;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String s;
		int k;
		try(Scanner scanner = new Scanner(System.in)) {
			s=scanner.nextLine();
			k=scanner.nextInt();
		}
		System.out.println(getSmallestAndLargest(s, k));
	}

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length 'k'
		// 'largest' must be the lexicographically largest substring of length 'k'

		char[] sCharArray = s.toCharArray();
		/*
		int least=0, greatest=0;
		for(int i=0; i<=sCharArray.length-1-k+1; i++) {
			least = sCharArray[i]<sCharArray[least] ? i : least;
			greatest = sCharArray[i]>sCharArray[greatest] ? i : greatest;
		}
		smallest=s.substring(least, least+3);
		largest=s.substring(greatest, greatest+3);
		*/
		String[] subStrings = new String[s.length()-k+1];
		for(int i=0; i<=sCharArray.length-1-k+1; i++) {
			subStrings[i]=s.substring(i, i+k);
		}
		Arrays.sort(subStrings);
		smallest=subStrings[0];
		largest=subStrings[subStrings.length-1];

		return smallest + "\n" + largest;
	}
}