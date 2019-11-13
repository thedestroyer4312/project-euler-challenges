/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecteuler;
/**
 *
 * @author twojineric
 */
public class LongestCollatzSequence {
    
   /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      System.out.println(longestCollatzSeq(1000000));
    } 
    
    public static long lengthCollatz(long n)
    {
     int count = 0;
     while(n != 1)
     {
      if(n % 2 == 0)
          n = n/2;
         else
          n = 3 * n + 1;
      
      count++;
     }
     return count + 1; 
    //add one because the last term (which is 1)
    //is not accounted for in the loop
    }
    
  public static long longestCollatzSeq(long n)
  {
      long maxN = 1;
      long maxLength = 1;
      for(int i = 2; i <= n; i++)
      {
          
          if(lengthCollatz(i) > maxLength)
          {
              maxN = i;
              maxLength = lengthCollatz(maxN);
          }
      }
      return maxN;
  }
  
}

