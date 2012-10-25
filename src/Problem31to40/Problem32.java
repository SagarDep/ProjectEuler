package problem31to40;

import java.util.HashMap;

public class Problem32 {

	public Problem32(){
		System.out.println("Total " + solve());
	}
	
	private int solve() {
		HashMap<Integer, String> set = new HashMap<Integer, String>();
		for (int i = 1; i < 9999; i++) {
			int len = ("" + i).length();
			if(5 - len > 0) {
				for (int j = 1; j < Math.pow(10, 5 - len); j++) {
					int p = i * j;
					if(p > 9999) break;
					String s = ("" + i + j + p);
					if(s.length() == 9) {
						if(checkNumbers(s)) {
							set.put(p, null);
							System.out.println(i + " * " + j + " = " + p);
						}
					}
				}
			}
		}
		int sum = 0;
		for (Integer i : set.keySet()) {
			sum += i;
		}
		System.out.println(set.size());
		
		return sum;
	}

	private boolean checkNumbers(String s) {
		HashMap<Character, String> set = new HashMap<Character, String>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '0')
				set.put(s.charAt(i), null);
		}
				
		return set.size() == 9;
	}

	public static void main(String[] args) {
		new Problem32();
	}

}
