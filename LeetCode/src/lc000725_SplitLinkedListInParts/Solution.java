package lc000725_SplitLinkedListInParts;

public class Solution {

	public Solution() {}

	public ListNode[] splitListToParts(ListNode head, int k) {
		//思路：先遍歷計算長度，然後計算平均出每一個part的長度，進行切割
		ListNode[] parts = new ListNode[k];
		//if(head==null) {return parts;}
		int length=0;
		/*
		for(ListNode node=head; node!=null; node=node.next) {
			length++;
		}
		*/
		ListNode node=head, prev=null;
		while(node!=null) {
			length++;
			node=node.next;
		}
		int partLength=length/k, redundantCount=length%k;
		node=head;
		/*
		for(int i=0; node!=null && i<k; i++,redundantCount--) {
			parts[i]=node;
			for(int j=0; j<partLength+(redundantCount>0 ? 1 : 0); j++) {
				prev=node;
				node=node.next;
			}
			prev.next=null;
		}
		*/
		int i=0;
		while(i++<k && node!=null) {
			parts[i]=node;
			int j=0;
			while(j++<partLength+(redundantCount>0 ? 1 : 0)) {
				prev=node;
				node=node.next;
			}
			prev.next=null;
			redundantCount--;
		}
		return parts;
	}

	public ListNode[] splitListToParts2(ListNode head, int k) {
		//思路：想辦法實現k*2個指針(prev1, node1, prev2, node2, ..., prevk, nodek)，當最尾且最快的指針(nodek)到達尾端時(node==null)，則每一node均為該part的頭端，每一prev則為該part的尾端
		//概念：new ListNode[k] {head~prev1, node1~prev2, ..., nodek-1~prevk};
		//TODO 待完成，又或許完不成XDD，容我先熟悉java reflection

		return null;
	}

}
