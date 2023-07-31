package prepare.tutorials.thirtyDaysOfCode.day18_QueuesAndStacks;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String input;
		try (Scanner scanner = new Scanner(System.in)) {
			input=scanner.nextLine();
        }
		Solution sol =new Solution();
		for(char character : input.toCharArray()) {
			sol.pushCharacter(character);
			sol.enqueueCharacter(character);
		}
		boolean isPalindrome=true;
		for(int i=0; i<(input.length()+1)/2; i++) {
			if(sol.popCharacter()!=sol.dequeueCharacter()) {isPalindrome=false;break;}
		}
		System.out.println("The word, " + input + ", is " + (isPalindrome ? "" : "not ") + "a palindrome.");
	}

	private Deque<Character> stack = new ArrayDeque<>();
	private Queue<Character> queue = new ArrayDeque<>();

	private void pushCharacter(char ch) {
		stack.push(ch);
	}
	private char popCharacter() {
		return !stack.isEmpty() ? stack.pop() : 0;
	}
	private void enqueueCharacter(char ch) {
		queue.offer(ch);
	}
	private char dequeueCharacter() {
		return !queue.isEmpty() ? queue.poll() : 0;
	}
}