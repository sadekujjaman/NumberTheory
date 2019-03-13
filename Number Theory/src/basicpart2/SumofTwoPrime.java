package basicpart2;

import java.math.BigInteger;
import java.util.*;

public class SumofTwoPrime {

	private static final int MAX = 100005;
	private static int[] prime = new int[MAX];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		

		int max = 10000005;
		boolean arr[] = new boolean[max + 5];
		
		for(int i = 2; i * i <= max; i++){
			if(arr[i] == false){
				for(int j = i * i; j <= max; j+=i){
					arr[j] = true; 
				}
			}
		}
		
//		
//		for(int i = 2; i <= 50; i++){
//			System.out.println(i + " " + arr[i]);
//		}
		
		int test = sc.nextInt();
		for(int t = 1; t <= test; t++)
		{
			int n=sc.nextInt();
			int count = 0;
			
				int flag = 0;
				for(int i = n / 2 ; i >= 2; i--){
//					BigInteger big1 = BigInteger.valueOf(i);
//					BigInteger big2 = BigInteger.valueOf(n - i);
//					
					if(arr[i] == false && arr[n - i] == false){
//						System.out.println(n + " is the sum of " + i + " and " + (n - i) + ".");
						flag = 1;
						count++;
//						break;
					}
					
				}
				if(flag == 0){
					count = 0;
//					System.out.println(n + " is not the sum of two primes!");
				}
				
			
			System.out.printf("Case %d: %d\n", t, count);
		}
		sc.close();

	}
	
	
}