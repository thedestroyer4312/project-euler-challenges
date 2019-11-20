
/**
 * ***SOLVED***
 * Euler Problem #6
 * Finds the 10001st prime
 * @author Trevor Tsai
 */
public class Prime10001{

    public static void main(String[] args){
        System.out.println(findNPrime(10001));
        //System.out.println(findNPrime(Integer.parseInt(args[0])));
    }

    /**
     * Finds the nth prime using a brute force method
     * @param n The input number for the prime
     * @return The nth prime number
     */
    public static long findNPrime(int n){
        int[] primes = new int[n];
        int counter = 0;

        //brute force method
        for(int i = 2;; i++){
            if(counter >= primes.length){
                break;
            }
            if(isPrime(i)){
                primes[counter] = i;
                counter++;
            }
        }
        return primes[primes.length - 1];
    }

    /**
     * Determines if a number n is a prime number using the fact that all primes
     * can be written as 6k + i Test for divisibility by 2 or 3, then with some
     * value of k
     * @param n The number which are we trying to determine is a prime or not
     * @return true if it is prime, false if it is not
     */
    public static boolean isPrime(long n){
        if(n == 2 || n == 3){
            return true;
        }
        if(n % 2 == 0 || n % 3 == 0){
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
