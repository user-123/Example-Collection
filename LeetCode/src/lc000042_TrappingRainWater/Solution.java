package lc000042_TrappingRainWater;

public class Solution {

	public Solution() {}

	public int trap(int[] height) {
		//思路：總是從比較低的那邊算起，因為水位最高也不會高過較低那邊的高度
		//例子：[2, 1, 3]最高只能存1的水，而不是2或3
		if(height==null || height.length==0 || height.length==1 || height.length==2) {return 0;}	//if(height==null || height.length==0) {return 0;}
		int totalWater=0, left=0, right=height.length-1, maxLeftHeight=0, maxRightHeight=0;
		while(left<right) {
			if(height[left]<height[right]) {
				if(height[left]>=maxLeftHeight) {	//if(height[left]>maxLeftHeight) {
					maxLeftHeight=height[left];
				}else {
					totalWater+=maxLeftHeight-height[left];
				}
				left++;
			}else {
				if(height[right]>=maxRightHeight) {	//if(height[right]>maxRightHeight) {
					maxRightHeight=height[right];
				}else {
					totalWater+=maxRightHeight-height[right];
				}
				right--;
			}
		}
		return totalWater;
	}

}
