package calendrier;

import java.util.ArrayList;

import org.joda.time.*;

public class Calendrier {

	ArrayList<String> init = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	ArrayList<String> daysOfTheMonth = new ArrayList<String>();

	int start;

	String Lundi1;
	String Lundi2;
	String Lundi3;
	String Lundi4;
	String Lundi5;
	String Lundi6;

	String Mardi1;
	String Mardi2;
	String Mardi3;
	String Mardi4;
	String Mardi5;
	String Mardi6;

	String Mercredi1;
	String Mercredi2;
	String Mercredi3;
	String Mercredi4;
	String Mercredi5;
	String Mercredi6;

	String Jeudi1;
	String Jeudi2;
	String Jeudi3;
	String Jeudi4;
	String Jeudi5;
	String Jeudi6;

	String Vendredi1;
	String Vendredi2;
	String Vendredi3;
	String Vendredi4;
	String Vendredi5;
	String Vendredi6;

	String Samedi1;
	String Samedi2;
	String Samedi3;
	String Samedi4;
	String Samedi5;
	String Samedi6;

	String Dimanche1;
	String Dimanche2;
	String Dimanche3;
	String Dimanche4;
	String Dimanche5;
	String Dimanche6;

	DateTime today = new DateTime();

	int day = today.getDayOfMonth();
	int month = today.getMonthOfYear();
	int year = today.getYear();

	String titleDate;

	public String getTitleDate() {
		titleDate = convertMonthNumberToString() + " " + String.valueOf(year);
		return titleDate;
	}
	
	public String convertMonthNumberToString() {
		switch (month) {
		case 1 : 
			return "Janvier";
		case 2 : 
			return "Fevrier";
		case 3 :
			return "Mars";
		case 4 :
			return "Avril";
		case 5 :
			return "Mai";
		case 6 :
			return "Juin";
		case 7 :
			return "Juillet";
		case 8 :
			return "Aout";
		case 9 : 
			return "Septembre";
		case 10 :
			return "Octobre";
		case 11 :
			return "Novembre";
		case 12 :
			return "Decembre";
		default :
			return "yo";
		}
	}

	public void resetInit() {
		init.clear();
		for (int i = 1; i <= 42; i++) {
			init.add("");
		}
	}

	public void resetTemp() {
		temp.clear();
		for (int i = 1; i <= 42; i++) {
			temp.add("");
		}
	}

	public void fillDaysOfTheMonthArrayList() {
		for (int i = 1; i <= 31; i++) {
			daysOfTheMonth.add(String.valueOf(i));
		}
	}

	public void mergeWithTemp() {
		for (int i = 0; i < 31; i++) {
			temp.set(start + i, daysOfTheMonth.get(i));
		}
	}

	public void calculateNumberOfDaysInMonth() {

	}

	public void monthPlus() {
		if (month == 12) {
			year++;
			month = 1;
		} else
			month++;
	}

	public void monthMinus() {
		if (month == 1) {
			year--;
			month = 12;
		} else
			month--;
	}
	
	public void resetToToday() {
		month = today.getMonthOfYear();
		year = today.getYear();
	}

	/*
	 * To get the starting point in the calendar
	 */
	public void defineStart() {

		DateTime day1 = new DateTime(year, month, 1, 0, 0);
		int day1DayofWeek = day1.getDayOfWeek();

		switch (day1DayofWeek) {

		case 1:
			// start at lundi
			start = 0;
			break;
		case 2:
			// start at mardi
			start = 1;
			break;
		case 3:
			// start at mercredi
			start = 2;
			break;
		case 4:
			// start at jeudi
			start = 3;
			break;
		case 5:
			// start at vendredi
			start = 4;
			break;
		case 6:
			// start at samedi
			start = 5;
			break;
		case 7:
			// start at dimanche
			start = 6;
			break;
		}
	}

//		DateTime date1 = new DateTime(1983, 8, 2, 15, 43);
//		System.out.println(date1);
//		System.out.println(date1.minusYears(1));
//		System.out.println(date1.minusMonths(1));
//		System.out.println(date1.minusDays(1));
//		System.out.println(date1.getYear());
//		System.out.println(date1.getMonthOfYear());
//		System.out.println(date1.getDayOfMonth());

}
