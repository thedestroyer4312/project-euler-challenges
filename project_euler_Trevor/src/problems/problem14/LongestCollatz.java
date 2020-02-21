package problems.problem14;

/**
 * ***SOLVED***
 * Euler Problem #14
 * Finds the longest Collatz sequence with starting number under 1 million
 * A Collatz sequence is where if n is even, the next in the sequence is n/2
 * If it's odd, then the next is 3n + 1
 * Although unproven, it's thought that all sequences terminate at 1 eventually
 * @author Trevor Tsai
 */
public class LongestCollatz{

	public static void main(String[] args){
		long starter = longestCollatzUnder(1000000l);
		System.out.println(starter);
	}

	/**
	 * Returns the number that has the longest Collatz sequence under a
	 * parameter n (exclusive)
	 * @param n The upper limit (exclusive) for starting numbers
	 * @return The number under n that has the longest Collatz sequence
	 */
	public static long longestCollatzUnder(long n){
		int longest = 0;
		long biggestNum = 1;
		for(long i = 1; i < n; i++){
			int temp = collatzCounter(i);
			if(temp > longest){
				longest = temp;
				biggestNum = i;
			}
		}
		return biggestNum;
	}

	/**
	 * Generates the next number in the Collatz sequence given starting number n
	 * @param n The starting number
	 * @return The next number in the sequence (n/2 if n is even, 3n + 1 if odd)
	 */
	public static long nextCollatz(long n){
		long output;
		if(n == 1){
			output = 1;
		}else if(n % 2 == 0){
			output = n / 2;
		}else{
			output = 3 * n + 1;
		}
		return output;
	}

	/**
	 * Finds the length of the Collatz sequence that starts with number n
	 * @param n The starting number for the sequence; the first term
	 * @return The length of the Collatz sequence starting at n
	 */
	public static int collatzCounter(long n){
		long temp = n;
		int counter = 1;
		while(temp != 1){
			temp = nextCollatz(temp);
			counter++;
		}
		return counter;
	}
}
