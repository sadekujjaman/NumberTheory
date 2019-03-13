
import java.util.*;

public class LargestPalindrome {

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = 0;
		for(int i = 100; i <= 999; i++){
			for(int j = 100; j <= 999; j++){
				if(palindromeCheck(i * j)){
					System.out.println(i + "x" + j + " = " + (i * j));
					if(max < (i * j))
						max = (i * j);
				}
			}
		}
		
		System.out.println("Max: " + max);
		
		sc.close();
	}
	static boolean palindromeCheck(int n){
		int temp = n;
		int num = 0;
		while(n > 0){
			int rem = n % 10;
			num *= 10;
			num += rem;
			n /= 10;
		}
		if(num != temp)
			return false;
		return true;
	}


}

