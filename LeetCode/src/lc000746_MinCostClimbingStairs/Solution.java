package lc000746_MinCostClimbingStairs;

public class Solution {	//學習：https://leetcode.com/problems/min-cost-climbing-stairs/solutions/476388/4-ways-step-by-step-from-recursion-top-down-dp-bottom-up-dp-fine-tuning/?envType=daily-question&envId=2023-10-13

	public Solution() {}

	public int minCostClimbingStairs(int[] cost) {
		//思路：一點一點的迭代，取較小的cost記錄
		int[] result = new int[cost.length];
		result[0]=cost[0];
		result[1]=cost[1];
		for(int i=2; i<result.length; i++) {
			result[i] += cost[i] + (result[i-2]<result[i-1] ? result[i-2] : result[i-1]);
		}
		return result[result.length-2]<result[result.length-1] ? result[result.length-2] : result[result.length-1];
	}

	public int minCostClimbingStairs2(int[] cost) {
		//思路：前一個優化版，直接對cost in-place記錄
		for(int i=2; i<cost.length; i++) {
			cost[i] += (cost[i-2]<cost[i-1] ? cost[i-2] : cost[i-1]);
		}
		return cost[cost.length-2]<cost[cost.length-1] ? cost[cost.length-2] : cost[cost.length-1];
	}

}
