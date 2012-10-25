package problem21to30;

/**
 * Project Euler Problem 30
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 1634 = 14 + 64 + 34 + 44
 * 8208 = 84 + 24 + 04 + 84
 * 9474 = 94 + 44 + 74 + 44
 * As 1 = 14 is not a sum it is not included.
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * 
 * """"""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""""
 * 
 * We need to calculate the upper bound. In order to do so we need to know how many digits need to be used.
 * ---------
 * 				Smallest														Highest
 * 3 Digits:	1^5 + 0^5 + 0^5 (1)							-					9^5 + 9^5 + 9^5 (177147)
 * 4 Digits:	1^5 + 0^5 + 0^5 + 0^5 (1)					-					9^5 + 9^5 + 9^5 + 9^5 (236196)
 * 5 Digits:	1^5 + 0^5 + 0^5 + 0^5 + 0^5 (1)				-					9^5 + 9^5 + 9^5 + 9^5 + 9^5 (295245)
 * 6 Digits:	1^5 + 0^5 + 0^5 + 0^5 + 0^5 + 0^5 (1)		-					9^5 + 9^5 + 9^5 + 9^5 + 9^5 + 9^5 (354294)
 * 7 Digits:	1^5 + 0^5 + 0^5 + 0^5 + 0^5 + 0^5 + 0^5 (1)	-					9^5 + 9^5 + 9^5 + 9^5 + 9^5 + 9^5 + 9^5 (413343)
 * 
 * ---------
 * In order to solve the problem the number of digits must be the same as the length of the sum.
 * Since 7 digits only produce a 6 digit number there's no use testing beyond 6 digits.
 * 
 * @author Pagge
 *
 */

public class Problem30 {
	
	public Problem30() {
		long before = System.currentTimeMillis();
		long solution = solve();
		long after = System.currentTimeMillis();
		
		System.out.println("answer " + solution + " (" + ((after - before) / (double)1000) + "s)");
	}
	
	private long solve() {
		int[] powers = new int[10];
		for (int i = 0; i < powers.length; i++) 
			powers[i] = (int) Math.pow(i, 5);
		
		long sum = 0;
		int number;
		int temp;
		int tempSum;
		for(int i = 100; i < 354295; i++) {
			number = i;
			tempSum = 0;
			while(number > 0) {
				temp = number % 10;
				number /= 10;
				tempSum += powers[temp];
			}
			
			if(i == tempSum)
				sum += i;
		}
		return sum;
	}

	public static void main(String[] args) {
		new Problem30();
	}
}
