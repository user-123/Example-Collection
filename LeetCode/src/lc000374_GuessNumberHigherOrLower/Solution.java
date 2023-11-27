package lc000374_GuessNumberHigherOrLower;

import java.util.Random;

class GuessGame {
	int target;

	GuessGame(int n) {
		this.target=new Random().nextInt(n);
	}

	/**
	 * Forward declaration of guess API.
	 * @param num	your guess
	 * @return	-1 if num is higher than the picked number
	 * 		1 if num is lower than the picked number
	 * 		otherwise return 0
	 * int guess(int num);
	 */
	int guess(int num) {
		return num==this.target ? 0 : num<this.target ? 1 : -1;
	}
}


public class Solution extends GuessGame {

	public Solution() {
		super(new Random().nextInt());
	}

	public int guessNumber(int n) {
		int min=1, max=n, mid;
		while(true) {
			mid=min+(max-min)/2;
			int pickResult=guess(mid);
			if(pickResult==0) {break;}
			if(pickResult==1) {min=mid+1;continue;}
			if(pickResult==-1) {max=mid-1;}
		}
		return mid;
	}
}
