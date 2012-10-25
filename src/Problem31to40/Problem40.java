package problem31to40;

public class Problem40 {
	private static final int[] NUMBERS = {1, 10, 100, 1000, 10000, 100000, 1000000};
	
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		StringBuilder sb = new StringBuilder();
		long before = System.currentTimeMillis();
		
		for(int i = 1; i < 1000001; i++)
			sb.append(""+ i);
				
		int p = 1;
		for (Integer i : NUMBERS)  
			p *= Character.digit(sb.charAt(i-1), 10);

		long after = System.currentTimeMillis();
		System.out.println("answer: " + p + " (" + (after-before) / (double) 1000 + "s)");
	}
}
