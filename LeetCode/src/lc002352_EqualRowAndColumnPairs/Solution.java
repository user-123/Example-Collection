package lc002352_EqualRowAndColumnPairs;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int equalPairs(int[][] grid) {
		//思路：依照理解題意，一個點的row sequence和col sequence一樣即為一個pair，代表每個pair都是在某一個點有交會，這意味著只要考慮row和col的互相配對組合即可，且會同時排除掉row與row或col與col之間相同的情況
		int length=grid.length, pairCount=0;
		Map<String, Integer> row = new HashMap<>(), col = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<length; i++) {
			stringBuilder.setLength(0);
			for(int j=0; j<length; j++) {
				if(!stringBuilder.isEmpty()) {stringBuilder.append(", ");}
				stringBuilder.append(grid[i][j]);
			}
			row.put(stringBuilder.toString(), row.getOrDefault(stringBuilder.toString(), 0)+1);
		}
		for(int j=0; j<length; j++) {
			stringBuilder.setLength(0);
			for(int i=0; i<length; i++) {
				if(!stringBuilder.isEmpty()) {stringBuilder.append(", ");}
				stringBuilder.append(grid[i][j]);
			}
			col.put(stringBuilder.toString(), col.getOrDefault(stringBuilder.toString(), 0)+1);
		}
		for(String sequence : row.keySet()) {	//也可for each col.keySet()
			pairCount+=col.getOrDefault(sequence, 0)*row.getOrDefault(sequence, 0);
		}
		return pairCount;
	}

	public int equalPairs2(int[][] grid) {
		//思路：前一個方法的微優化，整體思路不變，不過在第二輪迴圈時(讀取col時)，直接進行查詢並計算
		int length=grid.length, pairCount=0;
		Map<String, Integer> row = new HashMap<>();
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0; i<length; i++) {
			stringBuilder.setLength(0);
			for(int j=0; j<length; j++) {
				stringBuilder.append(grid[i][j]).append(", ");
			}
			row.put(stringBuilder.toString(), row.getOrDefault(stringBuilder.toString(), 0)+1);
		}
		for(int j=0; j<length; j++) {
			stringBuilder.setLength(0);
			for(int i=0; i<length; i++) {
				stringBuilder.append(grid[i][j]).append(", ");
			}
			pairCount+=row.getOrDefault(stringBuilder.toString(), 0);
		}
		return pairCount;
	}

}
