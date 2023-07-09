package lc000070_ClimbingStairs;

public class Solution {

	public Solution() {}

	public int climbStairs(int n) {
		//Fibonacci Sequence：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987 ...
		//Pascal's Triangle
		if(n==0) {return 0;}	//1
		if(n==1) {return 1;}	//1
		//if(n==2) {return 2;}	//2
		//if(n==3) {return 3;}	//3
		//if(n==4) {return 5;}	//5
		//if(n==5) {return 8;}	//6
		//if(n==6) {return 13;}	//13
		int result = 0, prev = 1, next = 1;
		for(int i=2; i<=n; i++) {
		//for (int i=2-1; i<n; i++) {
			result=prev+next;
			prev=next;
			next=result;
		}
		return result;
	}

	public int climbStairs2(int n) {
		//if(n==0) {return 0;}	//1
		if(n==1) {return 1;}	//1
		if(n==2) {return 2;}	//2
		//if(n==3) {return 3;}	//3
		int result = 0, prev = 1, next = 2;
		for(int i=2; i<n; i++) {
			result=prev+next;
			prev=next;
			next=result;
		}
		return result;
	}

	public int climbStairs3(int n) {
		int result = 0, prev = 1, next = 2;
		if(n==1) {result=1;}
		if(n==2) {result=2;}
		for(int i=2; i<n; i++) {
			result=prev+next;
			prev=next;
			next=result;
		}
		return result;
	}

	public int climbStairs4(int n) {
		//公式解，呵呵~
		return (int) (1/Math.pow(5, 0.5)*(Math.pow((1+Math.sqrt(5))/2, n+1)-Math.pow((1-Math.sqrt(5))/2, n+1)));
	}

	public int climbStairs5(int n) {
		//公式解好看化
		double pha = Math.pow(1+Math.sqrt(5), n+1);	//Math.sqrt(5) == Math.pow(5, 0.5)
	    double phb = Math.pow(1-Math.sqrt(5), n+1);
	    double div = Math.pow(2, n+1)*Math.sqrt(5);
		return (int) ((pha-phb)/div);
	}

	public int climbStairs6(int n) {
		//遞迴解
		if(n==1) {return 1;}
		if(n==2) {return 2;}
		return climbStairs6(n-1)+climbStairs6(n-2);
	}

	public int climbStairs7(int n) {
		return n==1 ? 1 : n == 2 ? 2 : climbStairs7(n-1)+climbStairs7(n-2);
	}

	public int climbStairs8(int n) {
		//遞迴解+紀錄，待完成
		if(n==1) {return 1;}
		if(n==2) {return 2;}
		return climbStairs8(n-1)+climbStairs8(n-2);
	}

}
