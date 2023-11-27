package lc000138_CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {	//本題head必須保持原樣或是在最後恢復原樣

	public Solution() {}

	public Node copyRandomList(Node head) {
		//思路：在第一輪遍歷時使用map記錄下，原node與新node的映射關係，在第二輪遍歷時，利用map來恢復新head的結構
		if(head==null) {return null;}
		Map<Node, Node> nodeMapping = new HashMap<>();
		Node copyHead = new Node(head.val), copyNode=copyHead, node=head;
		nodeMapping.put(head, copyHead);
		while(node.next!=null) {
			copyNode.next = new Node(node.next.val);
			nodeMapping.put(node.next, copyNode.next);
			copyNode=copyNode.next;
			node=node.next;
		}
		copyNode=copyHead;
		node=head;
		while(node!=null) {
			if(node.random!=null) {
				copyNode.random=nodeMapping.get(node.random);
			}
			copyNode=copyNode.next;
			node=node.next;
		}
		return copyHead;
	}

	public Node copyRandomList2(Node head) {
		//思路：將新增(複製)的node接在原本的node後面，然後新複製的node.random必定指向null(原node.random==null)或是原node.random.next(原本node.random!=null)，最後再將copyHead從head中拆分出來，順便恢復head成原樣
		//參考：https://leetcode.com/problems/copy-list-with-random-pointer/solutions/43491/a-solution-with-constant-space-complexity-o-1-and-linear-time-complexity-o-n/
		//1->2->3->4 => 1->1'->2->2'->3->3'->4->4' => 1->2->3->4 1'->2'->3'->4'
		if(head==null) {return null;}
		Node node=head, then=node.next;
		while(node!=null && then!=null) {
			node.next=new Node(node.val);
			node.next.next=then;
			node=then;
			then=then.next;
		}
		node.next=new Node(node.val);

		node=head;
		then=node.next;
		while(node!=null && then.next!=null) {
			then.random = node.random==null ? null : node.random.next;
			node=node.next.next;
			then=then.next.next;
		}
		then.random = node.random==null ? null : node.random.next;

		node=head.next;
		Node copyHead=node, prev=head;
		//then=node.next;
		while(node.next!=null) {
			prev.next=node.next;
			node.next=node.next.next;
			prev=prev.next;
			node=node.next;
		}
		prev.next=null;
		node.next=null;

		return copyHead;
	}

}
