package problem31to40;

public class Problem34 {
	private static final int N = 2540160;
	private static final int[] FACTORIALS = new int[10];
	
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		for (int i = 0; i <= 9; i++)	FACTORIALS[i] = fac(i);

		int result = 0;
		for (int i = 3; i < N; i++) {
			int sum = 0;
			int temp = i;
			while(temp != 0) {
				sum += FACTORIALS[temp % 10];
				temp /= 10;
			}
			
			if(i == sum)	result += sum;
		}
		System.out.println(result);
	}

	private static int fac(int n) {
		return n < 2 ? 1 : n * fac(n-1);
	}
}
