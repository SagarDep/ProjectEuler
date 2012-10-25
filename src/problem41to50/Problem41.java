package problem41to50;

import java.util.ArrayList;

import library.Primes;

public class Problem41 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		int[] p = Primes.arrayOfPrimes(1000000000);
		long after = System.currentTimeMillis();
		
		System.out.println((after-before) / (double) 1000 + "s");
	}
	
	
}
