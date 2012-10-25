package problem31to40;

public class Problem39 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		long before = System.currentTimeMillis();
		int[] p = new int[1000];
		
		for (int a = 1; a < 1000; a++)  //A
			for (int b = a + 1; b < 1000; b++)  //B
				for (int c = b + 1; c < 1000; c++)  //C
					if(a + b + c <= 1000)
						if(isRightAngle(a, b, c))	p[a + b + c - 1]++;
						else						;
					else
						break;

		int max = -1;
		int index = -1;
		for (int i = 0; i < p.length; i++) {
			if(p[i] > max) {
				max = p[i];
				index = i;
			}
		}
		
		long after = System.currentTimeMillis();
		System.out.println("answer: " + (index + 1) + " (" + max + " times) (" + (after - before) / (double) 1000 + "s)");
	}
	
	private static boolean isRightAngle(int a, int b, int c) {
		return a*a + b*b == c*c;
	}
}
