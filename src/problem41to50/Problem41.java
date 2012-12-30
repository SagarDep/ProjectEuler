package problem41to50;

import library.Primes;
import library.Numbers;

public class Problem41 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		
		int[] primes = Primes.arrayOfPrimesBelow(1000000000);
		
		System.out.println("Array of Primes calculated...");
		
		int max = -1;
		for (int i = 4; i < primes.length; i++) {
			String s = "" + primes[i];
			if(Numbers.isPanDigitalN("" + s, s.length()))
				if(primes[i] > max)
					max = primes[i];
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println("answer: " + max + " " + (after-before) / (double) 1000 + "s");
	}
}
