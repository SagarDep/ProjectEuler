package problem51to60;

import java.math.BigInteger;

public class Problem53 {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		solve();
		long after = System.currentTimeMillis();
		System.out.println((after-before) / 1000.0 + "s");
	}

	private static void solve() {
		BigInteger[] arr = new BigInteger[101];
		for (int i = 0; i < arr.length; i++)
			arr[i] = fac(BigInteger.valueOf(i));
		
		BigInteger n, r, diff, total;
		BigInteger million = BigInteger.valueOf(1000000);
		BigInteger last = BigInteger.ZERO;
		int counter = 0;
		for (int i = 23; i < arr.length; i++) {
			n = arr[i];
			int count = 0;
		
			for (int j = 0; j <= i; j++) {
				r = arr[j];
				diff = arr[i - j];
				total = n.divide(r.multiply(diff));
				
				if(total.compareTo(last) < 0) {
					if(total.compareTo(million) > 0) 	count = (count - 1) * 2 + 1;
					break;
				}
				
				if(total.compareTo(last) == 0) {
					if(total.compareTo(million) > 0)	count *= 2;
					break;
				}
				
				if(total.compareTo(million) > 0)
					count++;
				
				last = total;
			}
			counter += count;
			last = BigInteger.ZERO;
		}
		System.out.println("answer: " + counter);
	}
	
	private static BigInteger fac(BigInteger n) {
		if(n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE))	return BigInteger.ONE;
		return n.multiply(fac(n.subtract(BigInteger.ONE)));
	}
}
