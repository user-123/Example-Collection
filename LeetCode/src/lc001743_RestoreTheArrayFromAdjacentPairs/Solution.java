package lc001743_RestoreTheArrayFromAdjacentPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int[] restoreArray(int[][] adjacentPairs) {
		//思路：將相鄰的數用map記下來
		Map<Integer, int[]> near = new HashMap<>();
		for(int i=0; i<adjacentPairs.length; i++) {
			if(near.containsKey(adjacentPairs[i][0])) {
				near.get(adjacentPairs[i][0])[1]=adjacentPairs[i][1];
			}else {
				near.put(adjacentPairs[i][0], new int[] {adjacentPairs[i][1], Integer.MIN_VALUE});
			}
			if(near.containsKey(adjacentPairs[i][1])) {
				near.get(adjacentPairs[i][1])[1]=adjacentPairs[i][0];
			}else {
				near.put(adjacentPairs[i][1], new int[] {adjacentPairs[i][0], Integer.MIN_VALUE});
			}
		}
		int[] result = new int[adjacentPairs.length+1];
		int start=Integer.MIN_VALUE;
		for(Map.Entry<Integer, int[]> entry : near.entrySet()) {
			if(entry.getValue()[1]==Integer.MIN_VALUE) {start=entry.getKey();break;}
		}
		result[0]=start;
		int left=Integer.MIN_VALUE;
		for(int i=1; i<result.length; i++) {
			int[] values = near.get(start);
			int right = values[0]==left ? values[1] : values[0];
			result[i]=right;
			left=start;
			start=right;
		}
		return result;
	}

}
