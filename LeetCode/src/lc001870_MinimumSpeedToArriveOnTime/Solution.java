package lc001870_MinimumSpeedToArriveOnTime;

public class Solution {

	public Solution() {}

	public int minSpeedOnTime(int[] dist, double hour) {
		//思路：然後使用binary search，去逼近最小速度
		int result=-1;
		double minTime=dist.length-1+dist[dist.length-1]/1e7;	//最小時間(最高速度)必為dist中的間距dist.length-1加上最後一班的時間，或是說除了dist.length-1項以外其它項所花的時間均計為1hr，所以如果hour<=dist.length-1那肯定無法完成
		if(hour<=minTime) {return hour==minTime ? (int)1e7 : result;}
		int minSpeed=1, maxSpeed=(int)1e7;	//依照題意，最高速度為10^7
		while(minSpeed<=maxSpeed) {
			int midSpeed=minSpeed+(maxSpeed-minSpeed)/2;
			if(isPossibleSpeed(dist, hour, midSpeed)) {
				result=midSpeed;
				maxSpeed=midSpeed-1;
			}else {
				minSpeed=midSpeed+1;
			}
		}
		return result;
	}

	private boolean isPossibleSpeed(int[] distances, double hour, int speed) {
		int length=distances.length;
		double time=0;
		for(int i=0; i<length-1; i++) {
			time+=Math.ceil((double)distances[i] /speed);	//time+=(distances[i]+speed-1) /speed;
		}
		time+=(double)distances[length-1] /speed;
		return time<=hour;
	}

	private boolean isPossibleSpeed2(int[] distances, double hour, int speed) {
		//思路：前一個isPossibleSpeed的改寫，棄用Math.ceil()，改為更騷的操作；利用int會無條件捨去小數點的邏輯，改為計算(distances[i]+speed-1) /speed，如果distances[i]/speed整除，則speed-1/speed的部份會被捨去；如果distances[i]-1 ~ distances[i]+speed-2 /speed整除，則speed/speed的部份會使(distances[i]+speed-1) /speed增加1(因為Math.ceil((double)distances[i] /speed)==(int)distances[i]/speed +1)，也就是無條件進位的邏輯；舉個實例：(int)21~23/4=6
		int length=distances.length;
		double time=0;
		for(int i=0; i<length-1; i++) {
			time+=(distances[i]+speed-1) /speed;	//time+=Math.ceil((double)distances[i] /speed);
		}
		time+=(double)distances[length-1] /speed;
		return time<=hour;
	}

	public int minSpeedOnTime2(int[] dist, double hour) {
		//思路：微改寫前一個minSpeedOnTime方法，將length傳入方法，避免重複宣告
		int result=-1, length=dist.length;
		double minTime=length-1+dist[length-1]/1e7;	//最小時間(最高速度)必為dist中的間距dist.length-1加上最後一班的時間，或是說除了dist.length-1項以外其它項所花的時間均計為1hr，所以如果hour<=dist.length-1那肯定無法完成
		if(hour<=minTime) {return hour==minTime ? (int)1e7 : result;}
		int minSpeed=1, maxSpeed=(int)1e7;	//依照題意，最高速度為10^7
		while(minSpeed<=maxSpeed) {
			int midSpeed=minSpeed+(maxSpeed-minSpeed)/2;
			if(isPossibleSpeed(dist, hour, midSpeed, length)) {
				result=midSpeed;
				maxSpeed=midSpeed-1;
			}else {
				minSpeed=midSpeed+1;
			}
		}
		return result;
	}

	private boolean isPossibleSpeed(int[] distances, double hour, int speed, int length) {
		//思路：搭配minSpeedOnTime2使用，傳入length
		double time=0;
		for(int i=0; i<length-1; i++) {
			time+=Math.ceil((double)distances[i] /speed);	//time+=(distances[i]+speed-1) /speed;
		}
		time+=(double)distances[length-1] /speed;
		return time<=hour;
	}

}
