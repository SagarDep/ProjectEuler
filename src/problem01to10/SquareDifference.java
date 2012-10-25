package problem01to10;

public class SquareDifference {

	public static void main(String[] args) {
		int sumOfSquares = 0;
		int squareOfSum = 0;
		
		for (int i = 1; i <= 100; i++) {
			sumOfSquares += (i*i);
			squareOfSum += i;
		}
		
		squareOfSum = squareOfSum * squareOfSum;
		
		
		System.out.println(sumOfSquares);
		System.out.println(squareOfSum);
		System.out.println(squareOfSum - sumOfSquares);
	}	

}
