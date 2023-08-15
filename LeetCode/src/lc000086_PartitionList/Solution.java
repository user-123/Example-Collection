package lc000086_PartitionList;

public class Solution {

	public Solution() {}

	public ListNode partition(ListNode head, int x) {
		ListNode lesser = new ListNode(Integer.MIN_VALUE), lesserTail=lesser, equalOrGreater = new ListNode(Integer.MAX_VALUE), equalOrGreaterTail=equalOrGreater;
		while(head!=null) {
			if(head.val<x) {
				lesserTail.next = head;
				lesserTail=lesserTail.next;
			}else {
				equalOrGreaterTail.next = head;
				equalOrGreaterTail=equalOrGreaterTail.next;
			}
			head=head.next;
		}
		lesserTail.next=equalOrGreater.next;
		equalOrGreaterTail.next=null;
		return lesser.next;
	}

}
