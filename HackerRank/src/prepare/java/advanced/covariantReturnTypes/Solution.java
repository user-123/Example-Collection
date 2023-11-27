package prepare.java.advanced.covariantReturnTypes;

import java.io.*;
import java.util.*;

//Complete the classes below
class Flower {
	String whatsYourName() {
		return "I have many names and types.";
	}
}

class Jasmine extends Flower {
	@Override
	String whatsYourName() {
		return "Jasmine";
	}
}

class Lotus extends Flower {
	@Override
	String whatsYourName() {
		return "Lotus";
	}
}

class Lily extends Flower {
	@Override
	String whatsYourName() {
		return "Lily";
	}
}

class Region {
	Flower yourNationalFlower() {
		return new Flower();
	}
}

class WestBengal extends Region {
	@Override
	Flower yourNationalFlower() {
		return new Jasmine();
	}
}

class Karnataka extends Region {
	@Override
	Flower yourNationalFlower() {
		return new Lotus();
	}
}

class AndhraPradesh extends Region {
	@Override
	Flower yourNationalFlower() {
		return new Lily();
	}
}

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try{
			s = reader.readLine().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Region region = null;
		switch(s) {
			case "WestBengal":
				region = new WestBengal();
				break;
			case "Karnataka":
				region = new Karnataka();
				break;
			case "AndhraPradesh":
				region = new AndhraPradesh();
				break;
		}
		Flower flower = region.yourNationalFlower();
		System.out.println(flower.whatsYourName());
	}
}