package problem01to10;

public class Pythagorean1000 {

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			for (int j = 0; j < i; j++) {
				for (int x = 0; x < j; x++) {
					if(i * i == j * j + x * x)
						if(i + j + x == 1000) {
							System.out.println(i*j*x);
						}
				}
			}
		}
	}

}
