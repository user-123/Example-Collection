package template;

public class IntRandom {

	public IntRandom() {}

	public static void main(String[] args) {
		//注意：不能使用int，計算時會溢位
		long numsMaximum = Integer.MAX_VALUE;
		long numsMinimum = Integer.MIN_VALUE;
		int numRandom = (int) (Math.random()*(numsMaximum-numsMinimum+1)+numsMinimum);
		System.out.println(numRandom);
	}
}
