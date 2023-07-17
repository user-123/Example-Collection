package algorithm.sort;

import java.util.Arrays;

public class InsertionSort {	//插入排序(Insertion Sort)

	public InsertionSort() {}

	public static void main(String[] args) {
		System.out.println("=====執行開始=====");
		System.out.println("-----生成array-----");
		int quantity = (int) (Math.random()*(2000-1+1)+1);
		int[] input = new int[quantity];
		long numsMaximum = Integer.MAX_VALUE;
		long numsMinimum = Integer.MIN_VALUE;
		for(int i=0; i<quantity; i++) {
			input[i]=(int) (Math.random()*(numsMaximum-numsMinimum+1)+numsMinimum);
		}
		System.out.println(input);
		System.out.println("=====測試開始=====");
		test(input);
		System.out.println("=====測試結束=====");
		System.out.println(input);
		System.out.println("=====執行結束=====");
	}

	private static void test(int[] input) {
		System.out.println("輸入：" + Arrays.toString(input));
		long beginTime = System.currentTimeMillis();
		sort(input);
		//var output = sort(input);
		long endTime = System.currentTimeMillis();
		System.out.println("輸出：" + Arrays.toString(input));
		System.out.println();
		System.out.println("耗時：" + (endTime - beginTime) + "ms");
		System.out.println("--------------------");
	}

	public static void sort(int[] nums) {
		insertionSortByIterative(nums);
		return;
	}

	private static void insertionSortByIterative(int[] nums) {

	}

}
