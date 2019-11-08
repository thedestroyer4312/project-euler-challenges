/**
 * ***WORK IN PROGRESS***
 *Euler Problem #9
 *Attempts to find the special Pythagorean triple (a^2 + b^2 = c^2)
 *where a + b + c = 1000
 */
public class SpecialPythagoreanTriplet{

  public static void main(String[] args){
    System.out.println(specPTriplet());
  }

 /**
  *Finds the special Pythagorean triple where a + b + c = 1000
  *@return an int[] containing a, b, and c in that order
  */
  public static int[] specPTriplet(){
    int[] output = new int[3];
  }

 /**
  *Checks if three ints fulfill the triple requirement
  *@return true if it does, false if it does not
  */
  public static boolean checkTriple(int a, int b, int c){
    return (a + b + c) == 1000;
  }
}
