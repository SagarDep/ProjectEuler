package problem51to60;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class Problem54 {
	private static final int HIGH_CARD			= 0;
	private static final int ONE_PAIR			= 100;
	private static final int TWO_PAIRS			= 200;
	private static final int THREE_OF_A_KIND	= 300;
	private static final int STRAIGHT			= 400;
	private static final int FLUSH				= 500;
	private static final int FULL_HOUSE			= 600;
	private static final int FOUR_OF_A_KIND		= 700;
	private static final int STRAIGHT_FLUSH		= 800;
	private static final int ROYAL_FLUSH		= 900;
	
	private static final int A_WINS				= 1;
	private static final int DRAW				= 0;
	private static final int B_WINS				= -1;
	
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		try {
			solve();
		} catch (FileNotFoundException e) {		e.printStackTrace();
		} 
		long after = System.currentTimeMillis();
		System.out.println((after - before) / 1000.0 + "s");
	}

	private static void solve() throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(new File("data/poker.txt")));
		

		String[] split = null;
		int counter = 0;
		for (int i = 0; i < 1; i++) {
			Card[] handA = new Card[5];
			Card[] handB = new Card[5];
			boolean flushableA = true;
			boolean flushableB = true;
			
			try {
				split = br.readLine().split(" ");
			} catch (IOException e) {	e.printStackTrace();	}
			
			String suit = split[0].substring(1);
			int val = parseValue(split[0].substring(0, 1));
			handA[0] = new Card(val, suit);
			for (int j = 1; j < 5; j++) {
				suit = split[j].substring(1);
				val = parseValue(split[j].substring(0, 1));
				handA[j] = new Card(val, suit);
				if(!suit.equals(suit))
					flushableA = false;
			}
			
			suit = split[5].substring(1);
			val = parseValue(split[5].substring(0, 1));
			handB[5] = new Card(val, suit);
			for (int j = 1; j < 5; j++) {
				suit = split[j].substring(1);
				val = parseValue(split[j].substring(0, 1));
				handB[j] = new Card(val, suit);
				if(!suit.equals(suit))
					flushableB = false;
			}
			
			Arrays.sort(handA);
			Arrays.sort(handB);
			
//			counter += aIsWinner(playerA, flushableA, playerB, flushableB);
		}
		
		System.out.println("answer: " + counter);
	}

	private static int parseValue(String s) {
		int value = -1;
		try {
			value = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			
			if	   (s.equals("T")) value = 10;
			else if(s.equals("J")) value = 11;
			else if(s.equals("Q")) value = 12;
			else if(s.equals("K")) value = 13;
			else if(s.equals("A")) value = 14;
		}
		return value;
	}
	
	static class Card implements Comparable {
		private int value;
		private String suit;
		public Card(int value, String suit) {
			this.value = value;
			this.suit = suit;
		}
		
		public int compareTo(Object o) {
			Card b = (Card) o;
			Integer a = new Integer(value);
			return a.compareTo(b.value);
		}
	}
}
