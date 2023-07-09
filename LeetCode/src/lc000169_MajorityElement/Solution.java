package lc000169_MajorityElement;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int majorityElement(int[] nums) {
		//博耶-摩爾多數投票算法(Boyer–Moore majority vote algorithm)
		int counter=1, element=nums[0];
		for(int i=1; i<nums.length; i++) {
			if(counter==0 && nums[i]!=element) {
				element=nums[i];
				counter++;
			}else if(nums[i]==element) {
				counter++;
			}else if(nums[i]!=element) {
				counter--;
			}
		}
		return element;
	}

	public int majorityElement2(int[] nums) {
		//多數投票算法 再精煉
		int counter=1, element=nums[0];
		for(int i=1; i<nums.length; i++) {
			if(nums[i]==element) {
				counter++;
			}else if(counter>0) {
				counter--;
			}else {
				element=nums[i];
				counter++;
			}
		}
		return element;
	}

	public int majorityElement3(int[] nums) {
		Arrays.sort(nums);
		return nums[(nums.length+1)/2-1];
	}

}
