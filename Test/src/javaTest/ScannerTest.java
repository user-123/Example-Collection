package javaTest;

import java.util.Scanner;

public class ScannerTest {

	public ScannerTest() {}

	public static void main(String[] args) {
		/* input
		12
		4.0
		is the best place to learn and practice coding!
		 */
		int i=4, i2;
        double d=4.0, d2=0.0;
        String s="HackerRank" , s2;
        System.out.print("請輸入：");
        try (Scanner scanner = new Scanner(System.in)) {
            i2 = scanner.nextInt();	//不會消耗該行末端換行
            d2 = scanner.nextDouble();	//不會消耗該行末端換行
            scanner.nextLine();	//
            s2 = scanner.nextLine();
            System.out.println((int) (i+i2));
            System.out.println(d+d2);
            System.out.printf("%s %s%n", s, s2);
            while(scanner.hasNext()) {
            	//do somethings
            }
        }
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		System.out.print("input = ");
		System.out.println(input);
		System.out.println("--------------------");
	}

}
