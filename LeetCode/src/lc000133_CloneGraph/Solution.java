package lc000133_CloneGraph;

public class Solution {

	Node[] newNodes;

	public Solution() {}

	//思路；必須至少遍歷一遍所有node

	public Node cloneGraph(Node node) {
		//思路：BFS??DFS??，待確定@@
		if(node==null) {return null;}
		newNodes = new Node[101];
		if(node.neighbors==null) {return new Node(node.val);}
		return cloneNode(node);
	}

	private Node cloneNode(Node node) {
		if(newNodes[node.val]!=null) {return newNodes[node.val];}
		Node newNode = new Node(node.val);
		newNodes[node.val] = newNode;
		for(Node neighborNode : node.neighbors) {newNode.neighbors.add(cloneNode(neighborNode));}
		return newNode;
	}

	public Node cloneGraph2(Node node) {
		//思路：依照提議推測，圖形為環形閉環的圖形，如果此為正確，則可以使用雙指針雙向遍歷直到兩指針碰頭
		//待完成
		return node;
	}

}
