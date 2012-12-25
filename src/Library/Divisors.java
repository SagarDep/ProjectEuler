package library;

import java.util.ArrayList;

public class Divisors {

	public static int GCD(int a, int b) {
		return (b == 0 ? a : GCD(b, a%b));
	}
	
	public static ArrayList<Integer> listOfDivisors(int n, boolean includeN) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		if(n == 1) {
			if(includeN) {
				list.add(1);
				return list;
			} else
				return null;
		}
		
		if(n == 2) {
			list.add(1);
			if(includeN) {
				list.add(2);
			}
			return list; 
		}
		
		for (int i = 1; i <= ((n / 2) + 1); i++) {
			if(n % i == 0) {
				list.add(i);
			}
		}
		
		if(includeN)
			list.add(n);
		
		return list;
	}
	
	public static long sumOfDivisors(int n, boolean includeN) {
		ArrayList<Integer> list = listOfDivisors(n, includeN);
		long sum = 0;
		
		for(Integer i : list)
			sum += i;
		
		return sum;
	}
}
