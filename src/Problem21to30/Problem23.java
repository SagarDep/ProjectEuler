package problem21to30;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem23 {

	public Problem23() {
		long before = System.currentTimeMillis();
		System.out.println(solve());
		long after = System.currentTimeMillis();
		System.out.println("Time " + (after-before)/(double)1000 + "s");
	}
	
	private long solve() {
		ArrayList<Integer> abundants = new ArrayList<Integer>();
		
		for(int i = 1; i < 28123; i++) {
			long div = divisors(i);
			if(div > i) {
				abundants.add(i);
			}
		}
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int one : abundants) {
			for (int two : abundants) {
				int sum = one + two;
				if(sum > 28123)
					break;
				else {
					if(!map.containsKey(sum)) {
						map.put(sum, null);
					}
				}
			}
		}
		
		long sum = 0;
		for (int i = 1; i <= 28123; i++) {
			if(!map.containsKey(i))
				sum += i;
		}
		
		return sum;
	}
	
	private long divisors(int n) {
		int sum = 0;
		if(n == 1)
			return 1;
		if(n == 2)
			return 1;
		for (int i = 1; i <= ((n / 2) + 1); i++) {
			if(n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		new Problem23();
	}
}
