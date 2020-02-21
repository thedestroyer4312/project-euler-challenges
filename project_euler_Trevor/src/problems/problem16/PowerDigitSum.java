package problems.problem16;

import helpers.BigNum;

/**
 * ***SOLVED***
 * Euler Problem #16
 * Find the sum of the digits of 2^1000
 * @author Trevor Tsai
 */
public class PowerDigitSum{

	public static void main(String[] args){
		String output = power(2, 1000);
		int digSum = digitSum(output);
		System.out.println(digSum);
	}

	/**
	 * Returns a String representation of a base raised to a power using the
	 * BigNum class
	 * @param base The base number
	 * @param exp The exponent
	 * @return A String that represents the number
	 */
	public static String power(int base, int exp){
		BigNum temp = new BigNum(base);
		temp = temp.power(exp);
		return temp.toString();
	}

	/**
	 * Sums the digits of a String that represents a number
	 * @param input An input String representing a number
	 * @return The sum of the digits of the number
	 */
	public static int digitSum(String input){
		int sum = 0;
		for(int i = 0; i < input.length(); i++){
			sum += Character.getNumericValue(input.charAt(i));
		}
		return sum;
	}
}
