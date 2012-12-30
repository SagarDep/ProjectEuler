package problem51to60;

import library.Permutations;

public class Problem52 {

	public static void main(String[] args) {
		long before = System.currentTimeMillis();
//		solve(); //first, easy, naive solution (sloooow ~17s)
		solve2(); // < 1s
		long after = System.currentTimeMillis();
		System.out.println((after-before) / 1000.0 + "s");
	}

//	private static void solve() {
//		boolean done = false;
//		int counter = 0;
//		Set<String> set;
//		
//		while(!done) {
//			counter++;
//			int n = 0;
//			set = Permutations.permutations("" + counter);
//			if(set.contains("" + (2*counter))) n++;
//			if(set.contains("" + (3*counter))) n++;
//			if(set.contains("" + (4*counter))) n++;
//			if(set.contains("" + (5*counter))) n++;
//			if(set.contains("" + (6*counter))) n++;
//			
//			if(n == 5)
//				done = true;
//		}
//		
//		System.out.println("answer: " + counter);
//	}

	private static void solve2() {
		boolean done = false;
		int counter = 0;
		
		while(!done) {
			counter++;
			int n = 0;
			
			if(Permutations.isPermutation(counter, counter*2)) n++;
			if(Permutations.isPermutation(counter, counter*3)) n++;
			if(Permutations.isPermutation(counter, counter*4)) n++;
			if(Permutations.isPermutation(counter, counter*5)) n++;
			if(Permutations.isPermutation(counter, counter*6)) n++;
			
			if(n == 5)
				done = true;
		}
		
		System.out.println("answer: " + counter);
	}
}
