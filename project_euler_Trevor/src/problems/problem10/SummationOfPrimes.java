package problems.problem10;

/**
 * ***SOLVED***
 * Euler Problem #10
 * Attempts to find the sum of all primes under 2 million
 */
import java.util.*;

public class SummationOfPrimes{

	public static void main(String[] args){
		System.out.println(sumPrimesUnder(2000000));
	}

	/**
	 * Adds all the prime numbers under n, not inclusive This only works for n
	 * <= INTEGER.MAX_VALUE because the maximum length of an array is that value
	 * To go above this value, another implementation would be required to
	 * exceed the integer limit @param n The upper limit for primes @return The
	 * sum of the primes under n
	 */
	public static long sumPrimesUnder(int n){
		int[] output = findPrimesUnder(n);
		long sum = 0;
		for(int i = 0; i < output.length; i++){
			sum += output[i];
		}
		return sum;
	}

	/**
	 * Finds all prime numbers under n using the Sieve of Eratosthenes The Sieve
	 * of Eratosthenes is where once a prime number is found, all multiples of
	 * that number are then eliminated as primes
	 * @param n The upper limit for primes
	 * @return all primes under n as a an array of ints
	 */
	public static int[] findPrimesUnder(long n){
		boolean[] list = new boolean[(int) n + 1];
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for(int i = 0; i < list.length; i++){// Setting all values of list to true initially (prime until proven
												// otherwise)
			list[i] = true;
		}

		for(int i = 0; i < list.length; i++){
			if(!list[i]){
				continue;
			}else{
				if(!isPrime(i))// if the number is not prime
				{
					list[i] = false;
				}else{// if the number is prime
					primes.add(i);
					for(int j = 2 * i; j < list.length; j += i){
						list[j] = false;
					}
				}
			}
		}
		int[] output = new int[primes.size()];
		for(int i = 0; i < output.length; i++){// filling an output int[]
			output[i] = primes.get(i);
		}
		return output;
	}

	/**
	 * Finds whether a number is prime using the fact that all primes can be
	 * written as 6k +- 1
	 * @param n An int, the number we are checking
	 * @return true if n is prime, false if it is not
	 */
	public static boolean isPrime(int n){
		if(n == 2 || n == 3){
			return true;
		}
		if(n % 2 == 0 || n % 3 == 0 || n == 0 || n == 1){
			return false;
		}
		boolean isPrime = true;
		for(int i = 5; i * i <= n; i += 6){
			if(n % i == 0 || n % (i + 2) == 0){
				isPrime = false;
				break;
			}
		}
		return isPrime;
	}
}
