package lc000011_ContainerWithMostWater;

public class Solution {

	public Solution() {}

	public int maxArea(int[] height) {
		//思路：area=width*height=(right-left)*Math.min(height[left], height[right])
		//pointer移動的邏輯，永遠移動高度矮的那邊，理由是不管你再怎麼移動高的那邊，得到的area永遠會比較小(因為area是取決於兩邊height較小的當作"高"，高的那邊不管怎樣，都不會增加"高"，甚至還有可能會變短；向中間移動pointer則寬度永遠會越來越小)，永遠貪婪的求取兩邊同時越高越好)
		int width=height.length, left=0, right=width-1, maxArea=0;
		while(left<right) {
			int leftHeight=height[left], rightHeight=height[right], area=(right-left)*Math.min(leftHeight, rightHeight);
			maxArea=Math.max(area, maxArea);
			/*
			if(leftHeight<rightHeight) {
				left++;
			}else if(leftHeight>rightHeight) {
				right--;
			}else {
				left++;
				right--;
			}
			*/
			if(leftHeight<rightHeight) {left++;continue;}
			if(leftHeight>rightHeight) {right--;continue;}
			if(leftHeight==rightHeight) {left++;right--;}
		}
		return maxArea;
	}

}
