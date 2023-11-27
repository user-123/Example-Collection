package lc002038_RemoveColoredPiecesIfBothNeighborsAreTheSameColor;

public class Solution {

	public Solution() {}

	public boolean winnerOfGame(String colors) {
		//思路：找到連續3個的AAA或BBB，就可以進行一次拿取，如果是4則是兩次，依此類推；A與B之間不會互相影響(因為能拿的A、B只能在兩邊都是同樣A或B的情況下)
		int aCount=0, bCount=0, aGroupCount=0, bGroupCount=0;
		char[] colorsArray = colors.toCharArray();
		for(char color : colorsArray) {
			if(color=='A') {
				bCount=0;
				aCount++;
				aGroupCount += aCount>=3 ? 1 : 0;
				continue;
			}
			aCount=0;
			bCount++;
			bGroupCount += bCount>=3 ? 1 : 0;
		}
		return aGroupCount>bGroupCount;
	}

}
