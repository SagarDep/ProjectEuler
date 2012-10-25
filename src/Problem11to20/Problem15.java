package problem11to20;

public class Problem15 {

	public Problem15(){
		solve();
	}
	
	
	private void solve() {
		long[][] pascal = new long[3][3];
		
		for (int i = 0; i < pascal.length; i++) {
			pascal[i][0] = 1;
		}
		
		for (int i = 0; i < pascal.length; i++) {
			pascal[0][i] = 1;
		}
		
		
		
		for (int i = 1; i < pascal.length; i++) {
			for (int j = 1; j < pascal[0].length; j++) {
				pascal[i][j] = pascal[i][j-1] + pascal[i-1][j];
			}
		}
		
		for (int i = 0; i < pascal.length; i++) {
			for (int j = 0; j < pascal[0].length; j++) {
				System.out.print(pascal[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(pascal[2][2]);
	}
	


	public static void main(String[] args) {
		new Problem15();
	}
}
