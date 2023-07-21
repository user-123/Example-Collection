package lc000019_RemoveNthNodeFromEndOfList;

public class Solution {

	public Solution() {}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		//思路：一開始就抓好兩個pointer的距離，當先行的pointer到底的時候，累加出來的length就是"node數量"(或許也可說"長度"，不過長度應該算length還是length-1，就待討論囉)，
		//而start pointer所指的就是欲刪除node的前一個node(也就是說start.next就是要刪除的node)，將start的next指向到欲刪除node的下一node(start.next -> start.next.next)上
		//這邊要考慮一些edge case；其一是如果head長度等於1且n等於1的時候，那就代表會變成null的listNode；其二就是length==n，代表的是刪除第一個node，那就直接返回head.next
		ListNode start = head , end = start;
		int length=0;
		while(end!=null) {
			if(length>n) {start=start.next;}
			end=end.next;
			length++;
		}
		if(length==1 && n==1) {return null;}
		if(length==n) {return head.next;}
		start.next=start.next.next;
		return head;
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		//思路：使用常規的快慢pointer的方式進行
		//待完成

		return null;
	}

}
