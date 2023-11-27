package lc002391_MinimumAmountOfTimeToCollectGarbage;

public class Solution {

	public Solution() {}

	public int garbageCollection(String[] garbage, int[] travel) {
		//思路：
		int timeCount=0;
		int[] lastAppear = new int[128];
		for(int i=0; i<garbage.length; i++) {
			timeCount+=garbage[i].length();
			for(char trash : garbage[i].toCharArray()) {
				lastAppear[trash]=i;
			}
		}
		for(int i=1; i<travel.length; i++) {
			travel[i]+=travel[i-1];
		}
		for(char trashType : "MPG".toCharArray()) {
			timeCount += lastAppear[trashType]>0 ? travel[lastAppear[trashType]-1] : 0;
		}
		return timeCount;
	}

}
