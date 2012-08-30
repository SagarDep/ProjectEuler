package Library;

import java.util.Arrays;

public class Primes {

	public static boolean[] arrayOfPrimes(int n) {
			boolean[] array = new boolean[n];
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
			
			return array;
	}
	
	public static long sumOfPrimesUpTo(int n) {
		boolean[] array = arrayOfPrimes(n);
		long sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i])
				sum += i;
		}
		
		return sum;
	}
}
