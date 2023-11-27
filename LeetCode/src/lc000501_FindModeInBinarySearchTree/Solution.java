package lc000501_FindModeInBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public Solution() {}

	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		dfs(root, map);
		int max = Collections.max(map.values());
		List<Integer> result = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key)==max) {result.add(key);}
		}
		return result.stream().mapToInt(integer->integer).toArray();
	}

	private void dfs(TreeNode node, Map<Integer, Integer> map) {
		if(node==null) {return;}
		map.put(node.val, map.getOrDefault(node.val, 0)+1);
		dfs(node.left, map);
		dfs(node.right, map);
	}

}
