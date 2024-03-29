package lc000257_BinaryTreePaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public Solution() {}

	public List<String> binaryTreePaths(TreeNode root) {
		//List<String> treePaths = new LinkedList<String>();
		//List<String> treePaths = new ArrayList<String>();
		//List<String> treePaths = new LinkedList<>();
		List<String> treePaths = new ArrayList<>();
		if(root==null) {
			//return treePaths;
			//treePaths.add(null);
			return null;
		}
		String currentPath = Integer.toString(root.val);
		if(root.left==null && root.right==null) {//this is the answer
			treePaths.add(currentPath);
		}
		if(root.left!=null) {//this is not the answer, find deeper
			searchForPath(root.left, treePaths, currentPath);
		}
		if(root.right!=null) {//this is not the answer, find deeper
			searchForPath(root.right, treePaths, currentPath);
		}
		return treePaths;
	}

	private void searchForPath(TreeNode node, List<String> treePaths,String currentPath) {
		currentPath += "->" + node.val;
		if(node.left==null && node.right==null) {//this is the answer
			treePaths.add(currentPath);
		}
		if(node.left!=null) {//this is not the answer, find deeper
			searchForPath(node.left, treePaths, currentPath);
		}
		if(node.right!=null) {//this is not the answer, find deeper
			searchForPath(node.right, treePaths, currentPath);
		}
	}
}
