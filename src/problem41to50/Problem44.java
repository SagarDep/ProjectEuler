package problem41to50;

public class Problem44 {

	public static void main(String[] args) {
//		solve(); Inefficient, guessing solution
		solve2();
	}

//	private static void solve() {
//		int[] numbers = generatePentagonalNumbers(10000);
//		HashMap<Integer, String> set = new HashMap<Integer, String>();
//		for (int i : numbers) {
//			if(i != 0)
//				set.put(i, null);
//		}
//		int min = Integer.MAX_VALUE;
//		for (int i = 1; i < numbers.length; i++) {
//			int a = numbers[i];
//			for (int j = 1; j < numbers.length; j++) {
//				int b = numbers[j];
//				if(set.containsKey(a-b))
//					if(set.containsKey(a+b))
//						if(Math.abs(b-a) < min)
//							min = Math.abs(b-a);
//			}
//		}
//		System.out.println("D = " + min);
//	}

//	private static int[] generatePentagonalNumbers(int n) {
//		int[] array = new int[n];
//		for (int i = 1; i < array.length; i++) {
//			array[i] = (i * (3*i - 1)) / 2;
//		}
//		return array;
//	}
	
	private static void solve2() {
		int d = Integer.MAX_VALUE;
		boolean notDone = true;
		int i = 0;
		while(notDone) {
			i++;
			int a = i * (3 * i - 1) / 2;	
			
			for (int j = i-1; j > 0; j--) {
				int b = j * (3 * j - 1) / 2;
				if(isPentagonal(a-b))
					if(isPentagonal(a+b)) {
						d = Math.abs(b-a);
						notDone = false;
						break;
					}
			}
		}
		System.out.println("D = " + d);
	}
	
	private static boolean isPentagonal(int n) {
	    double value = (Math.sqrt(1 + 24 * n) + 1.0) / 6.0;
	    return value == ((int) value);
	}
}
