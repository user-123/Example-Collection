package lc000234_PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public Solution2() {}

	public boolean isPalindrome(ListNode head) {
		//微優化原本的解法
		boolean result = true;
		List<Integer> record = new ArrayList<>();
		ListNode currentNode = head;
		while(currentNode != null) {
			record.add(currentNode.val);
			currentNode = currentNode.next;

		}
		System.out.println(record);
		int recordCount = record.size();
		for(int i=0; i<(recordCount+1)/2; i++) {
			if(record.get(i) != record.get(recordCount-1-i)) {
				result = false;
				break;
			}
		}
		return result;
		//待改寫成遞迴
//		if (head == null || head.next == null) {
//			return head;
//		}
//
//		ListNode newHead = reverseList(head.next);
//		head.next.next = head;
//		head.next = null;
//		return newHead;	//待修改
	}

}
