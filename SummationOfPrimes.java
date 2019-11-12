/**
 * ***WORK IN PROGRESS***
 *Euler Problem #10
 *Attempts to find the sum of all primes under 2 million
 */
public class SummationOfPrimes{

  public static void main(String[] args){
    System.out.println(sumPrimesUnder(2000000l));
  }
  
 /**
  *Adds all the prime numbers under n, not inclusive
  *@param n The upper limit for primes
  *@return The sum of the primes under n
  */
  public static long sumPrimesUnder(long n){
    long[] output = findPrimesUnder(n);
    long sum = 0;
    for(int i = 0; i < output.length; i++){
      sum += output[i];
    }
  }

 /**
  *Finds all prime numbers under n
  *@param n The upper limit for primes
  *@return all primes under n as a an array of longs
  */
  public static long[] findPrimesUnder(long n){

  }
}
