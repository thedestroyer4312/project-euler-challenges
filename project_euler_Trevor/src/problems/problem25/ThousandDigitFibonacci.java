package problems.problem25;

/**
 * ***SOLVED***
 * Euler Problem #25
 * Finds the first Fibonacci number that is over 1000 digits
 * @author Trevor Tsai
 */
import java.util.*;

import helpers.BigNum;

public class ThousandDigitFibonacci{

	public static void main(String[] args){
		int temp = fibonacciNDigits(1000);
		System.out.println(temp);
	}

	/**
	 * Returns the index of the first number (as a BigNum) in the Fibonacci
	 * sequence with n digits
	 * @param n The number of digits the term should have
	 * @return The index of the first Fibonacci number with n digits
	 */
	public static int fibonacciNDigits(int n){
		// the first two in the sequence are 1 and 1
		List<BigNum> fibSeq = new ArrayList<BigNum>();
		fibSeq.add(new BigNum(1));
		BigNum first = new BigNum(1);
		BigNum previous = new BigNum(1);

		while(first.length() < n){
			// System.out.println("first is " + first);
			// System.out.println("previous is " + previous);
			fibSeq.add(first);
			BigNum temp = new BigNum(first);
			first = first.add(previous);
			// System.out.println("new first is " + first);
			previous = temp;
			// System.out.println("new previous is " + first);
			// System.out.println(fibSeq);
		}
		return fibSeq.size() + 1;
	}
}
