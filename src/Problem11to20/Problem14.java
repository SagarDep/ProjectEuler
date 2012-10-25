package problem11to20;

public class Problem14 {
	private final int N = 1000000;
	
	public Problem14() {
		solve();
	}
	
	private void solve() {
		long nextValue;
		long nodes;
		long longestChain = -1;
		long number = -1;
		
		for(int i = 1; i < N; i++) {
			nextValue = i;
			nodes = 0;
			
			while((nextValue = calcNext(nextValue)) != 1) {
				nodes++;
			}
			
			if(nodes > longestChain) {
				System.out.println(nodes);
				longestChain = nodes;
				number = i;
			}
		}
		System.out.println(number);
	}
	
	private long calcNext(long value) {
		if(value % 2 == 0)
			return value/2;
		else
			return 3*value + 1;
	}
	
	public static void main(String[] args) {
		new Problem14();
	}
}
