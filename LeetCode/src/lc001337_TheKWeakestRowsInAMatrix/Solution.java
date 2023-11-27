package lc001337_TheKWeakestRowsInAMatrix;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {

	public Solution() {}

	public int[] kWeakestRows(int[][] mat, int k) {
		//TODO 待完善
		//int[] result = new int[mat.length];
		int[] result = new int[k];
		Arrays.fill(result, -1);
		int index=0;
		label:
		for(int j=0; j<mat[0].length; j++) {
			label2:
			for(int i=0; i<mat.length; i++) {
				if(mat[i][j]==0) {
					for(int p=0; p<index; p++) {
						if(result[p]==i) {
							continue label2;
						}
					}
					result[index++]=i;
				}
				if(index>=k) {break label;}
			}
		}
		//return Arrays.copyOf(result, k);
		return result;
	}

	public int[] kWeakestRows999(int[][] mat, int k) {
		//TODO 待思考
		int[][] array = new int[mat.length][2];
		int[] result = new int[k];
		for(int i=0; i<mat.length; i++) {
			array[i][0]=IntStream.of(mat[i]).sum();
			array[i][1]=i;
		}
		Arrays.sort(array, (a, b) -> {
			if(a[0]==b[0]) {return a[1]-b[1];}
			return a[0]-b[0];
		});
		for(int i=0; i<k; i++) {
			result[i]=array[i][1];
		}
		return result;
	}

}
