package lc000138_CopyListWithRandomPointer;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	@Override
	public String toString() {
		return "Node2 [val=" + val + ", next=" + next + ", random=" + random + "]";
	}

}
