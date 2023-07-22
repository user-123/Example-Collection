package projecteuler;

public class Pe000001_MultiplesOf3Or5 {

	public Pe000001_MultiplesOf3Or5() {}

	public static void main(String[] args) {
		int n = 1000;//1<=n<=2^31-1	//使用long可以避免運算時出現int overflow，不過方法已經封裝，可以傳入int並自動轉換為long	//using long type can avoid int overflow when program calculate. replace anything you want, just watch out for int overflow
		long multipleOf3Sum=sumOfmultiples(n, 3);
		long multipleOf5Sum=sumOfmultiples(n, 5);
		long multipleOf15Sum=sumOfmultiples(n, 3*5);
		System.out.println(multipleOf3Sum-multipleOf15Sum+multipleOf5Sum);	//先減再加可以避開一些long overflow	//minus first, plus next. we can avoid some cases of long overflow
	}

	private static long sumOfmultiples (long n, int m) {
		return (m+(n-1)/m*m) * ((n-1)/m) /2;
	}

}
