package basicpart1.problem;

import java.util.Scanner;

public class SumOfDivisor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int i = 0; i < test; i++){
			int num = sc.nextInt();
			int res = sumOfDivisor(num);
			System.out.println(res);
		}
		sc.close();
	}
	static int sumOfDivisor(int n){
		int result = 0;
		for(int i = 1; i <= (int)Math.sqrt(n); i++){
			if(n % i == 0)
				result++;
		}
		if(n == 0 || n == 1)
			return result;
		else{// 9 -> 1 3 9
			 // 2
			//  
			int sq = (int) Math.sqrt(n);
			if(sq * sq == n){
				result = 2 * result - 1;
			}
			else{
				result = 2 * result;
			}
					}
		return result;
	}

}
