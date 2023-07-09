package lc000283_MoveZeroes;

public class Solution {

	public Solution() {}

	public void moveZeroes(int[] nums) {
		//快指針找到非0的項，然後寫到慢指針為0的位置
		int nonZeroPointer = 0;
		for(int i=0; i<nums.length; i++) {
			while(nonZeroPointer<nums.length && (nums[nonZeroPointer]==0 || nonZeroPointer<=i)) {nonZeroPointer++;}
			if(nonZeroPointer==nums.length) {break;}
			if(nums[i]==0) {
				nums[i]=nums[nonZeroPointer];
				nums[nonZeroPointer]=0;
			}
		}
		return;
	}

	public void moveZeroes2(int[] nums) {
		//快指針找到非0的項，然後依序寫入
		int insertPosition = 0;
		for(int num : nums) {
			if(num!=0) {nums[insertPosition++]=num;}
		}
		while(insertPosition<nums.length) {
			nums[insertPosition++]=0;
		}
		return;
	}

}
