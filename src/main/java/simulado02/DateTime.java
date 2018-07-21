package simulado02;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class DateTime {

	public static void main2(String[] args) {

		LocalDateTime ld = LocalDateTime.of(2015, Month.OCTOBER, 31, 10, 0);

		ZonedDateTime date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Duration.ofDays(1));
		System.out.println(date);

		date = ZonedDateTime.of(ld, ZoneId.of("US/Eastern"));
		date = date.plus(Period.ofDays(1));
		System.out.println(date);

	}

	public static void main(String[] args) {
		Period p = Period.between(LocalDate.now(), LocalDate.of(2018, Month.JULY, 11));
		System.out.println(p);
		Duration d = Duration.between(LocalDate.now(), LocalDate.of(2015, Month.JULY, 11));
		System.out.println(d);
	}

}
