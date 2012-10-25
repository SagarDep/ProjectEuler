package problem01to10;

public class Palindrom {

	public static void main(String[] args) {
		int largest = 0;
		int temp;
		
		
		for (int i = 0; i < 999; i++) {
			for (int j = 0; j < 999; j++) {
				temp = i*j;
				if(reverseString("" + temp).equals("" + temp) && temp > largest)
					largest = temp;
			}
		}
		
		System.out.println("largest number is " + largest);
	}
	
	
	public static String reverseString(String original){
		return new StringBuffer(original).reverse().toString();
	}

}
