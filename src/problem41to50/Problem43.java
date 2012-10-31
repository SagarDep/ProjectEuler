package problem41to50;

import java.util.ArrayList;

public class Problem43 {
	private static final ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		permuteString("", "0123456789");
		long sum = 0;
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			
			long d = Integer.parseInt(s.substring(1, 4));
			if(d % 2 != 0)	continue;
			
			d = Integer.parseInt(s.substring(2, 5));
			if(d % 3 != 0)	continue;
			
			d = Integer.parseInt(s.substring(3, 6));
			if(d % 5 != 0)	continue;
			
			d = Integer.parseInt(s.substring(4, 7));
			if(d % 7 != 0)	continue;
			
			d = Integer.parseInt(s.substring(5, 8));
			if(d % 11 != 0)	continue;
			
			d = Integer.parseInt(s.substring(6, 9));
			if(d % 13 != 0)	continue;
			
			d = Integer.parseInt(s.substring(7, 10));
			if(d % 17 != 0)	continue;
			
			sum += Long.parseLong(s);
		}
		
		long after = System.currentTimeMillis();
		
		System.out.println("answer: " + sum + " (" + (after-before) / (double) 1000 + "s)");
	}
	
	private static void permuteString(String beginningString, String endingString) {
	    if (endingString.length() <= 1)
	      list.add(beginningString + endingString);
	    else
	      for (int i = 0; i < endingString.length(); i++) {
	        try {
	          String newString = endingString.substring(0, i) + endingString.substring(i + 1);
	          permuteString(beginningString + endingString.charAt(i), newString);
	        } catch (StringIndexOutOfBoundsException e) {	e.printStackTrace();
	        }
	      }
	}
}
