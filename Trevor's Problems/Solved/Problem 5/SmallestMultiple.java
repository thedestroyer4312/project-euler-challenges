/**
 * ***SOLVED***
 *Euler Problem #5
 *Finds the smallest positive number that is divisible by all of the numbers from 1 - 20
 *@author Trevor Tsai
 */
import java.lang.*;

public class SmallestMultiple{

  public static void main(String[] args){
    System.out.println(smallestMultiple(1, 20));
   // System.out.println(gcd(5,20));
  // System.out.println(smallestMultiple(5,7));
 // System.out.println(smallestMultiple(Integer.parseInt(args[0]),Integer.parseInt(args[1])));
  }

  /**
   *Finds the smallest positive number divisble by all numbers in a certain range
   *@param min Indicates the starting range
   *@param max Indicates the maximum range
   * @return the smallest multiple evenly divisble by all numbers between min and max -- that is, the least common multiple
   */
  public static long smallestMultiple(int min, int max){
    long output = lcm(max - 1, max);
    for(int i = max; i >= min; i--){
      output = lcm(i, output);
    }
    return output;
  }

 /**
  *Returns the LCM of two numbers
  *@param a The first number
  *@param b The second number
  *@return the LCM of the two numbers (their product divided by their GCM)
  */
  public static long lcm(long a, long b){
    return (a*b)/gcd(a,b);
  }
  /**
   *Finds the greatest common divisor of two numbers using Euclid's algorithm
   *@param a The first number
   *@param b The second number
   *@return The GCD of the two numbers
   */
   public static long gcd(long a, long b){
     if(b == 0)
       return a;
     else
       return gcd(b, a % b);
  }
}
