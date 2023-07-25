package prepare.tutorials.thirtyDaysOfCode.day13_AbstractClasses;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		String title, author;
		int price;
		try (Scanner scanner = new Scanner(System.in)) {
			title=scanner.nextLine();
			author=scanner.nextLine();
			price=Integer.valueOf(scanner.nextLine());
        }
		MyBook myBook = new MyBook(title, author, price);
		System.out.println(myBook.display());
	}
}

class MyBook extends Book {

	MyBook(String title, String author, int price) {
		super(title, author, price);
	}

	@Override
	public String display() {
		String newLine=System.getProperty("line.separator");
		return "Title: " + title + newLine + "Author: " + author + newLine + "Price: " + price;
	}


}

abstract class Book {
	String title;
	String author;
	int price;

	Book(String title, String author, int price) {
		this.title=title;
		this.author=author;
		this.price=price;
	}

	abstract String display();
}