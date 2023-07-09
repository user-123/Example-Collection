package lc000234_PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public Solution() {}

	public boolean isPalindrome(ListNode head) {
		//將val記錄到array裡再比對，也可記錄成string再比或許對會更快
		//或是用雙指針的思維，不過需要反轉序列
		//或是一個快指針、一個慢指針，當快指針到底時，慢指針剛好在中間(不過要判別序列數是偶數還是奇數)，慢指針與新指針分別往前往後檢查，或是相似的方法實現雙指針
		Boolean result = null;
		List<Integer> record = new ArrayList<>();
		ListNode currentNode = head;
		while(currentNode != null) {
			record.add(currentNode.val);
			currentNode = currentNode.next;

		}
		System.out.println(record);
		int recordCount = record.size();
		for(int i=0; i<(recordCount+1)/2; i++) {
			if(record.get(i) == record.get(recordCount-1-i)) {
				result = true;
			}else {
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
