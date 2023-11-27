package lc000092_ReverseLinkedListII;

public class Solution {

	public Solution() {}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		//思路：
		if(head==null) {return null;}
		ListNode headPrev=new ListNode(Integer.MIN_VALUE);
		headPrev.next=head;
		ListNode prev=headPrev;
		for(int i=0; i<left-1; i++) {
			prev=prev.next;
		}
		ListNode start=prev.next, then=start.next;
		for(int i=0; i<right-left; i++) {
			start.next=then.next;
			then.next=prev.next;
			prev.next=then;
			then=start.next;
		}
		return headPrev.next;
	}

	public ListNode reverseBetween2(ListNode head, int left, int right) {
		//思路：利用之前寫過的206. Reverse Linked List，將部份的序列reverse sort，然後再接起來
		//TODO 待修正
		if(left==right) {return head;}
		int nodeCount=0;
		ListNode node=head, headEnd=null, start=null, tailHead=null;
		nodeCount++;
		while(node!=null) {
			if(nodeCount==left-1) {
				start=node.next;
				headEnd=node;
			}
			if(nodeCount==right) {
				tailHead=node.next;
				break;
			}
			node=node.next;
			nodeCount++;
		}
		//headEnd.next=null;
		node.next=null;
		if(headEnd==null) {
			return head;
		}else {
			headEnd.next=reverseList(start);
		}
		start.next=tailHead;
		return head;
	}

	private ListNode reverseList(ListNode node) {
		ListNode newHead = new ListNode();
		ListNode currentNode = node;
		while (currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = newHead.next;
			newHead.next = currentNode;
			currentNode = nextNode;
		}
		return newHead.next;
	}

}
