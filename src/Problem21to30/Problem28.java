package problem21to30;

public class Problem28 {
	private final int N = 1001;

	private final int RIGHT = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int UP = 3;
	
	private int[][] matrix;
	
	public Problem28() {
		this.matrix = new int[N][N];
		System.out.println(solve());
	}
	
	private long solve() {
		int dir = RIGHT;
		int steps = 1;
		int i = 1;
		
		int y = (N / 2);
		int x = (N / 2);
		
		while(y != 0 || x != N) {
			
			for (int j = 0; j < steps; j++) {
				
				if(y == 0 && x == N)	break;
				
				matrix[y][x] = i;
				
				if(dir == RIGHT)		x++;
				else if(dir == DOWN)	y++;
				else if(dir == LEFT)	x--;
				else if(dir == UP)		y--;
				
				i++;
			}
			
			if(dir == DOWN)		steps++;
			if(dir == UP)		steps++;
			
			dir = changeDir(dir);
		}
		
		return calcSum();
		
	}
	
	private long calcSum() {
		long sum = 0;
		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				if(i == j || i + j == matrix.length - 1)
					sum += matrix[i][j];
				
		return sum;
	}
	
	private int changeDir(int n) {
		if(n != UP) return n+1;
		else return RIGHT;
	}

	public static void main(String[] args) {
		new Problem28();
	}
}