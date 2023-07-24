package lc000033_SearchInRotatedSortedArray;

public class Solution {

	public Solution() {}

	public int search(int[] nums, int target) {
		//思路：使用雙指針，然後判斷target是在左半邊還是右半邊(常規的binary search再加上變體的判斷)
		int low=0, high=nums.length-1;
		while(low<=high) {
			int middle=(low+high)/2;
			if(target==nums[middle]) {return middle;}
			if(nums[middle]<nums[low]) {	//6,7,0,1,2,3,4,5
				if(target<nums[middle] || target>=nums[low]) {
					high=middle-1;
				}else {
					low=middle+1;
				}
			}else {	//2,3,4,5,6,7,0,1
				if(target>nums[middle] || target<nums[low]) {
					low=middle+1;
				}else {
					high=middle-1;
				}
			}
		}
		return -1;
	}

	public int search__(int[] nums, int target) {
		//思路：
		int low=0, high=nums.length;
		while(low<high) {
			int middle=(low+high)/2;
			double num = (nums[middle]<nums[0] == target<nums[0]) ? nums[middle] : target<nums[0] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
			if(num<target) {
				low=middle+1;
			}else if(num>target) {
				high=middle;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public int search_(int[] nums, int target) {
		//思路：
		int low=0, high=nums.length-1;
		while(low<=high) {
			int middle=(low+high)/2;
			double num = (nums[middle]<nums[0] == target<nums[0]) ? nums[middle] : target<nums[0] ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
			if(num<target) {
				low=middle+1;
			}else if(num>target) {
				high=middle-1;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public int search_2(int[] nums, int target) {
		//思路：
		int low=0, high=nums.length;
		while(low<high) {
			int middle=(low+high)/2;
			double num;
			if(nums[middle]<nums[0] == target<nums[0]) {	//代表target在右半邊或坐半邊
				num=nums[middle];
			}else {	//代表target在nums[0]~nums[middle]或nums[middle]~nums[high]之間
				if(target<nums[0]) {
					num=Double.NEGATIVE_INFINITY;
				}else {
					num=Double.POSITIVE_INFINITY;
				}
			}
			if(num<target) {
				low=middle+1;
			}else if(num>target) {
				high=middle;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public int search_3(int[] nums, int target) {
		//思路：
		int low=0, high=nums.length;
		while(low<high) {
			int middle=(low+high)/2;
			double num;
			if(nums[middle]<nums[0] == target<nums[0]) {
				num=nums[middle];
			}else {
				if(target<nums[0]) {
					num=Double.NEGATIVE_INFINITY;
				}else {
					num=Double.POSITIVE_INFINITY;
				}
			}
			if(num<target) {
				low=middle+1;
			}else if(num>target) {
				high=middle;
			}else {
				return middle;
			}
		}
		return -1;
	}

	public int search999999(int[] nums, int target) {
		//待完成
		int start=0, end=nums.length-1, pivot=start+(end-start)/2;
		while(start<end) {
			pivot=start+(end-start)/2;
			if(nums[end]<nums[pivot]) {start=pivot+1;continue;}
			if(nums[end]>=nums[pivot]) {end=pivot-1;continue;}
			//if(nums[start]<nums[pivot]) {start=pivot+1;continue;}
		}
		if(pivot>0) {
			start=pivot;
			end=pivot-1;
		}else {
			start=0;
			end=nums.length-1;
		}
		//binary search
		// TODO


		return -1;
	}

}
