/**
 * ***WORK IN PROGRESS***
 *Euler Problem #5
 *Finds the smallest positive number that is divisible by all of the numbers from 1 - 20
 */
public class SmallestMultiple{

  public static void main(String[] args){
    System.out.println(smallestMultiple(1, 20));
  }

  /**
   *Finds the smallest positive number divisble by all numbers in a certain range
   *@param min Indicates the starting range
   *@param max Indicates the maximum range
   * @return the smallest multiple evenly divisble by all numbers between min and max -- that is, the least common multiple
   */
  public static long smallestMultiple(int min, int max){
    long output = 1;
    for(int i = min; i < max - 1; i++){
      output *= i;
      output /= gcd(i, i + 1);
    }
    return output;
  }

  /**
   *Finds the greatest common divisor of two numbers using Euclid's algorithm
   *@param a The first number
   *@param b The second number
   *@return The GCD of the two numbers
   */
   public static int gcd(int a, int b){
     if(b == 0)
       return a;
     else
       return gcd(b, a % b);
  }
}
