package prepare.java.objectOrientedProgramming.javaInheritanceII;

import java.io.*;
import java.util.*;

//Write your code here
class Adder extends Arithmetic {

	public Adder() {
		super();
	}

}

class Arithmetic{

	protected Arithmetic() {}

	protected int add(int num1, int num2) {
		return num1+num2;
	}

}

public class Solution {
	public static void main(String []args) {
		// Create a new Adder object
		Adder a = new Adder();

		// Print the name of the superclass on a new line
		System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

		// Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
		System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
	}
}