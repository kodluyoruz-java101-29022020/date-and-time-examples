package datetime.samples;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws ParseException {
		java7DateTimeExample();
		java8DateTimeExample();
	}
	
	
	private static void java7DateTimeExample() throws ParseException {
		
		// new Date() ile bu anın bilgisini alabilirsiniz.
		Date now = new Date();
		System.out.println(now);

		Date userDefinedDate = new Date(102938102222L);
		System.out.println(userDefinedDate);
		
		// Zaman bilgisini milisaniye cinsinden verir.
		long millisecondsTime = userDefinedDate.getTime();
		System.out.println(millisecondsTime);
		
		// belli bir formata göre tarih bilgisi oluşturmak için SimpleDateFormat sınıfı kullanılır.
		SimpleDateFormat formatter = new SimpleDateFormat ("dd/MMMM/yyyy");
		String formattedDate = formatter.format(new Date());
		System.out.println("Current Date: " + formattedDate);
		
		// String tipte bir veriyi Date tipinde bir veriye çevirmek için SimpleDateFormat sınıfı kullanılır.
		SimpleDateFormat formatter2 = new SimpleDateFormat ("yyyy-MM-dd");
		String dateAstext = "2020-02-10";
		Date parsedDate = formatter2.parse(dateAstext);
		System.out.println("Parsed Date: " + parsedDate.toString());
		
	}
	
	private static void java8DateTimeExample() {
		
		// Java8 ile birlikte tarih işlemleri için LocalDate sınıfı gelmiştir.
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());
				
		// haftanın hangi günü olduğunu bulmak gayet kolaydır.
		DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
		System.out.println(sunday);
		
		// Mevcut tarihe gün, ay, yıl eklemek çıkarmak çok kolaydır.
		LocalDate now1 = LocalDate.now();
		LocalDate sixDaysBehind = now1.minusDays(6);
		
		// iki tarih arası farkı bulmak için Period sınıfının between fonksiyonu tercih edilir.
		Period period = Period.between(now1, sixDaysBehind);
		int diff = period.getDays();
		System.out.println("Gün farkı: " + diff);
	}

}
