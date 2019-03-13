package basicpart2;

import java.math.BigInteger;
import java.util.*;

public class PrimeFactorLarge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()){
			
			BigInteger bigNum = sc.nextBigInteger();
			
			if(bigNum.compareTo(BigInteger.ZERO) < 0)
				break;
			
			findPrimeFactorBigNum(bigNum);
			
			
			
		}
		
		
		sc.close();

	}

	private static void findPrimeFactorBigNum(BigInteger bigNum) {
	
		StringBuilder sb = new StringBuilder();
		if(bigNum.isProbablePrime(10))
		{
			sb.append("    ");
			sb.append(bigNum);
			sb.append("\n");
		}
		else if(!bigNum.equals(BigInteger.ZERO)){
			BigInteger two = BigInteger.valueOf(2);
			// check for two
			while(bigNum.mod(two).equals(BigInteger.ZERO)){
				bigNum = bigNum.divide(two);
				sb.append("    ");
				sb.append(two);
				sb.append("\n");
			}
			
			// check for three and above number
			
			for(BigInteger big = BigInteger.valueOf(3); big.multiply(big).compareTo(bigNum) < 0; big = big.add(two)){
				
				while(bigNum.mod(big).equals(BigInteger.ZERO)){
					bigNum = bigNum.divide(big);
					sb.append("    ");
					sb.append(big);
					sb.append("\n");
				}
			}
			
			// last factor
			if(bigNum.compareTo(BigInteger.ONE) > 0){
				sb.append("    ");
				sb.append(bigNum);
				sb.append("\n");
			}
			
		}
		else 
			sb.append("\n");
		
		
		System.out.println(sb.toString());
			
		
	}

}