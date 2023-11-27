package lc000274_H_Index;

import java.util.Arrays;

public class Solution {

	public Solution() {}

	public int hIndex(int[] citations) {
		//思路：桶排序，
		int paperQuantity=citations.length;
		int[] receivedCounts = new int[paperQuantity+1];
		for(int receivedQuantity : citations) {
			if(receivedQuantity>=paperQuantity) {
				receivedCounts[paperQuantity]++;
			}else {
				receivedCounts[receivedQuantity]++;
			}
		}
		int count=0;
		for(int i=paperQuantity; i>=0; i--) {
			count+=receivedCounts[i];
			if(count>=i) {return i;}
		}
		return 0;
	}

	public int hIndex2(int[] citations) {
		//思路：排序後從後面開始檢查
		Arrays.sort(citations);
		int hIndex=0;
		for(int i=citations.length-1; i>=0; i--) {
			//hIndex = citations[i]>=citations.length-i ? citations.length-i : hIndex;
			//hIndex += citations[i]>=citations.length-i ? 1 : 0;
			if(citations[i]<citations.length-i) {break;}
			hIndex++;
		}
		return hIndex;
	}

}
