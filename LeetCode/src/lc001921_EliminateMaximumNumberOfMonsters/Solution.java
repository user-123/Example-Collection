package lc001921_EliminateMaximumNumberOfMonsters;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int eliminateMaximum(int[] dist, int[] speed) {
		//思路：將到達的時間升冪排序，當遇到到達時間早於當下的時間就代表能殺幾隻怪獸
		int quantity=dist.length;
		double[] timeToCity = new double[quantity];
		for(int i=0; i<quantity; i++) {
			timeToCity[i] = (double)dist[i]/speed[i];
		}
		Arrays.sort(timeToCity);
		for(int i=0;i<quantity; i++) {
			if(timeToCity[i]<=i) {return i;}
		}
		return quantity;
	}

}
