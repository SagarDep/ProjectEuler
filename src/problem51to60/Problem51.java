package problem51to60;

import org.apache.commons.lang3.StringUtils;

import library.Primes;

public class Problem51 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int[] primes = Primes.arrayOfPrimesBetween(100000, 999999);
		
		for (int i : primes) {
			String s = "" + i;
			String last = s.substring(5, 7);
			
			if(StringUtils.countMatches(s, "0") == 3 && hasEightPrimeFamily(s, 0))
				finish(s);
			if(StringUtils.countMatches(s, "1") == 3 && !last.equals("1") && hasEightPrimeFamily(s, 1))
				finish(s);
			if(StringUtils.countMatches(s, "2") == 3 && hasEightPrimeFamily(s, 2))
				finish(s);
		}
	}
	
	private static void finish(String s) {
		System.out.println("answer: " + s);
		System.exit(0);
	}

	private static boolean hasEightPrimeFamily(String s, int digit) {
		
		
		return false;
	}

}
