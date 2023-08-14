package template;

public class Gcd_Hcf {	//最大公約數(greatest common divisor, gcd)，也稱 最大公因數(highest common factor, hcf)

	public Gcd_Hcf() {}

	public static void main(String[] args) {}

	private static int getGcd(int m, int n) {
		return getGcd1(m, n);
	}

	private static int getGcd1(int m, int n) {	//輾轉相除法_迭代
		while(m%n!=0) {
			int temp=m%n;
			m=n;
			n=temp;
		}
		return n;
	}

	private static int getGcd2(int m, int n) {	//輾轉相除法_遞迴
		return m%n==0 ? n : getGcd2(n, m%n);
	}

	private static int getGcd3(int m, int n) {	//輾轉相除法_遞迴
		if(n==0) {
			return m;
		}else {
			return getGcd3(n, m%n);
		}
	}

	private static int getGcd4(int m, int n) {	//窮舉法
		int max = m>n ? n : m;
		while(max!=0) {
			if(m%max==0 && n%max==0) {break;}
			max--;
		}
		return max;
	}
}
