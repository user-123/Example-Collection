package lc000141_LinkedListCycle;

import java.util.HashSet;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean hasCycle(ListNode head) {
		boolean result=false;
		ListNode fastPointer=head, slowPointer=head;
		while(fastPointer!=null && fastPointer.next!=null) {
			fastPointer=fastPointer.next.next;
			slowPointer=slowPointer.next;
			if(fastPointer==slowPointer) {
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean hasCycle2(ListNode head) {
		//使用賤招set，不過速度顯然比較慢QQ
		boolean result=false;
		Set<ListNode> nodeSet = new HashSet<>();
		ListNode pointer=head;
		while(pointer!=null) {
			if(!nodeSet.add(pointer)) {
				result=true;
				break;
			}
			pointer=pointer.next;
		}
		return result;
	}

}
