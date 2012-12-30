package problem41to50;

import java.util.ArrayList;
import java.util.HashMap;
import library.Primes;

public class Problem50 {
	private static final int N = 1000000;

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		int[] array = Primes.arrayOfPrimesBelow(N);
		HashMap<Integer, String> primes = new HashMap<Integer, String>();
		for (int i : array)
			primes.put(i, null);

		ArrayList<Integer> usedPrimes = new ArrayList<Integer>();
		
		int frontSum = 0;
		int frontPrime = -1;
		int frontCount = 0;
		for (int i = 0; i < array.length; i++) {
			if(frontSum + array[i] < N) {
				frontSum += array[i];
				if(primes.containsKey(frontSum)) {
					frontCount = i + 1;
					frontPrime = frontSum;
				}
				usedPrimes.add(array[i]);
			} else {
				System.out.println("Sum of Primes (Front -> End): " + frontPrime + "\tConsecutive Primes: " + frontCount);				
				int endSum = 0;
				int endPrime = -1;
				int endCount = 0;
				for (int j = 0; j < usedPrimes.size(); j++) {
					if(endSum + usedPrimes.get(usedPrimes.size() - 1 - j) < N) {
						endSum += usedPrimes.get(usedPrimes.size() - 1 - j);
						if(primes.containsKey(endSum)) {
							endPrime = endSum;
							endCount = j + 1;
						}
					} else 
						break;
				}
				
				long after = System.currentTimeMillis();
				System.out.println("Sum of Primes (End -> Front): " + endPrime + "\tConsecutive Primes: " + endCount);
				if(frontCount > endCount)
					System.out.println("Answer: " + frontPrime + " (" + (after-before) / (double) 1000 + "s)");
				else
					System.out.println("Answer: " + endPrime + " (" + (after-before) / (double) 1000 + "s)");
				
				break;
			}
		}
	}
}
