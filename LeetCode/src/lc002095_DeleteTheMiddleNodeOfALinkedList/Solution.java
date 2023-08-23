package lc002095_DeleteTheMiddleNodeOfALinkedList;

public class Solution {

	public Solution() {}

	public ListNode deleteMiddle(ListNode head) {
		//思路：利用快慢指針，slow每次跳一格，fast每次跳兩格；當兩個指針同時從head出發，則當fast到底時(fast==null || fast.next==null)，slow的位置剛好是要被去除的node；為了不必再從新定位middle node的前一個node，所以在一開始時先讓fast先跳一次，這樣當fast到底時，slow.next剛好是要刪除的node，直接slow.next=slow.next.next即可
		if(head==null || head.next==null) {return null;}
		ListNode slow=head, fast=head;
		fast=fast.next.next;
		while(fast!=null && fast.next!=null) {	//!(fast==null || fast.next==null)
			slow=slow.next;
			fast=fast.next.next;
		}
		slow.next=slow.next.next;
		return head;
	}

}
