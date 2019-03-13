package basicpart1;
// modular multiplicative inverse
// a * b % m = 1
public class MMI {

	public static void main(String[] args) {
		int a = 12;
		int m = 5;
		System.out.println(modInverse(a, m));
		System.out.println(modInverse1(a, m));
	}
	// O(m)
	static int modInverse(int a,int m){
		
		for(int b = 1; b < m; b++){
			if((a * b) % m == 1)
				return b;
		}
      return 1;
	}
	//O(log(max(A,M)))
	static int modInverse1(int a, int m){
		extendedEuclid(a, m);
		return (x%m + m ) %m;
	}
	
	static int x;
	static int y;
	static int gcdx;
	static void extendedEuclid(int a, int b){
		if(b == 0){
			gcdx = a;
			x = 1;
			y = 0;
		}
		else{
			extendedEuclid(b, a % b);
			int temp = x;
			x = y;
			y = temp - ((a / b) * y);
		}
	}


}
