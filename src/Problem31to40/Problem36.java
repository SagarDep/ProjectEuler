package problem31to40;

public class Problem36 {
	private static final int N = 1000000;

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		String s;
		int sum = 0;
		for (int i = 0; i < N; i++) {
			s = "" + i;
			if(s.equals(reverseString(s))) {
				s = Integer.toBinaryString(i);
				if(s.equals(reverseString(s)))
					sum += i;
			}
		}
		System.out.println("Sum " + sum);
	}

	private static String reverseString(String original){
		return new StringBuffer(original).reverse().toString();
	}
}
