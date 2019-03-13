package basicpart1;

import java.math.BigInteger;
import java.util.*;

public class Bigmod {

	private static final int MOD = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		
//		System.out.println(bigMod1(5111, 233));
//		System.out.println(bigMod(5111, 233));
//		
		
		int test = sc.nextInt();

		// StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= test; t++) {
			long n = sc.nextLong();
			long k = sc.nextLong();

			double temp = 1.0 * k * Math.log10(n * 1.0);
			// System.out.println(temp);
			temp = temp - (long) temp;

			long first = (long) (Math.pow(10.0, temp) * 100.0);

			long second = bigMod1(n, k);
			System.out.printf("Case %d: %d %03d\n", t, first, second);
			
			// sb.append("Case " + t + ": " + first + " "+ second + "\n");
//			System.gc();
		}

		// System.out.println(sb.toString());

		sc.close();

	}
//
//	private static long bigMod(long n, long k) {
//		if (k == 1)
//			return n % MOD;
//		long temp = bigMod(n, k / 2);
//		long ans = temp * temp % MOD;
//
//		if (k % 2 == 1)
//			ans = (ans * n) % MOD;
//
//		return ans;
//	}
	
	private static long bigMod1(long n, long k){
		long ans = 1;
	    while(k > 0)
	    {
	        if((k & 1) == 1)
	            ans = ans * n % 1000;
	        n = n * n % 1000;
	        k >>= 1;
	    }
	    return ans;
	}

}