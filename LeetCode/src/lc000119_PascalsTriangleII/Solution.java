package lc000119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public Solution() {}

	public List<Integer> getRow(int rowIndex) {
		//思路：
		List<Integer> result = new ArrayList<>(rowIndex+1);
		result.add(1);
		for(int i=1; i<rowIndex+1; i++) {
			result.add(0);
		}
		for(int i=1; i<rowIndex+1; i++) {
			for(int j=i; j>=1; j--) {
				result.set(j, result.get(j)+result.get(j-1));
			}
		}
		return result;
	}

	public List<Integer> getRow2(int rowIndex) {
		//思路：
		int[] result = new int[rowIndex+1];
		result[0]=1;
		for(int i=1; i<rowIndex+1; i++) {
			for(int j=i; j>=1; j--) {
				result[j]+=result[j-1];
			}
		}
		return Arrays.stream(result).boxed().toList();
	}

	public List<Integer> getRow3(int rowIndex) {
		//思路：
		List<Integer> result = new ArrayList<>(rowIndex);
		long element=1L;
		for(int i=0; i<=rowIndex; i++) {
			result.add((int)element);
			element*=(rowIndex-i)/(i+1);
		}
		return result;
	}

}

/*
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
*/