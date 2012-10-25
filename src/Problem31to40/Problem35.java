package problem31to40;

import java.util.ArrayList;
import java.util.Arrays;


public class Problem35 {
	private static final int N = 1000000;
	public static void main(String[] args) {
		solve();
		
		arrayOfPrimes(N);
	}

	private static void solve() {
		ArrayList<Integer> primes = arrayOfPrimes(N);
		
		int counter = 0;
		for (int i = 0; i < primes.size(); i++) {
			int n = primes.get(i);
			if(n == -1)		continue;
			
			int len = ("" + n).length();
			int temp = n;
			ArrayList<Integer> changes = new ArrayList<Integer>();
			for (int j = 0; j < len; j++) {
				int index = primes.indexOf(temp);

				if(index != -1)		changes.add(index);
				else				break;
				
				temp = (temp % 10) * (int) Math.pow(10, len-1) + temp / 10;
			}
			
			if(changes.size() == len) {
				for (Integer prime : changes) {
					if(primes.get(prime) != -1) {
						primes.set(prime, -1);
						counter++;
					}
				}
			} else
				primes.set(i, -1);
		}
		System.out.println("counter " + counter);
	}
	
	private static ArrayList<Integer> arrayOfPrimes(int n) {
		boolean[] array = new boolean[n+1];
		Arrays.fill(array, true);
		for (long i = 2; i * i < array.length; i++) {
			if(array[(int) i]){
				long j = i * i;
				while(j < array.length) {
					array[(int) j] = false;
					j += i;
				}
			}
		}
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < array.length; i++) {
			if(array[i])
				primes.add(i);
		}
		return primes;
	}
}
