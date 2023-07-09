package lc000234_PalindromeLinkedList;

public class Solution3 {

	public Solution3() {}

	public boolean isPalindrome(ListNode head) {
		//待完成
		//思路：利用之前寫過的206. Reverse Linked List，將一半的序列reverse sort，然後相互比對
		boolean result=true;
		ListNode fastPointer=head, slowPointer=head;
		while(fastPointer!=null && fastPointer.next!=null) {
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next.next;
		}
		slowPointer = reverseList(slowPointer);
		fastPointer = head;
		while(slowPointer!=null) {// && fastPointer!=null
			if(slowPointer.val!=fastPointer.val) {
				result=false;
				break;
			}
			slowPointer=slowPointer.next;
			fastPointer=fastPointer.next;
		}
		return result;
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
