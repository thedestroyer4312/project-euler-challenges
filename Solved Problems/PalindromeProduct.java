/**
 * ***SOLVED***
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
    int min = (int) Math.pow(10, n - 1);
    int max = (int) Math.pow(10, n);
    long largest = -1;
    for(int i = max - 1; i >= min; i--){
      for(int j = max - 1; j >= min; j--){
        if(isPalindrome(i * j) && (i * j) > largest)
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
    String nString = String.valueOf(n);
    return isPalindrome(nString);
  }

  /**
   *
   */
  public static boolean isPalindrome(String input){
    if(input.length() == 1 || input.length() == 0)
      return true;
    else{
      if(input.charAt(0) != input.charAt(input.length() - 1))
        return false;
      else
        return isPalindrome(input.substring(1, input.length() - 1));
    }
  }

  /**
   *Finds the first digit of a number n
   *@param n A number to be evaluated
   *@return First digit of number n
   */
  public static byte firstDigit(long n){
    byte output = -1;
    while(n >= 10){
      n /= 10;
    }
    output = (byte) n;
    return output;
  }

  /**
   *Finds the first digit of a number n
   *@param n A number to be evaluated
   *@return first digit of the number n
   */
  public static int numDigits(long n){
    int numDigits = 1;
    while(n >= 10){
      n /= 10;
      numDigits++;
    }
    return numDigits;
  }
}

