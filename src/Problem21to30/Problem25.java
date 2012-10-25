package problem21to30;

import java.math.BigInteger;

public class Problem25 {

	public Problem25() {
		fibonacci();
	}
	
	private void fibonacci() {
		BigInteger nOld = BigInteger.ZERO;
		BigInteger n = BigInteger.ONE;
		int counter = 0;
		
		while(nOld.toString().length() < 1000) {
			BigInteger temp = nOld.add(n);
			nOld = n;
			n = temp;
			counter++;
		}
		
		System.out.println(counter);
	}

	public static void main(String[] args) {
		new Problem25();
	}

}
