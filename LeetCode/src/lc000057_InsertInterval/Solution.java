package lc000057_InsertInterval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public int[][] insert(int[][] intervals, int[] newInterval) {
		//if(intervals.length==0) {return new int[][] {newInterval};}
		List<int[]> result = new ArrayList<>();
		for(int[] interval : intervals) {
			int iStart=interval[0], iEnd=interval[1];
			if(newInterval==null) {
				result.add(interval);
			}else if(newInterval[1]<iStart) {
				result.add(newInterval);
				newInterval=null;
				result.add(interval);
			}else if(newInterval[0]>iEnd) {
				result.add(interval);
			}else {
				newInterval[0]=Math.min(newInterval[0], iStart);
				newInterval[1]=Math.max(newInterval[1], iEnd);
			}
		}
		if(newInterval!=null) {result.add(newInterval);}
		return result.toArray(new int[result.size()][]);
	}

}
