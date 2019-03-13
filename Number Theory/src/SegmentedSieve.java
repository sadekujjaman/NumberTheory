import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class SegmentedSieve {

	public static void main(String[] args) {
		Vector<Integer> primes = sieve();
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 0; i < test; i++){
			long left = sc.nextLong();
			long right = sc.nextLong();
			
			if(left > right)
			{
				long temp = right;
				right = left;
				left = temp;
			}
			if(left < 2)
				left = 2;
			printPrimes(left, right, primes);
		}
		sc.close();
	}
	private static void printPrimes(long left, long right, Vector<Integer> primes) {
		int size =(int) (right - left + 1);
		boolean isPrime[] = new boolean[size];
		Arrays.fill(isPrime, true);
		
		for(int i = 0; primes.get(i) * primes.get(i) <= right; i++){
			int currentPrime = primes.get(i);
			
			// just smaller or equal value to left
			long base = (left / currentPrime) * currentPrime;
			if(base < left){
				base = base + currentPrime;
			}
			
			// mark all multiples within left to right as false
			for(long j = base; j <= right; j+=currentPrime){
				isPrime[(int) (j - left)] = false;
			}
			
			// there may be a case where base itself a prime
			if(base == currentPrime){
				isPrime[(int) (base - left)] = true;
			}
		}
		int count = 0;
		for(int i = 0; i <= right - left; i++){
			if(isPrime[i]){
				System.out.println(i + left);
				count++;
			}
		}
		System.out.println(count);
	}
	static final int SIZE = 100001;
	static Vector<Integer> sieve(){
		boolean isPrime[] = new boolean[SIZE];
		Arrays.fill(isPrime, true);
		
		for(int i = 2; i * i < SIZE; i++){
			if(isPrime[i]){
				for(int j = i * i; j < SIZE; j+=i){
					isPrime[j] = false; 
				}
			}
		}
		
		Vector<Integer> primes= new Vector<>();
		primes.add(2);
		for(int i = 3; i < SIZE; i+=2){
			if(isPrime[i]){
				primes.add(i);
			}
		}
		
		return primes;
	}

}
