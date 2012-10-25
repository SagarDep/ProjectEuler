package problem01to10;

public class SmallestDivisbleBy1To20 {

	public static void main(String[] args) {
		System.out.println(calc());
	}

	private static String calc() {

		boolean allOK = true;
		int i = 1;
		
		while(allOK) {
			for (int j = 1; j <= 20; j++) {
				if(!(i % j == 0))
					allOK = false;
			}
			
			if(allOK)
				return "" + i;
			else
				allOK = true;
			
			i++;
		}
		
		return "";
	}
}

