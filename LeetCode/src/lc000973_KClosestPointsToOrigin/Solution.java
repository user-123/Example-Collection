package lc000973_KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public int[][] kClosest(int[][] points, int k) {
		//思路：依照距離排序
		//優點是簡短、直觀、易於實現。
		//缺點是效率不高，必須事先知道所有的點，並且無法處理實時（在線）情況，它是一種離線解決方案。
		Arrays.sort(points, (p1, p2) -> (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
		return Arrays.copyOfRange(points, 0, k);
	}

	public int[][] kClosest2(int[][] points, int k) {
		//思路：維護一個priority queue
		//此解決方案的優點是它可以處理實時（在線）流數據。它不必事先知道數據的大小。
		//此解決方案的缺點是它不是最有效率的解決方案。
		int[][] result = new int[k][2];
		Queue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]));
		for(int[] point : points) {
			priorityQueue.offer(point);	//offer：如果隊列已滿，則返回false並且不會拋出異常；add：如果隊列已滿，則拋出異常
			if(priorityQueue.size()>k) {priorityQueue.poll();}
		}
		//while(priorityQueue.size()>k) {priorityQueue.poll();}
		while(k>0) {result[--k]=priorityQueue.poll();}
		return result;
	}

	public int[][] kClosest2_2(int[][] points, int k) {
		//思路：上一個priority queue的變體
		int[][] result = new int[k][2];
		Queue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
		for(int[] point : points) {
			priorityQueue.offer(point);
		}
		int index=0;
		while(index<k) {result[index++]=priorityQueue.poll();}
		return result;
	}

	public int[][] kClosest3(int[][] points, int k) {
		//待完成
		//思路：使用快速排序的概念，quick select????

		return new int[0][0];
	}

}
