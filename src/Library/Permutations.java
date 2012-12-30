package library;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
	
	public static boolean isPermutation(int m, int n) {
		int[] array = new int[10];
		
		int temp = n;
		while(temp > 0) {
			array[temp % 10]++;
			temp /= 10;
		}
		
		temp = m;
		while(temp > 0) {
			array[temp % 10]--;
			temp /= 10;
		}
		
		for (int i = 0; i < 10; i++)
			if(array[i] != 0) return false;
		return true;
	}
	
	public static Set<String> permutations(String str) { 
	    HashSet<String> list = new HashSet<String>();
		permutation("", str, list);
		return list;
	 }

	 private static void permutation(String prefix, String str, HashSet<String> list) {
	    int n = str.length();
	    if (n == 0) list.add(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n),list);
	    }
	}
	
    // print all subsets of the characters in s
    public static void comb1(String s) { comb1("", s); }

    // print all subsets of the remaining elements, with given prefix 
    private static void comb1(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            comb1(prefix + s.charAt(0), s.substring(1));
            comb1(prefix,               s.substring(1));
        }
    }  

    // alternate implementation
    public static void comb2(String s) { comb2("", s); }
    private static void comb2(String prefix, String s) {
        System.out.println(prefix);
        for (int i = 0; i < s.length(); i++)
            comb2(prefix + s.charAt(i), s.substring(i + 1));
    }  


    // read in N from command line, and print all subsets among N elements
    public static void main(String[] args) {
       int N = 5;
       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String elements = alphabet.substring(0, N);

       // using first implementation
       comb1(elements);
       System.out.println();

       // using second implementation
       comb2(elements);
       System.out.println();
    }
}
