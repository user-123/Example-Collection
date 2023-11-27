package prepare.java.advanced.javaSingletonPattern;

import java.io.*;
import java.util.*;

enum Singleton {
	singleInstance;

	String str;

	private Singleton() {}

	static Singleton getSingleInstance() {
		return singleInstance;
	}

	void setSingleton(String string) {
		this.str=string;
		//System.out.printf("Hello I am a singleton! Let me say %s to you", string);
		//this.toString();
	}

	@Override
	public String toString() {
		return String.format("Hello I am a singleton! Let me say %s to you", this.str);
	}
}

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String input;
		try(Scanner scanner = new Scanner(System.in)) {
			input = scanner.nextLine();
		}
		Singleton singleton = Singleton.getSingleInstance();
		singleton.setSingleton(input);
		System.out.println(singleton);
	}
}