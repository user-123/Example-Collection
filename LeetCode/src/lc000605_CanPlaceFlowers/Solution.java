package lc000605_CanPlaceFlowers;

public class Solution {

	public Solution() {}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int length=flowerbed.length, count=0;
		//if(n==0) {return true;}
		if(length==0) {return n==0;}
		if(length==1) {return flowerbed[0]==0 && n<=1 || flowerbed[0]==1 && n==0;}
		for(int i=0; i<length; i++) {
			if(i==0 && flowerbed[i]==0 && flowerbed[i+1]==0) {
				count++;
				i++;
				continue;
			}
			if(i==length-1 && flowerbed[i-1]==0 && flowerbed[i]==0) {
				count++;
				i++;
				continue;
			}
			if(i!=0 && i!=length-1 && flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0) {
				count++;
				i++;
				continue;
			}
		}
		return count>=n;
	}

	public boolean canPlaceFlowers_2(int[] flowerbed, int n) {
		int length=flowerbed.length, count=0;
		//if(n==0) {return true;}
		if(length==0) {return n==0;}
		if(length==1) {return flowerbed[0]==0 && n<=1 || flowerbed[0]==1 && n==0;}
		for(int i=0; i<length; i++) {
			if(i==0 && flowerbed[i]==0 && flowerbed[i+1]==0 || i==length-1 && flowerbed[i-1]==0 && flowerbed[i]==0 || i!=0 && i!=length-1 && flowerbed[i-1]==0 && flowerbed[i]==0 && flowerbed[i+1]==0) {
				count++;
				i++;
			}
		}
		return count>=n;
	}

	public boolean canPlaceFlowers_3(int[] flowerbed, int n) {
		int length=flowerbed.length, count=0;
		//if(n==0) {return true;}
		//if(length==0) {return n==0;}
		//if(length==1) {return flowerbed[0]==0 && n<=1 || flowerbed[0]==1 && n==0;}
		for(int i=0; i<length; i++) {
			if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==length-1 || flowerbed[i+1]==0)) {
				count++;
				i++;
			}
		}
		return count>=n;
	}

	public boolean canPlaceFlowers_4(int[] flowerbed, int n) {
		for(int i=0; i<flowerbed.length; i++) {
			if(flowerbed[i]==0 && (i==0 || flowerbed[i-1]==0) && (i==flowerbed.length-1 || flowerbed[i+1]==0)) {
				n--;
				i++;
			}
		}
		return n<=0;
	}

}
