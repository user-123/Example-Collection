package lc000206_ReverseLinkedList;

public class Solution {

	public Solution() {}

	public ListNode reverseList(ListNode head) {
//		if (head == null || head.next == null) {
//			return head;
//		}
//
//		ListNode newHead = reverseList(head.next);
//		head.next.next = head;
//		head.next = null;
//		return newHead;	//待修改

		ListNode newHead = new ListNode();
		ListNode currentNode = head;
		while (currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = newHead.next;
			newHead.next = currentNode;
			currentNode = nextNode;
		}
		return newHead.next;
	}

}
