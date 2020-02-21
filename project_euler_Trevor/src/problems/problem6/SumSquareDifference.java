package problems.problem6;

/**
 * ***SOLVED***
 * Euler Problem #6
 * Finds the difference between the sum of squares and the square of the sums of the first 100 natural numbers
 * @author Trevor Tsai
 */
public class SumSquareDifference{

	public static void main(String[] args){
		System.out.println(Math.abs(sumOfSquares(100) - squareOfSum(100)));
	}

	/**
	 * Finds the sum of the squares of the first n natural numbers
	 * @param n The n natural numbers
	 * @return The sum of the squares (1^2 + 2^2 + 3^3...)
	 */
	public static long sumOfSquares(int n){
		long output = 0;
		for(int i = 0; i <= n; i++){
			output += (long) Math.pow(i, 2);
		}
		return output;
	}

	/**
	 * Finds the square of the sums of the first n natural numbers
	 * @param n The n natural numbers
	 * @return The square of the sums (1 + 2 + 3 +...)^2
	 */
	public static long squareOfSum(int n){
		long output = 0;
		for(int i = 0; i <= n; i++){
			output += i;
		}
		return (long) Math.pow(output, 2);
	}
}
