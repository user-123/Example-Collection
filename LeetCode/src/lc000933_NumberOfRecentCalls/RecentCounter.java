package lc000933_NumberOfRecentCalls;

import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
	Queue<Integer> recentRequests;

	public RecentCounter() {
		recentRequests = new ArrayDeque<>();
	}

	public int ping(int t) {
		recentRequests.offer(t);
		while(recentRequests.peek()<t-3000) {
			recentRequests.poll();
		}
		return recentRequests.size();
	}
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */