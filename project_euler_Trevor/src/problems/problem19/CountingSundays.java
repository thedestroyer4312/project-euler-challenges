package problems.problem19;

/**
 * ***WORK IN PROGRESS***
 * Given the following information, determine how many Sundays fell on the first of the month during the twentieth
 * century (1/1/1901 - 12/31/2000):
 * 1/1/1900 was a Monday.
 * September, April, June, November have 30 days.
 * The rest have 31, except for February.
 * February has 28 days except for during leap years, when it has 29.
 * A leap year occurs when the year is evenly divisible by 4, but not on a century unless divisible by 400
 * @author Trevor Tsai
 *
 */
public class CountingSundays{

	public static void main(String[] args){
		int count = countSundays(2000);
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
	public static int countSundays(int endY){
		return 0;
	}
}
