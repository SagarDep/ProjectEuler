package library;

import java.util.HashMap;

public class Numbers {

	public static boolean isPanDigital(String s) {
		if(s.length() > 9) return false;
		
		HashMap<Character, String> set = new HashMap<Character, String>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '0')
				set.put(s.charAt(i), null);
		}
				
		return set.size() == 9;
	}
	
	public static boolean isPanDigitalN(String s, int n) {
		if(n > 9 || s.length() > n) return false;
		
		HashMap<Character, String> set = new HashMap<Character, String>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch != '0' && Character.digit(ch, 10) <= n)
				set.put(s.charAt(i), null);
		}
				
		return set.size() == n;
	}
	
	public static boolean isPentagonal(int n) {
	    double value = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0;
	    return value == ((int) value);
	}
	
	public static boolean isHexagonal(int n) {
		double value = (Math.sqrt(1.0 + 8 * n) + 1.0) / 4.0;
	    return value == ((int) value);
	}
	
	public static boolean isTriangular(int n) {
		double value = (Math.sqrt(1 + 8 * n) - 1.0) / 2.0;
	    return value == ((int) value);
	}

	public static long factorial(int n) {
		if(n == 0 || n == 1) return 1;
		return n * factorial(n-1);
	}
}
