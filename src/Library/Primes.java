package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Primes {

	public static boolean[] boolArrayOfPrimes(int n) {
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
		if(n > Integer.MAX_VALUE) return -1;
		boolean[] array = boolArrayOfPrimes(n);
		long sum = 0;
		
		for (int i = 0; i < array.length; i++)
			if(array[i])	sum += i;
		
		return sum;
	}
	

	public static ArrayList<Integer> listOfPrimes(int n) {
		if(n > Integer.MAX_VALUE) return null;
		boolean[] array = boolArrayOfPrimes(n);
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < array.length; i++)
			if(array[i])	primes.add(i);
		return primes;
	}
	
	
	public static int[] arrayOfPrimesBellow(int n) {
		if(n > Integer.MAX_VALUE) return null;
		
		boolean[] array = boolArrayOfPrimes(n);
		
		int counter = 0;
		for (boolean b : array)
			if(b)	counter++;

		int[] primes = new int[counter];
		counter = 0;

		for (int i = 2; i < array.length; i++) {
			if(array[i]) {
				primes[counter] = i;
				counter++;
			}
		}
		
		return primes;
	}
	
	public static HashSet<Integer> primeFactorization(int number) {
		int n = number;
		HashSet<Integer> factors = new HashSet<Integer>();
		for (int i = 2; i < n/i; i++) {
			while(n % i == 0) {
				factors.add(i);
				n /= i;
			}
		}
		if(n > 1)
			factors.add(n);
		
		return factors;
	}
}
