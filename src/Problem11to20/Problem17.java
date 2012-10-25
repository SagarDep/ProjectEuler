package problem11to20;

public class Problem17 {
	public static final String[] NUMBERS = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	public static final String[] TENS = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	
	
	public Problem17(){
		String s = new Digit(21).toString();
		System.out.println(s);
		s = new Digit(111).toString();
		System.out.println(s);
		s = new Digit(910).toString();
		System.out.println(s);
		s = new Digit(900).toString();
		System.out.println(s);
		s = new Digit(109).toString();
		System.out.println(s);
		solve();
		
		//Riktigt svar 21124
		//Problemet ligger med tal som 111
	}
	
	private void solve() {
		String line = "";
		for (int i = 1; i <= 1000; i++) {
			line = line + new Digit(i).toString() + ", ";
		}
		
		char c;
		int count = 0;
		for (int i = 0; i < line.length(); i++) {
			c = line.charAt(i);
			
			if(c != ' ' && c != '-' && c != ',')
				count++;
		}
		
		System.out.println(count);
		
		System.out.println(line);
	}






	class Digit {
		private int value;

		public Digit(int value) {
			this.value = value;
		}
		
		public String toString(){
			int hundred, ten, single;
			if(value < 20)
				return NUMBERS[value];
			else if(value >= 20 && value < 100) {
				ten = Integer.parseInt(("" + value).substring(0,1));
				single = Integer.parseInt(("" + value).substring(1,2));
				return TENS[ten] + (single != 0 ? "-" : "") + NUMBERS[single];
			}
			else if(value >= 100 && value < 1000) {
				hundred = Integer.parseInt(("" + value).substring(0,1));
				ten = Integer.parseInt(("" + value).substring(1,2));
				single = Integer.parseInt(("" + value).substring(2,3));
				
				if(value % 100 == 0)
					return NUMBERS[hundred] + " hundred";
				if(ten == 0 && single < 10)
					return NUMBERS[hundred] + " hundred and " + NUMBERS[single];
				
				if(ten == 0 && single < 10)
					return NUMBERS[hundred] + " hundred and " + NUMBERS[single];
				
				if(ten * 10 + single < 20)
					return NUMBERS[hundred] + " hundred and " + NUMBERS[ten*10+single];
				
				return NUMBERS[hundred] + " hundred and " + TENS[ten] + "-" + NUMBERS[single];
				
			}
			else if(value == 1000)
				return "one thousand";
			
			
			return "FUCK YOU";
		}
	}
	
	public static void main(String[] args) {
		new Problem17();
	}
}
