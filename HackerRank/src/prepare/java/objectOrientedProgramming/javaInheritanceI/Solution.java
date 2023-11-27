package prepare.java.objectOrientedProgramming.javaInheritanceI;

import java.io.*;
import java.util.*;

class Animal {
	void walk() {
		System.out.println("I am walking");
	}
}

class Bird extends Animal {
	void fly() {
		System.out.println("I am flying");
	}

	void sing() {
		System.out.println("I am singing");
	}
}

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Bird bird = new Bird();
		bird.walk();
		bird.fly();
		bird.sing();
	}
}