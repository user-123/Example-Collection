package lc002251_NumberOfFlowersInFullBloom;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		//思路：Sweep Line Algorithm(掃描線演算法)，將三種事件合到一個時間軸；花開先算，再來人看，最後花謝
		Queue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
		for(int index=0; index<people.length; index++) {
			priorityQueue.offer(new int[] {people[index], 1, index});
		}
		for(int[] flower : flowers) {
			priorityQueue.offer(new int[] {flower[0], 0});
			priorityQueue.offer(new int[] {flower[1], 2});
		}
		int[] result = new int[people.length];
		int bloomCount=0;
		while(!priorityQueue.isEmpty()) {
			int[] current=priorityQueue.poll();
			bloomCount += current[1]==0 ? 1 : current[1]==2 ? -1 : 0;
			if(current[1]==1) {result[current[2]]=bloomCount;}
		}
		return result;
	}

	public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
		//思路：(Sweep Line Algorithm(掃描線演算法))+binary search
		int[] bloom=new int[flowers.length], fade=new int[flowers.length], result=new int[people.length];
		for(int i=0; i<flowers.length; i++) {
			bloom[i]=flowers[i][0];
			fade[i]=flowers[i][1];
		}
		Arrays.sort(bloom);
		Arrays.sort(fade);
		for(int i=0; i<people.length; i++) {
			result[i]=bloomCount(bloom, people[i], true)-bloomCount(fade, people[i], false);
		}
		return result;
	}

	private int bloomCount(int[] array, int target, boolean isEqual) {
		int start=0, end=array.length, mid;	//思考一下end為什麼這樣設
		while(start<end) {
			mid=start+(end-start)/2;
			if(array[mid]<target || isEqual && array[mid]==target) {start=mid+1;continue;}
			end=mid;
		}
		return start;
	}

}
