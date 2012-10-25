package problem31to40;

public class Problem31 {
	private final int N = 200;
	private final int[] VALUES = {200, 100, 50, 20, 10, 5, 2, 1};
	private int count;
	
	public Problem31() {
		this.count = 0;
		
		long before = System.currentTimeMillis();
		solve(0, N);
		long after = System.currentTimeMillis();
		
		System.out.println("answer " + count + " (" + ((after - before) / (double) 1000) + "s)");
	}
	
	private void solve(int i, int amount) {
		
		if(amount == 0 || i == VALUES.length -1) {
			count++;
			return;
		}
		
		for (int j = 0; j <= amount / VALUES[i]; j++) {
			solve(i + 1, amount - j * VALUES[i]);
		}
	}

	public static void main(String[] args) {
		new Problem31();
	}

}
