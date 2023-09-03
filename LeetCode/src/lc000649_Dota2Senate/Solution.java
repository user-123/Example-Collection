package lc000649_Dota2Senate;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public Solution() {}

	public String predictPartyVictory(String senate) {
		char[] senators = senate.toCharArray();
		Queue<Integer> radiantSenators = new LinkedList<>(), direSenators = new LinkedList<>();
		for(int i=0; i<senators.length; i++) {
			if(senators[i]=='R') {
				radiantSenators.offer(i);
			}else {
				direSenators.offer(i);
			}
		}
		while(!radiantSenators.isEmpty() && !direSenators.isEmpty()) {
			int radiantSenator=radiantSenators.poll(), direSenator=direSenators.poll();
			if(radiantSenator<direSenator) {
				radiantSenators.offer(radiantSenator+senators.length);
			}else {
				direSenators.offer(direSenator+senators.length);
			}
		}
		return radiantSenators.size()>direSenators.size() ? "Radiant" : "Dire";
	}

}
