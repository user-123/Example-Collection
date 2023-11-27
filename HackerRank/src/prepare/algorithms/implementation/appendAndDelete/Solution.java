package prepare.algorithms.implementation.appendAndDelete;

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

class Result {

	/*
	 * Complete the 'appendAndDelete' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. STRING s
	 *  2. STRING t
	 *  3. INTEGER k
	 */

	public static String appendAndDelete(String s, String t, int k) {
		// Write your code here
		//思路：如果兩個string長度加起來小於k，那必定可以無痛轉換；如果從頭開始去掉重複的部份，剩下的部份小於k，且剩餘的步數(k-move)為偶數，可以利用刪一個加一個將剩餘的步數消耗完
		char[] sString=s.toCharArray(), tString=t.toCharArray();
		int pointer;
		for(pointer=0; pointer<Math.min(sString.length, tString.length); pointer++) {
			if(sString[pointer]!=tString[pointer]) {break;}
		}
		int move=(sString.length-pointer)+(tString.length-pointer);
		//return move<=k && ((k-move)%2==0 || (sString.length+tString.length)<=k) ? "Yes" : "No";
		return sString.length+tString.length<=k || move<=k && (k-move)%2==0 ? "Yes" : "No";
	}

	public static String appendAndDelete2(String s, String t, int k) {
		// Write your code here
		char[] sString=s.toCharArray(), tString=t.toCharArray();
		int move=sString.length+tString.length;
		for(int i=0; i<Math.min(sString.length, tString.length); i++) {
			if(sString[i]!=tString[i]) {break;}
			move-=2;
		}
		//return move<=k && ((k-move)%2==0 || (sString.length+tString.length)<=k) ? "Yes" : "No";
		return sString.length+tString.length<=k || move<=k && (k-move)%2==0 ? "Yes" : "No";
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = bufferedReader.readLine();

		String t = bufferedReader.readLine();

		int k = Integer.parseInt(bufferedReader.readLine().trim());

		String result = Result.appendAndDelete(s, t, k);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
