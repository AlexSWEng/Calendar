package calendrier;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Calendrier {

    String            testNewBranch  = "testNewBranch";

    ArrayList<String> init           = new ArrayList<String>();
    ArrayList<String> temp           = new ArrayList<String>();
    ArrayList<String> daysOfTheMonth = new ArrayList<String>();

    int               startingDayOfTheWeek;

    DateTime          today          = new DateTime();
    int               day            = today.getDayOfMonth();
    int               month          = today.getMonthOfYear();
    int               year           = today.getYear();

    String            titleDate;

    /*
     * Prepares the title for the header with name of Month and Year
     */
    public String getTitleDate() {
        titleDate = convertMonthNumberToString() + " " + String.valueOf( year );
        return titleDate;
    }

    /*
     * Converts the number of the month to the name of the month
     */
    public String convertMonthNumberToString() {
        switch ( month ) {
        case 1:
            return "Janvier";
        case 2:
            return "Fevrier";
        case 3:
            return "Mars";
        case 4:
            return "Avril";
        case 5:
            return "Mai";
        case 6:
            return "Juin";
        case 7:
            return "Juillet";
        case 8:
            return "Aout";
        case 9:
            return "Septembre";
        case 10:
            return "Octobre";
        case 11:
            return "Novembre";
        case 12:
            return "Decembre";
        default:
            return "default";
        }
    }

    /*
     * Fills ArayList init with 42 empty strings
     */
    public void resetInit() {
        init.clear();
        for ( int i = 1; i <= 42; i++ ) {
            init.add( "" );
        }
    }

    /*
     * Fills ArayList temp with 42 empty strings
     */
    public void resetTemp() {
        temp.clear();
        for ( int i = 1; i <= 42; i++ ) {
            temp.add( "" );
        }
    }

    /*
     * Given the month number (1 to 12) and the year, returns the number of days
     * in said month
     */
    public int calcDaysInMonth() {

        int n = 0;

        switch ( month ) {
        case 1:
            n = 31;
            break;
        case 2:
            if ( year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ) {
                n = 29;
            } else {
                n = 28;
            }
            break;
        case 3:
            n = 31;
            break;
        case 4:
            n = 30;
            break;
        case 5:
            n = 31;
            break;
        case 6:
            n = 30;
            break;
        case 7:
            n = 31;
            break;
        case 8:
            n = 31;
            break;
        case 9:
            n = 30;
            break;
        case 10:
            n = 31;
            break;
        case 11:
            n = 30;
            break;
        case 12:
            n = 31;
        }
        return n;
    }

    /*
     * Given the number of days in calcDaysInMonths(), fills ArrayList
     * daysOfTheMonths
     */
    public void fillDaysOfTheMonthArrayList() {
        // we wanna put 28, 29, 30, or 31 here.
        daysOfTheMonth.clear();
        for ( int i = 1; i <= calcDaysInMonth(); i++ ) {
            daysOfTheMonth.add( String.valueOf( i ) );
        }
    }

    /*
     * Given the starting day of the month (start), merges both ArrayLists
     * daysOfTheMonths into temp
     */
    public void mergeWithTemp() {
        for ( int i = 0; i < calcDaysInMonth(); i++ ) {
            temp.set( startingDayOfTheWeek + i, daysOfTheMonth.get( i ) );
        }
    }

    /*
     * Sets month to next month
     */
    public void monthPlus() {
        if ( month == 12 ) {
            year++;
            month = 1;
        } else {
            month++;
        }
    }

    /*
     * Sets month to previous month
     */
    public void monthMinus() {
        if ( month == 1 ) {
            year--;
            month = 12;
        } else {
            month--;
        }
    }

    /*
     * Sets month to current month
     */
    public void resetToToday() {
        month = today.getMonthOfYear();
        year = today.getYear();
    }

    /*
     * To get the starting point in the calendar
     */
    public void defineStart() {
        DateTime date = new DateTime( year, month, 1, 0, 0 );
        startingDayOfTheWeek = date.getDayOfWeek() - 1;
    }

}
