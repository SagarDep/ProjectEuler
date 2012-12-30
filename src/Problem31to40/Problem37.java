package problem31to40;
import java.util.ArrayList;
import java.util.HashSet;

import library.Primes;

public class Problem37 {
	private static HashSet<Integer> SET;

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		ArrayList<Integer> primes = Primes.listOfPrimesBelow(1000000);	// Returns a list of primes < 1,000,000
		SET = new HashSet<Integer>(primes);
		long before = System.currentTimeMillis();
		int counter = 0;
		int sum = 0;
		int i = 4;				// Since we ignore primes 2, 3, 5 & 7
		while(counter != 11) {
			if(checkPrime(primes.get(i))) {
				counter++;
				sum += primes.get(i);
			}
			i++;
		}
		long after = System.currentTimeMillis();
		System.out.println("sum: " + sum + " (" + (after - before) / (double) 1000 + "s)");
	}

	private static boolean checkPrime(int prime) {
		int len = (int) Math.pow(10, ("" + prime).length() -1);

		if(!SET.contains(prime % 10))	return false;
		if(!SET.contains(prime / len))	return false;
		
		int a = prime / 10;		// Removed the most right digit
		int b =	prime % len;	// Remove the most left digit

		return rec(a, b, len/10);
	}

	private static boolean rec(int a, int b, int len) {
		if(!SET.contains(a)) return false;
		if(!SET.contains(b)) return false;
		
		if(a < 10) {
			return true;
		}
		
		int a2 = a / 10;	// Removed the most right digit
		int b2 = b % len;	// Remove the most left digit
		
		return rec(a2, b2, len / 10);
	}
}
