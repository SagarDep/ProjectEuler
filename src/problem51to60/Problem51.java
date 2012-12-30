package problem51to60;

import java.util.Set;

import library.Primes;

import org.apache.commons.lang3.StringUtils;

public class Problem51 {
	private static Set<Integer> set;

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int[] primes = Primes.arrayOfPrimesBetween(100000, 999999);
		set = Primes.setOfPrimesBelow(1000000);
		
		String s;
		String last;
		for (int i : primes) {
			s = "" + i;
			last = s.substring(5, 6);
			
			if(StringUtils.countMatches(s, "0") == 3 && hasEightPrimeFamily(s, "0"))
				finish(s);
			if(StringUtils.countMatches(s, "1") == 3 && !last.equals("1") && hasEightPrimeFamily(s, "1"))
				finish(s);
			if(StringUtils.countMatches(s, "2") == 3 && hasEightPrimeFamily(s, "2"))
				finish(s);
		}
	}
	
	private static void finish(String s) {
		System.out.println("answer: " + s);
		System.exit(0);
	}

	private static boolean hasEightPrimeFamily(String s, String digit) {
		String temp;
		int number = Integer.parseInt(s);
		int counter = 0;
		for (int i = 0; i < 10; i++) {
			temp = s.replace(digit, "" + i);
			int n = Integer.parseInt(temp);
			if(set.contains(n) && n >= number)
				counter++;
		}
		return counter == 8;
	}
}
