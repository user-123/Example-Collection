package algorithm.sort;

import java.util.Arrays;

public class QuickSort {	//快速排序(Quick Sort)

	public QuickSort() {}

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
		if(Math.random()<0.5) {
			System.out.println("使用sortRecursively");
			sortRecursively(nums);
		}else {
			System.out.println("使用sortIteratively");
			sortIteratively(nums);
		}
		return;
	}

	public static void sortRecursively(int[] nums) {
		quickSortByRecursive(nums, 0, nums.length - 1);
		return;
	}

	public static void sortIteratively(int[] nums) {
		if(nums.length==0 || nums.length==1) {return;}
		quickSortByIterative(nums, 0, nums.length - 1);
		return;
	}

	private static void quickSortByRecursive(int[] nums, int left, int right) {
		if(left<right) {
			int mid = partition(nums, left, right);
			quickSortByRecursive(nums, left, mid-1);
			quickSortByRecursive(nums, mid+1, right);
		}
	}

	private static void quickSortByIterative(int[] nums, int left, int right) {}

	private static int partition(int[] nums, int start, int end) {
		int left = start, right = end, pivot = (int) (Math.random()*nums.length);
		int pivotValue = nums[pivot];

		while(left<right) {
			while(left<right && nums[right]>=pivotValue) {right--;}
			while(left<right && nums[left]<=pivotValue) {left++;}
			if(left!=right) {swap(nums, left, right);}
		}
		swap(nums, start, left);	//swap(nums, start, right);
		return left;	//return right;
	}

	//private static void partition2(int[] nums, int left, int right) {}

	//private static void partition3(int[] nums, int left, int right) {}

	private static void swap(int[] nums, int left, int right) {
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

}
