package problem01to10;

public class LargePrimeFactor {

	public static void main(String[] args) {
		System.out.println(findLargestPrime(13195));
		System.out.println(findLargestPrime(600851475143L));
	}

	public static int findLargestPrime(long number){
		int i;
		
		for (i = 2; i <= number; i++) {
			if(number % i == 0) {
				number /= i;
				i--;
			}
		}
		
		return i;
	}
}
