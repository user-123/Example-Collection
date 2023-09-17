package lc000000_Template;

class RandomListNode {
	int val;
	RandomListNode next;
	RandomListNode random;

	public RandomListNode(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}

	@Override
	public String toString() {
		return "Node2 [val=" + val + ", next=" + next + ", random=" + random + "]";
	}

}
