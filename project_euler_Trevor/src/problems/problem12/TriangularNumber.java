package problems.problem12;

/**
 * ***SOLVED***
 * Euler Problem #12
 * A triangular number is a number formed by adding natural numbers
 * Example: the 7th triangular number is 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28
 * Find the first triangular number with over 500 divisors
 * @author Trevor Tsai
 */

public class TriangularNumber{

	public static void main(String[] args){
		long triangularNumber = triNumWithNDivisors(500);
		System.out.println(triangularNumber);
		// System.out.println(nthTriNum(500));
	}

	/**
	 * Finds the first triangle number with over n divisors
	 * @param n The number of divisors for the requirement
	 * @return the first triangle number with over n divisors
	 */
	public static long triNumWithNDivisors(int n){
		long output = -1;

		for(int i = 1;; i++){
			long triNum = nthTriNum(i);
			int factors = factorCount(triNum);
			if(factors >= n){
				output = triNum;
				break;
			}
		}
		return output;
	}

	/**
	 * Finds the nth triangular number Adds the natural numbers up to n
	 * (inclusive) starting from 1
	 * @param n The n in nth triangular nubmers
	 * @return the nth triangular number
	 */
	public static long nthTriNum(int n){
		if(n < 1){
			throw new IllegalArgumentException("Cannot find under the 1st triangular number");
		}

		long output = 0;
		for(int i = 1; i <= n; i++){
			output += i;
		}
		return output;
	}

	/**
	 * Counts the factors in a given number Basically, we brute force it
	 * @param n The input number
	 * @return the number of even factors in n (counting 1 and itself)
	 */
	public static int factorCount(long n){
		int count = 0;
		int increment = 1;
		if(n % 2 != 0){
			increment = 2;
		}
		for(long i = 1; i <= (long) Math.sqrt(n); i += increment){
			if(n % i == 0){
				count += 2;// for every even factor there's another
			}
		}
		return count;// because it's also divisible by itself
	}
}
