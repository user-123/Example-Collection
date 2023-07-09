package lc000000_Template;

import java.util.Arrays;
import java.util.List;

public class Main {

	public Main() {}

	public static void main(String[] args) {
		Integer[] testArray = {1, 2, 3, null, 5, 6, 7, 8};
		System.out.println(Arrays.toString(testArray));

		ClassType testTree = new ClassType();
		int testArrayLength = testArray.length;
		int testTreeLayer = (int) Math.ceil(Math.log(testArrayLength+1)/Math.log(2));
		int testTreeLayer2 = (int) Math.ceil(Math.log1p(testArrayLength)/Math.log(2));
		//使用2進制算長度，假設一個數為2的整數冪，則這個數在2進制中表現形式必須為1、10、100、1000、10000、100000、……的形式
		int testTreeLayer3 = (int) (Integer.toBinaryString(testArrayLength+1).length()-1 + Math.ceil((testArrayLength+1)/Math.pow(2, (Integer.toBinaryString(testArrayLength+1).length()-1))-1));
		System.out.println(testArrayLength);
		System.out.println(testTreeLayer);
		System.out.println(testTreeLayer2);
		System.out.println(testTreeLayer3);
		while(testArrayLength==1/*****還要改*****/ ) {}



		for (int testTreeElement=(testArray.length-1)-1; testTreeElement>=0; testTreeElement--) {
			ClassType newTestTree = new ClassType(testTreeElement);
			testTree = newTestTree;
		}
		System.out.println(testTree);
		Main.test(testTree);
	}
	private static void test(ClassType input) {
		System.out.println("輸入：" + input);
		var solution = new Solution();
		long beginTime = System.currentTimeMillis();
		var output = solution.XXXXX(input);
		long endTime = System.currentTimeMillis();
		//System.out.println(input + ":	output=" + output);
		System.out.println("輸出：" + output);
		System.out.println();
		System.out.println("耗時：" + (endTime - beginTime) + "ms");
		System.out.println("--------------------");
		if(SolutionCheck.XXXXX(input) != output) {
			System.out.println("------結果錯誤------");
		}else {
			System.out.println("------結果正確------");
		}
		System.out.println("--------------------");
	}

}
