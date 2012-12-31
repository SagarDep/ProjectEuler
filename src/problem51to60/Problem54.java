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
			int[] playerA = new int[5];
			int[] playerB = new int[5];
			boolean flushableA = true;
			boolean flushableB = true;
			
			try {
				split = br.readLine().split(" ");
			} catch (IOException e) {	e.printStackTrace();	}
			
			String color = split[0].substring(1);
			playerA[0] = parseValue(split[0].substring(0, 1));
			for (int j = 1; j < 5; j++) {
				playerA[j] = parseValue(split[j].substring(0, 1));
				if(!color.equals(split[j].substring(1)))
					flushableA = false;
			}
			
			playerB[0] = parseValue(split[5].substring(0, 1));
			for (int j = 1; j < 5; j++) {
				playerB[j] = parseValue(split[j+5].substring(0, 1));
				if(!color.equals(split[j+5].substring(1)))
					flushableB = false;
			}
			
			Arrays.sort(playerA);
			Arrays.sort(playerB);
			
			counter += aIsWinner(playerA, flushableA, playerB, flushableB);
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

	private static int aIsWinner(int[] playerA, boolean flushableA, int[] playerB, boolean flushableB) {
		int scoreA = score(playerA, flushableA);
		int scoreB = score(playerB, flushableB);
		
		if(scoreA > scoreB)	return A_WINS;
		if(scoreB > scoreA)	return B_WINS;
		return DRAW;
	}

	private static int score(int[] cards, boolean flushable) {
		

		int last = -1;
		boolean success = true;
		for (int i = 0; i < cards.length; i++) {
			if(cards[i] <= last) {
				success = false;
				break;
			}
			last = cards[i];
		}
		
		if(success) {
			score = STRAIGHT;
			if(flushable) {
				score = STRAIGHT_FLUSH;
				if(cards[0] == 10)
					score = ROYAL_FLUSH;
			}
			return score;			
		}
		
		int[] c = new int[13];
		for (int i = 0; i < cards.length; i++) {
			c[cards[i]]++;	
		}
		
		int rank = -1;
		int value = -1; //Borde användas sen för att jämföra par
		int highest = -1;
		int two = 0;
		boolean three = false;
		for (int i = 0; i < c.length; i++) {
			if(c[i] != 0 && i > highest)
				highest = i;
			if(c[i] > rank) {
				rank = c[i];
				value = i + 1;
			}
			if(c[i] == 2)
				two++;
			if(c[i] == 3)
				three = true;
		}
		
		if(two == 1 && three)
			return FULL_HOUSE;
		
		if(rank == FOUR_OF_A_KIND)
			return FOUR_OF_A_KIND;
		
		if(flushable)
			return FLUSH;
		
		if(three)
			return THREE_OF_A_KIND;
		
		if(two == 2)
			return TWO_PAIRS;
		
		if(two == 1)
			return ONE_PAIR;
		
		int score = HIGH_CARD + highest;
		
		return score;
	}
}
