package javaTest;

import java.util.StringTokenizer;

public class StringTokenizerTest {

	public StringTokenizerTest() {}

	public static void main(String[] args) {
		System.out.println("-----st1-----");
		//StringTokenizer st1 = new StringTokenizer(null);	//不能放null
		//while(st1.hasMoreTokens()) {System.out.println(st1.nextToken());}
		System.out.println("-----st2-----");
		StringTokenizer st2 = new StringTokenizer("");
		while(st2.hasMoreTokens()) {System.out.println(st2.nextToken());}	//如果沒有nextToken了，執行了nextToken()會報錯，所以凡事必須用hasMoreTokens()檢查

		System.out.println("-----st3-----");
		StringTokenizer st3 = new StringTokenizer("Hello Runoob How are you");
		while(st3.hasMoreTokens()) {System.out.println(st3.nextToken());}
		System.out.println("-----st3_-----");
		StringTokenizer st3_ = new StringTokenizer("Hello Runoob How are you", " ");
		while(st3_.hasMoreTokens()) {System.out.println(st3_.nextToken());}
		System.out.println("-----st4-----");
		StringTokenizer st4 = new StringTokenizer("JAVA : Code : String", " :");
		while(st4.hasMoreTokens()) {System.out.println(st4.nextToken());}
		System.out.println("-----st5-----");
		StringTokenizer st5 = new StringTokenizer("JAVA : Code : String", " :",  true);
		while(st5.hasMoreTokens()) {System.out.println(st5.nextToken());}
	}

}
