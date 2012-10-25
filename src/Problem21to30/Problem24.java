package problem21to30;

import java.util.ArrayList;

public class Problem24 {
	private ArrayList<String> combinations;
	
	public Problem24() {
		this.combinations = new ArrayList<String>();
		permutation("0123456789");
		System.out.println(combinations.get(999999));
	}
	
	private void permutation(String str) {
		permut("", str);
	}
	
	private void permut(String prefix, String str) {
		int n = str.length();
		if(n == 0) combinations.add(prefix);
		else {
			for (int i = 0; i < n; i++) {
				permut(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		new Problem24();
	}

}
