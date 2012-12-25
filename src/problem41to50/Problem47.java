package problem41to50;

import java.util.HashSet;

import library.Primes;

public class Problem47 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		boolean done = false;
		int i = 646;
		int last = -1;
		int counter = 0;
		while(!done) {

			if(counter == 4) {
				done = true;
				break;
			}

			i++;
			
			HashSet<Integer> set = Primes.primeFactorization(i);
			if(set.size() == 4) {
				if(last == i - 1) {
					counter++;
				}
			} else
				counter = 0;
			
			last = i;
		}
		
		System.out.println("answer: " + (i - 3));
	}

}
