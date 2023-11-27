package lc000377_CombinationSumIV;

public class Solution {

	public Solution() {}

	public int combinationSum4(int[] nums, int target) {
		//思路：想法與之前遇到的爬樓梯問題相似，
		//nums={1, 2, 3}, target=4 => 1+target=3 + 2+target=2 + 3+target=1
		//dp[0]=1, 到0的組合為1
		int[] dp = new int[target+1];
		dp[0]=1;
		for(int i=1; i<=target; i++) {
			for(int j=0; j<nums.length; j++) {
				dp[i] += nums[j]<=i ? dp[i-nums[j]] : 0;
			}
		}
		return dp[target];
	}

}
