package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {	//選擇排序(Selection Sort)

	public SelectionSort() {}

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
		SelectionSort.test(input);
		System.out.println("=====測試結束=====");
		System.out.println(input);
		System.out.println("=====執行結束=====");
	}

	private static void test(int[] input) {
		System.out.println("輸入：" + Arrays.toString(input));
		long beginTime = System.currentTimeMillis();
		SelectionSort.sort(input);
		//var output = sort(input);
		long endTime = System.currentTimeMillis();
		System.out.println("輸出：" + Arrays.toString(input));
		System.out.println();
		System.out.println("耗時：" + (endTime - beginTime) + "ms");
		System.out.println("--------------------");
	}

	public static void sort(int[] nums) {
		selectionSortByIterative(nums);
		return;
	}

	private static void selectionSortByIterative(int[] nums) {
		int length = nums.length;
		for(int i=0;i<length-1; i++) {	//最後一項了不用比
			int minValueIndex=i;
			for(int j=i+1;j<length; j++) {	//自己跟自己不用比
				if(nums[j]<nums[minValueIndex]) {minValueIndex=j;}
			}
			if(minValueIndex!=i) {	//可以不用判斷
				int temp=nums[i];
				nums[i]=nums[minValueIndex];
				nums[minValueIndex]=temp;
			}
		}
	}

}
