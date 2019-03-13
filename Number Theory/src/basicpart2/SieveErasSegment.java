package basicpart2;

import java.util.Arrays;
import java.util.Scanner;

public class SieveErasSegment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		long r = sc.nextLong();
		boolean prime[] = new boolean[(int) (r - l + 6)];
		
		Arrays.fill(prime, true);
		for(long i = 2; i * i <= r; i++){//i * i, (l + (i - 1)) / i  * i)
			for(long j = Math.max((i * i), (l + (i - 1)) / (i* i)); j <= r; j+=i){
			   prime[(int) (j - l)] = false;	
			}
		}
		for (long i = Math.max(l, 2); i <= r; ++i) {
		    if (prime[(int) (i - l)]) {
		        System.out.print(i + " ");
		    }
		}
		sc.close();
	}
	

}
