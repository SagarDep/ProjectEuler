package problem01to10;

public class Prime10001 {

	public static void main(String[] args) {
		boolean isPrime = true;
		int primes = 0;
		int i = 1;
		
		while(primes < 10001) {
			i++;
			isPrime = true;
			
			for (int j = 2; j < i; j++) {
				if(i % j == 0)
					isPrime = false;
			}
			
			if(isPrime)
				primes++;
			
		}
		
		System.out.println(i);
		
	}

}
