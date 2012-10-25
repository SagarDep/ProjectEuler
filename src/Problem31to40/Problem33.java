package problem31to40;

public class Problem33 {

	public static void main(String[] args) {
		System.out.println(solve());
	}

	private static int solve() {
		Fraction[] res = new Fraction[4];
		int counter = 0;
		for (int i = 10; i < 100; i++) {
			for (int j = i+1; j < 100; j++) {
				double q1 = i / (double)j;
				double q2 = reduceNumbers(i, j);
				
				if(q1 == q2 && q1 < 1 && q2 != 0 && q2 != -1) {
					res[counter] = new Fraction();
					res[counter].x = i;
					res[counter].y = j;
					counter++;
				}				
			}
		}
		System.out.println(counter);
		
		for (Fraction f : res) {
			System.out.println(f.x + " / " + f.y + " = " + (f.x / (double) f.y));
		}
		
		return smallestGCD(res);
	}

	private static int smallestGCD(Fraction[] res) {
		int num = 1;
		int denom = 1;
		
		for (Fraction f : res) {
			num *= f.x;
			denom *= f.y;
		}
		
		int gcd = GCD(num, denom);
		
		return denom / gcd;
		
	}
	
	private static int GCD(int a, int b) {
		return (b == 0 ? a : GCD(b, a%b));
	}

	private static double reduceNumbers(int i, int j) {
		int i1 = i / 10;
		int i2 = i % 10;
		int j1 = j / 10;
		int j2 = j % 10;
		
		if(i1 == j2 && j1 != 0 && i2 != 0)	return i2 / (double) j1;
		if(i2 == j1 && j2 != 0 && i1 != 0)	return i1 / (double) j2;
		
		
		return -1;
	}

}

class Fraction {
	int x;
	int y;
}