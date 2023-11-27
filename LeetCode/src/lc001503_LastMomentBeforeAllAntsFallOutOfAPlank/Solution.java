package lc001503_LastMomentBeforeAllAntsFallOutOfAPlank;

public class Solution {

	public Solution() {}

	public int getLastMoment(int n, int[] left, int[] right) {
		//思路：
		int result=-1;
		for(int goLeftAnt : left) {
			result = goLeftAnt>result ? goLeftAnt : result;
		}
		for(int goRightAnt : right) {
			result = n-goRightAnt>result ? n-goRightAnt : result;
		}
		return result;
	}

}
