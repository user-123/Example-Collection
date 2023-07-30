package lc001732_FindTheHighestAltitude;

public class Solution {

	public Solution() {}

	public int largestAltitude(int[] gain) {
		int maxHeight=0, height=0;
		for(int gainHeight : gain) {
			height+=gainHeight;
			maxHeight = height>maxHeight ? height : maxHeight;
		}
		return maxHeight;
	}

}
