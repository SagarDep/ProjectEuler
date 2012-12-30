package problem41to50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import library.Permutations;
import library.Primes;

public class Problem49 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		ArrayList<Integer> primes = Primes.listOfPrimesBelow(10000);
		HashMap<Integer,String> set = new HashMap<Integer, String>();
		for (Integer i : primes) {
			if(i > 999 && i < 10000)
				set.put(i, null);
		}
		
		int a = 0, b = 0;
		for (Integer i : primes) {
			a = i + 3330;
			b = a + 3330;
			if(b > 9999)
				break;
			
			if(set.containsKey(a) && set.containsKey(b)) {
				Set<String> perm = Permutations.permutations("" + i);
				if(perm.contains("" + a) && perm.contains("" + b))
					System.out.println("answer: " + i + a + b);
			}
		}
	}

}
