package basicpart2;

import java.util.Arrays;
import java.util.Scanner;

// Sieve of Eratosthenes
public class SimpleSieve {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		 //O(NloglogN)
		boolean arr[] = new boolean[n + 5];
		Arrays.fill(arr, true);
		for(int i = 2; i * i <=n; i++){
			if(arr[i] == true){
				for(int j = i * i; j <= n; j+=i){
					arr[j] = false; 
				}
			}
		}
		int count = 0;
		for(int i = 2; i <= n; i++){
			if(arr[i] == true){
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.println(count);
		sc.close();
	}

}
