package problem11to20;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Problem19 {

	public static void main(String[] args) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		int count = 0;
		
		for (int i = 1901; i <= 2000; i++) {
			for (int j = 1; j  <= 12; j++) {
				Calendar now = Calendar.getInstance();
				now.set(i, j, 1);
				if(now.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
					count++;
			}
		}
		System.out.println(count);
	}
}
