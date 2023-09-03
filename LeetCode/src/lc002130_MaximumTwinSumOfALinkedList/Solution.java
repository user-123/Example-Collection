package lc002130_MaximumTwinSumOfALinkedList;

public class Solution {

	public Solution() {}

	public int pairSum(ListNode head) {
		//利用之前寫過的206. Reverse Linked List，將一半的序列reverse sort，然後相互兩兩相加比較
		//if(head.next.next==null) {return head.val+head.next.val;}
		ListNode slow=head, fast=head;
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		ListNode subList = reverseList(slow);
		int max=Integer.MIN_VALUE;
		while(subList!=null) {
			max = head.val+subList.val>max ? head.val+subList.val : max;
			head=head.next;
			subList=subList.next;
		}
		return max;
	}

	private ListNode reverseList(ListNode node) {
		ListNode newHead = new ListNode();
		ListNode currentNode = node;
		while(currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = newHead.next;
			newHead.next = currentNode;
			currentNode = nextNode;
		}
		return newHead.next;
	}

}
