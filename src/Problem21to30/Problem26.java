package problem21to30;

import java.util.HashMap;

public class Problem26 {
	private final int N = 1000;
	
	public Problem26() {
		System.out.println("result " + solve());
	}
	
	private int solve() {
		int greatest = -1;
		int longest = 0;
		int temp;
		
		for (int i = 1; i < N; i++) {
			temp = recurring(i);
			
			if(temp > longest) {
				greatest = i;
				longest = temp;
			}
		}
		
		return greatest;
	}
	
	private int recurring(int n) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();		
		int counter = 0;
		int remainder = 1 % n;
		map.put(remainder, null);
		counter++;
		for (int i = 0; i < n - 1; i++) {
			remainder = remainder * 10 % n;
			if(map.containsKey(remainder))
				break;
			else {
				map.put(remainder, null);
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		new Problem26();
	}

}
