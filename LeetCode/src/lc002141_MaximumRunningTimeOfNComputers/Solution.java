package lc002141_MaximumRunningTimeOfNComputers;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public long maxRunTime(int n, int[] batteries) {
		//思路：假設能完美平均的使用並耗盡每顆電池，則能得到最長時間；將電池按電量排序，依反序檢查，若是電池能讓一台電腦持續運行到maxTime，則繼續檢查，直到遇到無法達成的電池，則它的使用時間就是maxTime
		Arrays.sort(batteries);
		int batteryQuantity=batteries.length;
		if(batteryQuantity==n) {
			return batteries[0];
		}
		long maxEnergy=0, maxTime;
		for(int battery : batteries) {
			maxEnergy+=battery;
		}
		maxTime=maxEnergy/n;
		int computerCount=0;
		while(batteries[batteryQuantity-1-computerCount]>maxTime) {
			maxEnergy-=batteries[batteryQuantity-1-computerCount++];
			maxTime=maxEnergy/(n-computerCount);
		}
		return maxTime;
	}

	public long maxRunTime2(int n, int[] batteries) {
		//思路：觀察前一算法邏輯，是否能改成binary search，省去sort的nlogn時間，待思考如何移動指針
		//待完成
		int batteryQuantity=batteries.length;
		long maxEnergy=0, maxTime;
		for(int battery : batteries) {
			maxEnergy+=battery;
		}
		maxTime=maxEnergy/n;

		// TODO

		return maxTime;
	}

}
