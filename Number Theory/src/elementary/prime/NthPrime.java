package elementary.prime;

import java.util.Scanner;

public class NthPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(isPrime(2));
		System.out.println(nthPrime(5000000));
		sc.close();
	}
	
	private static int nthPrime(int n){
		int candidate = 2;
		int count = 0;
		for(candidate = 2, count = 0;count<n; ++candidate){
			if(isPrimeOpt(candidate)){
				++count;
				//System.out.print(candidate + " ");
			}
		}
		System.out.println();
		return candidate -1;
	}

	private static boolean isPrime(int candidate) {
		if(candidate == 1)
			return false;
		int n = (int) Math.sqrt(candidate);
		for(int i = 2; i <= n; i++){
			if(candidate % i == 0)
				return false;
		}
		return true;
	}
	
	private static boolean isPrimeOpt(int n) {
	    if (n % 2 == 0) return n == 2;
	    if (n % 3 == 0) return n == 3;
	    int step = 4, m = (int)Math.sqrt(n) + 1;
	    for(int i = 5; i < m; step = 6-step, i += step) {
	        if (n % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
