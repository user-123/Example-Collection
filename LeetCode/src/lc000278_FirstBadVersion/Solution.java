package lc000278_FirstBadVersion;

public class Solution extends VersionControl {

	public Solution() {}

	public int firstBadVersion(int n) {
		int startPointer = 1, endPointer = n, badVersion = -1;	//如果要用array，pointer都-1
		/*
		int[] versionArray = new int[n];
		for(int i=0; i<n; i++) {
			versionArray[i]=i+1;
		}
		*/
		while(startPointer<=endPointer) {
			//不能寫成int currentPointer = (startPointer+endPointer)/2
			//因為startPointer+endPointer有可能會溢位
			int currentPointer = startPointer+(endPointer-startPointer)/2;	//注意！注意！必須要寫成這樣
			if(isBadVersion(currentPointer)) {
				badVersion=currentPointer;
				endPointer=currentPointer-1;
			}else {
				startPointer=currentPointer+1;
			}
		}
		return badVersion;
	}

	@Override
	boolean isBadVersion(int version) {	//這只是個假API，非實際
		return version%2==0 ? false : true;
	}

}
