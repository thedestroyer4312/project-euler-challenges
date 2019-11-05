/**
 * ***SOLVED***
 *Euler Problem #1
 *Finds the sum of all multiples of 3 and 5 under a certain number n.
 */
public class multiples3And5{
  public static void main(String[] args){
    int output = multiples3Or5(1000);
    System.out.println(output);
  }
  /**
   *Finds the sum of multiples of 3 or 5 under a number input
   *@param input The upper limit for the multiple sum
   *@return the sum of all multiples of 3 or 5 under input
   */
  public static int multiples3Or5(int input){
    int sum=0;
    for(int i=0;i<input;i+=5){
      sum+=i;
    }
    for(int i=0;i<input;i+=3){
      if(i%5==0)
        continue;
      sum+=i;
    }
    return sum;
  }
}
