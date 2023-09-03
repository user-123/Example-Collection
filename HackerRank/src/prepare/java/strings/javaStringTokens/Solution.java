package prepare.java.strings.javaStringTokens;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String input;
		try(Scanner scanner = new Scanner(System.in)) {
			input=scanner.nextLine();
		}
		printStringTokens(input);
	}

	private static void printStringTokens(String string) {
		String[] tokens = string.split("[\\s?!._,@?']+");	//這段regex的意思是括號內的元素只要出現1次或以上的時候要被切掉，所以可以切得很乾淨
		/*	這個解法有漏洞(錯誤)，就是沒考慮如果頭或尾被切的話在會多出""的切片
		System.out.println(tokens.length);
		for(String token : tokens) {
			if(!token.isBlank()) {System.out.println(token);}
		}
		*/
		/*	將所有結果加到list，即可確保沒有""，但其實只要考慮頭尾問題即可
		List<String> list = new ArrayList<>(tokens.length);
		for(String token : tokens) {
			if(!token.isBlank()) {list.add(token);}	//if(!token.isEmpty()) {list.add(token);}
		}
		System.out.println(list.size());
		for(String element : list) {
			System.out.println(element);
		}
		*/
		//這個解法最理想，排除掉切片array長度為0或長度為1但其唯一元素為""的情況，剩下就只要考慮頭尾""的問題就行
		int n=tokens.length;
		if(n==0 || n==1 && tokens[0].isBlank()) {System.out.println(0);return;}
		n = tokens[0].isBlank() ? n-1 : n;
		n = tokens[tokens.length-1].isBlank() ? n-1 : n;
		System.out.println(n);
		for(String token : tokens) {
			if(!token.isBlank()) {System.out.println(token);}
		}
	}
}