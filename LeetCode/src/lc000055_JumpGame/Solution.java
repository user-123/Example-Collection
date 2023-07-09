package lc000055_JumpGame;

public class Solution {

	public Solution() {}

	public boolean canJump(int[] nums) {
		//if(nums.length<=1) {return true;}
		//使用貪婪，是否有例外??
		//[3,4,3,2,5,0,7]
		int maxReach = 0;
		for(int i=0; i<=maxReach; i++) {
			maxReach=Math.max(maxReach, i+nums[i]);
			if(maxReach>=nums.length-1) {
				return true;
			}
		}
		return false;
	}

}
