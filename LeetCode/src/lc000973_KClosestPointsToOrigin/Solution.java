package lc000973_KClosestPointsToOrigin;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public Solution() {}

	//思路：概念上類似取第k遠的距離

	public int[][] kClosest(int[][] points, int k) {
		//思路：依照距離排序
		//優點：簡短、直觀、易於實現
		//缺點：效率不高，必須事先知道所有的點(需要事先排列)，並且無法處理實時(在線)情況，它是一種離線解決方案
		Arrays.sort(points, (p1, p2) -> (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
		return Arrays.copyOfRange(points, 0, k);
	}

	public int[][] kClosest2(int[][] points, int k) {
		//思路：維護一個priority queue，可以理解為上一個解法的變體，優先度為大→小
		//優點：可以處理實時(在線)流數據，不必事先知道數據的大小(不需要事先排列)
		//缺點：不是最有效率的解決方案(而且在LeetCode上跑還比較慢0.0)
		int[][] result = new int[k][2];
		Queue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]));
		for(int[] point : points) {
			priorityQueue.offer(point);	//offer：如果隊列已滿，則返回false並且不會拋出異常；add：如果隊列已滿，則拋出異常
			//if(priorityQueue.size()>k) {priorityQueue.poll();}
		}
		while(priorityQueue.size()>k) {priorityQueue.poll();}
		while(k>0) {result[--k]=priorityQueue.poll();}
		return result;
	}

	public int[][] kClosest2_1(int[][] points, int k) {
		//思路：上一個priority queue的變體，優先度為小→大
		int[][] result = new int[k][2];
		Queue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> (p1[0]*p1[0]+p1[1]*p1[1])-(p2[0]*p2[0]+p2[1]*p2[1]));
		for(int[] point : points) {
			priorityQueue.offer(point);
		}
		int index=0;
		while(index<k) {result[index++]=priorityQueue.poll();}
		return result;
	}

	public int[][] kClosest2_2(int[][] points, int k) {
		//思路：上上一個priority queue的變體，永遠維持queue的大小為k，減少比較次數(效率貌似沒有增加??)，優先度為大→小
		int[][] result = new int[k][2];
		Queue<int[]> priorityQueue = new PriorityQueue<>((p1, p2) -> (p2[0]*p2[0]+p2[1]*p2[1])-(p1[0]*p1[0]+p1[1]*p1[1]));
		for(int[] point : points) {
			priorityQueue.offer(point);
			if(priorityQueue.size()>k) {priorityQueue.poll();}
		}
		//while(priorityQueue.size()>k) {priorityQueue.poll();}
		while(k>0) {result[--k]=priorityQueue.poll();}
		return result;
	}

	public int[][] kClosest3(int[][] points, int k) {
		//思路：使用類似quick sort的概念，就是quick select的概念
		//優點：最有效率的解決方案(理論上，平均時間複雜度是T(2n-1)=O(n))，因為省去排序的步驟
		//缺點：不是實時(在線)的解決方案，也不是穩定的解決方案(在最壞的情況下，這個解決方案會退化到O(n^2)，如quick sort和quick select一般)
		//待完成
		if(k>=points.length) {return points;}
		int start=0, end=points.length-1, pivot=(int) (Math.random()*points.length);	//pivot=start+(end-start)/2
		while(start<=end) {
			if(distanceSquared(points[start])>distanceSquared(points[pivot])) {

			}
		}
		return Arrays.copyOfRange(points, 0, k);
	}

	private int distanceSquared(int[] location) {
		return location[0]*location[0]+location[1]*location[1];
	}
	//private int compareDistance() {}

}
