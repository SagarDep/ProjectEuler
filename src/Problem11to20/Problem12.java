package problem11to20;

public class Problem12 {

	public static void main(String[] args) {
		
		int maxDivisors = 0;
		int i = 1;
		int number = 0;
		int temp;
		
		while(maxDivisors < 500) {
			number+=i;
			i++;
			temp = numberOfDivisors(number);
			
			if(temp > maxDivisors)
				maxDivisors = temp;
			
		}
		
		System.out.println(number);

	}
	
	public static int numberOfDivisors(int number) {
		int divisors = 0;
		
		for(int i = 1; i <= Math.sqrt((double) number); i++) {
			if(number % i == 0)
				divisors++;
		}
		
		if(divisors > 200)
			System.out.println(number + " " + divisors);
		
		return 2*divisors;
	}

}
