package basicpart2;

import java.util.Scanner;
import java.util.Vector;


public class Totient {
	static int MAX = 5000005;
	static int[] prime = new int[MAX];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		generatePrime();
		int test = sc.nextInt();
		
		for(int t = 1; t <= test; t++){
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a > b)
		{
		  int temp = a;
		  a = b;
		  b = temp;
		}
		long sum = 0;
		for(int i = a; i <= b; i++){
			int coPrime = calculateCoprime(i);
			sum += (coPrime * coPrime);
			
		}
		System.out.println("Case " + t + ": " + sum);
		}
		sc.close();
	}
	
	

	private static int calculateCoprime(int n) {
		int arr[] = new int[n + 2];
		Vector<Integer> result = new Vector<>();
		int num = n;
		while(num != 1){
			int val = prime[num];
			if(result.contains(val)){
				arr[val]++;
			}else{
			  result.add(prime[num]);
			  arr[val] = 1;
			}
			num /= val;
		}
		
		double temp = 1;
		for(int i: result){
//			System.out.println(i + "(" + arr[i] + ")");
			double a = 1.0 / (double)i;
			a = 1.0 -a;
//			System.out.println(a);
			temp *= a;
		}
		
//		System.out.println(temp);
	    
		return  (int)(n * temp);
	}



	private static void generatePrime() {
		
		// O(logN) --> small number(<10^8)
		for(int i = 2; i * i < MAX; i++){
			if(prime[i] == 0){
				for(int j = i * i; j < MAX; j+=i){
					if(prime[j] ==0)
						prime[j] = i;
				}
			}
		}
		for(int i = 2; i < MAX; i++){
			if(prime[i] == 0)
				prime[i] = i;
		}
	}
	
	

}