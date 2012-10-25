package problem11to20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem18 {
	private int[][] matrix;

	public Problem18(int[][] matrix) {
		this.matrix = matrix;

		System.out.println(solve());
	}
	
	
	private int solve() {
		return rec(0,0);
	}
	
	private int rec(int i, int j) {
		if(i == 14) {
			return matrix[i][j];
		}
		
		int value = matrix[i][j];
		
		return Math.max(value + rec(i+1, j), value + rec(i+1, j+1));
	}

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("data/Triangle")));
		} catch (FileNotFoundException e) { e.printStackTrace();}
		
		String line;
		String[] split;
		int[][] matrix = new int[15][15];
		
		for (int i = 0; i < 15; i++) {
			line = br.readLine();
			split = line.split(" ");
			for (int j = 0; j < split.length; j++) {
				matrix[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		new Problem18(matrix);
	}
}
