package javaTest;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class DecimalTest {

	public DecimalTest() {}

	public static void main(String[] args) {
		double random = Math.random();
		DecimalFormat df = new DecimalFormat("0.000000");	//會補0
		df.setRoundingMode(RoundingMode.HALF_UP);	//預設為RoundingMode.HALF_UP
		DecimalFormat df2 = new DecimalFormat("#.######");	//不補0
		NumberFormat df3 = new DecimalFormat("0.00");
		NumberFormat df4 = new DecimalFormat("#.##");
		System.out.println(random);
		System.out.println(df.format(random));
		System.out.println(df.format(1/3));	//0.000000


	}

}
