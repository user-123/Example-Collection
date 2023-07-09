package lc000189_RotateArray;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public void rotate(int[] nums, int k) {
		if(k>=nums.length) {
			k%=nums.length;
		}
		if(k==0) {return;}
		//if((k%=nums.length)==0) {return;}	//上面兩個判斷更精練的寫法

		int[] temp = new int[k];
		/* 不好的寫法
		for(int i=nums.length-k+1-1; i<nums.length; i++) {
			temp[i-nums.length+k]=nums[nums.length-k+1-1+i];
		}
		*/
		for(int i=0; i<k; i++) {
			temp[i]=nums[nums.length-k+1-1+i];
		}
		for(int i=nums.length-1; i>=k; i--) {
			nums[i]=nums[i-k];
		}
		for(int i=0; i<k; i++) {
			nums[i]=temp[i];
		}

		return;
	}

	public void rotate2(int[] nums, int k) {
		//未完成，搭配pointer和reversePartOfArray，先完成分段反轉，再全體反轉
		if((k%=nums.length)==0) {return;}
		int grabPointer = nums.length-k-1, putPointer=k+1-1, temp; //, numsQuantity=nums.length
		for(int i=0; i<grabPointer; i++) {
			//Input: nums = [1,2,3,   4   ,5,6,7], k = 3
			//Output: [5,6,7,1,2,3,4]
			temp=nums[putPointer];
			nums[putPointer]=nums[i];
		}
		return;
	}

	private void reversePartOfArray(int[] nums, int leftPointer, int rightPointer) {
		return;
	}

	public void rotate3(int[] nums, int k) {
		//有bug，雖然可行，但有許多邊界問題需要處理，棄用
		if((k%=nums.length)==0) {return;}
		int temp;
		for(int i=0; i<k; i++) {
			//Input: nums = [1,2,3,   4   ,5,6,7], k = 3
			//Output: [5,6,7,1,2,3,4]
			if(i+k>=nums.length) {break;}
			temp=nums[nums.length-(k-i)+1-1];
			nums[nums.length-(k-i)+1-1]=nums[(i+k)%nums.length];
			nums[(i+k)%nums.length]=nums[i];
			nums[i]=temp;
			System.out.println(Arrays.toString(nums));
		}
		return;
	}

}
