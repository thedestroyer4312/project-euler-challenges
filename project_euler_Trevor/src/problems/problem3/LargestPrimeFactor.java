package problems.problem3;

/**
 * ***SOLVED***
 * Euler Problem #3
 * Finds the largest prime factor of 600851475143
 * @author Trevor Tsai
 */
public class LargestPrimeFactor{

	public static void main(String[] args){
		long largestPFactor = largestPrimeF(600851475143l, 2);
		System.out.println(largestPFactor);
	}

	/**
	 * Calculates the largest prime factor of a number n
	 * @param n A long which indicates the number we are factorizing.
	 * @return The largest prime factor of the number n
	 *
	 * public static long largestPrimeF(long n){ long prime = 1; for(long i =
	 * n/2; i > 0; i--){ if(i % 2 == 0) continue; if(n % i == 0 && isPrime(i))
	 * prime = i; break; } return prime; }
	 */
	/**
	 * Calculates the largest prime factor of a number n
	 * @param n A long which indicates the number we are factorizing.
	 * @param t The test prime
	 * @return largest prime factor of n
	 */
	public static long largestPrimeF(long n, long t){
		if(isPrime(n)){
			return n;
		}else{
			if(n % t == 0){
				return largestPrimeF(n / t, t);
			}else{
				return largestPrimeF(n, largestPrime(t));
			}
		}
	}

	/**
	 * Checks whether an input number n is a prime number
	 * @param n A long which we are testing to see if it is prime
	 * @return A boolean indicating if it is prime or not
	 */
	public static boolean isPrime(long n){
		for(long i = 0; i < n; i++){
			if(i == 0 || i == 1){
				continue;
			}else{
				if(n % i == 0){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 *
	 */
	public static long largestPrime(long n){
		long largest = -1;
		long i = n;
		do{
			i++;
			largest = i;
		}while(!isPrime(i));

		return largest;
	}
}
