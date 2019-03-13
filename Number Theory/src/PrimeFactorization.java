

public class PrimeFactorization {

	public static void main(String[] args) {
		int n = 13195;
		primeFactorization(n);
	}
	// O(root n) --> big number
	static void primeFactorization(int n){
		for(int i = 2; i <= Math.sqrt(n); i++){
			if(n % i == 0){
			int count = 0;
			while(n % i == 0){
				count++;
				n = n / i;
			}
			System.out.println("i: " + i + ", count: " + count);
		}
			
		}
		if(n != 1)
			System.out.println(n);
	}

}
