package javaTest;

public class BitwiseOperator {

	public BitwiseOperator() {}

	public static void main(String[] args) {
		//利用位元運算子，計算1的數量
		//&：位元AND運算，兩者都有才取，否則取零。
		//|：位元OR運算，至少兩者其一有則為一，兩者皆無則為零。
		//^：位元XOR運算，只有兩者其一有才為一，兩者皆有及兩者皆無都為零。
		//~：取相反值，一變零，零變一。
		//<<：位元左移

		//<< : 左移運算符，num << 1,相當於num乘以2
		//>> : 右移運算符，num >> 1,相當於num除以2
		//>>> : 無符號右移，忽略符號位，空位都以0補齊

		//★☆java移位運算小技巧☆★ (java僅限正數??)
		//左移一位相當於乘以2的1次方，左移n位就相當於乘以2的n次方。
		//右移一位相當於除以2的1次方，右移n位就相當於除以2的n次方。
		//比如 10 << 1 = 20
		//10 << 3 = 80
		//6 >> 1 = 3
		//6 >> 2 = 1

		//https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/ComputerCode.html

		//你要知道3個事： （1）機器都是使用補碼，運算也是使用補碼運算。
		//（2）正數的原碼補碼反碼都一樣。
		//（3）補碼與原碼相互轉換，其運算過程是相同。
		int intMaximum = Integer.MAX_VALUE;
		int intMinimum = Integer.MIN_VALUE;
		int n = (int) Math.random()*(intMaximum-intMinimum+1)+intMinimum;
		System.out.println("n的十進位 = " + n);
		System.out.println("n的二進位 = " + Integer.toBinaryString(n));
		System.out.println("n的八進位 = " + Integer.toOctalString(n));
		System.out.println("n的十六進位 = " + Integer.toHexString(n));
		System.err.println("====================");
		System.out.println("n>>1 = " + (n>>1));
		System.out.println("n<<1 = " + (n<<1));
		System.out.println("n>>>1 = " + (n>>>1));
		System.out.println("n&1 = " + (n&1));
		System.out.println("n|1 = " + (n|1));
		System.out.println("n^1 = " + (n^1));
		System.out.println("~n = " + ~n);
	}

}
