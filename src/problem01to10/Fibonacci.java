package problem01to10;

public class Fibonacci {
	public static void main(String[] args) {
		int result = 0;
		int oldest = 1;
		int old = 1;
		int newest = 0;
		
		while(old < 4000000) {
			newest = old + oldest;
			if(newest % 2 == 0)
				result += newest;
			oldest = old;
			old = newest;
		}
		
		System.out.println(result);
	}
}
