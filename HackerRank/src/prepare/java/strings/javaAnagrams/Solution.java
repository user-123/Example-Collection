package prepare.java.strings.javaAnagrams;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}

	static boolean isAnagram(String a, String b) {
		// Complete the function

		//思路：會後將大小寫都計算到一起，最後只要有總和不等於0，代表兩個string不相同
		int[] usedCount = new int[128];
		char[] aCharArray=a.toCharArray(), bCharArray=b.toCharArray();
		for(char aChar : aCharArray) {
			usedCount[aChar]++;
		}
		for(char bChar : bCharArray) {
			usedCount[bChar]--;
		}
		for(int i=0; i<26; i++) {	//frequency
			if(usedCount[i+65]+usedCount[i+97]!=0) {return false;}
		}
		return true;
	}

	static boolean isAnagram2(String a, String b) {
		// Complete the function

		//思路：直接將大小寫都計算到一起，最後只要有element不等於0，代表兩個string不相同
		int[] usedCount = new int[26];
		char[] aCharArray=a.toCharArray(), bCharArray=b.toCharArray();
		for(char aChar : aCharArray) {
			usedCount[aChar-65>25 ? aChar-97 : aChar-65]++;
		}
		for(char bChar : bCharArray) {
			usedCount[bChar-65>25 ? bChar-97 : bChar-65]--;
		}
		for(int count : usedCount) {
			if(count!=0) {return false;}
		}
		return true;
	}
}