package mathexpo;


public class MatExpo {


	static final int MOD = 10007;
	
	public static void main(String[] args) {

		int rows = 2;
		int cols = 2;
		long arr[][] = new long[rows][cols];
		arr[0][0] = 1;
		arr[0][1] = 1;
		arr[1][0] = 1;
		arr[1][1] = 1;
		Matrix matrix = new Matrix(rows, cols, arr);
		Matrix res = matrixPower(matrix, 3);
		System.out.println(res);
		
		Matrix fibMat = fib_expo(5);
		System.out.println(fibMat);
 		
		int k = 2;
		long a[] = {1, 1};
		long c[] = {1, 1};
		Matrix recMat = recurrentSequence(5, k, a, c);
		System.out.println(recMat);
		
		System.exit(0);
	}

	
	private static Matrix recurrentSequence(int n, int k, long[] a, long[] c){
		System.out.println("Recurrent Sequence");
		if(n <= k - 1){
			System.out.println("Solution constant: " + a[n]);
			return null;
		}
		
		Matrix M = buildMatrix(k, c);
//		System.out.println(M);
		long arr[][] = new long[1][k];
		arr[0] = a;
		Matrix initial = new Matrix(1, k, arr);
		Matrix exp = matrixPower(M, n - k + 1);
		
		return initial.multiply(exp);
	}
	private static Matrix buildMatrix(int k, long[] c) {
		long arr[][] = new long[k][k];
		for(int i = 1; i < k; i++){
			arr[i][i - 1] = 1;
		}
		for(int i = 0; i < k; i++){
			arr[i][k - 1] = c[k - i - 1];
		}
		return new Matrix(k, k, arr);
	}
	private static Matrix fib_expo(int n){
		System.out.println("Fib Expo");
		if(n <= 1){
			System.out.println("Constant value");
			return null;
		}
		long arr[][] = new long[1][2];
		arr[0][0] = 1;
		arr[0][1] = 1;
		Matrix initail = new Matrix(1, 2, arr);
		long mrr[][] = new long[2][2];
		mrr[0][0] = 0;
		mrr[0][1] = 1;
		mrr[1][0] = 1;
		mrr[1][1] = 1;
		Matrix M = new Matrix(2, 2, mrr);
		Matrix exp = matrixPower(M, n - 1);
//		System.out.println(exp);
		Matrix res = initail.multiply(exp);
		return res;
	}
	private static Matrix matrixPower(Matrix matrix, int x) {
		int rows = matrix.rows;
		int cols = matrix.cols;
		long arr[][] = new long[rows][cols];
		for(int i = 0; i < rows; i++){
			arr[i][i] = 1;
		}
		Matrix result = new Matrix(rows, cols, arr);
		while(x > 0){
			if(x % 2 == 1){
				result = result.multiply(matrix);
			}
			matrix = matrix.multiply(matrix);
			x /= 2;
		}
		return result;
	}
	
	private static class Matrix{
		long mat[][];
		int rows;
		int cols;
		Matrix(int rows, int cols){
			this.rows = rows;
			this.cols = cols;
			mat = new long[rows][cols];
		}
		Matrix(int rows, int cols, long[][] mat){
			this.rows = rows;
			this.cols = cols;
			this.mat = mat;
		}
		Matrix multiply(Matrix anotherMat){
			int n = this.rows;
			int m = anotherMat.cols;
			long arr[][] = new long[n][m];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					long val = 0;
					for(int k = 0; k < this.cols; k++){
						val = (val  + (this.mat[i][k] % MOD * anotherMat.mat[k][j] % MOD) % MOD) % MOD;
					}
					arr[i][j] = val % MOD;
				}
			}
			return new Matrix(n, m, arr);
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < this.rows; i++){
				for(int j = 0; j < this.cols; j++){
					sb.append(this.mat[i][j] + " ");
				}
				sb.append("\n");
			}
			return sb.toString();
		}
	}
}
