package lc000403_FrogJump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

	public Solution() {}

	public boolean canCross(int[] stones) {
		Map<Integer, Set<Integer>> table = new HashMap<>();
		for(int posistion : stones) {table.put(posistion, new HashSet<>());}
		table.get(stones[0]).add(1);
		for(int posistion : stones) {
			for(int jumpDistance : table.get(posistion)) {
				if(jumpDistance!=0 && table.containsKey(posistion+jumpDistance)) {
					table.get(posistion+jumpDistance).add(jumpDistance-1);
					table.get(posistion+jumpDistance).add(jumpDistance);
					table.get(posistion+jumpDistance).add(jumpDistance+1);
				}
			}
		}
		return !table.get(stones[stones.length-1]).isEmpty();
	}

}
