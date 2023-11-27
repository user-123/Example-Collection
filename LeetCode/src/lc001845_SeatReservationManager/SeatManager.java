package lc001845_SeatReservationManager;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {
	//思路：MinHeap
	Queue<Integer> priorityQueue;
	int last;

	public SeatManager(int n) {
		priorityQueue = new PriorityQueue<>(n);
		last=1;
	}

	public int reserve() {
		return priorityQueue.size()==0 ? last++ : priorityQueue.poll();
	}

	public void unreserve(int seatNumber) {
		priorityQueue.offer(seatNumber);
	}
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
