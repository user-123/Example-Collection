package lc000876_MiddleOfTheLinkedList;

public class Solution {

	public Solution() {}

	public ListNode middleNode(ListNode head) {
		ListNode fastPointer = head, slowPointer = head;
		while(fastPointer.next!=null && fastPointer.next.next!=null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		return fastPointer.next==null ? slowPointer : slowPointer.next;
	}

	public ListNode middleNode2(ListNode head) {
		ListNode fastPointer = head, slowPointer = head;
		while(fastPointer!=null && fastPointer.next!=null) {
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
		}
		return slowPointer;
	}

}
