package problem21to30;

import java.util.Arrays;

public class Problem27 {
	private boolean[] primes;
	
	public Problem27() {
		initPrimes();
		System.out.println(solve());
	}
	
	private int solve() {
		int nMax = -1;
		int aMax = -1;
		int bMax = -1;
		
		for(int a = -1000; a <= 1000; a++) {
			for (int b = -1000; b <= 1000; b++) {
				int n = 0;
				
				while(isPrime((int)(Math.abs(n * n + a * n + b)))) {
					n++;
				}
				
				if(n > nMax) {
					nMax = n;
					aMax = a;
					bMax = b;
				}
			}
		}
		
		return aMax*bMax;
	}

	private boolean isPrime(int n) {
		return primes[n];
	}
	
	private void initPrimes() {
		boolean[] array = new boolean[2000000];
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
		
		this.primes = array;
	}
	
	public static void main(String[] args) {
		new Problem27();
	}

}
