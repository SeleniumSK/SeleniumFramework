package utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class Helper {
	
	@Test
	public static String getCurrentTime(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-DD-YY-HH-mm-ss");
		
		Date date = new Date();
		
		String currentDate = dateFormat.format(date);
		
		System.out.println(currentDate);
		return currentDate;
	}

}
