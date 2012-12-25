package problem41to50;

public class Problem45 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int i = 143;
		long n = -1;
		while(true) {
			i++;
			n = i * (2*i - 1);
				if(isPentagonal(n))
					break;
		}
		System.out.println("answer: " + n);
	}

	private static boolean isPentagonal(long n) {
	    double value = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0;
	    return value == ((int) value);
	}
}
