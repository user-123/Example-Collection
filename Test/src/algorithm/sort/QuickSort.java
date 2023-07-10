package algorithm.sort;

public class QuickSort {	//快速排序(Quick Sort)

	public QuickSort() {}

	public static void main(String[] args) {
		System.out.println("=====執行開始=====");
		int[] input = new int[0];
		System.out.println(input);
		System.out.println("=====測試開始=====");
		QuickSort.test(input);
		System.out.println("=====測試結束=====");
		System.out.println(input);
		System.out.println("=====執行結束=====");
	}

	private static <T> void test(T input) {
		System.out.println("輸入：" + input);
		long beginTime = System.currentTimeMillis();
		var output = sortIteratively(input);
		long endTime = System.currentTimeMillis();
		//System.out.println(input + ":	output=" + output);
		System.out.println("輸出：" + output);
		System.out.println();
		System.out.println("耗時：" + (endTime - beginTime) + "ms");
		System.out.println("--------------------");
	}

	private static void sort() {}

	public static void sortRecursively(int[] nums) {
		sortByRecursive(nums, 0, nums.length - 1);
		return;
	}

	public static void sortIteratively(int[] nums) {
		if(nums.length==0 || nums.length==1) {return;}
		sortByIterative(nums, 0, nums.length - 1);
		return;
	}

	private static void sortByRecursive(int[] nums, int left, int right) {

	}

	private static void sortByIterative(int[] nums, int left, int right) {}

	private static void partition(int[] nums, int left, int right) {
		int pivot = nums[(int) (Math.random()*nums.length)];
	}

	//private static void partition2(int[] nums, int left, int right) {}

	//private static void partition3(int[] nums, int left, int right) {}

	private static void swap(int[] nums, int left, int right) {
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}

}
