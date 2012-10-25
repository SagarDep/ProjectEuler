package problem31to40;

import java.util.HashMap;

public class Problem38 {
	
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long max = -1;
		long before = System.currentTimeMillis();
		for (long i = 1; i < 10000; i++) {
			int len = ("" + i).length();
			String pan = "";
			boolean done = true;
			for (int j = 1; j <= (10 - len); j++) {
				long x = i * j;
				pan += x;
				if(pan.length() == 9)	break;
				if(pan.length() > 9) {
					done = false;
					break;
				}
			}
			if(done) {
				if(isPanDigital(pan)) {
					long p = Long.parseLong(pan);
					max = (p > max) ? p : max;
				}
					
			}
		}
		long after = System.currentTimeMillis();
		System.out.println("answer: " + max + " (" + (after-before) / (double) 1000 + "s)");
	}

	private static boolean isPanDigital(String s) {
		if(s.length() > 9) return false;
		
		HashMap<Character, String> set = new HashMap<Character, String>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '0')
				set.put(s.charAt(i), null);
		}
				
		return set.size() == 9;
	}
}
