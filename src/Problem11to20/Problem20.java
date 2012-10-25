package problem11to20;

import java.math.BigInteger;

public class Problem20 {
	private final BigInteger TWO = new BigInteger("2");
	
	public Problem20() {
		String line = solve();
		
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			sum += Character.getNumericValue(line.charAt(i));
		}
		System.out.println(sum);
	}
	
	private String solve() {
		return rec(new BigInteger("100")).toString();
	}
	
	private BigInteger rec(BigInteger n) {
		if(n.compareTo(TWO) == 0)
			return n;
		return n.multiply(rec(n.subtract(BigInteger.ONE)));
	}

	public static void main(String[] args) {
		new Problem20();
	}

}
