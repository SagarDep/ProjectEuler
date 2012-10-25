package problem21to30;


public class Problem21 {
	
	public Problem21(){
		System.out.println(solve());
	}
	
	private int solve() {
		int[] results = new int[10000]; 
		for (int i = 1; i < results.length; i++) {
			results[i] = d(i);
		}

		int sum = 0;
		for (int i = 1; i < results.length; i++) {
			for (int j = 1; j < results.length; j++) {
				if(i != j && results[i] == j && results[j] == i)
					sum = sum + j;
			}
		}
		
		return sum;
	}

	private int d(int n){
		int sum = 0;
		
		long root = Math.round(Math.sqrt(n) + 1);
		
		for (int i = 2; i <= root; i++) {
			if(n % i == 0) {
				sum += (i + (n/i));
			}
		}
		return sum + 1;
	}

	public static void main(String[] args) {
		new Problem21();
	}

}
