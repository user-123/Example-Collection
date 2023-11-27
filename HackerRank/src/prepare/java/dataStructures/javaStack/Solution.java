package prepare.java.dataStructures.javaStack;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		List<String> inputs = new ArrayList<>();
		try(Scanner scanner = new Scanner(System.in)) {
			while(scanner.hasNext()) {
				inputs.add(scanner.nextLine());
			}
		}catch(Exception ex) {System.out.println(ex);}
		for(String input : inputs) {
			System.out.println(isBalanced(input));
		}
	}

	private static boolean isBalanced(String input) {
		if(input==null || input.length()==0) {return true;}
		char[] charArray = input.toCharArray();
		Deque<Character> stack = new ArrayDeque<>(input.length());
		for(char character : charArray) {
			if(character=='(' || character=='[' || character=='{') {
				stack.push(character);
				continue;
			}
			Character element = stack.peek();
			//if(character==')' && (element==null || element!='(') || character==']' && (element==null || element!='[') || character=='}' && (element==null || element!='{')) {return false;}
			if(element==null || character==')' && element!='(' || character==']' && element!='[' || character=='}' && element!='{') {return false;}
			stack.pop();	//stack.pollFirst();
		}
		return stack.isEmpty();
	}
}