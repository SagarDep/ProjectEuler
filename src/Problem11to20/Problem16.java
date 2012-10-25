package problem11to20;

import java.math.BigInteger;

public class Problem16 {

	public static void main(String[] args) {
		BigInteger big = new BigInteger("2");
		BigInteger two = new BigInteger("2");
		
		for(int i = 0; i < 999; i++) {
			big = big.multiply(two);
		}
		
		String answer = big.toString();
		int x;
		int sum = 0;
		
		for(int i = 0; i < answer.length(); i++) {
			x = Integer.parseInt(Character.toString(answer.charAt(i)));
			sum += x;
		}
		
		System.out.println(sum);
	}

}
