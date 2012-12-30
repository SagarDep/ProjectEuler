package problem41to50;

import java.util.ArrayList;
import java.util.HashMap;

import library.Primes;

public class Problem46 {

	public static void main(String[] args) {
		ArrayList<Integer> primes = Primes.listOfPrimesBelow(100000);
		HashMap<Integer, String> set = new HashMap<Integer, String>();
		
		for (Integer i : primes) {
			set.put(i, null);
		}
		
		boolean done = false;
		int i = 1;
		while(!done) {
			i += 2;
			int j = 0;
			done = true;
			while(i >= primes.get(j)) {
				if(isTwiceSqr(i-primes.get(j))) {
					done = false;
					break;
				}
				j++;
			}
		}
		
		System.out.println("answer: " + i);
	}

	private static boolean isTwiceSqr(long n) {
		double value = Math.sqrt(n / 2);
		return value == (int) value;
	}
}
