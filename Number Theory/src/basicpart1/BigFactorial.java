package basicpart1;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class BigFactorial {
	public static void main(String[] args) throws java.lang.Exception {
		
		
		BigInteger fact = BigInteger.ONE;
		
		int factorialNo = 1000;

		for (int i = 2; i <= factorialNo; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}

		System.out.println("The factorial of " + factorialNo + " is: " + fact);
	}
}