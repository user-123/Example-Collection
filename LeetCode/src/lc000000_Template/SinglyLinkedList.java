package lc000000_Template;

public class SinglyLinkedList {
	int val;
	SinglyLinkedList next;
	SinglyLinkedList(int x) {
		val = x;
		next = null;
	}

	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}

}
