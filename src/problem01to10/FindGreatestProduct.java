package problem01to10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

 
public class FindGreatestProduct {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("data/1000DigitNumber")));
		int highest = 0;
		int prod = 0;
		String line = br.readLine();
		
		int A, B, C, D, E;
		
		for (int i = 0; i < 994; i++) {
			A = Integer.parseInt(line.substring(i, i+1));
			B = Integer.parseInt(line.substring(i+1, i+2));
			C = Integer.parseInt(line.substring(i+2, i+3));
			D = Integer.parseInt(line.substring(i+3, i+4));
			E = Integer.parseInt(line.substring(i+4, i+5));
			
			prod = A * B * C * D * E;
			
			if(prod > highest)
				highest = prod;
		}
		
		System.out.println(highest);
		
		br.close();
	}

}
