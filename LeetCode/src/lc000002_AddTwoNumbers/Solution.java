package lc000002_AddTwoNumbers;

import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoListNode(l1, l2, 0);
	}

	private ListNode addTwoListNode(ListNode l1, ListNode l2, int carry) {
		if(l1 == null) {l1 = new ListNode(0);}
		if(l2 == null) {l2 = new ListNode(0);}
		ListNode result = new ListNode(l1.val+l2.val+carry);
		carry = 0;
		while(result.val>=10) {
			carry+=1;
			result.val-=10;
		}
		if(l1.next != null || l2.next != null || carry!=0) {
			result.next = addTwoListNode(l1.next, l2.next, carry);
		}
//		if(l1.next == null && l2.next == null && carry==0) {
//
//		}else if(l1.next == null && l2.next == null && carry!=0) {
//			result.next = addTwoListNode(l1.next, l2.next, carry);
//		}else {
//			result.next = addTwoListNode(l1.next, l2.next, carry);
//		}
		return result;
	}
}
