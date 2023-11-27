package lc002849_DetermineIfACellIsReachableAtAGivenTime;

public class Solution {

	public Solution() {}

	public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
		//思路：盡量走斜的，直到sx==fx || sy==fy，然後再走直的，所得到的路徑(時間)必定最短
		int needTime=Math.max(Math.abs(fx-sx), Math.abs(fy-sy));
		return needTime>0 ? t>=needTime : t!=1;
	}

}
