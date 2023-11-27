package lc001441_BuildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public List<String> buildArray(int[] target, int n) {
		//思路：
		List<String> result = new ArrayList<>(n*2-1);	//結果最長的情況就是target.length=1, target[0]=n這種情形，1~n-1都要有"push"和"pop"共兩element
		int expectedNum=1;
		//int max = target[target.length-1]<n ? target[target.length-1] : n;
		for(int i=0; i<target.length; i++) {
			result.add("Push");
			if(target[i]!=expectedNum++) {
				result.add("Pop");
				i--;
			}
		}
		return result;
	}

}
