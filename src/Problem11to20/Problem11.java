package problem11to20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Problem11 {
	private int[][] matrix;

	public Problem11(int[][] matrix) {
		this.matrix = matrix;
		solve();
	}

	private void solve() {
		int right, down, diagRight, diagLeft, temp;
		int max = 0;
		
		for (int i = 0; i < 20-3; i++) {
			for (int j = 0; j < 20-3; j++) {
				right = rightProd(i, j);
				down  = downProd(i, j);
				diagRight  = rightDiagProd(i, j);
				diagLeft = leftDiagProd(i, j);
				temp = Math.max(Math.max(diagRight, diagLeft), Math.max(down, right));

				if(temp > max) 
					max = temp;
			}
		}
		System.out.println(max);
	}
	
	private int rightProd(int i, int j) {
		int value = -1;
		if(i < 17)
			value = matrix[i][j] * matrix[i][j+1] * matrix[i][j+2] * matrix[i][j+3];
		return value;
	}

	private int downProd(int i, int j) {
		int value  = -1;
		if(j < 17)
			value = matrix[i][j] * matrix[i+1][j] * matrix[i+2][j] * matrix[i+3][j];
		
		return value;
	}
	
	private int rightDiagProd(int i, int j) {
		int value  = -1;
		if(i < 17 && j > 17)
			value = matrix[i][j] * matrix[i+1][j+1] * matrix[i+2][j+2] * matrix[i+3][j+3];
		return value;
	}
	
	private int leftDiagProd(int i, int j) {
		int value = -1;
		if(i > 2 && j < 17)
			value = matrix[i][j] * matrix[i-1][j+1] * matrix[i-2][j+2] * matrix[i-3][j+3];
		return value;
	}
	
	public static void main(String[] args) throws IOException {
		int[][] matrix = new int[20][20];
		String[] split;
		String line;
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(new File("data/20x20DigitMatrix")));
		} catch (FileNotFoundException e) { e.printStackTrace();}
		
		for (int i = 0; i < 20; i++) {
			line = br.readLine();
			split = line.split(" ");
			for (int j = 0; j < split.length; j++)
				matrix[i][j] = Integer.parseInt(split[j]);
		}
		new Problem11(matrix);
	}
}
