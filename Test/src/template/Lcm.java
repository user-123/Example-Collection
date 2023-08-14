package template;

public class Lcm {	//最小公倍數(least common multiple, lcm)(lowest common multiple)(smallest common multiple)

	public Lcm() {}

	public static void main(String[] args) {}

	private static int getLcm(int m, int n) {
		return getLcm1(m, n);
	}

	private static int getLcm1(int m, int n) {	//輾轉相除法
		//思路：m*n除以m和n的最大公因數=最小公倍數
		int m_n=m*n;
		while(m%n!=0) {
			int temp=m%n;
			m=n;
			n=temp;
		}
		return m_n/n;
	}

	private static int getLcm2(int m, int n) {	//窮舉法
		int min = m>n ? m : n;
		while(min!=0) {
			if(min%m==0 && min%n==0) {break;}
			min++;
		}
		return min;
	}
}
