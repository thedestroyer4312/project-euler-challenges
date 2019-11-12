/**
 * ***SOLVED***
 *Euler Problem #9
 *Attempts to find the special Pythagorean triple (a^2 + b^2 = c^2)
 *where a + b + c = 1000
 *@author Trevor Tsai
 */
import java.util.*;

public class SpecialPythagoreanTriplet{

  public static void main(String[] args){
    System.out.println(Arrays.toString(specPTriplet()));
  }

 /**
  *Finds the special Pythagorean triple where a + b + c = 1000
  *@return an int[] containing a, b, and c in that order
  */
  public static int[] specPTriplet(){
    int[] output = new int[3];
    //brute force method

    //Note that with a + b + c = 1000, the highest any of the one numbers can be is 998
    //With a + b + c = 1000, we can rearrange to yield b = 1000 - a - c to reduce the number of variables
    for(int i = 0; i <= 998; i++){//i represents a
      for(int j = 998; j >= 1; j--){//j represents c
        int b = 1000 - i - j;
	if(isTriangle(i, b, j) && isTriple(i, b, j) && isSpecialTriple(i, b, j)){
          output[0] = i;
	  output[1] = b;
	  output[2] = j;
	}
      }
    }
    return output;
  }

 /**
  *Checks to see if three numbers can form a triangle
  *@param a First number
  *@param b Second number
  *@param c Third number, the hypotenuse
  *@return true if it satisfies the triangle inequality, false otherwise
  */
  public static boolean isTriangle(int a, int b, int c){
    return (a + b ) > c;
  }

 /**
  *Checks if three ints fulfill the triple requirement
  *@return true if it does, false if it does not
  */
  public static boolean isSpecialTriple(int a, int b, int c){
    return (a + b + c) == 1000;
  }

 /**
  *Checks if three ints are a Pythagorean triple a^2 + b^2 = c^2
  *@param a The first number
  *@param b The second number
  *@param c The sum of the squares of a and b should equal the square of c
  *@return true if they fill this, false if they do not (within a millionth)
  */
  public static boolean isTriple(int a, int b, int c){
    return (long) Math.abs((Math.pow(a, 2) + Math.pow(b, 2)) - Math.pow(c, 2)) == 0;
  }
}
