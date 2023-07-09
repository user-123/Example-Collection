package lc000524_LongestWordInDictionaryThroughDeleting;

public class ClassType {
	int val;
	ClassType left;
	ClassType right;
	ClassType() {}
	ClassType(int val) {
		this.val = val;
	}
	ClassType(int val, ClassType left, ClassType right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

}
