package commonLibs.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
	
	public static String getCurrentDateAndTime() {
		
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyy-HH-mm-ss");
		String dateTimeFormat = dateTime.format(formatDate);
		return dateTimeFormat;
	}

}
