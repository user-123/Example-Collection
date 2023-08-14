package javaTest;

public class StringTest {

	public StringTest() {}

	public static void main(String[] args) {
		//String.concat
		String string = "abc";
		System.out.println(string);
		string=string.concat("123");
		System.out.println(string);
		string=string.concat(string);
		System.out.println(string);
	}

}
