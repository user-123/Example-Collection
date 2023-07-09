package lc000045_JumpGameII;

public class Solution {

	public Solution() {}

	public int jump(int[] nums) {
		//貪婪法改試試
		//[2, 3, 1, 1, 4]
		if(nums.length==1) {return 0;}
		int currentMaxReach = 0, maxReach = 0, count = 0;
		for(int i=0; i<=currentMaxReach; i++) {
			maxReach=Math.max(maxReach, i+nums[i]);
			if(currentMaxReach==i) {
				count++;
				currentMaxReach=maxReach;
			}
			if(currentMaxReach>=nums.length-1) {
				break;
			}
		}
		return count;
	}

	public boolean jump2(int[] nums) {
		//Implicit BFS

		return false;
	}

}
