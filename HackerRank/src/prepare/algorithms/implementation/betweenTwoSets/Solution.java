package prepare.algorithms.implementation.betweenTwoSets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY a
	 *  2. INTEGER_ARRAY b
	 */

	public static int getTotalX(List<Integer> a, List<Integer> b) {
	// Write your code here
		//思路：先確認a、b的相對關係，ab之間符合的數有兩個特性，為其中一個set的最小公倍數的倍數，為另一個set的公因數的倍數(最大值為此set的最大公因數)。
		//這裡使用for(int i=最小公倍數; i<=最大公因數; i=最小公倍數*n)解，不過需要先求出gcd和lcm
		int aMin=Integer.MAX_VALUE, aMax=Integer.MIN_VALUE, bMin=Integer.MAX_VALUE, bMax=Integer.MIN_VALUE;
		for(int aElement : a) {
			aMin = aElement<aMin ? aElement : aMin;
			aMax = aElement>aMax ? aElement : aMax;
		}
		for(int bElement : b) {
			bMin = bElement<bMin ? bElement : bMin;
			bMax = bElement>bMax ? bElement : bMax;
		}
		List<Integer> result;
		if(aMax<=bMin) {
			result=getTheNumbers(a, b, aMax, bMin);
		}else if(bMax<=aMin) {
			result=getTheNumbers(b, a, bMax, aMin);
		}else {
			result=new ArrayList<>();
		}
		return result.size();
	}

	private static List<Integer> getTheNumbers(List<Integer> minSet, List<Integer> maxSet, int minNum, int maxNum) {
		List<Integer> result = new ArrayList<>();
		int gcd=getGcd(maxSet), lcm=getLcm(minSet);
		for(int i=lcm, k=1; i<=gcd; i=lcm*++k) {
			if(gcd%i==0) {result.add(i);}	//只要i能整除gcd就是符合的答案
			//if(isEvenlyDivisible(maxSet, i)) {result.add(i);}	//因為已經求得最小公倍數，所以不需要驗證i是否能被minSet整除
		}
		return result;
	}

	private static int getGcd(List<Integer> maxSet) {
		//if(maxSet.size()==1) {return maxSet.get(0);}
		//if(maxSet.size()==2) {return getGcd(maxSet.get(0), maxSet.get(1));}
		int gcd=maxSet.get(0);
		for(int element : maxSet) {
			gcd=getGcd(element, gcd);
		}
		return gcd;
	}

	private static int getGcd(int m, int n) {
		return m%n==0 ? n : getGcd(n, m%n);
	}

	private static int getLcm(List<Integer> minSet) {
		//if(minSet.size()==1) {return minSet.get(0);}
		//if(minSet.size()==2) {return getLcm(minSet.get(0), minSet.get(1));}
		int lcm=minSet.get(0);
		for(int element : minSet) {
			lcm=getLcm(element, lcm);
		}
		return lcm;
	}

	private static int getLcm(int m, int n) {
		int m_n=m*n;
		while(m%n!=0) {
			int temp=m%n;
			m=n;
			n=temp;
		}
		return m_n/n;
	}

	public static int getTotalX2(List<Integer> a, List<Integer> b) {
		//思路：先確認a、b的相對關係，ab之間符合的數有兩個特性，為其中一個set的最小公倍數的倍數，為另一個set的公因數的倍數(最大值為此set的最大公因數)。
		//這裡使用簡單的暴力遍歷解
		Collections.sort(a);
		Collections.sort(b);
		int aMin=a.get(0), aMax=a.get(a.size()-1), bMin=b.get(0), bMax=b.get(b.size()-1);
		List<Integer> result;
		if(aMax<=bMin) {
			result=getTheNumbers2(a, b, aMax, bMin);
		}else if(bMax<=aMin) {
			result=getTheNumbers2(b, a, bMax, aMin);
		}else {
			result=new ArrayList<>();
		}
		return result.size();
	}

	private static List<Integer> getTheNumbers2(List<Integer> minSet, List<Integer> maxSet, int minNum, int maxNum) {
		List<Integer> result = new ArrayList<>();
		for(int i=minNum; i<=maxNum; i++) {
			if(isEvenlyDivisible(i, minSet) && isEvenlyDivisible(maxSet, i)) {result.add(i);}
		}
		return result;
	}

	private static boolean isEvenlyDivisible(int num, List<Integer> minSet) {
		for(int element : minSet) {
			if(num%element!=0) {return false;}
		}
		return true;
	}

	private static boolean isEvenlyDivisible(List<Integer> maxSet, int num) {
		for(int element : maxSet) {
			if(element%num!=0) {return false;}
		}
		return true;
	}
}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int total = Result.getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}
