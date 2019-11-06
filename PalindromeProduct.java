/**
 * ***WORK IN PROGRESS***
 *Euler Problem #4
 *Finds the largest palindrome that is the product of three digit numbers
 *@author Trevor Tsai
 */
public class PalindromeProduct{

  public static void main(String[] args){
    long largestPProduct = largestPalindromeProduct(3);
    System.out.println(largestPProduct);
  }

  /**
   *Returns the largest palindrome product number of two n-digit numbers
   *@param n The number of digits permitted (n digits)
   *@return The largest palindrome product of two n-digit numbers
   */
  public static long largestPalindromeProduct(int n){
    int max = (int) Math.pow(10,n);
    long largest = -1;
    for(int i = 0; i < max; i++){
      for(int j = 0; j < max; j++){
        if(isPalindrome(i * j))
	  largest = i * j;
      }
    }
    return largest;
  }

  /**
   *Checks to see if a number is a palindrome
   *@param n The number to be evaluated
   *@return true if the number is a palindrome, false if it is not
   */
  public static boolean isPalindrome(long n){
    if(n < 10) //that is, n is 1 digit
      return true;
    if(n < 100){ //that is, n is 2 digits
      return n / 10 == n % 10;
    }else{
      if(firstDigit(n) != n % 10)
        return false;
      else
        return isPalindrome(n / 10 - firstDigit(n / 10) * ((int) (Math.pow(10, numDigits(n / 10) - 1))));
    }
  }

  /**
   *Finds the first digit of a number n
   *@param n A number to be evaluated
   *@return First digit of number n
   */
  public static byte firstDigit(long n){
    if(n < 10)
     return (byte) n;
    else
      return firstDigit(n / 10);
  }

  /**
   *Finds the first digit of a number n
   *@param n A number to be evaluated
   *@return first digit of the number n
   */
  public static int numDigits(long n){
    int numDigits = 1;
    for(int i = 10; (n / i) < 10; i *= 10){
      numDigits++;
    }
    return numDigits;
  }
}

