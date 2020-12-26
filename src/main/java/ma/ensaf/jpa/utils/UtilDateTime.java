package ma.ensaf.jpa.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class UtilDateTime {

	public static Instant toInstant(String date) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(date));
//
//		return localDateTime.toInstant(ZoneOffset.UTC);
		
		LocalDate localDate = LocalDate.parse(                   
			    date ,        
			    DateTimeFormatter.ofPattern( "yyyy-MM-dd" , Locale.FRANCE )  
			);
		
		Instant instant = localDate.atStartOfDay(ZoneId.of( "UTC" ) ).toInstant();
		return instant;

	}
	
	
	public static void main(String[] args) {
		System.out.println(toInstant("2020-12-25"));
	}
}
