package problem01to10;

public class SumOfPrime {

	public static void main(String[] args) {
		boolean[] array = new boolean[2000000];
		long sum = 0;
		
		for (int i = 2; i < array.length; i++) {
			array[i] = true;
		}
		
		for (long i = 2; i * i < array.length; i++) {
			if(array[(int) i]){
				long j = i * i;
				while(j < array.length) {
					array[(int) j] = false;
					j += i;
				}
			}
		}
		
		for (int i = 2; i < array.length; i++) {
			if(array[i])
				sum += (i);
		}
		
		System.out.println(sum);
		
	}
}
