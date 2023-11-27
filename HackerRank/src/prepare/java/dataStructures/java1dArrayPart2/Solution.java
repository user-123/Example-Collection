package prepare.java.dataStructures.java1dArrayPart2;

import java.io.*;
import java.util.*;

public class Solution {

	public static boolean canWin(int leap, int[] game, int index) {
		// Return true if you can win the game; otherwise, return false.
		//思路：凡做過必留痕跡XDDD只要走過的地方全部標記上，不允許再次走動，避免來回循環的走動
		if(index>=game.length || index==game.length-1 && game[index]==0) {return true;}
		if(index<0 || game[index]!=0) {return false;}
		game[index]=-1;	//可以賦除0以外的任何值，只是為了標記避免來回走
		return canWin(leap, game, index+1) || canWin(leap, game, index-1) || canWin(leap, game, index+leap);
	}

	public static boolean canWin2(int leap, int[] game) {
		// Return true if you can win the game; otherwise, return false.
		boolean result=true;
		int index=0;
		while(index<game.length) {
			/*
			if(index>0 && game[index-1]==0 || index<game.length-1 && game[index+1]==0 || index+leap<game.length-1 && game[index+leap]==0 || index+leap>=game.length-1) {
			}
			*/
			//TODO 感覺不好寫，基本邏輯與前一個差不多，但原先的構思不夠全面
			if(index+leap>=game.length) {return true;}
			if(game[index+leap]==0) {}
		}
		return result;
	}

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		while (q-- > 0) {
			int n = scan.nextInt();
			int leap = scan.nextInt();

			int[] game = new int[n];
			for (int i = 0; i < n; i++) {
				game[i] = scan.nextInt();
			}

			System.out.println( (canWin(leap, game, 0)) ? "YES" : "NO" );
		}
		scan.close();
	}

}