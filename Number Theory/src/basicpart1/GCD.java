package basicpart1;

public class GCD {

	public static void main(String[] args) {

		int a = 4;
		int b = 1;
		System.out.println(nativ(a, b));
		System.out.println(recursive(a, b));
		extendedEuclid(a, b);
		System.out.println(x + " " + y + " " + gcdx );
	}
	//O(min(A, B)).
	static int nativ(int a, int b){
		int m = Math.min(a, b);
		int gcd = 0;
		for(int i = m; i >0; i--){
			if(a % i == 0 && b % i ==0)
				return i;
		}
		return 1;
	}
	//O(log(max(A, B))). 
	static int recursive(int a, int b){
		if(b == 0)
			return a;
		return recursive(b, a % b);
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
