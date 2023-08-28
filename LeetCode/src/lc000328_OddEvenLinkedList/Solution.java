package lc000328_OddEvenLinkedList;

public class Solution {

	public Solution() {}

	public ListNode oddEvenList(ListNode head) {
		if(head==null || head.next==null || head.next.next==null) {return head;}
		ListNode slow=head, fast=head.next, evenNodeHead=fast;;
		while(!(fast==null || fast.next==null)) {	//while(fast!=null && fast.next!=null) {
			slow.next=slow.next.next;
			fast.next=fast.next.next;
			slow=slow.next;
			fast=fast.next;
		}
		slow.next=evenNodeHead;
		return head;
	}

}
