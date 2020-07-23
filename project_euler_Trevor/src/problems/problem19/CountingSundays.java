package problems.problem19;

/**
 * ***WORK IN PROGRESS***
 * Given the following information, determine how many Sundays fell on the first of the month during the twentieth
 * century (1/1/1901 - 12/31/2000):
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs when the year is evenly divisible by 4, but not on a century unless divisible by 400
 * @author Trevor Tsai
 *
 */
public class CountingSundays{

	public static void main(String[] args){
		int count = countSundaysRange(2000);
		System.out.println(count);
	}

	/**
	 * Calculates whether a year is a leap year
	 * @param year An integer representing a year
	 * @return true if the year is evenly divisible by 4 and not 100 or 400, false otherwise
	 */
	public static boolean isLeapYear(int year){
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	/**
	 * Counts the number of Sundays that fall on the first of the month from 1/1/1901 to the ending year
	 * @param endY The ending year
	 * @return the number of Sundays falling on the first month between the two years
	 */
	public static int countSundaysRange(int endY){
		int count = 0;
		for(int i = 1901; i <= 2000; i++){

		}
		return count;
	}

	/**
	 * Counts the number of Sundays that fall on the first of the month for a particular year
	 * @param year The year that is being analyzed (must fall between 1901 and 2000)
	 * @param startingDay A number from 0-6 that tells what the first day of the year was (Sunday, Monday, etc.)
	 * @return The number of Sundays that fell on the first of the month for this year
	 */
	public static int countSundays(int year, int startingDay){
		boolean isLeapYear = isLeapYear(year);
		int days = startingDay;
		for(int i = 0; i < 12; i++){
			if(i == 1 && isLeapYear){
				days += Dictionary.MONTHS[i] + 1;
			}else{
				days += Dictionary.MONTHS[i];
			}
		}
		return 0;
	}
}
