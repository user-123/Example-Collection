package prepare.java.introduction.javaCurrencyFormatter;

import java.io.*;
import java.text.NumberFormat;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		double payment;
		try(Scanner scanner = new Scanner(System.in)) {
			payment=scanner.nextDouble();
		}
		printFormattedCurrency(payment);
	}

	private static void printFormattedCurrency(double payment) {
		//NumberFormat formattedCurrency = NumberFormat.getCurrencyInstance();
		System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
		NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(Locale.of("en","IN"));	//new Locale("en","IN")	//舊的Locale()已棄用，java19以後棄用Locale建構子，改為使用Locale.of()產生實例
		indiaFormat.setCurrency(Currency.getInstance("INR"));
		System.out.println("India: " + indiaFormat.format(payment));	//題目有問題，已知java15會輸出"₹"(印度盧比符號)，與題目期望不符；java8會輸出"Rs."
		System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));	//題目有問題，已知java15輸出的符號為半形"¥"，與題目期望不符；java8輸出為全形"￥"
		System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
	}
}