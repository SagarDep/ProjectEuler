package problem21to30;

import java.util.HashMap;

public class Problem29 {
	private final int N = 100;
	
	public Problem29() {
		System.out.println(solve());
	}
	
	private int solve() {
		HashMap<Double, String> map = new HashMap<Double, String>();
		
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
				map.put(Math.pow(i, j), null);
			}
		}
		
		return map.size();
	}

	public static void main(String[] args) {
		new Problem29();
	}
}