package calendrier;

import org.joda.time.*;

public class Tests {
	public static void main(String[] args) {
		DateTime date1 = new DateTime(1983, 8, 2, 15, 43);
		System.out.println(date1);
		System.out.println(date1.minusYears(1));
		System.out.println(date1.minusMonths(1));
		System.out.println(date1.minusDays(1));
		System.out.println(date1.getYear());
		System.out.println(date1.getMonthOfYear());
		System.out.println(date1.getDayOfMonth());
	}
}
