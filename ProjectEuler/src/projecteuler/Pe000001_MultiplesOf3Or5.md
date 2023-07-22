$ multipleOf3Sum = \dfrac{(3+3i)*i}{2}, 3i<target \le{3(i+1)} $

$ multipleOf5Sum = \dfrac{(5+5j)*j}{2}, 5j<target \le{5(j+1)} $

$ duplicatesSum = multipleOf15Sum = \dfrac{(15+15k)*k}{2}, 15k<target \le{15(k+1)} $

$ result = multipleOf3Sum + multipleOf5Sum - duplicatesSum $

[code=Java]
package projecteuler;

public class Pe000001_MultiplesOf3Or5 {

	public Pe000001_MultiplesOf3Or5() {}

	public static void main(String[] args) {
		int n = 1000;	//replace anything you want, 0<=n<=2^31-1
		long multipleOf3Sum=sumOfmultiples(n, 3);
		long multipleOf5Sum=sumOfmultiples(n, 5);
		long multipleOf15Sum=sumOfmultiples(n, 3*5);
		System.out.println(multipleOf3Sum-multipleOf15Sum+multipleOf5Sum);	//minus first, plus next. we can avoid some cases of long overflow
	}

	private static long sumOfmultiples (long n, int m) {
		return (m+(n-1)/m*m) * ((n-1)/m) /2;
	}

}
[/code]