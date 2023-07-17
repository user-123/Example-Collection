package javaTest;

import java.text.DecimalFormat;

public class DecimalTest {

	public DecimalTest() {}

	public static void main(String[] args) {
		double random = Math.random();
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println(random);
		System.out.println(df.format(random));
		System.out.println(df.format(1/3));	//0.000000
	}

}
