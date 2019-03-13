package basicpart1.problem;

import java.util.Scanner;

public class LoveTriangle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		long result = loveTriangle(n);
		System.out.println(result);
		sc.close();
	}
	//100
	// 1 + 10 *
	// 1
	static long loveTriangle(long n){
		if(n < 9)
			return n;
		return n % 9 + (10 * loveTriangle(n / 9));
	}

}
