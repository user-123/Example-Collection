package lc000135_Candy;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int candy(int[] ratings) {
		//思路：貪婪.... //TODO 完成思路
		int sum=0;
		int[] candyCount = new int[ratings.length];
		Arrays.fill(candyCount, 1);
		for(int i=0; i<ratings.length-1; i++) {
			candyCount[i+1] = ratings[i+1]>ratings[i] ? candyCount[i]+1 : candyCount[i+1];
		}
		for(int i=ratings.length-1; i>0; i--) {
			candyCount[i-1] = ratings[i-1]>ratings[i] && candyCount[i-1]<candyCount[i]+1 ? candyCount[i]+1 : candyCount[i-1];
		}
		for(int count : candyCount) {
			sum+=count;
		}
		return sum;
	}

}
