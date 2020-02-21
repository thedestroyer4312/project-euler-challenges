package problems.problem20;

import helpers.BigNum;

/**
 * ***SOLVED***
 * Euler Problem #20
 * Find the sum of the digits of 100!
 * Uses the helper class BigNum to represent 100!
 */
public class FactorialDigitSum{

	public static void main(String[] args){
		BigNum num = BigNum.factorial(100);
		System.out.println(num.getDigitSum());
	}
}
