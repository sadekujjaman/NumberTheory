package basicpart1;

import java.util.Scanner;

public class Test {

	//((a^b)/c)%m   , gcd(c,m)=1
	// ans1 = (a^b)%m
	// ans2 = c^-1 % m
	// ans = (ans1 * ans2) % m
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long m = sc.nextLong();
		long ans1 = recursiveModular(a, b, m);
		System.out.println(ans1);
		long ans2 = modInverse1(c, m) % m;
		long ans = (ans1 * ans2) % m;
		System.out.println(ans);
		
		sc.close();
	}
	static long recursiveModular(long x, long n,long m){
		if(n == 0)
			return 1;
		else if(n % 2 == 0)
			return recursiveModular((x * x) % m, n / 2, m);
		else
			return (x * recursiveModular((x * x) % m, (n - 1) / 2, m)) % m;
	}
	//O(log(max(A,M)))
		static long modInverse1(long a, long m){
			extendedEuclid(a, m);
			return (x%m + m ) %m;
		}
		static long x;
		static long y;
		static long gcdx;
		static void extendedEuclid(long a, long b){
			if(b == 0){
				gcdx = a;
				x = 1;
				y = 0;
			}
			else{
				extendedEuclid(b, a % b);
				long temp = x;
				x = y;
				y = temp - ((a / b) * y);
			}
		}


}
