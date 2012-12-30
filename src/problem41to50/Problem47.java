package problem41to50;

import java.util.HashSet;

import library.Primes;

public class Problem47 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		int i = 646, last = -1, counter = 0;
		while(true) {

			if(counter == 4)
				break;

			i++;
			
			HashSet<Integer> set = Primes.primeFactors(i);
			if(set.size() == 4)
				if(last == i - 1)
					counter++;
			else
				counter = 0;
			
			last = i;
		}
		System.out.println("answer: " + (i - 3));
	}
}
