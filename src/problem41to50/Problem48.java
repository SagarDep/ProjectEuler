package problem41to50;

import java.math.BigInteger;

public class Problem48 {

	public static void main(String[] args) {
		solve();
		solve2(); //Quicker and portable solution
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		BigInteger n = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++) {
			BigInteger k = BigInteger.valueOf(i);
			k = k.pow(i);
			n = n.add(k);
		}
		String line = n.toString().substring(n.toString().length()-10, n.toString().length());
		
		long after = System.currentTimeMillis();
		System.out.println("answer: " + line + " (" + (after - before) / 1000.0 + "s)");
	}

	private static void solve2() {
		long before = System.currentTimeMillis();
		long result = 0;
		long modulo = 10000000000L;
		
		for (int i = 1; i <= 1000; i++) {
			long temp = i;
			for (int j = 1; j < i; j++) {
				temp *= i;
				temp %= modulo;
			}
			result += temp;
			result %= modulo;
		}
		long after = System.currentTimeMillis();
		System.out.println("answer: " + result + " (" + (after - before) / 1000.0 + "s)");
	}
}
