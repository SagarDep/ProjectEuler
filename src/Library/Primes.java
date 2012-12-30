package library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Primes {

	public static boolean[] boolArrayOfPrimesBelow(int n) {
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

	public static Set<Integer> setOfPrimesBelow(int n) {
		int[] array = arrayOfPrimesBelow(n);
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer i : array)
			set.add(i);
		return set;
	}
	
	public static long sumOfPrimesUpTo(int n) {
		if(n > Integer.MAX_VALUE) return -1;
		boolean[] array = boolArrayOfPrimesBelow(n);
		long sum = 0;
		
		for (int i = 0; i < array.length; i++)
			if(array[i])	sum += i;
		
		return sum;
	}
	

	public static ArrayList<Integer> listOfPrimesBelow(int n) {
		if(n > Integer.MAX_VALUE) return null;
		boolean[] array = boolArrayOfPrimesBelow(n);
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 2; i < array.length; i++)
			if(array[i])	primes.add(i);
		return primes;
	}
	
	
	public static int[] arrayOfPrimesBelow(int n) {
		if(n > Integer.MAX_VALUE) return null;
		
		boolean[] array = boolArrayOfPrimesBelow(n);
		
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
	
	public static int[] arrayOfPrimesBetween(int first, int last) {
		if(last > Integer.MAX_VALUE) return null;
		
		boolean[] array = boolArrayOfPrimesBelow(last+1); // +1 to include last in array
		
		int counter = 0;
		for (int i = 0; i < array.length; i++)
			if(array[i] && i >= first)	counter++;
			
		int[] primes = new int[counter];
		counter = 0;

		for (int i = first; i < array.length; i++) {
			if(array[i]) {
				primes[counter] = i;
				counter++;
			}
		}
		
		return primes;
	}
	
	public static HashSet<Integer> primeFactors(int number) {
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
	
	public static boolean isPrime(int n) {
	    for(int i=2;2*i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}
