package basicpart1;

public class ModularExponent {

	public static void main(String[] args) {
		
		int x = 5;
		int n = 4;
		System.out.println(recursive(x, n));
		System.out.println(iterate(x, n));
		System.out.println(optimizeRecursive(x, n));
		System.out.println(optimizeIterate(x, n));
		System.out.println(recursiveModular(x, n, 1000000000));
		System.out.println(iterateModular(x, n, 1000000000));
	}
	
	static int recursive(int x, int n){
		if(n == 0)
			return 1;
		
		return x * recursive(x, n-1);
	}

	static int iterate(int x, int n){
		int result = 1;
		while(n > 0){
			result = result * x;
			n--;
		}
		return result;
	}
	
	static int optimizeRecursive(int x, int n){
		if(n == 0)
			return 1;
		else if(n % 2 == 0)
			return optimizeRecursive(x * x, n / 2);
		else
			return x * optimizeRecursive(x * x, n / 2);
	}
	static int optimizeIterate(int x, int n){
		int result = 1;
		while(n > 0){
			if(n % 2 == 1)
				result = result * x;
			x = x * x;
			n = n / 2;
		}
		return result;
	}
	static int recursiveModular(int x, int n, int m){
		if(n == 0)
			return 1;
		else if(n % 2 == 0)
			return recursiveModular((x * x) % m, n / 2, m);
		else
			return (x * recursiveModular((x * x) % m, (n - 1) / 2, m)) % m;
	}
	static int iterateModular(int x, int n, int m){
		int result = 1;
		while(n > 0){
			if(n % 2 == 1)
				result = (result * x) % m;
			x = (x * x) % m;
			n = n / 2;
		}
		return result;
	}
}
