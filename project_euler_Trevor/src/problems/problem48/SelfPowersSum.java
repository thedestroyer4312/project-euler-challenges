package problems.problem48;

import helpers.BigNum;

/**
 * ***SOLVED***
 * Euler Problem #50
 * Find the last 10 digits of the sum of 1^1 + 2^2 + 3^3 +...+ 1000^1000
 * Uses the BigNum class to compute these large numbers
 * NOTE: Runtime is under a minute but not instant
 * @author Trevor Tsai
 */
public class SelfPowersSum{

	public static void main(String[] args){
		BigNum output = selfPowerSum(1000);
		byte[] last10Digits = output.getLastDigits(10);
		for(byte i : last10Digits){
			System.out.print(i);
		}
	}

	/**
	 * Returns the sum of all self powers up until n (inclusive)
	 * Self powers are 1^1 + 2^2, etc.
	 * @param n The upper limit (inclusive) for the self powers
	 * @return A BigNum representing the sum
	 */
	public static BigNum selfPowerSum(int n){
		BigNum output = new BigNum(0);
		for(int i = 1; i <= n; i++){
			BigNum temp = new BigNum(i);
			temp = temp.power(i);
			output = output.add(temp);
		}
		return output;
	}
}
