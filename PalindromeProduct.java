/**
 *Finds the largest palindrome that is the product of three digit numbers
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
    int max = Math.pow(10,n);

  }

  /**
   *Checks to see if a number is a palindrome
   *@param n The number to be evaluated
   *@return true if the number is a palindrome, false if it is not
   */
  public static boolean isPalindrome(long n){
    if(n<10) //that is, n is 1 digit
      return true;
    else{

    }
  }
}
