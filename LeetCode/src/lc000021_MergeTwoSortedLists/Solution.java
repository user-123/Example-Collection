package lc000021_MergeTwoSortedLists;

public class Solution {

	public Solution() {}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		//if(list1==null) {return list2;}
		//if(list2==null) {return list1;}
		ListNode result = new ListNode();
		ListNode resultTail = result;
		while(list1!=null && list2!=null) {
			if(list1.val<list2.val) {
				resultTail.next=list1;
				list1=list1.next;
			}else {
				resultTail.next=list2;
				list2=list2.next;
			}
			resultTail=resultTail.next;
		}
		if(list1!=null) {
			resultTail.next=list1;
		}
		if(list2!=null) {
			resultTail.next=list2;
		}
		return result.next;
	}

}
