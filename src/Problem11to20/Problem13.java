package problem11to20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;

public class Problem13 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("data/100FiftyDigitNumbers")));
		} catch (FileNotFoundException e) {	e.printStackTrace();}
		
		BigInteger[] numbers = new BigInteger[100];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] =  new BigInteger(br.readLine());
		}
		
		BigInteger biggest = new BigInteger("0");
		
		for (int i = 0; i < numbers.length; i++) {
			biggest = biggest.add(numbers[i]);
		}
		
		System.out.println((biggest.toString().substring(0, 10)));
		
		br.close();
	}

}
