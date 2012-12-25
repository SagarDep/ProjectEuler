package problem41to50;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Problem42 {
	private static final HashMap<Integer, String> set = new HashMap<Integer, String>();
	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("data/Words")));
			line = br.readLine();
			br.close();
		} catch (FileNotFoundException e) {	e.printStackTrace();
		} catch (IOException e) {			e.printStackTrace();}
		
		line = line.replaceAll("\"", "");
		String[] words = line.split(",");
		
		int max = -1;
		for (int i = 0; i < words.length; i++)
			if(words[i].length() > max)
				max = words[i].length();

		calculateTriangleNumbers(max);
		
		int counter = 0;
		for (int i = 0; i < words.length; i++) {
			int value = calculateWordValue(words[i]);
			if(set.containsKey(value)) {
				counter++;
			}
		}
		long after = System.currentTimeMillis();
		System.out.println("answer: " + counter + " (" + (after-before) / (double) 1000 + "s)");
	}

	private static int calculateWordValue(String s) {
		int sum = 0;
		for (int i = 0; i < s.length(); i++)
			sum += (s.charAt(i) - 64);
		return sum;
	}

	private static void calculateTriangleNumbers(int n) {
		int max = n * 26;
		int i = 1;
		int t = 1;
		while(t < max) {
			t = (int) (0.5 * i * (i + 1));
			set.put(t, null);
			i++;
		}
	}
}
