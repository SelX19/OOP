package week1;

/*Create a program that counts and displays how many seconds there are in a year.
You can assume that a year consists of 365 days (therefore the year is not a leap year).*/

public class ex3_counting_seconds_in_a_year {
    public static void main(String[] args) {
        int days_in_year = 365;
        int hours_in_day = 24;
        int minutes_in_hour = 60;
        int seconds_in_minute = 60;

        int seconds_in_year = 365 * 24 * 60 * 60;

        System.out.println(seconds_in_year);
    }
}
