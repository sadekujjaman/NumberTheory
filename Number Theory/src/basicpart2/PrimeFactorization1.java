package basicpart2;

import java.util.Arrays;
import java.util.Vector;

public class PrimeFactorization1 {

	public static void main(String[] args) {
		int n = 1;
		
		int prime[] = new int[n + 2];
		
		// O(logN) --> small number(<10^8)
		for(int i = 2; i * i <= n; i++){
			if(prime[i] == 0){
				for(int j = i * i; j <= n; j+=i){
					if(prime[j] ==0)
						prime[j] = i;
				}
			}
		}
		
		
		for(int i = 2; i <= n; i++){
			if(prime[i] == 0)
				prime[i] = i;
		}
		
		
//		int arr[] = new int[n + 2];
		Vector<Integer> result = new Vector<>();
		int num = n;
		while(num != 1){
			int val = prime[num];
			
			if(!result.contains(val))
			     result.add(prime[num]);
			
			num /= val;
		}
		
		for(int i: result){
			System.out.println(i);
		}
	}
	
	
}
