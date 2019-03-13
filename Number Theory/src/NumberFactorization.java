
public class NumberFactorization {

	public static void main(String[] args) {
		int n = 4972968;
		numberFactorization(n);
		
	}

	private static void numberFactorization(int n) {
		for(int i = 1; i <= Math.sqrt(n); i++){
			if(n % i== 0){
			int a = i;
			int b = 0;
			if(i != Math.sqrt(n))
			    b = n / a;
			System.out.print(" " + a + " " + b);
			}
		}
	}

}

//BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//int T = Integer.parseInt(bufferedReader.readLine());
//String temp[];
//StringBuilder stringBuilder = new StringBuilder();
//
//while (T-- > 0) {
//
//	temp = bufferedReader.readLine().split(" ");
//
//	int num = Integer.parseInt(temp[0]);
//	int a = Integer.parseInt(temp[1]);
//	int b = Integer.parseInt(temp[2]);
//	int c = Integer.parseInt(temp[3]);
//	stringBuilder.append(solve(num, a, b, c) + "\n");
//
//}
//System.out.println(stringBuilder);




//private static int solve(int num, int a, int b, int c) {
//int count = 0;
//int x = Math.max(a, Math.max(b, c));
//int factorsIndex = 0;
//for (int i = 1; i <= x; i++) {
//	if (num % i == 0)
//		factors[factorsIndex++] = i;
//}
//
//for (int i = 0; i < factorsIndex; i++) {
//
//	if (factors[i] > a)
//		break;
//
//	int remaining = num / factors[i];
//
//	for (int j = 0; j < factorsIndex; j++) {
//		if (factors[j] > b || factors[j] > remaining)
//			break;
//		if (remaining % factors[j] == 0)
//			if (remaining / factors[j] < c)
//				count++;
//	}
//}
//return count;
//
//}
